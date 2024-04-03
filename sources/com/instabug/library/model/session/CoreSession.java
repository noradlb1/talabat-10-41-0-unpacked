package com.instabug.library.model.session;

import android.annotation.SuppressLint;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.library.internal.data.b;
import com.instabug.library.internal.data.c;
import com.instabug.library.model.common.SessionVersion;

@Keep
public class CoreSession implements com.instabug.library.model.common.a {
    /* access modifiers changed from: private */
    @b
    @Nullable
    @c(name = "application_token")
    public String appToken;
    /* access modifiers changed from: private */
    @b
    @Nullable
    @c(name = "app_version")
    public String appVersion;
    /* access modifiers changed from: private */
    @b
    @c(name = "crash_reporting_enabled")
    public boolean crashReportingEnabled;
    /* access modifiers changed from: private */
    @b
    @Nullable
    @c(alternate = "custom_attribute_keys", name = "custom_attributes")
    public String customAttributes;
    /* access modifiers changed from: private */
    @b
    @Nullable
    @c(name = "device")
    public String device;
    /* access modifiers changed from: private */
    @b
    @c(name = "duration")
    public long duration;
    @NonNull

    /* renamed from: id  reason: collision with root package name */
    private final String f51574id;
    /* access modifiers changed from: private */
    @b
    @c(name = "stitched_session_lead")
    public boolean isStitchedSessionLead;
    @NonNull
    @b
    @c(name = "os")

    /* renamed from: os  reason: collision with root package name */
    private final String f51575os;
    /* access modifiers changed from: private */
    @Nullable
    public String productionUsage;
    /* access modifiers changed from: private */
    @b
    @Nullable
    @c(name = "sdk_version")
    public String sdkVersion;
    /* access modifiers changed from: private */
    public long startNanoTime;
    /* access modifiers changed from: private */
    @b
    @c(name = "started_at")
    public long startTimestampMicros;
    /* access modifiers changed from: private */
    public int syncStatus;
    /* access modifiers changed from: private */
    @b
    @Nullable
    @c(name = "email")
    public String userEmail;
    /* access modifiers changed from: private */
    @b
    @Nullable
    @c(alternate = "user_event_keys", name = "user_events")
    public String userEvents;
    /* access modifiers changed from: private */
    @b
    @Nullable
    @c(name = "name")
    public String userName;
    /* access modifiers changed from: private */
    public boolean usersPageEnabled;
    @NonNull
    @b
    @c(name = "uuid")
    private final String uuid;

    public static class Builder {
        @Nullable
        private String appToken;
        @Nullable
        private String appVersion;
        private boolean crashReportingEnabled = false;
        @Nullable
        private String customAttributes;
        @Nullable
        private String device;
        private long duration;
        @NonNull

        /* renamed from: id  reason: collision with root package name */
        private String f51576id;
        private boolean isStitchedSessionLead = false;
        @NonNull

        /* renamed from: os  reason: collision with root package name */
        private String f51577os;
        @Nullable
        private String productionUsage;
        @Nullable
        private String sdkVersion;
        private long startNanoTime;
        private long startTimestampMicros;
        private int syncStatus = 0;
        @Nullable
        private String userEmail;
        @Nullable
        private String userEvents;
        @Nullable
        private String userName;
        private boolean usersPageEnabled = false;
        @NonNull
        private String uuid;

        public Builder(@NonNull String str, @NonNull String str2, @NonNull String str3) {
            this.f51576id = str;
            this.uuid = str2;
            this.f51577os = str3;
        }

        @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
        public CoreSession build() {
            CoreSession coreSession = new CoreSession(this.f51576id, this.uuid, this.f51577os);
            String unused = coreSession.device = this.device;
            String unused2 = coreSession.appToken = this.appToken;
            String unused3 = coreSession.appVersion = this.appVersion;
            long unused4 = coreSession.duration = this.duration;
            String unused5 = coreSession.productionUsage = this.productionUsage;
            boolean unused6 = coreSession.crashReportingEnabled = this.crashReportingEnabled;
            boolean unused7 = coreSession.isStitchedSessionLead = this.isStitchedSessionLead;
            String unused8 = coreSession.customAttributes = this.customAttributes;
            String unused9 = coreSession.sdkVersion = this.sdkVersion;
            long unused10 = coreSession.startNanoTime = this.startNanoTime;
            long unused11 = coreSession.startTimestampMicros = this.startTimestampMicros;
            int unused12 = coreSession.syncStatus = this.syncStatus;
            String unused13 = coreSession.userEmail = this.userEmail;
            String unused14 = coreSession.userEvents = this.userEvents;
            String unused15 = coreSession.userName = this.userName;
            boolean unused16 = coreSession.usersPageEnabled = this.usersPageEnabled;
            return coreSession;
        }

