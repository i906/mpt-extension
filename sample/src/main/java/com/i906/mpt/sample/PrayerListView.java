package com.i906.mpt.sample;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.i906.mpt.extension.PrayerView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PrayerListView extends PrayerView {

    protected SimpleDateFormat mDateFormatter;
    protected String[] mPrayerNames;
    protected TextView mCurrentTimeView;
    protected TextView mCurrentPrayerView;

    public PrayerListView(Context context) {
        this(context, null);
    }

    public PrayerListView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PrayerListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.view_prayer_list, this, true);
        mDateFormatter = new SimpleDateFormat("hh:mm");
        mPrayerNames = getResources().getStringArray(R.array.mpt_prayer_names);
        mCurrentTimeView = (TextView) findViewById(R.id.tv_current_time);
        mCurrentPrayerView = (TextView) findViewById(R.id.tv_current_prayer);
    }

    private void updatePrayerHeader() {
        Date d = getInterface().getCurrentPrayerTime();
        int i = getInterface().getCurrentPrayerIndex();
        mCurrentTimeView.setText(mDateFormatter.format(d));
        mCurrentPrayerView.setText(mPrayerNames[i]);
    }

    @Override
    public void onInterfaceLoaded() {
        updatePrayerHeader();
    }
}