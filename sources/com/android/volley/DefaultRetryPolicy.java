package com.android.volley;

public class DefaultRetryPolicy implements RetryPolicy {
    public static final float DEFAULT_BACKOFF_MULT = 1.0f;
    public static final int DEFAULT_MAX_RETRIES = 1;
    public static final int DEFAULT_TIMEOUT_MS = 2500;
    private final float mBackoffMultiplier;
    private int mCurrentRetryCount;
    private int mCurrentTimeoutMs;
    private final int mMaxNumRetries;

    public DefaultRetryPolicy() {
        this(2500, 1, 1.0f);
    }

    public float getBackoffMultiplier() {
        return this.mBackoffMultiplier;
    }

    public int getCurrentRetryCount() {
        return this.mCurrentRetryCount;
    }

    public int getCurrentTimeout() {
        return this.mCurrentTimeoutMs;
    }

    public boolean hasAttemptRemaining() {
        return this.mCurrentRetryCount <= this.mMaxNumRetries;
    }

    public void retry(VolleyError volleyError) throws VolleyError {
        this.mCurrentRetryCount++;
        int i11 = this.mCurrentTimeoutMs;
        this.mCurrentTimeoutMs = i11 + ((int) (((float) i11) * this.mBackoffMultiplier));
        if (!hasAttemptRemaining()) {
            throw volleyError;
        }
    }

    public DefaultRetryPolicy(int i11, int i12, float f11) {
        this.mCurrentTimeoutMs = i11;
        this.mMaxNumRetries = i12;
        this.mBackoffMultiplier = f11;
    }
}
