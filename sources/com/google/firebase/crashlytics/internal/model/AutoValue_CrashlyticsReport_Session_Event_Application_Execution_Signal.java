package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

final class AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal extends CrashlyticsReport.Session.Event.Application.Execution.Signal {
    private final long address;
    private final String code;

    /* renamed from: name  reason: collision with root package name */
    private final String f47383name;

    public static final class Builder extends CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder {
        private Long address;
        private String code;

        /* renamed from: name  reason: collision with root package name */
        private String f47384name;

        public CrashlyticsReport.Session.Event.Application.Execution.Signal build() {
            String str = "";
            if (this.f47384name == null) {
                str = str + " name";
            }
            if (this.code == null) {
                str = str + " code";
            }
            if (this.address == null) {
                str = str + " address";
            }
            if (str.isEmpty()) {
                return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal(this.f47384name, this.code, this.address.longValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder setAddress(long j11) {
            this.address = Long.valueOf(j11);
            return this;
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder setCode(String str) {
            if (str != null) {
                this.code = str;
                return this;
            }
            throw new NullPointerException("Null code");
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder setName(String str) {
            if (str != null) {
                this.f47384name = str;
                return this;
            }
            throw new NullPointerException("Null name");
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Event.Application.Execution.Signal)) {
            return false;
        }
        CrashlyticsReport.Session.Event.Application.Execution.Signal signal = (CrashlyticsReport.Session.Event.Application.Execution.Signal) obj;
        if (!this.f47383name.equals(signal.getName()) || !this.code.equals(signal.getCode()) || this.address != signal.getAddress()) {
            return false;
        }
        return true;
    }

    @NonNull
    public long getAddress() {
        return this.address;
    }

    @NonNull
    public String getCode() {
        return this.code;
    }

    @NonNull
    public String getName() {
        return this.f47383name;
    }

    public int hashCode() {
        long j11 = this.address;
        return ((((this.f47383name.hashCode() ^ 1000003) * 1000003) ^ this.code.hashCode()) * 1000003) ^ ((int) (j11 ^ (j11 >>> 32)));
    }

    public String toString() {
        return "Signal{name=" + this.f47383name + ", code=" + this.code + ", address=" + this.address + "}";
    }

    private AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal(String str, String str2, long j11) {
        this.f47383name = str;
        this.code = str2;
        this.address = j11;
    }
}
