package com.uxcam.internals;

import j$.util.DesugarTimeZone;
import java.util.Calendar;

public class gw {

    /* renamed from: a  reason: collision with root package name */
    public static final long f13509a;

    static {
        Calendar instance = Calendar.getInstance(DesugarTimeZone.getTimeZone("GMT"));
        instance.set(1904, 0, 1, 0, 0, 0);
        instance.set(14, 0);
        f13509a = instance.getTimeInMillis();
    }

    public static int a(long j11) {
        return (int) ((j11 - f13509a) / 1000);
    }
}
