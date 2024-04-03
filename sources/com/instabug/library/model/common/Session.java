package com.instabug.library.model.common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public interface Session {
    @Nullable
    String getAppVersion();

    @NonNull
    String getId();

    @NonNull
    String getOs();

    long getStartNanoTime();

    long getStartTimestampMicros();

    @NonNull
    String getUuid();

    String getVersion();
}
