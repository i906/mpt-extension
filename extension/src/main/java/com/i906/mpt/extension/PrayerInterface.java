package com.i906.mpt.extension;

import java.util.Date;

/**
 * An interface used by Malaysia Prayer Times to provide access to its data in the extensions.
 */
public interface PrayerInterface {

    int PRAYER_IMSAK = 0;
    int PRAYER_SUBUH = 1;
    int PRAYER_SYURUK = 2;
    int PRAYER_DHUHA = 3;
    int PRAYER_ZOHOR = 4;
    int PRAYER_ASAR = 5;
    int PRAYER_MAGRHIB = 6;
    int PRAYER_ISYAK = 7;

    int DATE_DATE = 0;
    int DATE_MONTH = 1;
    int DATE_YEAR = 2;

    /**
     * Retrieves the current prayer time.
     *
     * @return The current prayer time
     * @see #getCurrentPrayerIndex()
     * @see #getNextPrayerTime()
     */
    Date getCurrentPrayerTime();

    /**
     * Retrieves the next prayer time.
     *
     * @return The next prayer time
     * @see #getNextPrayerIndex()
     * @see #getCurrentPrayerTime()
     */
    Date getNextPrayerTime();

    /**
     * Retrieves the current prayer time index.
     *
     * @return The current prayer time index
     * @see #getCurrentPrayerTime()
     * @see #getNextPrayerIndex()
     */
    int getCurrentPrayerIndex();

    /**
     * Retrieves the next prayer time index.
     *
     * @return The next prayer time index
     * @see #getNextPrayerTime()
     * @see #getCurrentPrayerIndex()
     */
    int getNextPrayerIndex();

    /**
     * Retrieves the hijri date.
     *
     * @return The hijri date in an array
     */
    int[] getHijriDate();

    /**
     * Retrieves the current detected or user set location.
     *
     * @return The location name
     */
    String getLocation();

    /**
     * Retrieves the host's version.
     *
     * @return The Malaysia Prayer Times' version
     */
    int getAppVersion();
}
