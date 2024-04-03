package com.huawei.riemann.gnsslocation.core.bean.obs;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class SatelliteMeasurement {
    public double mAccumulatedDeltaRangeMeters;
    public int mAccumulatedDeltaRangeState;
    public double mAccumulatedDeltaRangeUncertaintyMeters;
    public double mAutomaticGainControlLevelInDb;
    public long mBootTime;
    public long mCarrierCycles;
    public float mCarrierFrequencyHz;
    public double mCarrierPhase;
    public double mCarrierPhaseUncertainty;
    public double mCn0DbHz;
    public int mConstellationType;
    public double mFullInterSignalBiasNanos;
    public double mFullInterSignalBiasUncertaintyNanos;
    public int mMultipathIndicator;
    public double mPseudorangeRateMetersPerSecond;
    public double mPseudorangeRateUncertaintyMetersPerSecond;
    public long mReceivedSvTimeNanos;
    public long mReceivedSvTimeUncertaintyNanos;
    public double mSatelliteInterSignalBiasNanos;
    public double mSatelliteInterSignalBiasUncertaintyNanos;
    public double mSnrInDb;
    public int mState;
    public int mSvid;
    public double mTimeOffsetNanos;

    public static final class Builder {
        public double mAccumulatedDeltaRangeMeters;
        public int mAccumulatedDeltaRangeState;
        public double mAccumulatedDeltaRangeUncertaintyMeters;
        public double mAutomaticGainControlLevelInDb;
        public long mBootTime;
        public long mCarrierCycles;
        public float mCarrierFrequencyHz;
        public double mCarrierPhase;
        public double mCarrierPhaseUncertainty;
        public double mCn0DbHz;
        public int mConstellationType;
        public double mFullInterSignalBiasNanos;
        public double mFullInterSignalBiasUncertaintyNanos;
        public int mMultipathIndicator;
        public double mPseudorangeRateMetersPerSecond;
        public double mPseudorangeRateUncertaintyMetersPerSecond;
        public long mReceivedSvTimeNanos;
        public long mReceivedSvTimeUncertaintyNanos;
        public double mSatelliteInterSignalBiasNanos;
        public double mSatelliteInterSignalBiasUncertaintyNanos;
        public double mSnrInDb;
        public int mState;
        public int mSvid;
        public double mTimeOffsetNanos;

        public static Builder aSatelliteMeasurement() {
            return new Builder();
        }

        public SatelliteMeasurement build() {
            SatelliteMeasurement satelliteMeasurement = new SatelliteMeasurement();
            double unused = satelliteMeasurement.mSatelliteInterSignalBiasUncertaintyNanos = this.mSatelliteInterSignalBiasUncertaintyNanos;
            double unused2 = satelliteMeasurement.mCn0DbHz = this.mCn0DbHz;
            double unused3 = satelliteMeasurement.mAccumulatedDeltaRangeUncertaintyMeters = this.mAccumulatedDeltaRangeUncertaintyMeters;
            double unused4 = satelliteMeasurement.mCarrierPhaseUncertainty = this.mCarrierPhaseUncertainty;
            int unused5 = satelliteMeasurement.mMultipathIndicator = this.mMultipathIndicator;
            double unused6 = satelliteMeasurement.mPseudorangeRateUncertaintyMetersPerSecond = this.mPseudorangeRateUncertaintyMetersPerSecond;
            float unused7 = satelliteMeasurement.mCarrierFrequencyHz = this.mCarrierFrequencyHz;
            double unused8 = satelliteMeasurement.mSatelliteInterSignalBiasNanos = this.mSatelliteInterSignalBiasNanos;
            int unused9 = satelliteMeasurement.mSvid = this.mSvid;
            long unused10 = satelliteMeasurement.mReceivedSvTimeUncertaintyNanos = this.mReceivedSvTimeUncertaintyNanos;
            int unused11 = satelliteMeasurement.mState = this.mState;
            int unused12 = satelliteMeasurement.mConstellationType = this.mConstellationType;
            double unused13 = satelliteMeasurement.mFullInterSignalBiasNanos = this.mFullInterSignalBiasNanos;
            double unused14 = satelliteMeasurement.mTimeOffsetNanos = this.mTimeOffsetNanos;
            long unused15 = satelliteMeasurement.mCarrierCycles = this.mCarrierCycles;
            double unused16 = satelliteMeasurement.mCarrierPhase = this.mCarrierPhase;
            long unused17 = satelliteMeasurement.mReceivedSvTimeNanos = this.mReceivedSvTimeNanos;
            double unused18 = satelliteMeasurement.mFullInterSignalBiasUncertaintyNanos = this.mFullInterSignalBiasUncertaintyNanos;
            double unused19 = satelliteMeasurement.mAutomaticGainControlLevelInDb = this.mAutomaticGainControlLevelInDb;
            double unused20 = satelliteMeasurement.mAccumulatedDeltaRangeMeters = this.mAccumulatedDeltaRangeMeters;
            double unused21 = satelliteMeasurement.mPseudorangeRateMetersPerSecond = this.mPseudorangeRateMetersPerSecond;
            int unused22 = satelliteMeasurement.mAccumulatedDeltaRangeState = this.mAccumulatedDeltaRangeState;
            double unused23 = satelliteMeasurement.mSnrInDb = this.mSnrInDb;
            long unused24 = satelliteMeasurement.mBootTime = this.mBootTime;
            return satelliteMeasurement;
        }

        public Builder but() {
            return aSatelliteMeasurement().withSvid(this.mSvid).withConstellationType(this.mConstellationType).withTimeOffsetNanos(this.mTimeOffsetNanos).withState(this.mState).withReceivedSvTimeNanos(this.mReceivedSvTimeNanos).withReceivedSvTimeUncertaintyNanos(this.mReceivedSvTimeUncertaintyNanos).withCn0DbHz(this.mCn0DbHz).withPseudorangeRateMetersPerSecond(this.mPseudorangeRateMetersPerSecond).withPseudorangeRateUncertaintyMetersPerSecond(this.mPseudorangeRateUncertaintyMetersPerSecond).withAccumulatedDeltaRangeState(this.mAccumulatedDeltaRangeState).withAccumulatedDeltaRangeMeters(this.mAccumulatedDeltaRangeMeters).withAccumulatedDeltaRangeUncertaintyMeters(this.mAccumulatedDeltaRangeUncertaintyMeters).withCarrierFrequencyHz(this.mCarrierFrequencyHz).withCarrierCycles(this.mCarrierCycles).withCarrierPhase(this.mCarrierPhase).withCarrierPhaseUncertainty(this.mCarrierPhaseUncertainty).withMultipathIndicator(this.mMultipathIndicator).withSnrInDb(this.mSnrInDb).withAutomaticGainControlLevelInDb(this.mAutomaticGainControlLevelInDb).withFullInterSignalBiasNanos(this.mFullInterSignalBiasNanos).withFullInterSignalBiasUncertaintyNanos(this.mFullInterSignalBiasUncertaintyNanos).withSatelliteInterSignalBiasNanos(this.mSatelliteInterSignalBiasNanos).withSatelliteInterSignalBiasUncertaintyNanos(this.mSatelliteInterSignalBiasUncertaintyNanos).withBootTime(this.mBootTime);
        }

        public Builder withAccumulatedDeltaRangeMeters(double d11) {
            this.mAccumulatedDeltaRangeMeters = d11;
            return this;
        }

        public Builder withAccumulatedDeltaRangeState(int i11) {
            this.mAccumulatedDeltaRangeState = i11;
            return this;
        }

        public Builder withAccumulatedDeltaRangeUncertaintyMeters(double d11) {
            this.mAccumulatedDeltaRangeUncertaintyMeters = d11;
            return this;
        }

        public Builder withAutomaticGainControlLevelInDb(double d11) {
            this.mAutomaticGainControlLevelInDb = d11;
            return this;
        }

        public Builder withBootTime(long j11) {
            this.mBootTime = j11;
            return this;
        }

        public Builder withCarrierCycles(long j11) {
            this.mCarrierCycles = j11;
            return this;
        }

        public Builder withCarrierFrequencyHz(float f11) {
            this.mCarrierFrequencyHz = f11;
            return this;
        }

        public Builder withCarrierPhase(double d11) {
            this.mCarrierPhase = d11;
            return this;
        }

        public Builder withCarrierPhaseUncertainty(double d11) {
            this.mCarrierPhaseUncertainty = d11;
            return this;
        }

        public Builder withCn0DbHz(double d11) {
            this.mCn0DbHz = d11;
            return this;
        }

        public Builder withConstellationType(int i11) {
            this.mConstellationType = i11;
            return this;
        }

        public Builder withFullInterSignalBiasNanos(double d11) {
            this.mFullInterSignalBiasNanos = d11;
            return this;
        }

        public Builder withFullInterSignalBiasUncertaintyNanos(double d11) {
            this.mFullInterSignalBiasUncertaintyNanos = d11;
            return this;
        }

        public Builder withMultipathIndicator(int i11) {
            this.mMultipathIndicator = i11;
            return this;
        }

        public Builder withPseudorangeRateMetersPerSecond(double d11) {
            this.mPseudorangeRateMetersPerSecond = d11;
            return this;
        }

        public Builder withPseudorangeRateUncertaintyMetersPerSecond(double d11) {
            this.mPseudorangeRateUncertaintyMetersPerSecond = d11;
            return this;
        }

        public Builder withReceivedSvTimeNanos(long j11) {
            this.mReceivedSvTimeNanos = j11;
            return this;
        }

        public Builder withReceivedSvTimeUncertaintyNanos(long j11) {
            this.mReceivedSvTimeUncertaintyNanos = j11;
            return this;
        }

        public Builder withSatelliteInterSignalBiasNanos(double d11) {
            this.mSatelliteInterSignalBiasNanos = d11;
            return this;
        }

        public Builder withSatelliteInterSignalBiasUncertaintyNanos(double d11) {
            this.mSatelliteInterSignalBiasUncertaintyNanos = d11;
            return this;
        }

        public Builder withSnrInDb(double d11) {
            this.mSnrInDb = d11;
            return this;
        }

        public Builder withState(int i11) {
            this.mState = i11;
            return this;
        }

        public Builder withSvid(int i11) {
            this.mSvid = i11;
            return this;
        }

        public Builder withTimeOffsetNanos(double d11) {
            this.mTimeOffsetNanos = d11;
            return this;
        }
    }

    public double getAccumulatedDeltaRangeMeters() {
        return this.mAccumulatedDeltaRangeMeters;
    }

    public int getAccumulatedDeltaRangeState() {
        return this.mAccumulatedDeltaRangeState;
    }

    public double getAccumulatedDeltaRangeUncertaintyMeters() {
        return this.mAccumulatedDeltaRangeUncertaintyMeters;
    }

    public double getAutomaticGainControlLevelInDb() {
        return this.mAutomaticGainControlLevelInDb;
    }

    public long getBootTime() {
        return this.mBootTime;
    }

    public long getCarrierCycles() {
        return this.mCarrierCycles;
    }

    public float getCarrierFrequencyHz() {
        return this.mCarrierFrequencyHz;
    }

    public double getCarrierPhase() {
        return this.mCarrierPhase;
    }

    public double getCarrierPhaseUncertainty() {
        return this.mCarrierPhaseUncertainty;
    }

    public double getCn0DbHz() {
        return this.mCn0DbHz;
    }

    public int getConstellationType() {
        return this.mConstellationType;
    }

    public double getFullInterSignalBiasNanos() {
        return this.mFullInterSignalBiasNanos;
    }

    public double getFullInterSignalBiasUncertaintyNanos() {
        return this.mFullInterSignalBiasUncertaintyNanos;
    }

    public int getMultipathIndicator() {
        return this.mMultipathIndicator;
    }

    public double getPseudorangeRateMetersPerSecond() {
        return this.mPseudorangeRateMetersPerSecond;
    }

    public double getPseudorangeRateUncertaintyMetersPerSecond() {
        return this.mPseudorangeRateUncertaintyMetersPerSecond;
    }

    public long getReceivedSvTimeNanos() {
        return this.mReceivedSvTimeNanos;
    }

    public long getReceivedSvTimeUncertaintyNanos() {
        return this.mReceivedSvTimeUncertaintyNanos;
    }

    public double getSatelliteInterSignalBiasNanos() {
        return this.mSatelliteInterSignalBiasNanos;
    }

    public double getSatelliteInterSignalBiasUncertaintyNanos() {
        return this.mSatelliteInterSignalBiasUncertaintyNanos;
    }

    public double getSnrInDb() {
        return this.mSnrInDb;
    }

    public int getState() {
        return this.mState;
    }

    public int getSvid() {
        return this.mSvid;
    }

    public double getTimeOffsetNanos() {
        return this.mTimeOffsetNanos;
    }

    public String toString() {
        return "SatelliteMeasurement{mSvid=" + this.mSvid + ", mConstellationType=" + this.mConstellationType + ", mTimeOffsetNanos=" + this.mTimeOffsetNanos + ", mState=" + this.mState + ", mReceivedSvTimeNanos=" + this.mReceivedSvTimeNanos + ", mReceivedSvTimeUncertaintyNanos=" + this.mReceivedSvTimeUncertaintyNanos + ", mCn0DbHz=" + this.mCn0DbHz + ", mPseudorangeRateMetersPerSecond=" + this.mPseudorangeRateMetersPerSecond + ", mPseudorangeRateUncertaintyMetersPerSecond=" + this.mPseudorangeRateUncertaintyMetersPerSecond + ", mAccumulatedDeltaRangeState=" + this.mAccumulatedDeltaRangeState + ", mAccumulatedDeltaRangeMeters=" + this.mAccumulatedDeltaRangeMeters + ", mAccumulatedDeltaRangeUncertaintyMeters=" + this.mAccumulatedDeltaRangeUncertaintyMeters + ", mCarrierFrequencyHz=" + this.mCarrierFrequencyHz + ", mCarrierCycles=" + this.mCarrierCycles + ", mCarrierPhase=" + this.mCarrierPhase + ", mCarrierPhaseUncertainty=" + this.mCarrierPhaseUncertainty + ", mMultipathIndicator=" + this.mMultipathIndicator + ", mSnrInDb=" + this.mSnrInDb + ", mAutomaticGainControlLevelInDb=" + this.mAutomaticGainControlLevelInDb + ", mFullInterSignalBiasNanos=" + this.mFullInterSignalBiasNanos + ", mFullInterSignalBiasUncertaintyNanos=" + this.mFullInterSignalBiasUncertaintyNanos + ", mSatelliteInterSignalBiasNanos=" + this.mSatelliteInterSignalBiasNanos + ", mSatelliteInterSignalBiasUncertaintyNanos=" + this.mSatelliteInterSignalBiasUncertaintyNanos + ", mBootTime=" + this.mBootTime + AbstractJsonLexerKt.END_OBJ;
    }
}
