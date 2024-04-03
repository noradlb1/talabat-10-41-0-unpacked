package com.huawei.riemann.location.bean.eph;

public class SbasEphemeris {
    public int mSatNumber;

    public static final class Builder {
        public int mSatNumber;

        public static Builder aSbasEphemeris() {
            return new Builder();
        }

        public SbasEphemeris build() {
            SbasEphemeris sbasEphemeris = new SbasEphemeris();
            int unused = sbasEphemeris.mSatNumber = this.mSatNumber;
            return sbasEphemeris;
        }

        public Builder but() {
            return aSbasEphemeris().withSatNumber(this.mSatNumber);
        }

        public Builder withSatNumber(int i11) {
            this.mSatNumber = i11;
            return this;
        }
    }
}
