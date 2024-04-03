package com.google.firebase.appindexing.builders;

import androidx.annotation.NonNull;
import com.google.firebase.appindexing.internal.zzae;
import java.util.Calendar;

public class AlarmInstanceBuilder extends IndexableBuilder<AlarmInstanceBuilder> {
    @NonNull
    public static final String DISMISSED = "Dismissed";
    @NonNull
    public static final String FIRED = "Fired";
    @NonNull
    public static final String MISSED = "Missed";
    @NonNull
    public static final String SCHEDULED = "Scheduled";
    @NonNull
    public static final String SNOOZED = "Snoozed";
    @NonNull
    public static final String UNKNOWN = "Unknown";

    public AlarmInstanceBuilder() {
        super("AlarmInstance");
    }

    @NonNull
    public AlarmInstanceBuilder setAlarmStatus(@NonNull String str) {
        String str2;
        if (FIRED.equals(str) || SNOOZED.equals(str) || "Missed".equals(str) || DISMISSED.equals(str) || SCHEDULED.equals(str) || "Unknown".equals(str)) {
            return (AlarmInstanceBuilder) put("alarmStatus", str);
        }
        String valueOf = String.valueOf(str);
        if (valueOf.length() != 0) {
            str2 = "Invalid alarm status ".concat(valueOf);
        } else {
            str2 = new String("Invalid alarm status ");
        }
        throw new IllegalArgumentException(str2);
    }

    @NonNull
    public AlarmInstanceBuilder setScheduledTime(@NonNull Calendar calendar) {
        return (AlarmInstanceBuilder) put("scheduledTime", zzae.zza(calendar));
    }
}
