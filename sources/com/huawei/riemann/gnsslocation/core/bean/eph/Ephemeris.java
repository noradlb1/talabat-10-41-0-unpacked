package com.huawei.riemann.gnsslocation.core.bean.eph;

public class Ephemeris {
    public BdsEphemeris mBdsEphemeris;
    public GalileoEphemeris mGalileoEphemeris;
    public GlonassEphemeris mGlonassEphemeris;
    public GpsEphemeris mGpsEphemeris;
    public IrnssEphemeris mIrnssEphemeris;
    public QzssEphemeris mQzssEphemeris;
    public SbasEphemeris mSbasEphemeris;

    public static final class Builder {
        public BdsEphemeris mBdsEphemeris;
        public GalileoEphemeris mGalileoEphemeris;
        public GlonassEphemeris mGlonassEphemeris;
        public GpsEphemeris mGpsEphemeris;
        public IrnssEphemeris mIrnssEphemeris;
        public QzssEphemeris mQzssEphemeris;
        public SbasEphemeris mSbasEphemeris;

        public static Builder anEphemeris() {
            return new Builder();
        }

        private Builder withIrnssEphemeris(IrnssEphemeris irnssEphemeris) {
            this.mIrnssEphemeris = irnssEphemeris;
            return this;
        }

        private Builder withQzssEphemeris(QzssEphemeris qzssEphemeris) {
            this.mQzssEphemeris = qzssEphemeris;
            return this;
        }

        private Builder withSbasEphemeris(SbasEphemeris sbasEphemeris) {
            this.mSbasEphemeris = sbasEphemeris;
            return this;
        }

        public Ephemeris build() {
            Ephemeris ephemeris = new Ephemeris();
            GpsEphemeris unused = ephemeris.mGpsEphemeris = this.mGpsEphemeris;
            SbasEphemeris unused2 = ephemeris.mSbasEphemeris = this.mSbasEphemeris;
            GlonassEphemeris unused3 = ephemeris.mGlonassEphemeris = this.mGlonassEphemeris;
            QzssEphemeris unused4 = ephemeris.mQzssEphemeris = this.mQzssEphemeris;
            BdsEphemeris unused5 = ephemeris.mBdsEphemeris = this.mBdsEphemeris;
            GalileoEphemeris unused6 = ephemeris.mGalileoEphemeris = this.mGalileoEphemeris;
            IrnssEphemeris unused7 = ephemeris.mIrnssEphemeris = this.mIrnssEphemeris;
            return ephemeris;
        }

        public Builder but() {
            return anEphemeris().withGpsEphemeris(this.mGpsEphemeris).withSbasEphemeris(this.mSbasEphemeris).withGlonassEphemeris(this.mGlonassEphemeris).withQzssEphemeris(this.mQzssEphemeris).withBdsEphemeris(this.mBdsEphemeris).withGalileoEphemeris(this.mGalileoEphemeris).withIrnssEphemeris(this.mIrnssEphemeris);
        }

        public Builder withBdsEphemeris(BdsEphemeris bdsEphemeris) {
            this.mBdsEphemeris = bdsEphemeris;
            return this;
        }

        public Builder withGalileoEphemeris(GalileoEphemeris galileoEphemeris) {
            this.mGalileoEphemeris = galileoEphemeris;
            return this;
        }

        public Builder withGlonassEphemeris(GlonassEphemeris glonassEphemeris) {
            this.mGlonassEphemeris = glonassEphemeris;
            return this;
        }

        public Builder withGpsEphemeris(GpsEphemeris gpsEphemeris) {
            this.mGpsEphemeris = gpsEphemeris;
            return this;
        }
    }

    public BdsEphemeris getBdsEphemeris() {
        return this.mBdsEphemeris;
    }

    public GalileoEphemeris getGalileoEphemeris() {
        return this.mGalileoEphemeris;
    }

    public GlonassEphemeris getGlonassEphemeris() {
        return this.mGlonassEphemeris;
    }

    public GpsEphemeris getGpsEphemeris() {
        return this.mGpsEphemeris;
    }

    public IrnssEphemeris getIrnssEphemeris() {
        return this.mIrnssEphemeris;
    }

    public QzssEphemeris getQzssEphemeris() {
        return this.mQzssEphemeris;
    }

    public SbasEphemeris getSbasEphemeris() {
        return this.mSbasEphemeris;
    }
}
