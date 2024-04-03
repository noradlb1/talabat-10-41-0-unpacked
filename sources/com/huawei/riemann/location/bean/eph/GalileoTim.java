package com.huawei.riemann.location.bean.eph;

public class GalileoTim {
    public double mA0;
    public double mA1;
    public long mT0;

    public static final class Builder {

        /* renamed from: a0  reason: collision with root package name */
        public double f50412a0;

        /* renamed from: a1  reason: collision with root package name */
        public double f50413a1;

        /* renamed from: t0  reason: collision with root package name */
        public long f50414t0;

        public static Builder aGalileoTim() {
            return new Builder();
        }

        public GalileoTim build() {
            GalileoTim galileoTim = new GalileoTim();
            double unused = galileoTim.mA0 = this.f50412a0;
            double unused2 = galileoTim.mA1 = this.f50413a1;
            long unused3 = galileoTim.mT0 = this.f50414t0;
            return galileoTim;
        }

        public Builder but() {
            return aGalileoTim().withA0(this.f50412a0).withA1(this.f50413a1).withT0(this.f50414t0);
        }

        public Builder withA0(double d11) {
            this.f50412a0 = d11;
            return this;
        }

        public Builder withA1(double d11) {
            this.f50413a1 = d11;
            return this;
        }

        public Builder withT0(long j11) {
            this.f50414t0 = j11;
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
