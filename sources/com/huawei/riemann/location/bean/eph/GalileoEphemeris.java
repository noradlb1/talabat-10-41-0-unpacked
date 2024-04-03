package com.huawei.riemann.location.bean.eph;

import java.util.Arrays;

public class GalileoEphemeris {
    public GalileoNav[] mGalileoNavs;
    public GalileoTim mGalileoTim;
    public int mNonBroadcastInd;
    public int mSatNumber;

    public static final class Builder {
        public GalileoNav[] mGalileoNavs;
        public GalileoTim mGalileoTim;
        public int mNonBroadcastInd;
        public int mSatNumber;

        public static Builder aGalileoEphemeris() {
            return new Builder();
        }

        public GalileoEphemeris build() {
            GalileoEphemeris galileoEphemeris = new GalileoEphemeris();
            int unused = galileoEphemeris.mSatNumber = this.mSatNumber;
            int unused2 = galileoEphemeris.mNonBroadcastInd = this.mNonBroadcastInd;
            GalileoNav[] unused3 = galileoEphemeris.mGalileoNavs = this.mGalileoNavs;
            GalileoTim unused4 = galileoEphemeris.mGalileoTim = this.mGalileoTim;
            return galileoEphemeris;
        }

        public Builder but() {
            return aGalileoEphemeris().withSatNumber(this.mSatNumber).withNonBroadcastInd(this.mNonBroadcastInd).withGalileoNavs(this.mGalileoNavs).withGalileoTim(this.mGalileoTim);
        }

        public Builder withGalileoNavs(GalileoNav[] galileoNavArr) {
            this.mGalileoNavs = (GalileoNav[]) Arrays.copyOf(galileoNavArr, galileoNavArr.length);
            return this;
        }

        public Builder withGalileoTim(GalileoTim galileoTim) {
            this.mGalileoTim = galileoTim;
            return this;
        }

        public Builder withNonBroadcastInd(int i11) {
            this.mNonBroadcastInd = i11;
            return this;
        }

        public Builder withSatNumber(int i11) {
            this.mSatNumber = i11;
            return this;
        }
    }

    public GalileoNav[] getGalileoNavs() {
        GalileoNav[] galileoNavArr = this.mGalileoNavs;
        return (GalileoNav[]) Arrays.copyOf(galileoNavArr, galileoNavArr.length);
    }

    public GalileoTim getGalileoTim() {
        return this.mGalileoTim;
    }

    public int getNonBroadcastInd() {
        return this.mNonBroadcastInd;
    }

    public int getSatNumber() {
        return this.mSatNumber;
    }
}
