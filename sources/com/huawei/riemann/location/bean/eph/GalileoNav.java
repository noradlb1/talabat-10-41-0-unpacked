package com.huawei.riemann.location.bean.eph;

public class GalileoNav {
    public double mAf0;
    public double mAf1;
    public double mAf2;
    public double mCic;
    public double mCis;
    public int mClockModelId;
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
    public int mIodc;
    public int mIode;
    public double mM0;
    public int mNumClockModel;
    public double mOmega;
    public double mOmega0;
    public double mOmegaDot;
    public double mSqrtA;
    public int mSvid;
    public int mToc;
    public int mToe;

    public static final class Builder {
        public double af0;
        public double af1;
        public double af2;
        public double cic;
        public double cis;
        public int clockModelId;
        public double crc;
        public double crs;
        public double cuc;
        public double cus;
        public double deltaN;
        public double ecc;
        public double groupDelay;
        public int health;

        /* renamed from: i0  reason: collision with root package name */
        public double f50410i0;
        public double iDot;
        public int iodc;
        public int iode;

        /* renamed from: m0  reason: collision with root package name */
        public double f50411m0;
        public int numClockModel;
        public double omega;
        public double omega0;
        public double omegaDot;
        public double sqrtA;
        public int svid;
        public int toc;
        public int toe;

        public static Builder aGalileoNav() {
            return new Builder();
        }

        public GalileoNav build() {
            GalileoNav galileoNav = new GalileoNav();
            double unused = galileoNav.mAf0 = this.af0;
            double unused2 = galileoNav.mGroupDelay = this.groupDelay;
            double unused3 = galileoNav.mEcc = this.ecc;
            double unused4 = galileoNav.mOmegaDot = this.omegaDot;
            double unused5 = galileoNav.mCrc = this.crc;
            double unused6 = galileoNav.mCuc = this.cuc;
            double unused7 = galileoNav.mCic = this.cic;
            double unused8 = galileoNav.mIDot = this.iDot;
            double unused9 = galileoNav.mOmega = this.omega;
            double unused10 = galileoNav.mCis = this.cis;
            int unused11 = galileoNav.mHealth = this.health;
            double unused12 = galileoNav.mSqrtA = this.sqrtA;
            double unused13 = galileoNav.mOmega0 = this.omega0;
            double unused14 = galileoNav.mCrs = this.crs;
            double unused15 = galileoNav.mDeltaN = this.deltaN;
            double unused16 = galileoNav.mM0 = this.f50411m0;
            int unused17 = galileoNav.mToc = this.toc;
            double unused18 = galileoNav.mI0 = this.f50410i0;
            double unused19 = galileoNav.mCus = this.cus;
            int unused20 = galileoNav.mSvid = this.svid;
            int unused21 = galileoNav.mIodc = this.iodc;
            double unused22 = galileoNav.mAf1 = this.af1;
            int unused23 = galileoNav.mToe = this.toe;
            double unused24 = galileoNav.mAf2 = this.af2;
            int unused25 = galileoNav.mIode = this.iode;
            int unused26 = galileoNav.mClockModelId = this.clockModelId;
            int unused27 = galileoNav.mNumClockModel = this.numClockModel;
            return galileoNav;
        }

        public Builder but() {
            return aGalileoNav().withSvid(this.svid).withIodc(this.iodc).withIode(this.iode).withM0(this.f50411m0).withDeltaN(this.deltaN).withEcc(this.ecc).withSqrtA(this.sqrtA).withOmega0(this.omega0).withI0(this.f50410i0).withOmega(this.omega).withOmegaDot(this.omegaDot).withIDot(this.iDot).withCuc(this.cuc).withCus(this.cus).withCrc(this.crc).withCrs(this.crs).withCic(this.cic).withCis(this.cis).withGroupDelay(this.groupDelay).withAf0(this.af0).withAf1(this.af1).withAf2(this.af2).withHealth(this.health).withToc(this.toc).withToe(this.toe).withClockModelId(this.clockModelId).withNumClockModel(this.numClockModel);
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

        public Builder withCic(double d11) {
            this.cic = d11;
            return this;
        }

        public Builder withCis(double d11) {
            this.cis = d11;
            return this;
        }

        public Builder withClockModelId(int i11) {
            this.clockModelId = i11;
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
            this.f50410i0 = d11;
            return this;
        }

        public Builder withIDot(double d11) {
            this.iDot = d11;
            return this;
        }

        public Builder withIodc(int i11) {
            this.iodc = i11;
            return this;
        }

        public Builder withIode(int i11) {
            this.iode = i11;
            return this;
        }

        public Builder withM0(double d11) {
            this.f50411m0 = d11;
            return this;
        }

        public Builder withNumClockModel(int i11) {
            this.numClockModel = i11;
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

    public double getAf0() {
        return this.mAf0;
    }

    public double getAf1() {
        return this.mAf1;
    }

    public double getAf2() {
        return this.mAf2;
    }

    public double getCic() {
        return this.mCic;
    }

    public double getCis() {
        return this.mCis;
    }

    public int getClockModelId() {
        return this.mClockModelId;
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

    public int getIodc() {
        return this.mIodc;
    }

    public int getIode() {
        return this.mIode;
    }

    public double getM0() {
        return this.mM0;
    }

    public int getNumClockModel() {
        return this.mNumClockModel;
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