        public Builder setAppToken(@Nullable String str) {
            this.appToken = str;
            return this;
        }

        public Builder setAppVersion(@Nullable String str) {
            this.appVersion = str;
            return this;
        }

        public Builder setCrashReportingEnabled(boolean z11) {
            this.crashReportingEnabled = z11;
            return this;
        }

        public Builder setCustomAttributes(@Nullable String str) {
            this.customAttributes = str;
            return this;
        }

        public Builder setDevice(@Nullable String str) {
            this.device = str;
            return this;
        }

        public Builder setDuration(long j11) {
            this.duration = j11;
            return this;
        }

        public Builder setId(@NonNull String str) {
            this.f51576id = str;
            return this;
        }

        public Builder setIsStitchedSessionLead(boolean z11) {
            this.isStitchedSessionLead = z11;
            return this;
        }

        public Builder setOs(@NonNull String str) {
            this.f51577os = str;
            return this;
        }

        public Builder setProductionUsage(@Nullable String str) {
            this.productionUsage = str;
            return this;
        }

        public Builder setSdkVersion(@Nullable String str) {
            this.sdkVersion = str;
            return this;
        }

        public Builder setStartNanoTime(long j11) {
            this.startNanoTime = j11;
            return this;
        }

        public Builder setStartTimestampMicros(long j11) {
            this.startTimestampMicros = j11;
            return this;
        }

        public Builder setSyncStatus(int i11) {
            this.syncStatus = i11;
            return this;
        }

        public Builder setUserEmail(@Nullable String str) {
            this.userEmail = str;
            return this;
        }

        public Builder setUserEvents(@Nullable String str) {
            this.userEvents = str;
            return this;
        }

        public Builder setUserName(@Nullable String str) {
            this.userName = str;
            return this;
        }

        public Builder setUsersPageEnabled(boolean z11) {
            this.usersPageEnabled = z11;
            return this;
        }

        public Builder setUuid(@NonNull String str) {
            this.uuid = str;
            return this;
        }
    }

    @Nullable
    public String getAppToken() {
        return this.appToken;
    }

    @Nullable
    public String getAppVersion() {
        return this.appVersion;
    }

    @Nullable
    public String getCustomAttributes() {
        return this.customAttributes;
    }

    @Nullable
    public String getDevice() {
        return this.device;
    }

    public long getDuration() {
        return this.duration;
    }

    @NonNull
    public String getId() {
        return this.f51574id;
    }

    @NonNull
    public String getOs() {
        return this.f51575os;
    }

    @Nullable
    public String getProductionUsage() {
        return this.productionUsage;
    }

    @Nullable
    public String getSdkVersion() {
        return this.sdkVersion;
    }

    public long getStartNanoTime() {
        return this.startNanoTime;
    }

    public long getStartTimestampMicros() {
        return this.startTimestampMicros;
    }

    public int getSyncStatus() {
        return this.syncStatus;
    }

    @Nullable
    public String getUserEmail() {
        return this.userEmail;
    }

    @Nullable
    public String getUserEvents() {
        return this.userEvents;
    }

    @Nullable
    public String getUserName() {
        return this.userName;
    }

    @NonNull
    public String getUuid() {
        return this.uuid;
    }

    public String getVersion() {
        return SessionVersion.V2;
    }

    public boolean isCrashReportingEnabled() {
        return this.crashReportingEnabled;
    }

    public boolean isStitchedSessionLead() {
        return this.isStitchedSessionLead;
    }

    public boolean isUsersPageEnabled() {
        return this.usersPageEnabled;
    }

    private CoreSession(@NonNull String str, @NonNull String str2, @NonNull String str3) {
        this.f51574id = str;
        this.uuid = str2;
        this.f51575os = str3;
    }
}
