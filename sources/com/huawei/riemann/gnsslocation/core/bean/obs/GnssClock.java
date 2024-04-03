package com.huawei.riemann.gnsslocation.core.bean.obs;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class GnssClock {
    public double mBiasNanos;
    public double mBiasUncertaintyNanos;
    public double mDriftNanosPerSecond;
    public double mDriftUncertaintyNanosPerSecond;
    public long mElapsedRealtimeMillis;
    public long mFullBiasNanos;
    public int mHardwareClockDiscontinuityCount;
    public int mLeapSecond;
    public long mTimeNanos;
    public double mTimeUncertaintyNanos;

    public static final class Builder {
        public double mBiasNanos;
        public double mBiasUncertaintyNanos;
        public double mDriftNanosPerSecond;
        public double mDriftUncertaintyNanosPerSecond;
        public long mElapsedRealtimeMillis;
        public long mFullBiasNanos;
        public int mHardwareClockDiscontinuityCount;
        public int mLeapSecond;
        public long mTimeNanos;
        public double mTimeUncertaintyNanos;

        public static Builder aGnssClock() {
            return new Builder();
        }

        public GnssClock build() {
            GnssClock gnssClock = new GnssClock();
            long unused = gnssClock.mTimeNanos = this.mTimeNanos;
            long unused2 = gnssClock.mFullBiasNanos = this.mFullBiasNanos;
            double unused3 = gnssClock.mTimeUncertaintyNanos = this.mTimeUncertaintyNanos;
            double unused4 = gnssClock.mDriftNanosPerSecond = this.mDriftNanosPerSecond;
            double unused5 = gnssClock.mDriftUncertaintyNanosPerSecond = this.mDriftUncertaintyNanosPerSecond;
            long unused6 = gnssClock.mElapsedRealtimeMillis = this.mElapsedRealtimeMillis;
            double unused7 = gnssClock.mBiasUncertaintyNanos = this.mBiasUncertaintyNanos;
            double unused8 = gnssClock.mBiasNanos = this.mBiasNanos;
            int unused9 = gnssClock.mHardwareClockDiscontinuityCount = this.mHardwareClockDiscontinuityCount;
            int unused10 = gnssClock.mLeapSecond = this.mLeapSecond;
            return gnssClock;
        }

        public Builder but() {
            return aGnssClock().withElapsedRealtimeMillis(this.mElapsedRealtimeMillis).withTimeNanos(this.mTimeNanos).withLeapSecond(this.mLeapSecond).withTimeUncertaintyNanos(this.mTimeUncertaintyNanos).withFullBiasNanos(this.mFullBiasNanos).withBiasNanos(this.mBiasNanos).withBiasUncertaintyNanos(this.mBiasUncertaintyNanos).withDriftNanosPerSecond(this.mDriftNanosPerSecond).withDriftUncertaintyNanosPerSecond(this.mDriftUncertaintyNanosPerSecond).withHardwareClockDiscontinuityCount(this.mHardwareClockDiscontinuityCount);
        }

        public Builder withBiasNanos(double d11) {
            this.mBiasNanos = d11;
            return this;
        }

        public Builder withBiasUncertaintyNanos(double d11) {
            this.mBiasUncertaintyNanos = d11;
            return this;
        }

        public Builder withDriftNanosPerSecond(double d11) {
            this.mDriftNanosPerSecond = d11;
            return this;
        }

        public Builder withDriftUncertaintyNanosPerSecond(double d11) {
            this.mDriftUncertaintyNanosPerSecond = d11;
            return this;
        }

        public Builder withElapsedRealtimeMillis(long j11) {
            this.mElapsedRealtimeMillis = j11;
            return this;
        }

        public Builder withFullBiasNanos(long j11) {
            this.mFullBiasNanos = j11;
            return this;
        }

        public Builder withHardwareClockDiscontinuityCount(int i11) {
            this.mHardwareClockDiscontinuityCount = i11;
            return this;
        }

        public Builder withLeapSecond(int i11) {
            this.mLeapSecond = i11;
            return this;
        }

        public Builder withTimeNanos(long j11) {
            this.mTimeNanos = j11;
            return this;
        }

        public Builder withTimeUncertaintyNanos(double d11) {
            this.mTimeUncertaintyNanos = d11;
            return this;
        }
    }

    public double getBiasNanos() {
        return this.mBiasNanos;
    }

    public double getBiasUncertaintyNanos() {
        return this.mBiasUncertaintyNanos;
    }

    public double getDriftNanosPerSecond() {
        return this.mDriftNanosPerSecond;
    }

    public double getDriftUncertaintyNanosPerSecond() {
        return this.mDriftUncertaintyNanosPerSecond;
    }

    public long getElapsedRealtimeMillis() {
        return this.mElapsedRealtimeMillis;
    }

    public long getFullBiasNanos() {
        return this.mFullBiasNanos;
    }

    public int getHardwareClockDiscontinuityCount() {
        return this.mHardwareClockDiscontinuityCount;
    }

    public int getLeapSecond() {
        return this.mLeapSecond;
    }

    public long getTimeNanos() {
        return this.mTimeNanos;
    }

    public double getTimeUncertaintyNanos() {
        return this.mTimeUncertaintyNanos;
    }

    public String toString() {
        return "GnssClock{mElapsedRealtimeMillis=" + this.mElapsedRealtimeMillis + ", mTimeNanos=" + this.mTimeNanos + ", mLeapSecond=" + this.mLeapSecond + ", mTimeUncertaintyNanos=" + this.mTimeUncertaintyNanos + ", mFullBiasNanos=" + this.mFullBiasNanos + ", mBiasNanos=" + this.mBiasNanos + ", mBiasUncertaintyNanos=" + this.mBiasUncertaintyNanos + ", mDriftNanosPerSecond=" + this.mDriftNanosPerSecond + ", mDriftUncertaintyNanosPerSecond=" + this.mDriftUncertaintyNanosPerSecond + ", mHardwareClockDiscontinuityCount=" + this.mHardwareClockDiscontinuityCount + AbstractJsonLexerKt.END_OBJ;
    }
}
