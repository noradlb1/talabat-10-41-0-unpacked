package com.huawei.riemann.location.bean.eph;

import java.util.Arrays;

public class BdsEphemeris {
    public BdsIon[] mBdsIons;
    public BdsNav[] mBdsNavs;
    public BdsTim[] mBdsTims;
    public int mNonBroadcastInd;
    public int mSatNumber;

    public static final class Builder {
        public BdsIon[] mBdsIons;
        public BdsNav[] mBdsNavs;
        public BdsTim[] mBdsTims;
        public int mNonBroadcastInd;
        public int mSatNumber;

        public static Builder aBdsEphemeris() {
            return new Builder();
        }

        public BdsEphemeris build() {
            BdsEphemeris bdsEphemeris = new BdsEphemeris();
            BdsIon[] unused = bdsEphemeris.mBdsIons = this.mBdsIons;
            int unused2 = bdsEphemeris.mNonBroadcastInd = this.mNonBroadcastInd;
            int unused3 = bdsEphemeris.mSatNumber = this.mSatNumber;
            BdsNav[] unused4 = bdsEphemeris.mBdsNavs = this.mBdsNavs;
            BdsTim[] unused5 = bdsEphemeris.mBdsTims = this.mBdsTims;
            return bdsEphemeris;
        }

        public Builder but() {
            return aBdsEphemeris().withSatNumber(this.mSatNumber).withNonBroadcastInd(this.mNonBroadcastInd).withBdsNavs(this.mBdsNavs).withBdsIons(this.mBdsIons).withBdsTims(this.mBdsTims);
        }

        public Builder withBdsIons(BdsIon[] bdsIonArr) {
            this.mBdsIons = (BdsIon[]) Arrays.copyOf(bdsIonArr, bdsIonArr.length);
            return this;
        }

        public Builder withBdsNavs(BdsNav[] bdsNavArr) {
            this.mBdsNavs = (BdsNav[]) Arrays.copyOf(bdsNavArr, bdsNavArr.length);
            return this;
        }

        public Builder withBdsTims(BdsTim[] bdsTimArr) {
            this.mBdsTims = (BdsTim[]) Arrays.copyOf(bdsTimArr, bdsTimArr.length);
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

    public BdsIon[] getBdsIons() {
        BdsIon[] bdsIonArr = this.mBdsIons;
        return (BdsIon[]) Arrays.copyOf(bdsIonArr, bdsIonArr.length);
    }

    public BdsNav[] getBdsNavs() {
        BdsNav[] bdsNavArr = this.mBdsNavs;
        return (BdsNav[]) Arrays.copyOf(bdsNavArr, bdsNavArr.length);
    }

    public BdsTim[] getBdsTims() {
        BdsTim[] bdsTimArr = this.mBdsTims;
        return (BdsTim[]) Arrays.copyOf(bdsTimArr, bdsTimArr.length);
    }

    public int getNonBroadcastInd() {
        return this.mNonBroadcastInd;
    }

    public int getSatNumber() {
        return this.mSatNumber;
    }
}
