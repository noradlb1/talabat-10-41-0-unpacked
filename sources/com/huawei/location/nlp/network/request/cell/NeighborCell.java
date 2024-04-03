package com.huawei.location.nlp.network.request.cell;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class NeighborCell {
    private int cNum;
    private int pId;
    private short rssi;

    public NeighborCell(int i11, int i12, short s11) {
        this.cNum = i11;
        this.pId = i12;
        this.rssi = s11;
    }

    public short getRssi() {
        return this.rssi;
    }

    public int getcNum() {
        return this.cNum;
    }

    public int getpId() {
        return this.pId;
    }

    public void setRssi(short s11) {
        this.rssi = s11;
    }

    public void setcNum(int i11) {
        this.cNum = i11;
    }

    public void setpId(int i11) {
        this.pId = i11;
    }

    public String toString() {
        return "NeighborCell{cNum=" + this.cNum + ", pId=" + this.pId + ", rssi=" + this.rssi + AbstractJsonLexerKt.END_OBJ;
    }
}
