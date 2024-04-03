package com.google.firebase.appindexing.builders;

import androidx.annotation.NonNull;
import com.google.firebase.appindexing.internal.zzae;
import com.huawei.wisesecurity.ucs.credential.Credential;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.util.Calendar;

public final class TimerBuilder extends IndexableBuilder<TimerBuilder> {
    @NonNull
    public static final String EXPIRED = "Expired";
    @NonNull
    public static final String MISSED = "Missed";
    @NonNull
    public static final String PAUSED = "Paused";
    @NonNull
    public static final String RESET = "Reset";
    @NonNull
    public static final String STARTED = "Started";
    @NonNull
    public static final String UNKNOWN = "Unknown";

    public TimerBuilder() {
        super("Timer");
    }

    @NonNull
    public TimerBuilder setExpireTime(@NonNull Calendar calendar) {
        put(Credential.EXPIRE_TIME, zzae.zza(calendar));
        return this;
    }

    @NonNull
    public TimerBuilder setIdentifier(@NonNull String str) {
        put(Constants.IDENTIFIER, str);
        return this;
    }

    @NonNull
    public TimerBuilder setLength(long j11) {
        put("length", j11);
        return this;
    }

    @NonNull
    public TimerBuilder setMessage(@NonNull String str) {
        put("message", str);
        return this;
    }

    @NonNull
    public TimerBuilder setRemainingTime(long j11) {
        put("remainingTime", j11);
        return this;
    }

    @NonNull
    public TimerBuilder setRingtone(@NonNull String str) {
        put("ringtone", str);
        return this;
    }

    @NonNull
    public TimerBuilder setTimerStatus(@NonNull String str) {
        String str2;
        if ("Started".equals(str) || "Paused".equals(str) || EXPIRED.equals(str) || "Missed".equals(str) || RESET.equals(str) || "Unknown".equals(str)) {
            put("timerStatus", str);
            return this;
        }
        String valueOf = String.valueOf(str);
        if (valueOf.length() != 0) {
            str2 = "Invalid timer status ".concat(valueOf);
        } else {
            str2 = new String("Invalid timer status ");
        }
        throw new IllegalArgumentException(str2);
    }

    @NonNull
    public TimerBuilder setVibrate(boolean z11) {
        put("vibrate", z11);
        return this;
    }
}
