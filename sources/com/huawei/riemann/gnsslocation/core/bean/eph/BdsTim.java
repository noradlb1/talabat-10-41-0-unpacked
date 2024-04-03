package com.huawei.riemann.gnsslocation.core.bean.eph;

public class BdsTim {
    public double mA0;
    public double mA1;
    public double mA2;
    public int mDeltaT;
    public int mGnssToId;
    public int mWeekNumber;
    public int mWeekSecond;

    public static final class Builder {

        /* renamed from: a0  reason: collision with root package name */
        public double f50312a0;

        /* renamed from: a1  reason: collision with root package name */
        public double f50313a1;

        /* renamed from: a2  reason: collision with root package name */
        public double f50314a2;
        public int deltaT;
        public int gnssToId;
        public int weekNumber;
        public int weekSecond;

        public static Builder aBdsTim() {
            return new Builder();
        }

        public BdsTim build() {
            BdsTim bdsTim = new BdsTim();
            double unused = bdsTim.mA0 = this.f50312a0;
            int unused2 = bdsTim.mWeekSecond = this.weekSecond;
            double unused3 = bdsTim.mA2 = this.f50314a2;
            int unused4 = bdsTim.mGnssToId = this.gnssToId;
            int unused5 = bdsTim.mWeekNumber = this.weekNumber;
            int unused6 = bdsTim.mDeltaT = this.deltaT;
            double unused7 = bdsTim.mA1 = this.f50313a1;
            return bdsTim;
        }

        public Builder but() {
            return aBdsTim().withWeekSecond(this.weekSecond).withWeekNumber(this.weekNumber).withA0(this.f50312a0).withA1(this.f50313a1).withA2(this.f50314a2).withGnssToId(this.gnssToId).withDeltaT(this.deltaT);
        }

        public Builder withA0(double d11) {
            this.f50312a0 = d11;
            return this;
        }

        public Builder withA1(double d11) {
            this.f50313a1 = d11;
            return this;
        }

        public Builder withA2(double d11) {
            this.f50314a2 = d11;
            return this;
        }

        public Builder withDeltaT(int i11) {
            this.deltaT = i11;
            return this;
        }

        public Builder withGnssToId(int i11) {
            this.gnssToId = i11;
            return this;
        }

        public Builder withWeekNumber(int i11) {
            this.weekNumber = i11;
            return this;
        }

        public Builder withWeekSecond(int i11) {
            this.weekSecond = i11;
            return this;
        }
    }

    public double getA0() {
        return this.mA0;
    }

    public double getA1() {
        return this.mA1;
    }

    public double getA2() {
        return this.mA2;
    }

    public int getDeltaT() {
        return this.mDeltaT;
    }

    public int getGnssToId() {
        return this.mGnssToId;
    }

    public int getWeekNumber() {
        return this.mWeekNumber;
    }

    public int getWeekSecond() {
        return this.mWeekSecond;
    }
}
