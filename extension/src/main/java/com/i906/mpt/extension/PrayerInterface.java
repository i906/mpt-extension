package com.i906.mpt.extension;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Date;

public interface PrayerInterface {

    int PRAYER_IMSAK = 0;
    int PRAYER_SYURUK = 1;
    int PRAYER_SUBUH = 2;
    int PRAYER_DHUHA = 3;
    int PRAYER_ZOHOR = 4;
    int PRAYER_ASAR = 5;
    int PRAYER_MAGRHIB = 6;
    int PRAYER_ISYAK = 7;

    int DATE_DATE = 0;
    int DATE_MONTH = 1;
    int DATE_YEAR = 2;

    Date getCurrentPrayerTime();

    Date getNextPrayerTime();

    @PrayerType
    int getCurrentPrayerIndex();

    @PrayerType
    int getNextPrayerIndex();

    int[] getHijriDate();

    Date getMasihiDate();

    String getLocation();

    int getAppVersion();

    @IntDef({
            PRAYER_IMSAK,
            PRAYER_SYURUK,
            PRAYER_SUBUH,
            PRAYER_DHUHA,
            PRAYER_ZOHOR,
            PRAYER_ASAR,
            PRAYER_MAGRHIB,
            PRAYER_ISYAK
    })
    @Retention(RetentionPolicy.SOURCE)
    public @interface PrayerType { }
}
