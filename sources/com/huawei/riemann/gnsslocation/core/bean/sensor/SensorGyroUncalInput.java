package com.huawei.riemann.gnsslocation.core.bean.sensor;

public class SensorGyroUncalInput {
    public double mBiasx;
    public double mBiasy;
    public double mBiasz;
    public long mBootTime;
    public double mUgx;
    public double mUgy;
    public double mUgz;

    public static final class Builder {
        public double biasx;
        public double biasy;
        public double biasz;
        public long bootTime;
        public double ugx;
        public double ugy;
        public double ugz;

        public static Builder aSensorGyroUncalInput() {
            return new Builder();
        }

        public SensorGyroUncalInput build() {
            SensorGyroUncalInput sensorGyroUncalInput = new SensorGyroUncalInput();
            long unused = sensorGyroUncalInput.mBootTime = this.bootTime;
            double unused2 = sensorGyroUncalInput.mUgx = this.ugx;
            double unused3 = sensorGyroUncalInput.mUgy = this.ugy;
            double unused4 = sensorGyroUncalInput.mUgz = this.ugz;
            double unused5 = sensorGyroUncalInput.mBiasx = this.biasx;
            double unused6 = sensorGyroUncalInput.mBiasy = this.biasy;
            double unused7 = sensorGyroUncalInput.mBiasz = this.biasz;
            return sensorGyroUncalInput;
        }

        public Builder but() {
            return aSensorGyroUncalInput().withBt(this.bootTime).withUgx(this.ugx).withUgy(this.ugy).withUgz(this.ugz).withBiasx(this.biasx).withBiasy(this.biasy).withBiasz(this.biasz);
        }

        public Builder withBiasx(double d11) {
            this.biasx = d11;
            return this;
        }

        public Builder withBiasy(double d11) {
            this.biasy = d11;
            return this;
        }

        public Builder withBiasz(double d11) {
            this.biasz = d11;
            return this;
        }

        public Builder withBt(long j11) {
            this.bootTime = j11;
            return this;
        }

        public Builder withUgx(double d11) {
            this.ugx = d11;
            return this;
        }

        public Builder withUgy(double d11) {
            this.ugy = d11;
            return this;
        }

        public Builder withUgz(double d11) {
            this.ugz = d11;
            return this;
        }
    }

    public double getBiasx() {
        return this.mBiasx;
    }

    public double getBiasy() {
        return this.mBiasy;
    }

    public double getBiasz() {
        return this.mBiasz;
    }

    public long getBootTime() {
        return this.mBootTime;
    }

    public double getUgx() {
        return this.mUgx;
    }

    public double getUgy() {
        return this.mUgy;
    }

    public double getUgz() {
        return this.mUgz;
    }
}
