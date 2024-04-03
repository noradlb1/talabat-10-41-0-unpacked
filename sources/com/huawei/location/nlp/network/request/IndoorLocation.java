package com.huawei.location.nlp.network.request;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class IndoorLocation {
    private float acc;
    private String buildingId;
    private int flags;
    private int floor;
    private float floorAcc;
    private double lat;
    private double lon;
    private long time;

    public float getAcc() {
        return this.acc;
    }

    public String getBuildingId() {
        return this.buildingId;
    }

    public int getFlags() {
        return this.flags;
    }

    public int getFloor() {
        return this.floor;
    }

    public float getFloorAcc() {
        return this.floorAcc;
    }

    public double getLat() {
        return this.lat;
    }

    public double getLon() {
        return this.lon;
    }

    public long getTime() {
        return this.time;
    }

    public void setAcc(float f11) {
        this.acc = f11;
    }

    public void setBuildingId(String str) {
        this.buildingId = str;
    }

    public void setFlags(int i11) {
        this.flags = i11;
    }

    public void setFloor(int i11) {
        this.floor = i11;
    }

    public void setFloorAcc(float f11) {
        this.floorAcc = f11;
    }

    public void setLat(double d11) {
        this.lat = d11;
    }

    public void setLon(double d11) {
        this.lon = d11;
    }

    public void setTime(long j11) {
        this.time = j11;
    }

    public String toString() {
        return "IndoorLocation{lat=" + this.lat + ", lon=" + this.lon + ", acc=" + this.acc + ", buildingId='" + this.buildingId + '\'' + ", floor=" + this.floor + ", floorAcc=" + this.floorAcc + ", time=" + this.time + ", flags=" + this.flags + AbstractJsonLexerKt.END_OBJ;
    }
}
