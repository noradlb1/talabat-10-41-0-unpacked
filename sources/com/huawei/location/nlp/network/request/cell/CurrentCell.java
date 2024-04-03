package com.huawei.location.nlp.network.request.cell;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class CurrentCell {
    private long boottime;
    private long cellId;
    private int lac;
    private int mcc;
    private int mnc;
    private int rat;
    private short rssi;

    public long getBoottime() {
        return this.boottime;
    }

    public long getCellId() {
        return this.cellId;
    }

    public int getLac() {
        return this.lac;
    }

    public int getMcc() {
        return this.mcc;
    }

    public int getMnc() {
        return this.mnc;
    }

    public int getRat() {
        return this.rat;
    }

    public short getRssi() {
        return this.rssi;
    }

    public void setBoottime(long j11) {
        this.boottime = j11;
    }

    public void setCellId(long j11) {
        this.cellId = j11;
    }

    public void setLac(int i11) {
        this.lac = i11;
    }

    public void setMcc(int i11) {
        this.mcc = i11;
    }

    public void setMnc(int i11) {
        this.mnc = i11;
    }

    public void setRat(int i11) {
        this.rat = i11;
    }

    public void setRssi(short s11) {
        this.rssi = s11;
    }

    public String toString() {
        return "CurrentCell{boottime=" + this.boottime + ", mcc=" + this.mcc + ", mnc=" + this.mnc + ", lac=" + this.lac + ", cellId=" + this.cellId + ", rat=" + this.rat + ", rssi=" + this.rssi + AbstractJsonLexerKt.END_OBJ;
    }
}
