package com.adjust.sdk;

import com.newrelic.agent.android.payload.PayloadController;
import org.apache.commons.lang3.time.DateUtils;

public enum BackoffStrategy {
    LONG_WAIT(1, PayloadController.PAYLOAD_REQUEUE_PERIOD_MS, 86400000, 0.5d, 1.0d),
    SHORT_WAIT(1, 200, DateUtils.MILLIS_PER_HOUR, 0.5d, 1.0d),
    TEST_WAIT(1, 200, 1000, 0.5d, 1.0d),
    NO_WAIT(100, 1, 1000, 1.0d, 1.0d);
    
    public double maxRange;
    public long maxWait;
    public long milliSecondMultiplier;
    public double minRange;
    public int minRetries;

    private BackoffStrategy(int i11, long j11, long j12, double d11, double d12) {
        this.minRetries = i11;
        this.milliSecondMultiplier = j11;
        this.maxWait = j12;
        this.minRange = d11;
        this.maxRange = d12;
    }
}
