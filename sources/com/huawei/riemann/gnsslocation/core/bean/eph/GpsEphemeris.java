package com.huawei.riemann.gnsslocation.core.bean.eph;

import java.util.Arrays;

public class GpsEphemeris {
    public GpsIon mGpsIon;
    public GpsNav[] mGpsNavs;
    public int mSatNumber;

    public static final class Builder {
        public GpsIon mGpsIon;
        public GpsNav[] mGpsNavs;
        public int mSatNumber;

        public static Builder aGpsEphemeris() {
            return new Builder();
        }

        public GpsEphemeris build() {
            GpsEphemeris gpsEphemeris = new GpsEphemeris();
            GpsNav[] unused = gpsEphemeris.mGpsNavs = this.mGpsNavs;
            int unused2 = gpsEphemeris.mSatNumber = this.mSatNumber;
            GpsIon unused3 = gpsEphemeris.mGpsIon = this.mGpsIon;
            return gpsEphemeris;
        }

        public Builder but() {
            return aGpsEphemeris().withSatNumber(this.mSatNumber).withGpsNavs(this.mGpsNavs).withGpsIon(this.mGpsIon);
        }

        public Builder withGpsIon(GpsIon gpsIon) {
            this.mGpsIon = gpsIon;
            return this;
        }

        public Builder withGpsNavs(GpsNav[] gpsNavArr) {
            this.mGpsNavs = (GpsNav[]) Arrays.copyOf(gpsNavArr, gpsNavArr.length);
            return this;
        }

        public Builder withSatNumber(int i11) {
            this.mSatNumber = i11;
            return this;
        }
    }

    public GpsIon getGpsIon() {
        return this.mGpsIon;
    }

    public GpsNav[] getGpsNavs() {
        GpsNav[] gpsNavArr = this.mGpsNavs;
        return (GpsNav[]) Arrays.copyOf(gpsNavArr, gpsNavArr.length);
    }

    public int getSatNumber() {
        return this.mSatNumber;
    }
}
