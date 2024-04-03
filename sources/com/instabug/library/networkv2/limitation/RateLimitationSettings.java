package com.instabug.library.networkv2.limitation;

public interface RateLimitationSettings {
    boolean isRateLimited();

    void setLastRequestStartedAt(long j11);

    void setLimitedUntil(int i11);
}
