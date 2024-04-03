package com.huawei.riemann.gnsslocation.core.bean.sensor;

public class SensorGyroInput {
    public long mBootTime;
    public double mGx;
    public double mGy;
    public double mGz;

    public static final class Builder {
        public long bootTime;

        /* renamed from: gx  reason: collision with root package name */
        public double f50392gx;

        /* renamed from: gy  reason: collision with root package name */
        public double f50393gy;

        /* renamed from: gz  reason: collision with root package name */
        public double f50394gz;

        public static Builder aSensorGyroInput() {
            return new Builder();
        }

        public SensorGyroInput build() {
            SensorGyroInput sensorGyroInput = new SensorGyroInput();
            long unused = sensorGyroInput.mBootTime = this.bootTime;
            double unused2 = sensorGyroInput.mGx = this.f50392gx;
            double unused3 = sensorGyroInput.mGy = this.f50393gy;
            double unused4 = sensorGyroInput.mGz = this.f50394gz;
            return sensorGyroInput;
        }

        public Builder but() {
            return aSensorGyroInput().withBootTime(this.bootTime).withGx(this.f50392gx).withGy(this.f50393gy).withGz(this.f50394gz);
        }

        public Builder withBootTime(long j11) {
            this.bootTime = j11;
            return this;
        }

        public Builder withGx(double d11) {
            this.f50392gx = d11;
            return this;
        }

        public Builder withGy(double d11) {
            this.f50393gy = d11;
            return this;
        }

        public Builder withGz(double d11) {
            this.f50394gz = d11;
            return this;
        }
    }

    public long getBootTime() {
        return this.mBootTime;
    }

    public double getGx() {
        return this.mGx;
    }

    public double getGy() {
        return this.mGy;
    }

    public double getGz() {
        return this.mGz;
    }
}
