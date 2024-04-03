package com.huawei.wearengine.p2p;

import com.huawei.wearengine.WearEngineException;
import java.io.File;

public class Message {
    public static final int MESSAGE_TYPE_DATA = 1;
    public static final int MESSAGE_TYPE_DEFAULT = 0;
    public static final int MESSAGE_TYPE_FILE = 2;

    /* renamed from: a  reason: collision with root package name */
    private String f44760a;

    /* renamed from: b  reason: collision with root package name */
    private byte[] f44761b;

    /* renamed from: c  reason: collision with root package name */
    private File f44762c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f44763d;

    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        public String f44764a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public byte[] f44765b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public File f44766c;

        /* renamed from: d  reason: collision with root package name */
        private int f44767d = 0;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public boolean f44768e = true;

        public Message build() {
            return new Message(this);
        }

        public Builder setDescription(String str) {
            this.f44764a = str;
            return this;
        }

        public Builder setEnableEncrypt(boolean z11) {
            this.f44768e = z11;
            return this;
        }

        public Builder setPayload(File file) {
            int i11 = this.f44767d;
            if (i11 == 0 || i11 == 2) {
                this.f44766c = file;
                this.f44767d = 2;
                return this;
            }
            throw new WearEngineException(5);
        }

        public Builder setPayload(byte[] bArr) {
            int i11 = this.f44767d;
            if (i11 == 0 || i11 == 1) {
                this.f44765b = bArr == null ? null : (byte[]) bArr.clone();
                this.f44767d = 1;
                return this;
            }
            throw new WearEngineException(5);
        }
    }

    public Message(Builder builder) {
        this.f44760a = builder.f44764a;
        this.f44761b = builder.f44765b;
        this.f44762c = builder.f44766c;
        this.f44763d = builder.f44768e;
    }

    public byte[] getData() {
        byte[] bArr = this.f44761b;
        if (bArr == null) {
            return null;
        }
        return (byte[]) bArr.clone();
    }

    public String getDescription() {
        return this.f44760a;
    }

    public File getFile() {
        return this.f44762c;
    }

    public int getType() {
        if (this.f44761b != null) {
            return 1;
        }
        return this.f44762c != null ? 2 : 0;
    }

    public boolean isEnableEncrypt() {
        return this.f44763d;
    }
}
