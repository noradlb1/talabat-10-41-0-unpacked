package com.huawei.location.nlp.network.request.wifi;

public class WifiInfo {
    private static final int FLAG_SAME_CODE = 16;
    private int frequency;
    private long mac;
    private int rssi;
    private long time;

    public WifiInfo(long j11, int i11, long j12, int i12) {
        this.mac = j11;
        this.rssi = i11;
        this.time = j12;
        this.frequency = i12;
    }

    public int getFrequency() {
        return this.frequency;
    }

    public long getMac() {
        return this.mac;
    }

    public int getRssi() {
        return this.rssi;
    }

    public long getSameCode() {
        return this.mac / 16;
    }

    public long getTime() {
        return this.time;
    }

    public void setFrequency(int i11) {
        this.frequency = i11;
    }

    public void setMac(long j11) {
        this.mac = j11;
    }

    public void setRssi(short s11) {
        this.rssi = s11;
    }

    public void setTime(long j11) {
        this.time = j11;
    }
}
