package com.huawei.location.nlp.network.request;

import com.huawei.location.nlp.network.response.Location;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class CacheLocationOnline extends Location {
    private float accFilter;
    private short flagsFilter;
    private double latFilter;
    private double lonFilter;

    public float getAccFilter() {
        return this.accFilter;
    }

    public short getFlagsFilter() {
        return this.flagsFilter;
    }

    public double getLatFilter() {
        return this.latFilter;
    }

    public double getLonFilter() {
        return this.lonFilter;
    }

    public void setAccFilter(float f11) {
        this.accFilter = f11;
    }

    public void setFlagsFilter(short s11) {
        this.flagsFilter = s11;
    }

    public void setLatFilter(double d11) {
        this.latFilter = d11;
    }

    public void setLonFilter(double d11) {
        this.lonFilter = d11;
    }

    public String toString() {
        return "CacheLocationOnline{" + super.toString() + "latFilter=" + this.latFilter + ", lonFilter=" + this.lonFilter + ", accFilter=" + this.accFilter + ", flagsFilter=" + this.flagsFilter + AbstractJsonLexerKt.END_OBJ;
    }
}
