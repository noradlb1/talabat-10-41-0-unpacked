package com.batoulapps.adhan.internal;

class SolarCoordinates {

    /* renamed from: a  reason: collision with root package name */
    public final double f43257a;

    /* renamed from: b  reason: collision with root package name */
    public final double f43258b;

    /* renamed from: c  reason: collision with root package name */
    public final double f43259c;

    public SolarCoordinates(double d11) {
        double a11 = CalendricalHelper.a(d11);
        double n11 = Astronomical.n(a11);
        double j11 = Astronomical.j(a11);
        double e11 = Astronomical.e(a11);
        double radians = Math.toRadians(Astronomical.c(a11, n11));
        double l11 = Astronomical.l(a11);
        double d12 = a11;
        double d13 = n11;
        double d14 = j11;
        double d15 = e11;
        double o11 = Astronomical.o(d12, d13, d14, d15);
        double p11 = Astronomical.p(d12, d13, d14, d15);
        double k11 = Astronomical.k(a11);
        double radians2 = Math.toRadians(Astronomical.b(a11, k11));
        this.f43257a = Math.toDegrees(Math.asin(Math.sin(radians2) * Math.sin(radians)));
        this.f43258b = DoubleUtil.c(Math.toDegrees(Math.atan2(Math.cos(radians2) * Math.sin(radians), Math.cos(radians))));
        this.f43259c = l11 + (((o11 * 3600.0d) * Math.cos(Math.toRadians(k11 + p11))) / 3600.0d);
    }
}
