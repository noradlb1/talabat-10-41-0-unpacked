package com.instabug.library.util;

import androidx.annotation.Keep;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Keep
public final class TimeUtils {
    public static final long DAY_MILLIS = TimeUnit.DAYS.toMillis(1);
    public static final long MINUTE = 60000;

    private TimeUtils() {
    }

    public static long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    public static long currentTimeSeconds() {
        return System.currentTimeMillis() / 1000;
    }

    public static long currentTimeStampMicroSeconds() {
        return TimeUnit.MILLISECONDS.toMicros(currentTimeMillis());
    }

    public static long elapsedTimeMillis(long j11, long j12, TimeUnit timeUnit) {
        return timeUnit.toMillis(j12) - timeUnit.toMillis(j11);
    }

    public static String getDateString(long j11, String str) {
        Date time = Calendar.getInstance().getTime();
        time.setTime(j11);
        return new SimpleDateFormat(str).format(time);
    }

    public static boolean hasXHoursPassed(long j11, long j12) {
        return System.currentTimeMillis() - j11 > j12;
    }

    public static int millisToSeconds(long j11) {
        return (int) TimeUnit.MILLISECONDS.toSeconds(j11);
    }

    public static long monthToDays(int i11) {
        return TimeUnit.DAYS.toDays(((long) i11) * 30);
    }

    public static long monthToHours(int i11) {
        return TimeUnit.DAYS.toHours(((long) i11) * 30);
    }

    public static long monthToMillis(int i11) {
        return TimeUnit.DAYS.toMillis(((long) i11) * 30);
    }

    public static long nanoTime() {
        return System.nanoTime();
    }
}
