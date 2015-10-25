package com.i906.mpt.model;

import android.support.annotation.Nullable;

import java.util.Date;
import java.util.List;

/**
 * Created by Noorzaini Ilhami on 24/10/2015.
 */
public interface CurrentData extends Prayer, HijriDate {

    /**
     * Retrieves the current prayer time.
     *
     * @return The current prayer time
     * @see #getCurrentPrayerIndex()
     * @see #getNextPrayerTime()
     */
    @Nullable
    Date getCurrentPrayerTime();

    /**
     * Retrieves the next prayer time.
     *
     * @return The next prayer time
     * @see #getNextPrayerIndex()
     * @see #getCurrentPrayerTime()
     */
    @Nullable
    Date getNextPrayerTime();

    /**
     * Retrieves the current prayer time index. May return -1 if prayer times is not yet loaded.
     *
     * @return The current prayer time index
     * @see #getCurrentPrayerTime()
     * @see #getNextPrayerIndex()
     */
    int getCurrentPrayerIndex();

    /**
     * Retrieves the next prayer time index. May return -1 if prayer times is not yet loaded.
     *
     * @return The next prayer time index
     * @see #getNextPrayerTime()
     * @see #getCurrentPrayerIndex()
     */
    int getNextPrayerIndex();

    /**
     * Retrieves all prayer times for the current day.
     *
     * @return An array of prayer times for the current day
     */
    @Nullable
    List<Date> getCurrentDayPrayerTimes();

    /**
     * Retrieves the current detected or user set location.
     *
     * @return The location name
     */
    String getLocation();
}
