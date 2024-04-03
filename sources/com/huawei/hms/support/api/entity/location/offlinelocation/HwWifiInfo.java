package com.huawei.hms.support.api.entity.location.offlinelocation;

public class HwWifiInfo {
    private String bssid;
    private int frequency;
    private int rssi;
    private long timestamp;

    public String getBssid() {
        return this.bssid;
    }

    public int getFrequency() {
        return this.frequency;
    }

    public int getRssi() {
        return this.rssi;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setBssid(String str) {
        this.bssid = str;
    }

    public void setFrequency(int i11) {
        this.frequency = i11;
    }

    public void setRssi(int i11) {
        this.rssi = i11;
    }

    public void setTimestamp(long j11) {
        this.timestamp = j11;
    }
}
