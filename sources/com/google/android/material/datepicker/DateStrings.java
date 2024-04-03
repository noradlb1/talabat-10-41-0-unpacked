package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Build;
import android.text.format.DateUtils;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

class DateStrings {
    private DateStrings() {
    }

    public static Pair<String, String> getDateRangeString(@Nullable Long l11, @Nullable Long l12) {
        return getDateRangeString(l11, l12, (SimpleDateFormat) null);
    }

    public static String getDateString(long j11) {
        return getDateString(j11, (SimpleDateFormat) null);
    }

    public static String getMonthDay(long j11) {
        return getMonthDay(j11, Locale.getDefault());
    }

    public static String getMonthDayOfWeekDay(long j11) {
        return getMonthDayOfWeekDay(j11, Locale.getDefault());
    }

    public static String getYearMonth(Context context, long j11) {
        return DateUtils.formatDateTime(context, j11 - ((long) TimeZone.getDefault().getOffset(j11)), 36);
    }

    public static String getYearMonthDay(long j11) {
        return getYearMonthDay(j11, Locale.getDefault());
    }

    public static String getYearMonthDayOfWeekDay(long j11) {
        return getYearMonthDayOfWeekDay(j11, Locale.getDefault());
    }

    public static Pair<String, String> getDateRangeString(@Nullable Long l11, @Nullable Long l12, @Nullable SimpleDateFormat simpleDateFormat) {
        if (l11 == null && l12 == null) {
            return Pair.create(null, null);
        }
        if (l11 == null) {
            return Pair.create(null, getDateString(l12.longValue(), simpleDateFormat));
        }
        if (l12 == null) {
            return Pair.create(getDateString(l11.longValue(), simpleDateFormat), null);
        }
        Calendar todayCalendar = UtcDates.getTodayCalendar();
        Calendar utcCalendar = UtcDates.getUtcCalendar();
        utcCalendar.setTimeInMillis(l11.longValue());
        Calendar utcCalendar2 = UtcDates.getUtcCalendar();
        utcCalendar2.setTimeInMillis(l12.longValue());
        if (simpleDateFormat != null) {
            return Pair.create(simpleDateFormat.format(new Date(l11.longValue())), simpleDateFormat.format(new Date(l12.longValue())));
        } else if (utcCalendar.get(1) != utcCalendar2.get(1)) {
            return Pair.create(getYearMonthDay(l11.longValue(), Locale.getDefault()), getYearMonthDay(l12.longValue(), Locale.getDefault()));
        } else {
            if (utcCalendar.get(1) == todayCalendar.get(1)) {
                return Pair.create(getMonthDay(l11.longValue(), Locale.getDefault()), getMonthDay(l12.longValue(), Locale.getDefault()));
            }
            return Pair.create(getMonthDay(l11.longValue(), Locale.getDefault()), getYearMonthDay(l12.longValue(), Locale.getDefault()));
        }
    }

    public static String getDateString(long j11, @Nullable SimpleDateFormat simpleDateFormat) {
        Calendar todayCalendar = UtcDates.getTodayCalendar();
        Calendar utcCalendar = UtcDates.getUtcCalendar();
        utcCalendar.setTimeInMillis(j11);
        if (simpleDateFormat != null) {
            return simpleDateFormat.format(new Date(j11));
        }
        if (todayCalendar.get(1) == utcCalendar.get(1)) {
            return getMonthDay(j11);
        }
        return getYearMonthDay(j11);
    }

    public static String getMonthDay(long j11, Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return UtcDates.getAbbrMonthDayFormat(locale).format(new Date(j11));
        }
        return UtcDates.getMediumNoYear(locale).format(new Date(j11));
    }

    public static String getMonthDayOfWeekDay(long j11, Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return UtcDates.getAbbrMonthWeekdayDayFormat(locale).format(new Date(j11));
        }
        return UtcDates.getFullFormat(locale).format(new Date(j11));
    }

    public static String getYearMonthDay(long j11, Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return UtcDates.getYearAbbrMonthDayFormat(locale).format(new Date(j11));
        }
        return UtcDates.getMediumFormat(locale).format(new Date(j11));
    }

    public static String getYearMonthDayOfWeekDay(long j11, Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return UtcDates.getYearAbbrMonthWeekdayDayFormat(locale).format(new Date(j11));
        }
        return UtcDates.getFullFormat(locale).format(new Date(j11));
    }
}
