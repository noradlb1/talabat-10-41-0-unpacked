package com.google.firebase.appindexing.internal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import javax.annotation.concurrent.GuardedBy;

public final class zzae {
    @GuardedBy("itself")
    private static final DateFormat zza = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US);

    public static String zza(Calendar calendar) {
        String format;
        DateFormat dateFormat = zza;
        synchronized (dateFormat) {
            dateFormat.setTimeZone(calendar.getTimeZone());
            format = dateFormat.format(calendar.getTime());
        }
        return format;
    }
}
