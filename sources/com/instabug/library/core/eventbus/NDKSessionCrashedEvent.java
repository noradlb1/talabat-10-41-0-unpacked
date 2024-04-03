package com.instabug.library.core.eventbus;

import androidx.annotation.NonNull;

public class NDKSessionCrashedEvent {
    private final long sessionDuration;
    private final String sessionId;

    public NDKSessionCrashedEvent(@NonNull String str, long j11) {
        this.sessionId = str;
        this.sessionDuration = j11;
    }

    public long getSessionDuration() {
        return this.sessionDuration;
    }

    @NonNull
    public String getSessionId() {
        return this.sessionId;
    }
}
