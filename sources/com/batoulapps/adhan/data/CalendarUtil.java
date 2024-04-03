package com.batoulapps.adhan.data;

import j$.util.DesugarTimeZone;
import java.util.Calendar;
import java.util.Date;

public class CalendarUtil {
    public static Date add(Date date, int i11, int i12) {
        Calendar instance = Calendar.getInstance(DesugarTimeZone.getTimeZone("UTC"));
        instance.setTime(date);
        instance.add(i12, i11);
        return instance.getTime();
    }

    public static boolean isLeapYear(int i11) {
        return i11 % 4 == 0 && (i11 % 100 != 0 || i11 % 400 == 0);
    }

    public static Date resolveTime(DateComponents dateComponents) {
        return resolveTime(dateComponents.year, dateComponents.month, dateComponents.day);
    }

    public static Date roundedMinute(Date date) {
        Calendar instance = Calendar.getInstance(DesugarTimeZone.getTimeZone("UTC"));
        instance.setTime(date);
        instance.set(12, (int) (((double) instance.get(12)) + ((double) Math.round(((double) instance.get(13)) / 60.0d))));
        instance.set(13, 0);
        return instance.getTime();
    }

    private static Date resolveTime(int i11, int i12, int i13) {
        Calendar instance = Calendar.getInstance(DesugarTimeZone.getTimeZone("UTC"));
        instance.set(i11, i12 - 1, i13, 0, 0, 0);
        return instance.getTime();
    }
}
