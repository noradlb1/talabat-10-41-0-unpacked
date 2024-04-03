package com.huawei.riemann.location.bean.eph;

public class BdsNav {
    public int mAcc;
    public double mAf0;
    public double mAf1;
    public double mAf2;
    public int mAodc;
    public int mAode;
    public double mCic;
    public double mCis;
    public double mCrc;
    public double mCrs;
    public double mCuc;
    public double mCus;
    public double mDeltaN;
    public double mEcc;
    public double mGroupDelay;
    public int mHealth;
    public double mI0;
    public double mIDot;
    public double mM0;
    public double mOmega;
    public double mOmega0;
    public double mOmegaDot;
    public double mSqrtA;
    public int mSvid;
    public int mToc;
    public int mToe;

    public static final class Builder {
        public int acc;
        public double af0;
        public double af1;
        public double af2;
        public int aodc;
        public int aode;
        public double cic;
        public double cis;
        public double crc;
        public double crs;
        public double cuc;
        public double cus;
        public double deltaN;
        public double ecc;
        public double groupDelay;
        public int health;

        /* renamed from: i0  reason: collision with root package name */
        public double f50405i0;
        public double iDot;

        /* renamed from: m0  reason: collision with root package name */
        public double f50406m0;
        public double omega;
        public double omega0;
        public double omegaDot;
        public double sqrtA;
        public int svid;
        public int toc;
        public int toe;

        public static Builder aBdsNav() {
            return new Builder();
        }

        public BdsNav build() {
            BdsNav bdsNav = new BdsNav();
            double unused = bdsNav.mAf0 = this.af0;
            double unused2 = bdsNav.mOmega = this.omega;
            double unused3 = bdsNav.mCrc = this.crc;
            int unused4 = bdsNav.mAcc = this.acc;
            int unused5 = bdsNav.mHealth = this.health;
            int unused6 = bdsNav.mAodc = this.aodc;
            int unused7 = bdsNav.mToe = this.toe;
            double unused8 = bdsNav.mAf1 = this.af1;
            double unused9 = bdsNav.mCic = this.cic;
            double unused10 = bdsNav.mI0 = this.f50405i0;
            double unused11 = bdsNav.mOmegaDot = this.omegaDot;
            double unused12 = bdsNav.mCus = this.cus;
            int unused13 = bdsNav.mToc = this.toc;
            double unused14 = bdsNav.mIDot = this.iDot;
            double unused15 = bdsNav.mGroupDelay = this.groupDelay;
            double unused16 = bdsNav.mCuc = this.cuc;
            double unused17 = bdsNav.mEcc = this.ecc;
            double unused18 = bdsNav.mOmega0 = this.omega0;
            double unused19 = bdsNav.mAf2 = this.af2;
            double unused20 = bdsNav.mDeltaN = this.deltaN;
            int unused21 = bdsNav.mSvid = this.svid;
            int unused22 = bdsNav.mAode = this.aode;
            double unused23 = bdsNav.mCis = this.cis;
            double unused24 = bdsNav.mCrs = this.crs;
            double unused25 = bdsNav.mM0 = this.f50406m0;
            double unused26 = bdsNav.mSqrtA = this.sqrtA;
            return bdsNav;
        }

        public Builder but() {
            return aBdsNav().withSvid(this.svid).withAcc(this.acc).withAodc(this.aodc).withAode(this.aode).withM0(this.f50406m0).withDeltaN(this.deltaN).withEcc(this.ecc).withSqrtA(this.sqrtA).withOmega0(this.omega0).withI0(this.f50405i0).withOmega(this.omega).withOmegaDot(this.omegaDot).withIDot(this.iDot).withCuc(this.cuc).withCus(this.cus).withCrc(this.crc).withCrs(this.crs).withCic(this.cic).withCis(this.cis).withGroupDelay(this.groupDelay).withAf0(this.af0).withAf1(this.af1).withAf2(this.af2).withHealth(this.health).withToc(this.toc).withToe(this.toe);
        }

