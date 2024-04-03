package com.newrelic.agent.android.api.common;

import java.util.concurrent.TimeUnit;

public final class ConnectionState {
    public static final ConnectionState NULL = new ConnectionState();
    private final boolean collectingNetworkErrors;
    private final String crossProcessId;
    private final Object dataToken;
    private final int errorLimit;
    private final long harvestInterval;
    private final TimeUnit harvestIntervalTimeUnit;
    private final long maxTransactionAge;
    private final TimeUnit maxTransactionAgeTimeUnit;
    private final long maxTransactionCount;
    private final int responseBodyLimit;
    private final long serverTimestamp;
    private final int stackTraceLimit;

    private ConnectionState() {
        this.dataToken = null;
        this.crossProcessId = null;
        this.serverTimestamp = 0;
        this.harvestInterval = 60;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        this.harvestIntervalTimeUnit = timeUnit;
        this.maxTransactionAge = 600;
        this.maxTransactionAgeTimeUnit = timeUnit;
        this.maxTransactionCount = 1000;
        this.stackTraceLimit = 50;
        this.responseBodyLimit = 1024;
        this.collectingNetworkErrors = true;
        this.errorLimit = 10;
    }

    public String getCrossProcessId() {
        return this.crossProcessId;
    }

    public Object getDataToken() {
        return this.dataToken;
    }

    public int getErrorLimit() {
        return this.errorLimit;
    }

    public long getHarvestIntervalInMilliseconds() {
        return TimeUnit.MILLISECONDS.convert(this.harvestInterval, this.harvestIntervalTimeUnit);
    }

    public long getHarvestIntervalInSeconds() {
        return TimeUnit.SECONDS.convert(this.harvestInterval, this.harvestIntervalTimeUnit);
    }

    public long getMaxTransactionAgeInMilliseconds() {
        return TimeUnit.MILLISECONDS.convert(this.maxTransactionAge, this.maxTransactionAgeTimeUnit);
    }

    public long getMaxTransactionAgeInSeconds() {
        return TimeUnit.SECONDS.convert(this.maxTransactionAge, this.maxTransactionAgeTimeUnit);
    }

    public long getMaxTransactionCount() {
        return this.maxTransactionCount;
    }

    public int getResponseBodyLimit() {
        return this.responseBodyLimit;
    }

    public long getServerTimestamp() {
        return this.serverTimestamp;
    }

    public int getStackTraceLimit() {
        return this.stackTraceLimit;
    }

    public boolean isCollectingNetworkErrors() {
        return this.collectingNetworkErrors;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.dataToken);
        return sb2.toString();
    }

    public ConnectionState(Object obj, String str, long j11, long j12, TimeUnit timeUnit, long j13, TimeUnit timeUnit2, long j14, int i11, int i12, boolean z11, int i13) {
        this.dataToken = obj;
        this.crossProcessId = str;
        this.serverTimestamp = j11;
        this.harvestInterval = j12;
        this.harvestIntervalTimeUnit = timeUnit;
        this.maxTransactionAge = j13;
        this.maxTransactionAgeTimeUnit = timeUnit2;
        this.maxTransactionCount = j14;
        this.stackTraceLimit = i11;
        this.responseBodyLimit = i12;
        this.collectingNetworkErrors = z11;
        this.errorLimit = i13;
    }
}
