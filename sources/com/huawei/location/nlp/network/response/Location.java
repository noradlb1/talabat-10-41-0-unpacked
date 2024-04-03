package com.huawei.location.nlp.network.response;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class Location {
    private float acc;
    private float bearing;
    private String buildingId;
    private String extraInfo;
    private short flags;
    private int floor;
    private int floorAcc;
    private double lat;
    private double lon;
    private float speed;
    private long time;

    public float getAccuracy() {
        return this.acc;
    }

    public float getBearing() {
        return this.bearing;
    }

    public String getBuildingId() {
        return this.buildingId;
    }

    public String getExtraInfo() {
        return this.extraInfo;
    }

    public short getFlags() {
        return this.flags;
    }

    public int getFloor() {
        return this.floor;
    }

    public int getFloorAcc() {
        return this.floorAcc;
    }

    public double getLatitude() {
        return this.lat;
    }

    public double getLongitude() {
        return this.lon;
    }

    public float getSpeed() {
        return this.speed;
    }

    public long getTime() {
        return this.time;
    }

    public void setAccuracy(float f11) {
        this.acc = f11;
    }

    public void setBearing(float f11) {
        this.bearing = f11;
    }

    public void setBuildingId(String str) {
        this.buildingId = str;
    }

    public void setExtraInfo(String str) {
        this.extraInfo = str;
    }

    public void setFlags(short s11) {
        this.flags = s11;
    }

    public void setFloor(int i11) {
        this.floor = i11;
    }

    public void setFloorAcc(int i11) {
        this.floorAcc = i11;
    }

    public void setLatitude(double d11) {
        this.lat = d11;
    }

    public void setLongitude(double d11) {
        this.lon = d11;
    }

    public void setSpeed(float f11) {
        this.speed = f11;
    }

    public void setTime(long j11) {
        this.time = j11;
    }

    public String toString() {
        return "Location{lat=" + this.lat + ", lon=" + this.lon + ", acc=" + this.acc + ", speed=" + this.speed + ", bearing=" + this.bearing + ", flags=" + this.flags + ", time=" + this.time + ", buildingId='" + this.buildingId + '\'' + ", floor=" + this.floor + ", floorAcc=" + this.floorAcc + ", extraInfo='" + this.extraInfo + '\'' + AbstractJsonLexerKt.END_OBJ;
    }
}
