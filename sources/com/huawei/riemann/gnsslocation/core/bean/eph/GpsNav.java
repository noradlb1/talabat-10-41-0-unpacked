package com.huawei.riemann.gnsslocation.core.bean.eph;

public class GpsNav {
    public int mAcc;
    public double mAf0;
    public double mAf1;
    public double mAf2;
    public int mAodo;
    public double mCic;
    public double mCis;
    public double mCrc;
    public double mCrs;
    public double mCuc;
    public double mCus;
    public double mDeltaN;
    public double mEcc;
    public double mGpsTow23b;
    public double mGroupDelay;
    public int mHealth;
    public double mI0;
    public double mIDot;
    public int mIodc;
    public int mIode;
    public double mM0;
    public double mOmega;
    public double mOmega0;
    public double mOmegaDot;
    public double mSqrtA;
    public int mSvid;
    public int mToc;
    public int mToe;
    public int mWeekNumber;

    public static final class Builder {
        public int acc;
        public double af0;
        public double af1;
        public double af2;
        public int aodo;
        public double cic;
        public double cis;
        public double crc;
        public double crs;
        public double cuc;
        public double cus;
        public double deltaN;
        public double ecc;
        public double gpsTow23b;
        public double groupDelay;
        public int health;

        /* renamed from: i0  reason: collision with root package name */
        public double f50338i0;
        public double idot;
        public int iodc;
        public int iode;

        /* renamed from: m0  reason: collision with root package name */
        public double f50339m0;
        public double omega;
        public double omega0;
        public double omegaDot;
        public double sqrtA;
        public int svid;
        public int toc;
        public int toe;
        public int weekNumber;

        public static Builder aGpsNav() {
            return new Builder();
        }

        public GpsNav build() {
            GpsNav gpsNav = new GpsNav();
            double unused = gpsNav.mGroupDelay = this.groupDelay;
            double unused2 = gpsNav.mAf0 = this.af0;
            int unused3 = gpsNav.mAcc = this.acc;
            int unused4 = gpsNav.mIode = this.iode;
            double unused5 = gpsNav.mCrs = this.crs;
            double unused6 = gpsNav.mCis = this.cis;
            double unused7 = gpsNav.mEcc = this.ecc;
            double unused8 = gpsNav.mOmega = this.omega;
            double unused9 = gpsNav.mCus = this.cus;
            double unused10 = gpsNav.mGpsTow23b = this.gpsTow23b;
            double unused11 = gpsNav.mAf2 = this.af2;
            int unused12 = gpsNav.mWeekNumber = this.weekNumber;
            double unused13 = gpsNav.mIDot = this.idot;
            int unused14 = gpsNav.mHealth = this.health;
            int unused15 = gpsNav.mToe = this.toe;
            double unused16 = gpsNav.mSqrtA = this.sqrtA;
            double unused17 = gpsNav.mM0 = this.f50339m0;
            double unused18 = gpsNav.mCuc = this.cuc;
            double unused19 = gpsNav.mI0 = this.f50338i0;
            double unused20 = gpsNav.mOmegaDot = this.omegaDot;
            int unused21 = gpsNav.mAodo = this.aodo;
            double unused22 = gpsNav.mAf1 = this.af1;
            int unused23 = gpsNav.mIodc = this.iodc;
            int unused24 = gpsNav.mToc = this.toc;
            int unused25 = gpsNav.mSvid = this.svid;
            double unused26 = gpsNav.mDeltaN = this.deltaN;
            double unused27 = gpsNav.mOmega0 = this.omega0;
            double unused28 = gpsNav.mCic = this.cic;
            double unused29 = gpsNav.mCrc = this.crc;
            return gpsNav;
        }

        public Builder but() {
            return aGpsNav().withSvid(this.svid).withAcc(this.acc).withIodc(this.iodc).withIode(this.iode).withAodo(this.aodo).withM0(this.f50339m0).withDeltaN(this.deltaN).withEcc(this.ecc).withSqrtA(this.sqrtA).withOmega0(this.omega0).withI0(this.f50338i0).withOmega(this.omega).withOmegaDot(this.omegaDot).withIdot(this.idot).withCuc(this.cuc).withCus(this.cus).withCrc(this.crc).withCrs(this.crs).withCic(this.cic).withCis(this.cis).withGroupDelay(this.groupDelay).withAf0(this.af0).withAf1(this.af1).withAf2(this.af2).withHealth(this.health).withToc(this.toc).withToe(this.toe).withGpsTow23b(this.gpsTow23b).withWeekNumber(this.weekNumber);
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

        public Builder withAodo(int i11) {
            this.aodo = i11;
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

        public Builder withGpsTow23b(double d11) {
            this.gpsTow23b = d11;
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
            this.f50338i0 = d11;
            return this;
        }

        public Builder withIdot(double d11) {
            this.idot = d11;
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
            this.f50339m0 = d11;
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

        public Builder withWeekNumber(int i11) {
            this.weekNumber = i11;
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

    public int getAodo() {
        return this.mAodo;
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

    public double getGpsTow23b() {
        return this.mGpsTow23b;
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

    public int getWeekNumber() {
        return this.mWeekNumber;
    }
}
