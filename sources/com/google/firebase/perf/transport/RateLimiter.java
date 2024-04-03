package com.google.firebase.perf.transport;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.metrics.resource.ResourceType;
import com.google.firebase.perf.util.Clock;
import com.google.firebase.perf.util.Constants;
import com.google.firebase.perf.util.Rate;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.util.Utils;
import com.google.firebase.perf.v1.PerfMetric;
import com.google.firebase.perf.v1.PerfSession;
import com.google.firebase.perf.v1.SessionVerbosity;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

final class RateLimiter {
    private final ConfigResolver configResolver;
    private final double fragmentBucketId;
    private boolean isLogcatEnabled;
    private RateLimiterImpl networkLimiter;
    private final double samplingBucketId;
    private RateLimiterImpl traceLimiter;

    public static class RateLimiterImpl {
        private static final long MICROS_IN_A_SECOND = TimeUnit.SECONDS.toMicros(1);
        private static final AndroidLogger logger = AndroidLogger.getInstance();
        private long backgroundCapacity;
        private Rate backgroundRate;
        private long capacity;
        private final Clock clock;
        private long foregroundCapacity;
        private Rate foregroundRate;
        private final boolean isLogcatEnabled;
        private Timer lastTimeTokenReplenished;
        private Rate rate;
        private double tokenCount;

        public RateLimiterImpl(Rate rate2, long j11, Clock clock2, ConfigResolver configResolver, @ResourceType String str, boolean z11) {
            this.clock = clock2;
            this.capacity = j11;
            this.rate = rate2;
            this.tokenCount = (double) j11;
            this.lastTimeTokenReplenished = clock2.getTime();
            setRateByReadingRemoteConfigValues(configResolver, str, z11);
            this.isLogcatEnabled = z11;
        }

        private static long getBlimitEvents(ConfigResolver configResolver, @ResourceType String str) {
            if (str == ResourceType.TRACE) {
                return configResolver.getTraceEventCountBackground();
            }
            return configResolver.getNetworkEventCountBackground();
        }

        private static long getBlimitSec(ConfigResolver configResolver, @ResourceType String str) {
            if (str == ResourceType.TRACE) {
                return configResolver.getRateLimitSec();
            }
            return configResolver.getRateLimitSec();
        }

        private static long getFlimitEvents(ConfigResolver configResolver, @ResourceType String str) {
            if (str == ResourceType.TRACE) {
                return configResolver.getTraceEventCountForeground();
            }
            return configResolver.getNetworkEventCountForeground();
        }

        private static long getFlimitSec(ConfigResolver configResolver, @ResourceType String str) {
            if (str == ResourceType.TRACE) {
                return configResolver.getRateLimitSec();
            }
            return configResolver.getRateLimitSec();
        }

        private void setRateByReadingRemoteConfigValues(ConfigResolver configResolver, @ResourceType String str, boolean z11) {
            long flimitSec = getFlimitSec(configResolver, str);
            long flimitEvents = getFlimitEvents(configResolver, str);
            TimeUnit timeUnit = TimeUnit.SECONDS;
            Rate rate2 = new Rate(flimitEvents, flimitSec, timeUnit);
            this.foregroundRate = rate2;
            this.foregroundCapacity = flimitEvents;
            if (z11) {
                logger.debug("Foreground %s logging rate:%f, burst capacity:%d", str, rate2, Long.valueOf(flimitEvents));
            }
            long blimitSec = getBlimitSec(configResolver, str);
            long blimitEvents = getBlimitEvents(configResolver, str);
            Rate rate3 = new Rate(blimitEvents, blimitSec, timeUnit);
            this.backgroundRate = rate3;
            this.backgroundCapacity = blimitEvents;
            if (z11) {
                logger.debug("Background %s logging rate:%f, capacity:%d", str, rate3, Long.valueOf(blimitEvents));
            }
        }