        public Builder withAcc(int i11) {
            this.acc = i11;
            return this;
        }

        public Builder withAf0(double d11) {
            this.af0 = d11;
            return this;
        }

        public Builder withAf1(double d11) {
            this.af1 = d11;
            return this;
        }

        public Builder withAf2(double d11) {
            this.af2 = d11;
            return this;
        }

        public Builder withAodc(int i11) {
            this.aodc = i11;
            return this;
        }

        public Builder withAode(int i11) {
            this.aode = i11;
            return this;
        }

        public Builder withCic(double d11) {
            this.cic = d11;
            return this;
        }

        public Builder withCis(double d11) {
            this.cis = d11;
            return this;
        }

        public Builder withCrc(double d11) {
            this.crc = d11;
            return this;
        }

        public Builder withCrs(double d11) {
            this.crs = d11;
            return this;
        }

        public Builder withCuc(double d11) {
            this.cuc = d11;
            return this;
        }

        public Builder withCus(double d11) {
            this.cus = d11;
            return this;
        }

        public Builder withDeltaN(double d11) {
            this.deltaN = d11;
            return this;
        }

        public Builder withEcc(double d11) {
            this.ecc = d11;
            return this;
        }

        public Builder withGroupDelay(double d11) {
            this.groupDelay = d11;
            return this;
        }

        public Builder withHealth(int i11) {
            this.health = i11;
            return this;
        }

        public Builder withI0(double d11) {
            this.f50405i0 = d11;
            return this;
        }

        public Builder withIDot(double d11) {
            this.iDot = d11;
            return this;
        }

        public Builder withM0(double d11) {
            this.f50406m0 = d11;
            return this;
        }

        public Builder withOmega(double d11) {
            this.omega = d11;
            return this;
        }

        public Builder withOmega0(double d11) {
            this.omega0 = d11;
            return this;
        }

        public Builder withOmegaDot(double d11) {
            this.omegaDot = d11;
            return this;
        }

        public Builder withSqrtA(double d11) {
            this.sqrtA = d11;
            return this;
        }

        public Builder withSvid(int i11) {
            this.svid = i11;
            return this;
        }

        public Builder withToc(int i11) {
            this.toc = i11;
            return this;
        }

        public Builder withToe(int i11) {
            this.toe = i11;
            return this;
        }
    }

    public int getAcc() {
        return this.mAcc;
    }

    public double getAf0() {
        return this.mAf0;
    }

    public double getAf1() {
        return this.mAf1;
    }

    public double getAf2() {
        return this.mAf2;
    }

    public int getAodc() {
        return this.mAodc;
    }

    public int getAode() {
        return this.mAode;
    }

    public double getCic() {
        return this.mCic;
    }

    public double getCis() {
        return this.mCis;
    }

    public double getCrc() {
        return this.mCrc;
    }

    public double getCrs() {
        return this.mCrs;
    }

    public double getCuc() {
        return this.mCuc;
    }

    public double getCus() {
        return this.mCus;
    }

    public double getDeltaN() {
        return this.mDeltaN;
    }

    public double getEcc() {
        return this.mEcc;
    }

    public double getGroupDelay() {
        return this.mGroupDelay;
    }

    public int getHealth() {
        return this.mHealth;
    }

    public double getI0() {
        return this.mI0;
    }

    public double getIDot() {
        return this.mIDot;
    }

    public double getM0() {
        return this.mM0;
    }

    public double getOmega() {
        return this.mOmega;
    }

    public double getOmega0() {
        return this.mOmega0;
    }

    public double getOmegaDot() {
        return this.mOmegaDot;
    }

    public double getSqrtA() {
        return this.mSqrtA;
    }

    public int getSvid() {
        return this.mSvid;
    }

    public int getToc() {
        return this.mToc;
    }

    public int getToe() {
        return this.mToe;
    }
}
