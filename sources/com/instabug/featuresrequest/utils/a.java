package com.instabug.featuresrequest.utils;

import android.content.Context;
import com.instabug.featuresrequest.R;
import com.instabug.library.Instabug;
import com.instabug.library.util.LocaleUtils;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public abstract class a {
    public static String a(Context context, long j11) {
        Date date = new Date(j11);
        DateFormat dateInstance = DateFormat.getDateInstance(2);
        if (!Locale.getDefault().getISO3Language().equals(Locale.ENGLISH.getISO3Language())) {
            return dateInstance.format(date);
        }
        Date date2 = new Date();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        long seconds = timeUnit.toSeconds(date2.getTime() - date.getTime());
        long minutes = timeUnit.toMinutes(date2.getTime() - date.getTime());
        long hours = timeUnit.toHours(date2.getTime() - date.getTime());
        long days = timeUnit.toDays(date2.getTime() - date.getTime());
        if (seconds < 60) {
            return LocaleUtils.getLocaleStringResource(Instabug.getLocale(context), R.string.feature_request_str_just_now, context);
        }
        if (minutes < 60) {
            return context.getResources().getQuantityString(R.plurals.instabug_feature_rq_str_minutes_ago, (int) minutes, new Object[]{Long.valueOf(minutes)});
        } else if (hours < 24) {
            return context.getResources().getQuantityString(R.plurals.instabug_feature_rq_str_hours_ago, (int) hours, new Object[]{Long.valueOf(hours)});
        } else if (days >= 7) {
            return dateInstance.format(date);
        } else {
            return context.getResources().getQuantityString(R.plurals.instabug_feature_rq_str_days_ago, (int) days, new Object[]{Long.valueOf(days)});
        }
    }
}
