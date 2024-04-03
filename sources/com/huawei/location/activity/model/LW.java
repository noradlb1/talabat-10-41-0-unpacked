package com.huawei.location.activity.model;

import com.huawei.location.lite.common.log.LogConsole;

public class LW implements Cloneable {
    private float FB;
    private float LW;
    private float Vw;

    /* renamed from: yn  reason: collision with root package name */
    private long f49990yn;

    public LW() {
        this(0.0f, 0.0f, 0.0f);
    }

    public LW(float f11, float f12, float f13) {
        this.Vw = f11;
        this.FB = f12;
        this.LW = f13;
    }

    public float FB() {
        return this.FB;
    }

    public void FB(float f11) {
        this.LW = f11;
    }

    public float LW() {
        return this.LW;
    }

    public float Vw() {
        return this.Vw;
    }

    public void Vw(float f11) {
        this.FB = f11;
    }

    public Object clone() throws CloneNotSupportedException {
        LW lw2 = new LW(0.0f, 0.0f, 0.0f);
        try {
            if (super.clone() instanceof LW) {
                return (LW) super.clone();
            }
            return lw2;
        } catch (CloneNotSupportedException unused) {
            LogConsole.e("SensorRecord", "Clone Not Supported Exception");
            return lw2;
        }
    }

    public String toString() {
        return "time: " + this.f49990yn + " x:" + this.Vw + " y:" + this.FB + " z:" + this.LW;
    }

    public long yn() {
        return this.f49990yn;
    }

    public void yn(float f11) {
        this.Vw = f11;
    }

    public void yn(long j11) {
        this.f49990yn = j11;
    }
}
