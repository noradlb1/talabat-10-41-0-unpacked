package com.google.firebase.installations.remote;

import androidx.annotation.GuardedBy;
import com.google.firebase.installations.Utils;
import java.util.concurrent.TimeUnit;

class RequestLimiter {
    private static final long MAXIMUM_BACKOFF_DURATION_FOR_CONFIGURATION_ERRORS = TimeUnit.HOURS.toMillis(24);
    private static final long MAXIMUM_BACKOFF_DURATION_FOR_SERVER_ERRORS = TimeUnit.MINUTES.toMillis(30);
    @GuardedBy("this")
    private int attemptCount;
    @GuardedBy("this")
    private long nextRequestTime;
    private final Utils utils;

    public RequestLimiter(Utils utils2) {
        this.utils = utils2;
    }

    private synchronized long getBackoffDuration(int i11) {
        if (!isRetryableError(i11)) {
            return MAXIMUM_BACKOFF_DURATION_FOR_CONFIGURATION_ERRORS;
        }
        return (long) Math.min(Math.pow(2.0d, (double) this.attemptCount) + ((double) this.utils.getRandomDelayForSyncPrevention()), (double) MAXIMUM_BACKOFF_DURATION_FOR_SERVER_ERRORS);
    }

    private static boolean isRetryableError(int i11) {
        return i11 == 429 || (i11 >= 500 && i11 < 600);
    }

    private static boolean isSuccessfulOrRequiresNewFidCreation(int i11) {
        return (i11 >= 200 && i11 < 300) || i11 == 401 || i11 == 404;
    }

    private synchronized void resetBackoffStrategy() {
        this.attemptCount = 0;
    }

    public synchronized boolean isRequestAllowed() {
        boolean z11;
        if (this.attemptCount == 0 || this.utils.currentTimeInMillis() > this.nextRequestTime) {
            z11 = true;
        } else {
            z11 = false;
        }
        return z11;
    }

    public synchronized void setNextRequestTime(int i11) {
        if (isSuccessfulOrRequiresNewFidCreation(i11)) {
            resetBackoffStrategy();
            return;
        }
        this.attemptCount++;
        this.nextRequestTime = this.utils.currentTimeInMillis() + getBackoffDuration(i11);
    }

    public RequestLimiter() {
        this.utils = Utils.getInstance();
    }
}
