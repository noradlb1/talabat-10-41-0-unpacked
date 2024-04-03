package com.huawei.location.resp;

public class LocationAvailabilityInfo {
    private int cellStatus;
    private long elapsedRealtimeNs;
    private int locationStatus;
    private int wifiStatus;

    public int getCellStatus() {
        return this.cellStatus;
    }

    public long getElapsedRealtimeNs() {
        return this.elapsedRealtimeNs;
    }

    public int getLocationStatus() {
        return this.locationStatus;
    }

    public int getWifiStatus() {
        return this.wifiStatus;
    }

    public void setCellStatus(int i11) {
        this.cellStatus = i11;
    }

    public void setElapsedRealtimeNs(long j11) {
        this.elapsedRealtimeNs = j11;
    }

    public void setLocationStatus(int i11) {
        this.locationStatus = i11;
    }

    public void setWifiStatus(int i11) {
        this.wifiStatus = i11;
    }
}
