package com.instabug.library.util;

import android.content.Context;
import android.text.format.DateFormat;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.library.core.InstabugCore;
import j$.util.DesugarTimeZone;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class InstabugDateFormatter {
    public static Date convertUnixTimeToDate(long j11) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j11);
        return instance.getTime();
    }

    public static String convertUnixTimeToFormattedDate(long j11) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
        simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
        return simpleDateFormat.format(convertUnixTimeToDate(j11));
    }

    public static String formatConversationLastMessageDate(Context context, long j11) {
        return new SimpleDateFormat("dd MMM", InstabugCore.getLocale(context)).format(Long.valueOf(j11 * 1000));
    }

    public static String formatMessageDate(@NonNull Context context, long j11) {
        String str;
        if (DateFormat.is24HourFormat(context)) {
            str = "dd-MMM HH:mm";
        } else {
            str = "dd-MMM hh:mm a";
        }
        return new SimpleDateFormat(str, InstabugCore.getLocale(context)).format(Long.valueOf(j11 * 1000));
    }

    public static String formatUTCDate(long j11) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j11 * 1000);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
        simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
        return simpleDateFormat.format(instance.getTime());
    }

    public static String getCurrentDateAsString() {
        Calendar instance = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
        simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
        return simpleDateFormat.format(instance.getTime());
    }

    public static long getCurrentUTCTimeStampInMiliSeconds() {
        return System.currentTimeMillis();
    }

    public static long getCurrentUTCTimeStampInSeconds() {
        return System.currentTimeMillis() / 1000;
    }

    @Nullable
    public static Date getDate(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
        simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
        try {
            return simpleDateFormat.parse(str);
        } catch (ParseException e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public static Date getStandardizedDate(Date date) {
        return new Date(date.getTime());
    }

    public static String convertUnixTimeToFormattedDate(long j11, String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.US);
        simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
        return simpleDateFormat.format(convertUnixTimeToDate(j11));
    }
}
