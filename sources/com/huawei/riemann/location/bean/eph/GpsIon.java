package com.huawei.riemann.location.bean.eph;

public class GpsIon {
    public double mA0;
    public double mA1;
    public double mA2;
    public double mA3;
    public int mB0;
    public int mB1;
    public int mB2;
    public int mB3;
    public boolean mValid;

    public static final class Builder {

        /* renamed from: a0  reason: collision with root package name */
        public double f50425a0;

        /* renamed from: a1  reason: collision with root package name */
        public double f50426a1;

        /* renamed from: a2  reason: collision with root package name */
        public double f50427a2;

        /* renamed from: a3  reason: collision with root package name */
        public double f50428a3;

        /* renamed from: b0  reason: collision with root package name */
        public int f50429b0;

        /* renamed from: b1  reason: collision with root package name */
        public int f50430b1;

        /* renamed from: b2  reason: collision with root package name */
        public int f50431b2;

        /* renamed from: b3  reason: collision with root package name */
        public int f50432b3;
        public boolean valid;

        public static Builder aGpsIon() {
            return new Builder();
        }

        public GpsIon build() {
            GpsIon gpsIon = new GpsIon();
            int unused = gpsIon.mB3 = this.f50432b3;
            double unused2 = gpsIon.mA2 = this.f50427a2;
            double unused3 = gpsIon.mA3 = this.f50428a3;
            double unused4 = gpsIon.mA1 = this.f50426a1;
            double unused5 = gpsIon.mA0 = this.f50425a0;
            int unused6 = gpsIon.mB1 = this.f50430b1;
            int unused7 = gpsIon.mB2 = this.f50431b2;
            int unused8 = gpsIon.mB0 = this.f50429b0;
            boolean unused9 = gpsIon.mValid = this.valid;
            return gpsIon;
        }

        public Builder but() {
            return aGpsIon().withA0(this.f50425a0).withA1(this.f50426a1).withA2(this.f50427a2).withA3(this.f50428a3).withB0(this.f50429b0).withB1(this.f50430b1).withB2(this.f50431b2).withB3(this.f50432b3).withValid(this.valid);
        }

        public Builder withA0(double d11) {
            this.f50425a0 = d11;
            return this;
        }

        public Builder withA1(double d11) {
            this.f50426a1 = d11;
            return this;
        }

        public Builder withA2(double d11) {
            this.f50427a2 = d11;
            return this;
        }

        public Builder withA3(double d11) {
            this.f50428a3 = d11;
            return this;
        }

        public Builder withB0(int i11) {
            this.f50429b0 = i11;
            return this;
        }

        public Builder withB1(int i11) {
            this.f50430b1 = i11;
            return this;
        }

        public Builder withB2(int i11) {
            this.f50431b2 = i11;
            return this;
        }

        public Builder withB3(int i11) {
            this.f50432b3 = i11;
            return this;
        }

        public Builder withValid(boolean z11) {
            this.valid = z11;
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

    public double getA3() {
        return this.mA3;
    }

    public int getB0() {
        return this.mB0;
    }

    public int getB1() {
        return this.mB1;
    }

    public int getB2() {
        return this.mB2;
    }

    public int getB3() {
        return this.mB3;
    }

    public boolean getValid() {
        return this.mValid;
    }
}
