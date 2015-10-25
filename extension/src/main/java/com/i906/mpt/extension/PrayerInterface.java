package com.i906.mpt.extension;

import android.support.annotation.IntDef;

import com.i906.mpt.model.CurrentData;
import com.i906.mpt.model.HijriDate;
import com.i906.mpt.model.Prayer;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * An interface used by Malaysia Prayer Times to provide access to its data in the extensions.
 */
public interface PrayerInterface extends CurrentData, Prayer, HijriDate {

    int ERROR_OTHER = 0;
    int ERROR_NETWORK = 1;
    int ERROR_CONVERSION = 2;
    int ERROR_HTTP = 3;
    int ERROR_LOCATION = 4;



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

    /**
     * Check whether the given prayer has already passed.
     */
    boolean prayerHasPassed(int prayer);

    void onPrayerExtensionCrashed(Throwable t);

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
