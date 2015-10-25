package com.i906.mpt.model;

import java.util.Date;
import java.util.List;

/**
 * Created by Noorzaini Ilhami on 24/10/2015.
 */
final class CurrentDataImpl implements CurrentData {

    String location;
    Date currentPrayerTime;
    Date nextPrayerTime;
    int currentPrayerIndex;
    int nextPrayerIndex;
    List<Date> currentDayPrayerTimes;
    List<Integer> hijriDates;

    @Override
    public String getLocation() {
        return location;
    }

    @Override
    public Date getCurrentPrayerTime() {
        return currentPrayerTime;
    }

    @Override
    public Date getNextPrayerTime() {
        return nextPrayerTime;
    }

    @Override
    public int getCurrentPrayerIndex() {
        return currentPrayerIndex;
    }

    @Override
    public int getNextPrayerIndex() {
        return nextPrayerIndex;
    }

    @Override
    public List<Date> getCurrentDayPrayerTimes() {
        return currentDayPrayerTimes;
    }

    @Override
    public List<Integer> getHijriDate() {
        return hijriDates;
    }
}
