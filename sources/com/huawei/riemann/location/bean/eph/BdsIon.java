package com.huawei.riemann.location.bean.eph;

public class BdsIon {
    public double mA0;
    public double mA1;
    public double mA2;
    public double mA3;
    public int mB0;
    public int mB1;
    public int mB2;
    public int mB3;
    public int mSvid;
    public int mToe;

    public static final class Builder {

        /* renamed from: a0  reason: collision with root package name */
        public double f50397a0;

        /* renamed from: a1  reason: collision with root package name */
        public double f50398a1;

        /* renamed from: a2  reason: collision with root package name */
        public double f50399a2;

        /* renamed from: a3  reason: collision with root package name */
        public double f50400a3;

        /* renamed from: b0  reason: collision with root package name */
        public int f50401b0;

        /* renamed from: b1  reason: collision with root package name */
        public int f50402b1;

        /* renamed from: b2  reason: collision with root package name */
        public int f50403b2;

        /* renamed from: b3  reason: collision with root package name */
        public int f50404b3;
        public int svid;
        public int toe;

        public static Builder aBdsIon() {
            return new Builder();
        }

        public BdsIon build() {
            BdsIon bdsIon = new BdsIon();
            int unused = bdsIon.mSvid = this.svid;
            double unused2 = bdsIon.mA2 = this.f50399a2;
            int unused3 = bdsIon.mB2 = this.f50403b2;
            double unused4 = bdsIon.mA0 = this.f50397a0;
            double unused5 = bdsIon.mA1 = this.f50398a1;
            double unused6 = bdsIon.mA3 = this.f50400a3;
            int unused7 = bdsIon.mB0 = this.f50401b0;
            int unused8 = bdsIon.mB1 = this.f50402b1;
            int unused9 = bdsIon.mB3 = this.f50404b3;
            int unused10 = bdsIon.mToe = this.toe;
            return bdsIon;
        }

        public Builder but() {
            return aBdsIon().withSvid(this.svid).withToe(this.toe).withA0(this.f50397a0).withA1(this.f50398a1).withA2(this.f50399a2).withA3(this.f50400a3).withB0(this.f50401b0).withB1(this.f50402b1).withB2(this.f50403b2).withB3(this.f50404b3);
        }

        public Builder withA0(double d11) {
            this.f50397a0 = d11;
            return this;
        }

        public Builder withA1(double d11) {
            this.f50398a1 = d11;
            return this;
        }

        public Builder withA2(double d11) {
            this.f50399a2 = d11;
            return this;
        }

        public Builder withA3(double d11) {
            this.f50400a3 = d11;
            return this;
        }

        public Builder withB0(int i11) {
            this.f50401b0 = i11;
            return this;
        }

        public Builder withB1(int i11) {
            this.f50402b1 = i11;
            return this;
        }

        public Builder withB2(int i11) {
            this.f50403b2 = i11;
            return this;
        }

        public Builder withB3(int i11) {
            this.f50404b3 = i11;
            return this;
        }

        public Builder withSvid(int i11) {
            this.svid = i11;
            return this;
        }

        public Builder withToe(int i11) {
            this.toe = i11;
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

    public int getSvid() {
        return this.mSvid;
    }

    public int getToe() {
        return this.mToe;
    }
}
