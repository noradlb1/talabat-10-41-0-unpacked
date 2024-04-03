package com.huawei.riemann.gnsslocation.core.bean;

public class DeviceInfo {
    public String mChipName;
    public String mManufacturer;
    public int mSdkLevel;

    public static final class Builder {
        public String mChipName;
        public String mManufacturer;
        public int mSdkLevel;

        public static Builder aDeviceInfo() {
            return new Builder();
        }

        public DeviceInfo build() {
            DeviceInfo deviceInfo = new DeviceInfo();
            int unused = deviceInfo.mSdkLevel = this.mSdkLevel;
            String unused2 = deviceInfo.mManufacturer = this.mManufacturer;
            String unused3 = deviceInfo.mChipName = this.mChipName;
            return deviceInfo;
        }

        public Builder but() {
            return aDeviceInfo().withSdkLevel(this.mSdkLevel).withChipName(this.mChipName).withManufacturer(this.mManufacturer);
        }

        public Builder withChipName(String str) {
            this.mChipName = str;
            return this;
        }

        public Builder withManufacturer(String str) {
            this.mManufacturer = str;
            return this;
        }

        public Builder withSdkLevel(int i11) {
            this.mSdkLevel = i11;
            return this;
        }
    }

    public String getChipName() {
        return this.mChipName;
    }

    public String getManufacturer() {
        return this.mManufacturer;
    }

    public int getSdkLevel() {
        return this.mSdkLevel;
    }
}