        public synchronized void changeRate(boolean z11) {
            Rate rate2;
            long j11;
            if (z11) {
                rate2 = this.foregroundRate;
            } else {
                rate2 = this.backgroundRate;
            }
            this.rate = rate2;
            if (z11) {
                j11 = this.foregroundCapacity;
            } else {
                j11 = this.backgroundCapacity;
            }
            this.capacity = j11;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0047, code lost:
            return false;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized boolean check(@androidx.annotation.NonNull com.google.firebase.perf.v1.PerfMetric r5) {
            /*
                r4 = this;
                monitor-enter(r4)
                com.google.firebase.perf.util.Clock r5 = r4.clock     // Catch:{ all -> 0x0049 }
                com.google.firebase.perf.util.Timer r5 = r5.getTime()     // Catch:{ all -> 0x0049 }
                com.google.firebase.perf.util.Timer r0 = r4.lastTimeTokenReplenished     // Catch:{ all -> 0x0049 }
                long r0 = r0.getDurationMicros(r5)     // Catch:{ all -> 0x0049 }
                double r0 = (double) r0     // Catch:{ all -> 0x0049 }
                com.google.firebase.perf.util.Rate r2 = r4.rate     // Catch:{ all -> 0x0049 }
                double r2 = r2.getTokensPerSeconds()     // Catch:{ all -> 0x0049 }
                double r0 = r0 * r2
                long r2 = MICROS_IN_A_SECOND     // Catch:{ all -> 0x0049 }
                double r2 = (double) r2     // Catch:{ all -> 0x0049 }
                double r0 = r0 / r2
                r2 = 0
                int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r2 <= 0) goto L_0x002d
                double r2 = r4.tokenCount     // Catch:{ all -> 0x0049 }
                double r2 = r2 + r0
                long r0 = r4.capacity     // Catch:{ all -> 0x0049 }
                double r0 = (double) r0     // Catch:{ all -> 0x0049 }
                double r0 = java.lang.Math.min(r2, r0)     // Catch:{ all -> 0x0049 }
                r4.tokenCount = r0     // Catch:{ all -> 0x0049 }
                r4.lastTimeTokenReplenished = r5     // Catch:{ all -> 0x0049 }
            L_0x002d:
                double r0 = r4.tokenCount     // Catch:{ all -> 0x0049 }
                r2 = 4607182418800017408(0x3ff0000000000000, double:1.0)
                int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r5 < 0) goto L_0x003b
                double r0 = r0 - r2
                r4.tokenCount = r0     // Catch:{ all -> 0x0049 }
                monitor-exit(r4)
                r5 = 1
                return r5
            L_0x003b:
                boolean r5 = r4.isLogcatEnabled     // Catch:{ all -> 0x0049 }
                if (r5 == 0) goto L_0x0046
                com.google.firebase.perf.logging.AndroidLogger r5 = logger     // Catch:{ all -> 0x0049 }
                java.lang.String r0 = "Exceeded log rate limit, dropping the log."
                r5.warn(r0)     // Catch:{ all -> 0x0049 }
            L_0x0046:
                monitor-exit(r4)
                r5 = 0
                return r5
            L_0x0049:
                r5 = move-exception
                monitor-exit(r4)
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.transport.RateLimiter.RateLimiterImpl.check(com.google.firebase.perf.v1.PerfMetric):boolean");
        }

        @VisibleForTesting
        public long getBackgroundCapacity() {
            return this.backgroundCapacity;
        }

        @VisibleForTesting
        public Rate getBackgroundRate() {
            return this.backgroundRate;
        }

        @VisibleForTesting
        public long getForegroundCapacity() {
            return this.foregroundCapacity;
        }

        @VisibleForTesting
        public Rate getForegroundRate() {
            return this.foregroundRate;
        }

        @VisibleForTesting
        public Rate getRate() {
            return this.rate;
        }

        @VisibleForTesting
        public void setRate(Rate rate2) {
            this.rate = rate2;
        }
    }

    public RateLimiter(@NonNull Context context, Rate rate, long j11) {
        this(rate, j11, new Clock(), getSamplingBucketId(), getSamplingBucketId(), ConfigResolver.getInstance());
        this.isLogcatEnabled = Utils.isDebugLoggingEnabled(context);
    }

    @VisibleForTesting
    public static double getSamplingBucketId() {
        return new Random().nextDouble();
    }

    private boolean hasVerboseSessions(List<PerfSession> list) {
        if (list.size() <= 0 || list.get(0).getSessionVerbosityCount() <= 0 || list.get(0).getSessionVerbosity(0) != SessionVerbosity.GAUGES_AND_SYSTEM_EVENTS) {
            return false;
        }
        return true;
    }

    private boolean isDeviceAllowedToSendFragmentScreenTraces() {
        if (this.fragmentBucketId < this.configResolver.getFragmentSamplingRate()) {
            return true;
        }
        return false;
    }

    private boolean isDeviceAllowedToSendNetworkEvents() {
        if (this.samplingBucketId < this.configResolver.getNetworkRequestSamplingRate()) {
            return true;
        }
        return false;
    }

    private boolean isDeviceAllowedToSendTraces() {
        if (this.samplingBucketId < this.configResolver.getTraceSamplingRate()) {
            return true;
        }
        return false;
    }

    public void changeRate(boolean z11) {
        this.traceLimiter.changeRate(z11);
        this.networkLimiter.changeRate(z11);
    }

    @VisibleForTesting
    public boolean getIsDeviceAllowedToSendFragmentScreenTraces() {
        return isDeviceAllowedToSendFragmentScreenTraces();
    }

    @VisibleForTesting
    public boolean getIsDeviceAllowedToSendNetworkEvents() {
        return isDeviceAllowedToSendNetworkEvents();
    }

    @VisibleForTesting
    public boolean getIsDeviceAllowedToSendTraces() {
        return isDeviceAllowedToSendTraces();
    }

    public boolean isEventRateLimited(PerfMetric perfMetric) {
        if (!isRateLimitApplicable(perfMetric)) {
            return false;
        }
        if (perfMetric.hasNetworkRequestMetric()) {
            return !this.networkLimiter.check(perfMetric);
        }
        if (perfMetric.hasTraceMetric()) {
            return !this.traceLimiter.check(perfMetric);
        }
        return true;
    }

    public boolean isEventSampled(PerfMetric perfMetric) {
        if (perfMetric.hasTraceMetric() && !isDeviceAllowedToSendTraces() && !hasVerboseSessions(perfMetric.getTraceMetric().getPerfSessionsList())) {
            return false;
        }
        if (isFragmentScreenTrace(perfMetric) && !isDeviceAllowedToSendFragmentScreenTraces() && !hasVerboseSessions(perfMetric.getTraceMetric().getPerfSessionsList())) {
            return false;
        }
        if (!perfMetric.hasNetworkRequestMetric() || isDeviceAllowedToSendNetworkEvents() || hasVerboseSessions(perfMetric.getNetworkRequestMetric().getPerfSessionsList())) {
            return true;
        }
        return false;
    }

    public boolean isFragmentScreenTrace(PerfMetric perfMetric) {
        if (!perfMetric.hasTraceMetric() || !perfMetric.getTraceMetric().getName().startsWith(Constants.SCREEN_TRACE_PREFIX) || !perfMetric.getTraceMetric().containsCustomAttributes(Constants.ACTIVITY_ATTRIBUTE_KEY)) {
            return false;
        }
        return true;
    }

    public boolean isRateLimitApplicable(@NonNull PerfMetric perfMetric) {
        if ((!perfMetric.hasTraceMetric() || ((!perfMetric.getTraceMetric().getName().equals(Constants.TraceNames.FOREGROUND_TRACE_NAME.toString()) && !perfMetric.getTraceMetric().getName().equals(Constants.TraceNames.BACKGROUND_TRACE_NAME.toString())) || perfMetric.getTraceMetric().getCountersCount() <= 0)) && !perfMetric.hasGaugeMetric()) {
            return true;
        }
        return false;
    }

    public RateLimiter(Rate rate, long j11, Clock clock, double d11, double d12, ConfigResolver configResolver2) {
        double d13 = d11;
        double d14 = d12;
        this.traceLimiter = null;
        this.networkLimiter = null;
        boolean z11 = false;
        this.isLogcatEnabled = false;
        Utils.checkArgument(0.0d <= d13 && d13 < 1.0d, "Sampling bucket ID should be in range [0.0, 1.0).");
        if (0.0d <= d14 && d14 < 1.0d) {
            z11 = true;
        }
        Utils.checkArgument(z11, "Fragment sampling bucket ID should be in range [0.0, 1.0).");
        this.samplingBucketId = d13;
        this.fragmentBucketId = d14;
        this.configResolver = configResolver2;
        Rate rate2 = rate;
        long j12 = j11;
        Clock clock2 = clock;
        ConfigResolver configResolver3 = configResolver2;
        this.traceLimiter = new RateLimiterImpl(rate2, j12, clock2, configResolver3, ResourceType.TRACE, this.isLogcatEnabled);
        this.networkLimiter = new RateLimiterImpl(rate2, j12, clock2, configResolver3, ResourceType.NETWORK, this.isLogcatEnabled);
    }
}
