package com.google.firebase.database.connection.util;

import com.google.firebase.database.logging.LogWrapper;
import com.google.firebase.database.logging.Logger;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class RetryHelper {
    private long currentRetryDelay;
    private final ScheduledExecutorService executorService;
    private final double jitterFactor;
    private boolean lastWasSuccess;
    private final LogWrapper logger;
    private final long maxRetryDelay;
    private final long minRetryDelayAfterFailure;
    private final Random random;
    private final double retryExponent;
    /* access modifiers changed from: private */
    public ScheduledFuture<?> scheduledRetry;

    public static class Builder {
        private double jitterFactor = 0.5d;
        private final LogWrapper logger;
        private long minRetryDelayAfterFailure = 1000;
        private double retryExponent = 1.3d;
        private long retryMaxDelay = 30000;

        /* renamed from: service  reason: collision with root package name */
        private final ScheduledExecutorService f47399service;

        public Builder(ScheduledExecutorService scheduledExecutorService, Logger logger2, String str) {
            this.f47399service = scheduledExecutorService;
            this.logger = new LogWrapper(logger2, str);
        }

        public RetryHelper build() {
            return new RetryHelper(this.f47399service, this.logger, this.minRetryDelayAfterFailure, this.retryMaxDelay, this.retryExponent, this.jitterFactor);
        }

        public Builder withJitterFactor(double d11) {
            if (d11 < 0.0d || d11 > 1.0d) {
                throw new IllegalArgumentException("Argument out of range: " + d11);
            }
            this.jitterFactor = d11;
            return this;
        }

        public Builder withMaxDelay(long j11) {
            this.retryMaxDelay = j11;
            return this;
        }

        public Builder withMinDelayAfterFailure(long j11) {
            this.minRetryDelayAfterFailure = j11;
            return this;
        }

        public Builder withRetryExponent(double d11) {
            this.retryExponent = d11;
            return this;
        }
    }

    public void cancel() {
        if (this.scheduledRetry != null) {
            this.logger.debug("Cancelling existing retry attempt", new Object[0]);
            this.scheduledRetry.cancel(false);
            this.scheduledRetry = null;
        } else {
            this.logger.debug("No existing retry attempt to cancel", new Object[0]);
        }
        this.currentRetryDelay = 0;
    }

    public void retry(final Runnable runnable) {
        AnonymousClass1 r02 = new Runnable() {
            public void run() {
                ScheduledFuture unused = RetryHelper.this.scheduledRetry = null;
                runnable.run();
            }
        };
        if (this.scheduledRetry != null) {
            this.logger.debug("Cancelling previous scheduled retry", new Object[0]);
            this.scheduledRetry.cancel(false);
            this.scheduledRetry = null;
        }
        long j11 = 0;
        if (!this.lastWasSuccess) {
            long j12 = this.currentRetryDelay;
            if (j12 == 0) {
                this.currentRetryDelay = this.minRetryDelayAfterFailure;
            } else {
                this.currentRetryDelay = Math.min((long) (((double) j12) * this.retryExponent), this.maxRetryDelay);
            }
            double d11 = this.jitterFactor;
            long j13 = this.currentRetryDelay;
            j11 = (long) (((1.0d - d11) * ((double) j13)) + (d11 * ((double) j13) * this.random.nextDouble()));
        }
        this.lastWasSuccess = false;
        this.logger.debug("Scheduling retry in %dms", Long.valueOf(j11));
        this.scheduledRetry = this.executorService.schedule(r02, j11, TimeUnit.MILLISECONDS);
    }

    public void setMaxDelay() {
        this.currentRetryDelay = this.maxRetryDelay;
    }

    public void signalSuccess() {
        this.lastWasSuccess = true;
        this.currentRetryDelay = 0;
    }

    private RetryHelper(ScheduledExecutorService scheduledExecutorService, LogWrapper logWrapper, long j11, long j12, double d11, double d12) {
        this.random = new Random();
        this.lastWasSuccess = true;
        this.executorService = scheduledExecutorService;
        this.logger = logWrapper;
        this.minRetryDelayAfterFailure = j11;
        this.maxRetryDelay = j12;
        this.retryExponent = d11;
        this.jitterFactor = d12;
    }
}
