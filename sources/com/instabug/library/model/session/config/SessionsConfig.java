package com.instabug.library.model.session.config;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;

public class SessionsConfig {
    private final int maxSessionsPerRequest;
    private final int syncIntervalsInMinutes;
    private final int syncMode;

    public SessionsConfig(@IntRange(from = 0) int i11, @IntRange(from = 1) int i12, @IntRange(from = 0) int i13) {
        this.syncIntervalsInMinutes = i11;
        this.maxSessionsPerRequest = i12;
        this.syncMode = i13;
    }

    public static SessionsConfig a() {
        return new SessionsConfig(720, 10, 2);
    }

    public int getMaxSessionsPerRequest() {
        return this.maxSessionsPerRequest;
    }

    public int getSyncIntervalsInMinutes() {
        return this.syncIntervalsInMinutes;
    }

    public int getSyncMode() {
        return this.syncMode;
    }

    @NonNull
    public String toString() {
        return "{syncIntervalsInMinutes = " + this.syncIntervalsInMinutes + ", maxSessionsPerRequest = " + this.maxSessionsPerRequest + ", syncMode = " + this.syncMode + "}";
    }
}
