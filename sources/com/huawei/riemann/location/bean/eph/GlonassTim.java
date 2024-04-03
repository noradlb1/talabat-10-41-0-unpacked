package com.huawei.riemann.location.bean.eph;

public class GlonassTim {
    public double mA0;
    public double mA1;
    public double mA2;
    public int mGnssToId;
    public int mWeekNumber;
    public int mWeekSecond;

    public static final class Builder {

        /* renamed from: a0  reason: collision with root package name */
        public double f50422a0;

        /* renamed from: a1  reason: collision with root package name */
        public double f50423a1;

        /* renamed from: a2  reason: collision with root package name */
        public double f50424a2;
        public int gnssToId;
        public int weekNumber;
        public int weekSecond;

        public static Builder aGlonassTim() {
            return new Builder();
        }

        public GlonassTim build() {
            GlonassTim glonassTim = new GlonassTim();
            int unused = glonassTim.mWeekSecond = this.weekSecond;
            int unused2 = glonassTim.mWeekNumber = this.weekNumber;
            int unused3 = glonassTim.mGnssToId = this.gnssToId;
            double unused4 = glonassTim.mA1 = this.f50423a1;
            double unused5 = glonassTim.mA0 = this.f50422a0;
            double unused6 = glonassTim.mA2 = this.f50424a2;
            return glonassTim;
        }

        public Builder but() {
            return aGlonassTim().withWeekSecond(this.weekSecond).withWeekNumber(this.weekNumber).withA0(this.f50422a0).withA1(this.f50423a1).withA2(this.f50424a2).withGnssToId(this.gnssToId);
        }

        public Builder withA0(double d11) {
            this.f50422a0 = d11;
            return this;
        }

        public Builder withA1(double d11) {
            this.f50423a1 = d11;
            return this;
        }

        public Builder withA2(double d11) {
            this.f50424a2 = d11;
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
