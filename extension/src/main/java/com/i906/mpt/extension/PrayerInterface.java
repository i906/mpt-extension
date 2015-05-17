package com.i906.mpt.extension;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Date;
import java.util.List;

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

    int ERROR_OTHER = 0;
    int ERROR_NETWORK = 1;
    int ERROR_CONVERSION = 2;
    int ERROR_HTTP = 3;
    int ERROR_LOCATION = 4;

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
     * Retrieves all prayer times for the current day.
     *
     * @return An array of prayer times for the current day
     */
    List<Date> getCurrentDayPrayerTimes();

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

    /**
     * Instructs the host to refresh the prayer times.
     */
    void refresh();

    /**
     * Check whether the prayer times is already loaded.
     */
    boolean isPrayerTimesLoaded();

    void addPrayerListener(PrayerListener listener);

    void removePrayerListener(PrayerListener listener);

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({ERROR_OTHER, ERROR_NETWORK, ERROR_CONVERSION, ERROR_HTTP, ERROR_LOCATION})
    @interface ErrorType {}

    interface PrayerListener {
        void onPrayerTimesChanged();
        void onLocationChanged();
        void onError(@ErrorType int type, String code);
    }
}
