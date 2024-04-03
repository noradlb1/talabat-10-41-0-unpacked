package com.huawei.riemann.gnsslocation.core.bean.sensor;

public class SensorAccInput {
    public double mAx;
    public double mAy;
    public double mAz;
    public long mBootTime;

    public static final class Builder {

        /* renamed from: ax  reason: collision with root package name */
        public double f50389ax;

        /* renamed from: ay  reason: collision with root package name */
        public double f50390ay;

        /* renamed from: az  reason: collision with root package name */
        public double f50391az;
        public long bootTime;

        public static Builder aSensorAccInput() {
            return new Builder();
        }

        public SensorAccInput build() {
            SensorAccInput sensorAccInput = new SensorAccInput();
            long unused = sensorAccInput.mBootTime = this.bootTime;
            double unused2 = sensorAccInput.mAx = this.f50389ax;
            double unused3 = sensorAccInput.mAy = this.f50390ay;
            double unused4 = sensorAccInput.mAz = this.f50391az;
            return sensorAccInput;
        }

        public Builder but() {
            return aSensorAccInput().withBootTime(this.bootTime).withAx(this.f50389ax).withAy(this.f50390ay).withAz(this.f50391az);
        }

        public Builder withAx(double d11) {
            this.f50389ax = d11;
            return this;
        }

        public Builder withAy(double d11) {
            this.f50390ay = d11;
            return this;
        }

        public Builder withAz(double d11) {
            this.f50391az = d11;
            return this;
        }

        public Builder withBootTime(long j11) {
            this.bootTime = j11;
            return this;
        }
    }

    public double getAx() {
        return this.mAx;
    }

    public double getAy() {
        return this.mAy;
    }

    public double getAz() {
        return this.mAz;
    }

    public long getBootTime() {
        return this.mBootTime;
    }
}
