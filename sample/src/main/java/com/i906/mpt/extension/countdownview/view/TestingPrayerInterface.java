package com.i906.mpt.extension.countdownview.view;

import com.i906.mpt.extension.PrayerInterface;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TestingPrayerInterface implements PrayerInterface {

    protected List<Date> mTestDateList;
    protected PrayerListener mPrayerListener;
    protected boolean mLoaded = false;

    public TestingPrayerInterface() {

        mTestDateList = new ArrayList<>();

        Calendar c = Calendar.getInstance();

        c.set(Calendar.HOUR_OF_DAY, 5);
        c.set(Calendar.MINUTE, 55);
        mTestDateList.add(c.getTime());

        c.set(Calendar.HOUR_OF_DAY, 6);
        c.set(Calendar.MINUTE, 5);
        mTestDateList.add(c.getTime());

        c.set(Calendar.HOUR_OF_DAY, 7);
        c.set(Calendar.MINUTE, 21);
        mTestDateList.add(c.getTime());

        c.set(Calendar.HOUR_OF_DAY, 7);
        c.set(Calendar.MINUTE, 46);
        mTestDateList.add(c.getTime());

        c.set(Calendar.HOUR_OF_DAY, 13);
        c.set(Calendar.MINUTE, 25);
        mTestDateList.add(c.getTime());

        c.set(Calendar.HOUR_OF_DAY, 16);
        c.set(Calendar.MINUTE, 35);
        mTestDateList.add(c.getTime());

        c.set(Calendar.HOUR_OF_DAY, 19);
        c.set(Calendar.MINUTE, 27);
        mTestDateList.add(c.getTime());

        c.set(Calendar.HOUR_OF_DAY, 20);
        c.set(Calendar.MINUTE, 36);
        mTestDateList.add(c.getTime());

        mLoaded = true;
        if (mPrayerListener != null) mPrayerListener.onPrayerTimesChanged();
    }

    @Override
    public Date getCurrentPrayerTime() {
        return mTestDateList.get(getCurrentPrayerIndex());
    }

    @Override
    public Date getNextPrayerTime() {
        return mTestDateList.get(getCurrentPrayerIndex());
    }

    @Override
    public int getCurrentPrayerIndex() {
        int pos = 0;
        Calendar c = Calendar.getInstance();
        Calendar n = Calendar.getInstance();

        for (int i = 0; i < mTestDateList.size(); i++) {
            n.setTime(mTestDateList.get(i));
            if (n.after(c)) break;
            pos++;
        }

        return (pos - 1 == -1) ? 7 : pos - 1;
    }

    @Override
    public int getNextPrayerIndex() {
        return (getCurrentPrayerIndex() + 1) % 8;
    }

    @Override
    public List<Date> getCurrentDayPrayerTimes() {
        return mTestDateList;
    }

    @Override
    public int[] getHijriDate() {
        return new int[] { 22, 4, 1436 } ;
    }

    @Override
    public String getLocation() {
        return "Kuala Lumpur";
    }

    @Override
    public int getAppVersion() {
        return 2631;
    }

    @Override
    public void refresh() {

    }

    @Override
    public boolean isPrayerTimesLoaded() {
        return mLoaded;
    }

    @Override
    public void onPrayerExtensionCrashed(Throwable t) {
        t.printStackTrace();
    }

    @Override
    public void addPrayerListener(PrayerListener listener) {
        mPrayerListener = listener;
    }

    @Override
    public void removePrayerListener(PrayerListener listener) {
        mPrayerListener = null;
    }
}
