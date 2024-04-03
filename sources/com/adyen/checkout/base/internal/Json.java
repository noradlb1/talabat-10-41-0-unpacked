package com.adyen.checkout.base.internal;

import androidx.annotation.NonNull;
import j$.util.DesugarTimeZone;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

public final class Json {
    private static final String DATE_PATTERN = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    private static final TimeZone TIME_ZONE = DesugarTimeZone.getTimeZone("UTC");

    private Json() {
        throw new IllegalStateException("No instances.");
    }

    @NonNull
    private static DateFormat getDateFormat() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_PATTERN, Locale.US);
        simpleDateFormat.setTimeZone(TIME_ZONE);
        return simpleDateFormat;
    }

    @NonNull
    public static Map<String, String> getDefaultHeaders() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("Content-Type", "application/json; charset=UTF-8");
        return linkedHashMap;
    }

    @NonNull
    public static String serializeDate(@NonNull Date date) {
        return getDateFormat().format(date);
    }
}
