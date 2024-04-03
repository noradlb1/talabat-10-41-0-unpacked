package com.huawei.hms.support.api.entity.location.offlinelocation;

public class HwCellInfo {
    private long cellId;
    private int channelNumber;
    private boolean isRegistered;
    private int lacOrTac;
    private int mcc;
    private int mnc;
    private int physicalIdentity;
    private int rat;
    private int rssi;
    private long timeStamp;

    public long getCellId() {
        return this.cellId;
    }

    public int getChannelNumber() {
        return this.channelNumber;
    }

    public int getLacOrTac() {
        return this.lacOrTac;
    }

    public int getMcc() {
        return this.mcc;
    }

    public int getMnc() {
        return this.mnc;
    }

    public int getPhysicalIdentity() {
        return this.physicalIdentity;
    }

    public int getRat() {
        return this.rat;
    }

    public int getRssi() {
        return this.rssi;
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public boolean isRegistered() {
        return this.isRegistered;
    }

    public void setCellId(long j11) {
        this.cellId = j11;
    }

    public void setChannelNumber(int i11) {
        this.channelNumber = i11;
    }

    public void setLacOrTac(int i11) {
        this.lacOrTac = i11;
    }

    public void setMcc(int i11) {
        this.mcc = i11;
    }

    public void setMnc(int i11) {
        this.mnc = i11;
    }

    public void setPhysicalIdentity(int i11) {
        this.physicalIdentity = i11;
    }

    public void setRat(int i11) {
        this.rat = i11;
    }

    public void setRegistered(boolean z11) {
        this.isRegistered = z11;
    }

    public void setRssi(int i11) {
        this.rssi = i11;
    }

    public void setTimeStamp(long j11) {
        this.timeStamp = j11;
    }
}
