package com.huawei.riemann.gnsslocation.core.bean.eph;

import java.util.Arrays;

public class GlonassEphemeris {
    public GlonassNav[] mGlonassNavs;
    public GlonassTim mGlonassTim;
    public int mNonBroadcastInd;
    public int mSatNumber;

    public static final class Builder {
        public GlonassNav[] mGlonassNavs;
        public GlonassTim mGlonassTim;
        public int mNonBroadcastInd;
        public int mSatNumber;

        public static Builder aGlonassEphemeris() {
            return new Builder();
        }

        public GlonassEphemeris build() {
            GlonassEphemeris glonassEphemeris = new GlonassEphemeris();
            GlonassTim unused = glonassEphemeris.mGlonassTim = this.mGlonassTim;
            GlonassNav[] unused2 = glonassEphemeris.mGlonassNavs = this.mGlonassNavs;
            int unused3 = glonassEphemeris.mNonBroadcastInd = this.mNonBroadcastInd;
            int unused4 = glonassEphemeris.mSatNumber = this.mSatNumber;
            return glonassEphemeris;
        }

        public Builder but() {
            return aGlonassEphemeris().withSatNumber(this.mSatNumber).withNonBroadcastInd(this.mNonBroadcastInd).withGlonassNavs(this.mGlonassNavs).withGlonassTim(this.mGlonassTim);
        }

        public Builder withGlonassNavs(GlonassNav[] glonassNavArr) {
            this.mGlonassNavs = (GlonassNav[]) Arrays.copyOf(glonassNavArr, glonassNavArr.length);
            return this;
        }

        public Builder withGlonassTim(GlonassTim glonassTim) {
            this.mGlonassTim = glonassTim;
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

    public GlonassNav[] getGlonassNavs() {
        GlonassNav[] glonassNavArr = this.mGlonassNavs;
        return (GlonassNav[]) Arrays.copyOf(glonassNavArr, glonassNavArr.length);
    }

    public GlonassTim getGlonassTim() {
        return this.mGlonassTim;
    }

    public int getNonBroadcastInd() {
        return this.mNonBroadcastInd;
    }

    public int getSatNumber() {
        return this.mSatNumber;
    }
}
