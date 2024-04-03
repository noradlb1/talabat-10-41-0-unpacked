package com.huawei.riemann.location.bean.eph;

public class QzssEphemeris {
    public int mSatNumber;

    public static final class Builder {
        public int mSatNumber;

        public static Builder aQzssEphemeris() {
            return new Builder();
        }

        public QzssEphemeris build() {
            QzssEphemeris qzssEphemeris = new QzssEphemeris();
            int unused = qzssEphemeris.mSatNumber = this.mSatNumber;
            return qzssEphemeris;
        }

        public Builder but() {
            return aQzssEphemeris().withSatNumber(this.mSatNumber);
        }

        public Builder withSatNumber(int i11) {
            this.mSatNumber = i11;
            return this;
        }
    }
}
