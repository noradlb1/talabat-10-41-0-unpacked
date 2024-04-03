package com.huawei.riemann.location.bean.eph;

public class GlonassNav {
    public double mDeltaTau;
    public int mEn;
    public double mGamma;
    public int mHealth;
    public int mIod;
    public int mM;
    public int mP1;
    public int mP2;
    public int mSvid;
    public double mTaun;
    public double mX;
    public double mXDot;
    public double mXDotDot;
    public double mY;
    public double mYDot;
    public double mYDotDot;
    public double mZ;
    public double mZDot;
    public double mZDotDot;

    public static final class Builder {
        public double deltaTau;

        /* renamed from: en  reason: collision with root package name */
        public int f50415en;
        public double gamma;
        public int health;
        public int iod;

        /* renamed from: m  reason: collision with root package name */
        public int f50416m;

        /* renamed from: p1  reason: collision with root package name */
        public int f50417p1;

        /* renamed from: p2  reason: collision with root package name */
        public int f50418p2;
        public int svid;
        public double taun;

        /* renamed from: x  reason: collision with root package name */
        public double f50419x;
        public double xDot;
        public double xDotDot;

        /* renamed from: y  reason: collision with root package name */
        public double f50420y;
        public double yDot;
        public double yDotDot;

        /* renamed from: z  reason: collision with root package name */
        public double f50421z;
        public double zDot;
        public double zDotDot;

        public static Builder aGlonassNav() {
            return new Builder();
        }

        public GlonassNav build() {
            GlonassNav glonassNav = new GlonassNav();
            double unused = glonassNav.mTaun = this.taun;
            double unused2 = glonassNav.mZDotDot = this.zDotDot;
            int unused3 = glonassNav.mSvid = this.svid;
            int unused4 = glonassNav.mM = this.f50416m;
            double unused5 = glonassNav.mYDot = this.yDot;
            int unused6 = glonassNav.mP1 = this.f50417p1;
            double unused7 = glonassNav.mXDot = this.xDot;
            double unused8 = glonassNav.mXDotDot = this.xDotDot;
            double unused9 = glonassNav.mYDotDot = this.yDotDot;
            double unused10 = glonassNav.mZ = this.f50421z;
            int unused11 = glonassNav.mIod = this.iod;
            double unused12 = glonassNav.mGamma = this.gamma;
            double unused13 = glonassNav.mDeltaTau = this.deltaTau;
            double unused14 = glonassNav.mX = this.f50419x;
            int unused15 = glonassNav.mP2 = this.f50418p2;
            int unused16 = glonassNav.mEn = this.f50415en;
            double unused17 = glonassNav.mZDot = this.zDot;
            double unused18 = glonassNav.mY = this.f50420y;
            int unused19 = glonassNav.mHealth = this.health;
            return glonassNav;
        }

        public Builder but() {
            return aGlonassNav().withSvid(this.svid).withHealth(this.health).withIod(this.iod).withTaun(this.taun).withGamma(this.gamma).withDeltaTau(this.deltaTau).withEn(this.f50415en).withP1(this.f50417p1).withP2(this.f50418p2).withM(this.f50416m).withX(this.f50419x).withY(this.f50420y).withZ(this.f50421z).withXDot(this.xDot).withYDot(this.yDot).withZDot(this.zDot).withXDotDot(this.xDotDot).withYDotDot(this.yDotDot).withZDotDot(this.zDotDot);
        }

        public Builder withDeltaTau(double d11) {
            this.deltaTau = d11;
            return this;
        }

        public Builder withEn(int i11) {
            this.f50415en = i11;
            return this;
        }

        public Builder withGamma(double d11) {
            this.gamma = d11;
            return this;
        }

        public Builder withHealth(int i11) {
            this.health = i11;
            return this;
        }

        public Builder withIod(int i11) {
            this.iod = i11;
            return this;
        }

        public Builder withM(int i11) {
            this.f50416m = i11;
            return this;
        }

        public Builder withP1(int i11) {
            this.f50417p1 = i11;
            return this;
        }

        public Builder withP2(int i11) {
            this.f50418p2 = i11;
            return this;
        }

        public Builder withSvid(int i11) {
            this.svid = i11;
            return this;
        }

        public Builder withTaun(double d11) {
            this.taun = d11;
            return this;
        }

        public Builder withX(double d11) {
            this.f50419x = d11;
            return this;
        }

        public Builder withXDot(double d11) {
            this.xDot = d11;
            return this;
        }

        public Builder withXDotDot(double d11) {
            this.xDotDot = d11;
            return this;
        }

        public Builder withY(double d11) {
            this.f50420y = d11;
            return this;
        }

        public Builder withYDot(double d11) {
            this.yDot = d11;
            return this;
        }

        public Builder withYDotDot(double d11) {
            this.yDotDot = d11;
            return this;
        }

        public Builder withZ(double d11) {
            this.f50421z = d11;
            return this;
        }

        public Builder withZDot(double d11) {
            this.zDot = d11;
            return this;
        }

        public Builder withZDotDot(double d11) {
            this.zDotDot = d11;
            return this;
        }
    }

    public double getDeltaTau() {
        return this.mDeltaTau;
    }

    public int getEn() {
        return this.mEn;
    }

    public double getGamma() {
        return this.mGamma;
    }

    public int getHealth() {
        return this.mHealth;
    }

    public int getIod() {
        return this.mIod;
    }

    public int getM() {
        return this.mM;
    }

    public int getP1() {
        return this.mP1;
    }

    public int getP2() {
        return this.mP2;
    }

    public int getSvid() {
        return this.mSvid;
    }

    public double getTaun() {
        return this.mTaun;
    }

    public double getX() {
        return this.mX;
    }

    public double getY() {
        return this.mY;
    }

    public double getZ() {
        return this.mZ;
    }

    public double getxDot() {
        return this.mXDot;
    }

    public double getxDotDot() {
        return this.mXDotDot;
    }

    public double getyDot() {
        return this.mYDot;
    }

    public double getyDotDot() {
        return this.mYDotDot;
    }

    public double getzDot() {
        return this.mZDot;
    }

    public double getzDotDot() {
        return this.mZDotDot;
    }
}
