package com.huawei.riemann.location.bean.eph;

public class IrnssEphemeris {
    public int mSatNumber;

    public static final class Builder {
        public int mSatNumber;

        public static Builder aIrnssEphemeris() {
            return new Builder();
        }

        public IrnssEphemeris build() {
            IrnssEphemeris irnssEphemeris = new IrnssEphemeris();
            int unused = irnssEphemeris.mSatNumber = this.mSatNumber;
            return irnssEphemeris;
        }

        public Builder but() {
            return aIrnssEphemeris().withSatNumber(this.mSatNumber);
        }

        public Builder withSatNumber(int i11) {
            this.mSatNumber = i11;
            return this;
        }
    }
}
