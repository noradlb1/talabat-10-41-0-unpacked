package com.google.firebase.appindexing.builders;

import androidx.annotation.NonNull;
import io.flutter.plugins.firebase.crashlytics.Constants;

public final class AlarmBuilder extends IndexableBuilder<AlarmBuilder> {
    @NonNull
    public static final String FRIDAY = "Friday";
    @NonNull
    public static final String MONDAY = "Monday";
    @NonNull
    public static final String SATURDAY = "Saturday";
    @NonNull
    public static final String SUNDAY = "Sunday";
    @NonNull
    public static final String THURSDAY = "Thursday";
    @NonNull
    public static final String TUESDAY = "Tuesday";
    @NonNull
    public static final String WEDNESDAY = "Wednesday";

    public AlarmBuilder() {
        super("Alarm");
    }

    @NonNull
    public AlarmBuilder setAlarmInstances(@NonNull AlarmInstanceBuilder... alarmInstanceBuilderArr) {
        put("alarmInstances", (S[]) alarmInstanceBuilderArr);
        return this;
    }

    @NonNull
    public AlarmBuilder setDayOfWeek(@NonNull String... strArr) {
        String str;
        int length = strArr.length;
        int i11 = 0;
        while (i11 < length) {
            String str2 = strArr[i11];
            if (SUNDAY.equals(str2) || MONDAY.equals(str2) || TUESDAY.equals(str2) || WEDNESDAY.equals(str2) || THURSDAY.equals(str2) || FRIDAY.equals(str2) || SATURDAY.equals(str2)) {
                i11++;
            } else {
                String valueOf = String.valueOf(str2);
                if (valueOf.length() != 0) {
                    str = "Invalid weekday ".concat(valueOf);
                } else {
                    str = new String("Invalid weekday ");
                }
                throw new IllegalArgumentException(str);
            }
        }
        put("dayOfWeek", strArr);
        return this;
    }

    @NonNull
    public AlarmBuilder setEnabled(boolean z11) {
        put("enabled", z11);
        return this;
    }

    @NonNull
    public AlarmBuilder setHour(int i11) {
        if (i11 < 0 || i11 > 23) {
            throw new IllegalArgumentException("Invalid alarm hour");
        }
        put("hour", (long) i11);
        return this;
    }

    @NonNull
    public AlarmBuilder setIdentifier(@NonNull String str) {
        put(Constants.IDENTIFIER, str);
        return this;
    }

    @NonNull
    public AlarmBuilder setMessage(@NonNull String str) {
        put("message", str);
        return this;
    }

    @NonNull
    public AlarmBuilder setMinute(int i11) {
        if (i11 < 0 || i11 > 59) {
            throw new IllegalArgumentException("Invalid alarm minute");
        }
        put("minute", (long) i11);
        return this;
    }

    @NonNull
    public AlarmBuilder setRingtone(@NonNull String str) {
        put("ringtone", str);
        return this;
    }

    @NonNull
    public AlarmBuilder setVibrate(boolean z11) {
        put("vibrate", z11);
        return this;
    }
}
