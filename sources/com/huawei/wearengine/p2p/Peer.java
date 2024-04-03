package com.huawei.wearengine.p2p;

import com.huawei.wearengine.device.Device;

public class Peer {

    /* renamed from: a  reason: collision with root package name */
    private Device f44820a;

    /* renamed from: b  reason: collision with root package name */
    private String f44821b;

    /* renamed from: c  reason: collision with root package name */
    private String f44822c;

    public static class Builder {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public Device f44823a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public String f44824b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public String f44825c;

        public Peer build() {
            return new Peer(this);
        }

        public Builder setDevice(Device device) {
            this.f44823a = device;
            return this;
        }

        public Builder setFingerPrint(String str) {
            this.f44824b = str;
            return this;
        }

        public Builder setPkgName(String str) {
            this.f44825c = str;
            return this;
        }
    }

    public Peer(Builder builder) {
        this.f44820a = builder.f44823a;
        this.f44821b = builder.f44824b;
        this.f44822c = builder.f44825c;
    }

    public Device getDevice() {
        return this.f44820a;
    }

    public String getFingerPrint() {
        return this.f44821b;
    }

    public String getPkgName() {
        return this.f44822c;
    }
}
