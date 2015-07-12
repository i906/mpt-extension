package com.i906.mpt.extension.countdownview.view;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.i906.mpt.extension.PrayerInterface;
import com.i906.mpt.extension.PrayerView;
import com.i906.mpt.extension.countdownview.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class CountdownView extends PrayerView {

    protected boolean isUpdateTaskRunning = false;
    protected Handler mHandler;
    protected CountdownUpdater mUpdater;
    protected SimpleDateFormat mDateFormatter;
    protected String[] mPrayerNames;

    protected View mContentView;
    protected TextView mNextPrayerName;
    protected TextView mNextPrayerTime;
    protected TextView mLocationName;
    protected TextView mHourValue;
    protected TextView mMinuteValue;
    protected TextView mSecondValue;
    protected TextView mHourLabel;
    protected TextView mMinuteLabel;
    protected TextView mSecondLabel;
    protected View mProgressView;
    protected View mErrorView;
    protected TextView mErrorMessageView;

    public CountdownView(Context context) {
        this(context, null);
    }

    public CountdownView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CountdownView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.view_prayer_countdown, this, true);
        mDateFormatter = new SimpleDateFormat("hh:mm");
        mPrayerNames = getResources().getStringArray(R.array.mpt_prayer_names);
        mContentView = findViewById(R.id.content_container);
        mNextPrayerName = (TextView) findViewById(R.id.tv_prayer_name);
        mNextPrayerTime = (TextView) findViewById(R.id.tv_prayer_time);
        mHourValue = (TextView) findViewById(R.id.tv_value_hour);
        mMinuteValue = (TextView) findViewById(R.id.tv_value_minute);
        mSecondValue = (TextView) findViewById(R.id.tv_value_second);
        mHourLabel = (TextView) findViewById(R.id.tv_label_hour);
        mMinuteLabel = (TextView) findViewById(R.id.tv_label_minute);
        mSecondLabel = (TextView) findViewById(R.id.tv_label_second);
        mLocationName = (TextView) findViewById(R.id.tv_location);
        mProgressView = findViewById(R.id.progress_container);
        mErrorView = findViewById(R.id.error_container);
        mErrorMessageView = (TextView) findViewById(R.id.tv_error);
        mHandler = new Handler();
    }

    private void updatePrayerHeader() {
        Date d = getInterface().getNextPrayerTime();
        int i = getInterface().getNextPrayerIndex();
        String location = getInterface().getLocation();

        mNextPrayerTime.setText(mDateFormatter.format(d));
        mNextPrayerName.setText(mPrayerNames[i]);
        mLocationName.setText(location);
        updateCountdown();
        startUpdating();
    }

    private void updateCountdown() {
        long r = getRemaining();
        long hours = TimeUnit.MILLISECONDS.toHours(r);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(r - TimeUnit.HOURS.toMillis(hours));
        long seconds = TimeUnit.MILLISECONDS.toSeconds(r - TimeUnit.HOURS.toMillis(hours)
                - TimeUnit.MINUTES.toMillis(minutes));

        String h = hours < 10 ? "0" + hours : "" + hours;
        String m = minutes < 10 ? "0" + minutes : "" + minutes;
        String s = seconds < 10 ? "0" + seconds : "" + seconds;

        mHourValue.setText(h);
        mMinuteValue.setText(m);
        mSecondValue.setText(s);

        mHourLabel.setText(getResources().getQuantityString(R.plurals.label_hour, (int) hours));
        mMinuteLabel.setText(getResources().getQuantityString(R.plurals.label_minute, (int) minutes));
        mSecondLabel.setText(getResources().getQuantityString(R.plurals.label_second, (int) seconds));
    }

    private long getRemaining() {
        Date d = getInterface().getNextPrayerTime();
        if (d == null) return 0;
        return d.getTime() - System.currentTimeMillis();
    }

    private void startUpdating() {
        if (mUpdater == null) mUpdater = new CountdownUpdater();
        mHandler.post(mUpdater);
        isUpdateTaskRunning = true;
    }

    private void stopUpdating() {
        if (isUpdateTaskRunning) {
            mHandler.removeCallbacks(mUpdater);
            isUpdateTaskRunning = false;
        }
    }

    private void setViewVisibility(View view, boolean visible, boolean animate) {
        if (view.getVisibility() == View.VISIBLE && visible) return;
        if (view.getVisibility() == View.GONE && !visible) return;

        if (visible) {
            if (animate) {
                view.startAnimation(
                        AnimationUtils.loadAnimation(getContext(), android.R.anim.fade_in));
            } else {
                view.clearAnimation();
            }
            view.setVisibility(View.VISIBLE);
        } else {
            if (animate) {
                view.startAnimation(
                        AnimationUtils.loadAnimation(getContext(), android.R.anim.fade_out));
            } else {
                view.clearAnimation();
            }
            view.setVisibility(View.GONE);
        }
    }

    private void setContentVisibility(boolean visible, boolean animate) {
        setViewVisibility(mContentView, visible, animate);
    }

    private void setProgressVisibility(boolean visible, boolean animate) {
        setViewVisibility(mProgressView, visible, animate);
    }

    private void setErrorVisibility(boolean visible, boolean animate) {
        setViewVisibility(mErrorView, visible, animate);
    }

    protected void onRetryButtonClicked() {
        setContentVisibility(false, true);
        setErrorVisibility(false, true);
        setProgressVisibility(true, true);
        getInterface().refresh();
    }

    @Override
    public void onInterfaceLoaded() {
        if (getInterface().isPrayerTimesLoaded()) {
            setContentVisibility(true, true);
            setProgressVisibility(false, true);
            setErrorVisibility(false, true);
            updatePrayerHeader();
        } else {
            setContentVisibility(false, false);
            setProgressVisibility(true, false);
            setErrorVisibility(false, false);
        }
    }

    @Override
    public void onPrayerTimesChanged() {
        updatePrayerHeader();
        setContentVisibility(true, true);
        setProgressVisibility(false, true);
    }

    @Override
    public void onError(int type, String code) {
        setContentVisibility(false, true);
        setProgressVisibility(false, true);
        setErrorVisibility(true, true);

        switch (type) {
            case PrayerInterface.ERROR_NETWORK:
                mErrorMessageView.setText(R.string.mpt_error_no_network);
                break;
            case PrayerInterface.ERROR_LOCATION:
                if ("ERROR_ADDRESS".equals(code) || "ERROR_PLACE".equals(code)) {
                    mErrorMessageView.setText(R.string.mpt_error_undetectable_location);
                } else {
                    mErrorMessageView.setText(R.string.mpt_error_no_location);
                }
                break;
            default:
                mErrorMessageView.setText(R.string.mpt_error_unexpected);
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopUpdating();
    }

    class CountdownUpdater implements Runnable {
        @Override
        public void run() {
            updateCountdown();
            mHandler.postDelayed(this, 1000);
        }
    }
}
