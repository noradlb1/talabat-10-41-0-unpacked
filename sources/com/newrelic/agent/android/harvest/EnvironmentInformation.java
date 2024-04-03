package com.newrelic.agent.android.harvest;

public class EnvironmentInformation {
    private long[] diskAvailable;
    private long memoryUsage;
    private String networkStatus;
    private String networkWanType;
    private int orientation;

    public EnvironmentInformation() {
    }

    public EnvironmentInformation(long j11, int i11, String str, String str2, long[] jArr) {
        this.memoryUsage = j11;
        this.orientation = i11;
        this.networkStatus = str;
        this.networkWanType = str2;
        this.diskAvailable = jArr;
    }

    public long[] getDiskAvailable() {
        return this.diskAvailable;
    }

    public long getMemoryUsage() {
        return this.memoryUsage;
    }

    public String getNetworkStatus() {
        return this.networkStatus;
    }

    public String getNetworkWanType() {
        return this.networkWanType;
    }

    public int getOrientation() {
        return this.orientation;
    }

    public void setDiskAvailable(long[] jArr) {
        this.diskAvailable = jArr;
    }

    public void setMemoryUsage(long j11) {
        this.memoryUsage = j11;
    }

    public void setNetworkStatus(String str) {
        this.networkStatus = str;
    }

    public void setNetworkWanType(String str) {
        this.networkWanType = str;
    }

    public void setOrientation(int i11) {
        this.orientation = i11;
    }
}
