package com.i906.mpt.provider;

import android.net.Uri;

import com.i906.mpt.model.HijriDate;
import com.i906.mpt.model.Prayer;

/**
 * Created by Noorzaini Ilhami on 24/10/2015.
 */
public final class MptContract {

    public static final String AUTHORITY = "com.i906.mpt.staging.provider.prayer";
    public static final Uri AUTHORITY_URI = Uri.parse("content://" + AUTHORITY);

    public interface CurrentDataInfo {
        String BASE_PATH = "current_data";
        Uri URI = Uri.withAppendedPath(AUTHORITY_URI, BASE_PATH);

        String PRAYER_PREFIX = "prayer_";
        String HIJRI_DATE_PREFIX = "hijri_";

        interface Columns {
            String LOCATION = "location";
            String CURRENT_PRAYER_TIME = "current_prayer_time";
            String CURRENT_PRAYER_INDEX = "current_prayer_index";
            String NEXT_PRAYER_TIME = "next_prayer_time";
            String NEXT_PRAYER_INDEX = "next_prayer_index";
            String PRAYER_IMSAK = PRAYER_PREFIX + Prayer.PRAYER_IMSAK;
            String PRAYER_SUBUH = PRAYER_PREFIX + Prayer.PRAYER_SUBUH;
            String PRAYER_SYURUK = PRAYER_PREFIX + Prayer.PRAYER_SYURUK;
            String PRAYER_DHUHA = PRAYER_PREFIX + Prayer.PRAYER_DHUHA;
            String PRAYER_ZOHOR = PRAYER_PREFIX + Prayer.PRAYER_ZOHOR;
            String PRAYER_ASAR = PRAYER_PREFIX + Prayer.PRAYER_ASAR;
            String PRAYER_MAGRHIB = PRAYER_PREFIX + Prayer.PRAYER_MAGRHIB;
            String PRAYER_ISYAK = PRAYER_PREFIX + Prayer.PRAYER_ISYAK;
            String HIJRI_DAY = HIJRI_DATE_PREFIX + HijriDate.DATE_DAY;
            String HIJRI_MONTH = HIJRI_DATE_PREFIX + HijriDate.DATE_MONTH;
            String HIJRI_YEAR = HIJRI_DATE_PREFIX + HijriDate.DATE_YEAR;
        }
    }

    public interface Actions {
        String PRAYER_TIME_UPDATED = "com.i906.mpt.action.PRAYER_TIME_UPDATED";
    }
}
