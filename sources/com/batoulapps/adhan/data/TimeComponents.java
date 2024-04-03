package com.batoulapps.adhan.data;

import j$.util.DesugarTimeZone;
import java.util.Calendar;
import java.util.Date;

public class TimeComponents {
    public final int hours;
    public final int minutes;
    public final int seconds;

    private TimeComponents(int i11, int i12, int i13) {
        this.hours = i11;
        this.minutes = i12;
        this.seconds = i13;
    }

    public static TimeComponents fromDouble(double d11) {
        if (Double.isInfinite(d11) || Double.isNaN(d11)) {
            return null;
        }
        double floor = Math.floor(d11);
        double floor2 = Math.floor((d11 - floor) * 60.0d);
        return new TimeComponents((int) floor, (int) floor2, (int) Math.floor((d11 - ((floor2 / 60.0d) + floor)) * 60.0d * 60.0d));
    }

    public Date dateComponents(DateComponents dateComponents) {
        Calendar instance = Calendar.getInstance(DesugarTimeZone.getTimeZone("UTC"));
        instance.set(1, dateComponents.year);
        instance.set(2, dateComponents.month - 1);
        instance.set(5, dateComponents.day);
        instance.set(11, 0);
        instance.set(12, this.minutes);
        instance.set(13, this.seconds);
        instance.add(11, this.hours);
        return instance.getTime();
    }
}
