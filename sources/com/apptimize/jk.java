package com.apptimize;

import android.content.res.Resources;

public class jk implements jj<Number, Number> {

    /* renamed from: a  reason: collision with root package name */
    private float f43114a;

    public jk(float f11) {
        this.f43114a = f11;
    }

    public static jk a(Resources resources) {
        return new jk(resources.getDisplayMetrics().density);
    }

    public static jk b(Resources resources) {
        return new jk(resources.getDisplayMetrics().scaledDensity);
    }

    /* renamed from: a */
    public Number b(Number number) {
        return Integer.valueOf((int) ((((float) number.intValue()) / this.f43114a) + 0.5f));
    }

    /* renamed from: b */
    public Number a(Number number) {
        return Integer.valueOf((int) ((((float) number.intValue()) * this.f43114a) + 0.5f));
    }

    public Class<Number> a() {
        return Number.class;
    }

    public Class<Number> b() {
        return Number.class;
    }
}
