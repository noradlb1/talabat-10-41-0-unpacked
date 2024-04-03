package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.encoders.annotations.Encodable;

final class AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage extends CrashlyticsReport.Session.Event.Application.Execution.BinaryImage {
    private final long baseAddress;

    /* renamed from: name  reason: collision with root package name */
    private final String f47381name;
    private final long size;
    private final String uuid;

    public static final class Builder extends CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder {
        private Long baseAddress;

        /* renamed from: name  reason: collision with root package name */
        private String f47382name;
        private Long size;
        private String uuid;

        public CrashlyticsReport.Session.Event.Application.Execution.BinaryImage build() {
            String str = "";
            if (this.baseAddress == null) {
                str = str + " baseAddress";
            }
            if (this.size == null) {
                str = str + " size";
            }
            if (this.f47382name == null) {
                str = str + " name";
            }
            if (str.isEmpty()) {
                return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage(this.baseAddress.longValue(), this.size.longValue(), this.f47382name, this.uuid);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder setBaseAddress(long j11) {
            this.baseAddress = Long.valueOf(j11);
            return this;
        }

        public CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder setName(String str) {
            if (str != null) {
                this.f47382name = str;
                return this;
            }
            throw new NullPointerException("Null name");
        }

        public CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder setSize(long j11) {
            this.size = Long.valueOf(j11);
            return this;
        }

        public CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder setUuid(@Nullable String str) {
            this.uuid = str;
            return this;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Event.Application.Execution.BinaryImage)) {
            return false;
        }
        CrashlyticsReport.Session.Event.Application.Execution.BinaryImage binaryImage = (CrashlyticsReport.Session.Event.Application.Execution.BinaryImage) obj;
        if (this.baseAddress == binaryImage.getBaseAddress() && this.size == binaryImage.getSize() && this.f47381name.equals(binaryImage.getName())) {
            String str = this.uuid;
            if (str == null) {
                if (binaryImage.getUuid() == null) {
                    return true;
                }
            } else if (str.equals(binaryImage.getUuid())) {
                return true;
            }
        }
        return false;
    }

    @NonNull
    public long getBaseAddress() {
        return this.baseAddress;
    }

    @NonNull
    public String getName() {
        return this.f47381name;
    }

    public long getSize() {
        return this.size;
    }

    @Encodable.Ignore
    @Nullable
    public String getUuid() {
        return this.uuid;
    }

    public int hashCode() {
        int i11;
        long j11 = this.baseAddress;
        long j12 = this.size;
        int hashCode = (((((((int) (j11 ^ (j11 >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j12 >>> 32) ^ j12))) * 1000003) ^ this.f47381name.hashCode()) * 1000003;
        String str = this.uuid;
        if (str == null) {
            i11 = 0;
        } else {
            i11 = str.hashCode();
        }
        return hashCode ^ i11;
    }

    public String toString() {
        return "BinaryImage{baseAddress=" + this.baseAddress + ", size=" + this.size + ", name=" + this.f47381name + ", uuid=" + this.uuid + "}";
    }

    private AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage(long j11, long j12, String str, @Nullable String str2) {
        this.baseAddress = j11;
        this.size = j12;
        this.f47381name = str;
        this.uuid = str2;
    }
}
