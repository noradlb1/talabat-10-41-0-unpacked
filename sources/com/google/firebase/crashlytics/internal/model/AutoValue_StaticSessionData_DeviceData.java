package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.StaticSessionData;

final class AutoValue_StaticSessionData_DeviceData extends StaticSessionData.DeviceData {
    private final int arch;
    private final int availableProcessors;
    private final long diskSpace;
    private final boolean isEmulator;
    private final String manufacturer;
    private final String model;
    private final String modelClass;
    private final int state;
    private final long totalRam;

    public AutoValue_StaticSessionData_DeviceData(int i11, String str, int i12, long j11, long j12, boolean z11, int i13, String str2, String str3) {
        this.arch = i11;
        if (str != null) {
            this.model = str;
            this.availableProcessors = i12;
            this.totalRam = j11;
            this.diskSpace = j12;
            this.isEmulator = z11;
            this.state = i13;
            if (str2 != null) {
                this.manufacturer = str2;
                if (str3 != null) {
                    this.modelClass = str3;
                    return;
                }
                throw new NullPointerException("Null modelClass");
            }
            throw new NullPointerException("Null manufacturer");
        }
        throw new NullPointerException("Null model");
    }

    public int arch() {
        return this.arch;
    }

    public int availableProcessors() {
        return this.availableProcessors;
    }

    public long diskSpace() {
        return this.diskSpace;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StaticSessionData.DeviceData)) {
            return false;
        }
        StaticSessionData.DeviceData deviceData = (StaticSessionData.DeviceData) obj;
        if (this.arch == deviceData.arch() && this.model.equals(deviceData.model()) && this.availableProcessors == deviceData.availableProcessors() && this.totalRam == deviceData.totalRam() && this.diskSpace == deviceData.diskSpace() && this.isEmulator == deviceData.isEmulator() && this.state == deviceData.state() && this.manufacturer.equals(deviceData.manufacturer()) && this.modelClass.equals(deviceData.modelClass())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i11;
        long j11 = this.totalRam;
        long j12 = this.diskSpace;
        int hashCode = (((((((((this.arch ^ 1000003) * 1000003) ^ this.model.hashCode()) * 1000003) ^ this.availableProcessors) * 1000003) ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003) ^ ((int) (j12 ^ (j12 >>> 32)))) * 1000003;
        if (this.isEmulator) {
            i11 = 1231;
        } else {
            i11 = 1237;
        }
        return ((((((hashCode ^ i11) * 1000003) ^ this.state) * 1000003) ^ this.manufacturer.hashCode()) * 1000003) ^ this.modelClass.hashCode();
    }

    public boolean isEmulator() {
        return this.isEmulator;
    }

    public String manufacturer() {
        return this.manufacturer;
    }

    public String model() {
        return this.model;
    }

    public String modelClass() {
        return this.modelClass;
    }

    public int state() {
        return this.state;
    }

    public String toString() {
        return "DeviceData{arch=" + this.arch + ", model=" + this.model + ", availableProcessors=" + this.availableProcessors + ", totalRam=" + this.totalRam + ", diskSpace=" + this.diskSpace + ", isEmulator=" + this.isEmulator + ", state=" + this.state + ", manufacturer=" + this.manufacturer + ", modelClass=" + this.modelClass + "}";
    }

    public long totalRam() {
        return this.totalRam;
    }
}
