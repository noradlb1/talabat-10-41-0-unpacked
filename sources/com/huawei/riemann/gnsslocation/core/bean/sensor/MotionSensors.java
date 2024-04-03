package com.huawei.riemann.gnsslocation.core.bean.sensor;

public class MotionSensors {
    public SensorAccInput[] mSensorAccInputs;
    public SensorGyroInput[] mSensorGyroInputs;
    public SensorGyroUncalInput[] mSensorGyroUncalInputs;

    public static final class Builder {
        public SensorAccInput[] mAccInputs;
        public SensorGyroInput[] mGyroInputs;
        public SensorGyroUncalInput[] mGyroUncalInputs;

        public static Builder aSensor() {
            return new Builder();
        }

        public MotionSensors build() {
            MotionSensors motionSensors = new MotionSensors();
            SensorAccInput[] unused = motionSensors.mSensorAccInputs = this.mAccInputs;
            SensorGyroInput[] unused2 = motionSensors.mSensorGyroInputs = this.mGyroInputs;
            SensorGyroUncalInput[] unused3 = motionSensors.mSensorGyroUncalInputs = this.mGyroUncalInputs;
            return motionSensors;
        }

        public Builder but() {
            return aSensor().withAccInputs(this.mAccInputs).withGyroInputs(this.mGyroInputs).withGyroUncalInputs(this.mGyroUncalInputs);
        }

        public Builder withAccInputs(SensorAccInput[] sensorAccInputArr) {
            this.mAccInputs = sensorAccInputArr;
            return this;
        }

        public Builder withGyroInputs(SensorGyroInput[] sensorGyroInputArr) {
            this.mGyroInputs = sensorGyroInputArr;
            return this;
        }

        public Builder withGyroUncalInputs(SensorGyroUncalInput[] sensorGyroUncalInputArr) {
            this.mGyroUncalInputs = sensorGyroUncalInputArr;
            return this;
        }
    }

    public SensorAccInput[] getSensorAccInputs() {
        return (SensorAccInput[]) this.mSensorAccInputs.clone();
    }

    public SensorGyroInput[] getSensorGyroInputs() {
        return (SensorGyroInput[]) this.mSensorGyroInputs.clone();
    }

    public SensorGyroUncalInput[] getSensorGyroUncalInputs() {
        return (SensorGyroUncalInput[]) this.mSensorGyroUncalInputs.clone();
    }
}
