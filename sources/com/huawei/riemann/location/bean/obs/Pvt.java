package com.huawei.riemann.location.bean.obs;

public class Pvt {
    public float mAccuracy = 0.0f;
    public double mAltitude = 0.0d;
    public float mBearing = 0.0f;
    public int mErrCode = 0;
    public double mLatitude = 0.0d;
    public double mLongitude = 0.0d;
    public float mSpeed = 0.0f;
    public long mTime = 0;

    public static final class Builder {
        public float mAccuracy = 0.0f;
        public double mAltitude = 0.0d;
        public float mBearing = 0.0f;
        public int mErrCode = 0;
        public double mLatitude = 0.0d;
        public double mLongitude = 0.0d;
        public float mSpeed = 0.0f;
        public long mTime = 0;

        public static Builder aPvt() {
            return new Builder();
        }

        public Pvt build() {
            Pvt pvt = new Pvt();
            int unused = pvt.mErrCode = this.mErrCode;
            double unused2 = pvt.mLatitude = this.mLatitude;
            double unused3 = pvt.mLongitude = this.mLongitude;
            float unused4 = pvt.mBearing = this.mBearing;
            long unused5 = pvt.mTime = this.mTime;
            double unused6 = pvt.mAltitude = this.mAltitude;
            float unused7 = pvt.mSpeed = this.mSpeed;
            float unused8 = pvt.mAccuracy = this.mAccuracy;
            return pvt;
        }

        public Builder but() {
            return aPvt().withErrCode(this.mErrCode).withLatitude(this.mLatitude).withLongitude(this.mLongitude).withAltitude(this.mAltitude).withSpeed(this.mSpeed).withAccuracy(this.mAccuracy).withBearing(this.mBearing).withTime(this.mTime);
        }

        public Builder withAccuracy(float f11) {
            this.mAccuracy = f11;
            return this;
        }

        public Builder withAltitude(double d11) {
            this.mAltitude = d11;
            return this;
        }

        public Builder withBearing(float f11) {
            this.mBearing = f11;
            return this;
        }

        public Builder withErrCode(int i11) {
            this.mErrCode = i11;
            return this;
        }

        public Builder withLatitude(double d11) {
            this.mLatitude = d11;
            return this;
        }

        public Builder withLongitude(double d11) {
            this.mLongitude = d11;
            return this;
        }

        public Builder withSpeed(float f11) {
            this.mSpeed = f11;
            return this;
        }

        public Builder withTime(long j11) {
            this.mTime = j11;
            return this;
        }
    }

    public float getAccuracy() {
        return this.mAccuracy;
    }

    public double getAltitude() {
        return this.mAltitude;
    }

    public float getBearing() {
        return this.mBearing;
    }

    public int getErrCode() {
        return this.mErrCode;
    }

    public double getLatitude() {
        return this.mLatitude;
    }

    public double getLongitude() {
        return this.mLongitude;
    }

    public float getSpeed() {
        return this.mSpeed;
    }

    public long getTime() {
        return this.mTime;
    }
}
