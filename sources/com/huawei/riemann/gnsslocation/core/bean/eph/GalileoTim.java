package com.huawei.riemann.gnsslocation.core.bean.eph;

public class GalileoTim {
    public double mA0;
    public double mA1;
    public long mT0;

    public static final class Builder {

        /* renamed from: a0  reason: collision with root package name */
        public double f50317a0;

        /* renamed from: a1  reason: collision with root package name */
        public double f50318a1;

        /* renamed from: t0  reason: collision with root package name */
        public long f50319t0;

        public static Builder aGalileoTim() {
            return new Builder();
        }

        public GalileoTim build() {
            GalileoTim galileoTim = new GalileoTim();
            double unused = galileoTim.mA0 = this.f50317a0;
            double unused2 = galileoTim.mA1 = this.f50318a1;
            long unused3 = galileoTim.mT0 = this.f50319t0;
            return galileoTim;
        }

        public Builder but() {
            return aGalileoTim().withA0(this.f50317a0).withA1(this.f50318a1).withT0(this.f50319t0);
        }

        public Builder withA0(double d11) {
            this.f50317a0 = d11;
            return this;
        }

        public Builder withA1(double d11) {
            this.f50318a1 = d11;
            return this;
        }

        public Builder withT0(long j11) {
            this.f50319t0 = j11;
            return this;
        }
    }

    public double getA0() {
        return this.mA0;
    }

    public double getA1() {
        return this.mA1;
    }

    public long getT0() {
        return this.mT0;
    }
}
