package com.i906.mpt.model;

import android.database.Cursor;

import com.i906.mpt.provider.MptContract.CurrentDataInfo.Columns;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.i906.mpt.provider.MptContract.CurrentDataInfo;

/**
 * Created by Noorzaini Ilhami on 24/10/2015.
 */
public final class CurrentDataMapper {

    public static CurrentData mapFromCursor(Cursor c) {
        CurrentDataImpl cd = new CurrentDataImpl();

        long cpt = c.getLong(c.getColumnIndex(Columns.CURRENT_PRAYER_TIME));
        long npt = c.getLong(c.getColumnIndex(Columns.NEXT_PRAYER_TIME));
        List<Date> cdpt = new ArrayList<>(8);
        List<Integer> hd = new ArrayList<>(3);

        for (int i = 0; i < 8; i++) {
            long t = c.getLong(c.getColumnIndex(CurrentDataInfo.PRAYER_PREFIX + i));
            Date d = new Date(t);
            cdpt.add(d);
        }

        for (int i = 0; i < 3; i++) {
            int t = c.getInt(c.getColumnIndex(CurrentDataInfo.HIJRI_DATE_PREFIX + i));
            hd.add(t);
        }

        cd.location = c.getString(c.getColumnIndex(Columns.LOCATION));
        cd.currentPrayerIndex = c.getInt(c.getColumnIndex(Columns.CURRENT_PRAYER_INDEX));
        cd.nextPrayerIndex = c.getInt(c.getColumnIndex(Columns.NEXT_PRAYER_INDEX));
        cd.currentPrayerTime = new Date(cpt);
        cd.nextPrayerTime = new Date(npt);
        cd.currentDayPrayerTimes = cdpt;
        cd.hijriDates = hd;

        return cd;
    }
}
