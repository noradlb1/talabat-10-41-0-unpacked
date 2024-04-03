package com.batoulapps.adhan.data;

import j$.util.DesugarTimeZone;
import java.util.Calendar;
import java.util.Date;

public class DateComponents {
    public final int day;
    public final int month;
    public final int year;

    public DateComponents(int i11, int i12, int i13) {
        this.year = i11;
        this.month = i12;
        this.day = i13;
    }

    public static DateComponents from(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        return new DateComponents(instance.get(1), instance.get(2) + 1, instance.get(5));
    }

    public static DateComponents fromUTC(Date date) {
        Calendar instance = Calendar.getInstance(DesugarTimeZone.getTimeZone("UTC"));
        instance.setTime(date);
        return new DateComponents(instance.get(1), instance.get(2) + 1, instance.get(5));
    }
}
