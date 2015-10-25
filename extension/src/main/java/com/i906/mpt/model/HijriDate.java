package com.i906.mpt.model;

import java.util.List;

/**
 * Created by Noorzaini Ilhami on 25/10/2015.
 */
public interface HijriDate {

    int DATE_DAY = 0;
    int DATE_MONTH = 1;
    int DATE_YEAR = 2;

    /**
     * Retrieves the hijri date.
     *
     * @return The hijri date in an array
     */
    List<Integer> getHijriDate();
}
