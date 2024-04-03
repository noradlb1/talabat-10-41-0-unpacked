package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.encoders.annotations.Encodable;

final class AutoValue_CrashlyticsReport_Session extends CrashlyticsReport.Session {
    private final CrashlyticsReport.Session.Application app;
    private final String appQualitySessionId;
    private final boolean crashed;
    private final CrashlyticsReport.Session.Device device;
    private final Long endedAt;
    private final ImmutableList<CrashlyticsReport.Session.Event> events;
    private final String generator;
    private final int generatorType;
    private final String identifier;

    /* renamed from: os  reason: collision with root package name */
    private final CrashlyticsReport.Session.OperatingSystem f47379os;
    private final long startedAt;
    private final CrashlyticsReport.Session.User user;

    public static final class Builder extends CrashlyticsReport.Session.Builder {
        private CrashlyticsReport.Session.Application app;
        private String appQualitySessionId;
        private Boolean crashed;
        private CrashlyticsReport.Session.Device device;
        private Long endedAt;
        private ImmutableList<CrashlyticsReport.Session.Event> events;
        private String generator;
        private Integer generatorType;
        private String identifier;

        /* renamed from: os  reason: collision with root package name */
        private CrashlyticsReport.Session.OperatingSystem f47380os;
        private Long startedAt;
        private CrashlyticsReport.Session.User user;

        public CrashlyticsReport.Session build() {
            String str = "";
            if (this.generator == null) {
                str = str + " generator";
            }
            if (this.identifier == null) {
                str = str + " identifier";
            }
            if (this.startedAt == null) {
                str = str + " startedAt";
            }
            if (this.crashed == null) {
                str = str + " crashed";
            }
            if (this.app == null) {
                str = str + " app";
            }
            if (this.generatorType == null) {
                str = str + " generatorType";
            }
            if (str.isEmpty()) {
                return new AutoValue_CrashlyticsReport_Session(this.generator, this.identifier, this.appQualitySessionId, this.startedAt.longValue(), this.endedAt, this.crashed.booleanValue(), this.app, this.user, this.f47380os, this.device, this.events, this.generatorType.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public CrashlyticsReport.Session.Builder setApp(CrashlyticsReport.Session.Application application) {
            if (application != null) {
                this.app = application;
                return this;
            }
            throw new NullPointerException("Null app");
        }

        public CrashlyticsReport.Session.Builder setAppQualitySessionId(@Nullable String str) {
            this.appQualitySessionId = str;
            return this;
        }

        public CrashlyticsReport.Session.Builder setCrashed(boolean z11) {
            this.crashed = Boolean.valueOf(z11);
            return this;
        }

        public CrashlyticsReport.Session.Builder setDevice(CrashlyticsReport.Session.Device device2) {
            this.device = device2;
            return this;
        }

        public CrashlyticsReport.Session.Builder setEndedAt(Long l11) {
            this.endedAt = l11;
            return this;
        }

        public CrashlyticsReport.Session.Builder setEvents(ImmutableList<CrashlyticsReport.Session.Event> immutableList) {
            this.events = immutableList;
            return this;
        }

        public CrashlyticsReport.Session.Builder setGenerator(String str) {
            if (str != null) {
                this.generator = str;
                return this;
            }
            throw new NullPointerException("Null generator");
        }

        public CrashlyticsReport.Session.Builder setGeneratorType(int i11) {
            this.generatorType = Integer.valueOf(i11);
            return this;
        }

        public CrashlyticsReport.Session.Builder setIdentifier(String str) {
            if (str != null) {
                this.identifier = str;
                return this;
            }
            throw new NullPointerException("Null identifier");
        }

        public CrashlyticsReport.Session.Builder setOs(CrashlyticsReport.Session.OperatingSystem operatingSystem) {
            this.f47380os = operatingSystem;
            return this;
        }

        public CrashlyticsReport.Session.Builder setStartedAt(long j11) {
            this.startedAt = Long.valueOf(j11);
            return this;
        }

        public CrashlyticsReport.Session.Builder setUser(CrashlyticsReport.Session.User user2) {
            this.user = user2;
            return this;
        }

        public Builder() {
        }

        private Builder(CrashlyticsReport.Session session) {
            this.generator = session.getGenerator();
            this.identifier = session.getIdentifier();
            this.appQualitySessionId = session.getAppQualitySessionId();
            this.startedAt = Long.valueOf(session.getStartedAt());
            this.endedAt = session.getEndedAt();
            this.crashed = Boolean.valueOf(session.isCrashed());
            this.app = session.getApp();
            this.user = session.getUser();
            this.f47380os = session.getOs();
            this.device = session.getDevice();
            this.events = session.getEvents();
            this.generatorType = Integer.valueOf(session.getGeneratorType());
        }
    }

    public boolean equals(Object obj) {
        String str;
        Long l11;
        CrashlyticsReport.Session.User user2;
        CrashlyticsReport.Session.OperatingSystem operatingSystem;
        CrashlyticsReport.Session.Device device2;
        ImmutableList<CrashlyticsReport.Session.Event> immutableList;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session)) {
            return false;
        }
        CrashlyticsReport.Session session = (CrashlyticsReport.Session) obj;
        if (!this.generator.equals(session.getGenerator()) || !this.identifier.equals(session.getIdentifier()) || ((str = this.appQualitySessionId) != null ? !str.equals(session.getAppQualitySessionId()) : session.getAppQualitySessionId() != null) || this.startedAt != session.getStartedAt() || ((l11 = this.endedAt) != null ? !l11.equals(session.getEndedAt()) : session.getEndedAt() != null) || this.crashed != session.isCrashed() || !this.app.equals(session.getApp()) || ((user2 = this.user) != null ? !user2.equals(session.getUser()) : session.getUser() != null) || ((operatingSystem = this.f47379os) != null ? !operatingSystem.equals(session.getOs()) : session.getOs() != null) || ((device2 = this.device) != null ? !device2.equals(session.getDevice()) : session.getDevice() != null) || ((immutableList = this.events) != null ? !immutableList.equals(session.getEvents()) : session.getEvents() != null) || this.generatorType != session.getGeneratorType()) {
            return false;
        }
        return true;
    }

    @NonNull
    public CrashlyticsReport.Session.Application getApp() {
        return this.app;
    }

    @Nullable
    public String getAppQualitySessionId() {
        return this.appQualitySessionId;
    }

    @Nullable
    public CrashlyticsReport.Session.Device getDevice() {
        return this.device;
    }

    @Nullable
    public Long getEndedAt() {
        return this.endedAt;
    }

    @Nullable
    public ImmutableList<CrashlyticsReport.Session.Event> getEvents() {
        return this.events;
    }

    @NonNull
    public String getGenerator() {
        return this.generator;
    }

    public int getGeneratorType() {
        return this.generatorType;
    }

    @NonNull
    @Encodable.Ignore
    public String getIdentifier() {
        return this.identifier;
    }

    @Nullable
    public CrashlyticsReport.Session.OperatingSystem getOs() {
        return this.f47379os;
    }

    public long getStartedAt() {
        return this.startedAt;
    }

    @Nullable
    public CrashlyticsReport.Session.User getUser() {
        return this.user;
    }

    public int hashCode() {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int hashCode = (((this.generator.hashCode() ^ 1000003) * 1000003) ^ this.identifier.hashCode()) * 1000003;
        String str = this.appQualitySessionId;
        int i17 = 0;
        if (str == null) {
            i11 = 0;
        } else {
            i11 = str.hashCode();
        }
        long j11 = this.startedAt;
        int i18 = (((hashCode ^ i11) * 1000003) ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003;
        Long l11 = this.endedAt;
        if (l11 == null) {
            i12 = 0;
        } else {
            i12 = l11.hashCode();
        }
        int i19 = (i18 ^ i12) * 1000003;
        if (this.crashed) {
            i13 = 1231;
        } else {
            i13 = 1237;
        }
        int hashCode2 = (((i19 ^ i13) * 1000003) ^ this.app.hashCode()) * 1000003;
        CrashlyticsReport.Session.User user2 = this.user;
        if (user2 == null) {
            i14 = 0;
        } else {
            i14 = user2.hashCode();
        }
        int i21 = (hashCode2 ^ i14) * 1000003;
        CrashlyticsReport.Session.OperatingSystem operatingSystem = this.f47379os;
        if (operatingSystem == null) {
            i15 = 0;
        } else {
            i15 = operatingSystem.hashCode();
        }
        int i22 = (i21 ^ i15) * 1000003;
        CrashlyticsReport.Session.Device device2 = this.device;
        if (device2 == null) {
            i16 = 0;
        } else {
            i16 = device2.hashCode();
        }
        int i23 = (i22 ^ i16) * 1000003;
        ImmutableList<CrashlyticsReport.Session.Event> immutableList = this.events;
        if (immutableList != null) {
            i17 = immutableList.hashCode();
        }
        return ((i23 ^ i17) * 1000003) ^ this.generatorType;
    }

    public boolean isCrashed() {
        return this.crashed;
    }

    public CrashlyticsReport.Session.Builder toBuilder() {
        return new Builder(this);
    }

    public String toString() {
        return "Session{generator=" + this.generator + ", identifier=" + this.identifier + ", appQualitySessionId=" + this.appQualitySessionId + ", startedAt=" + this.startedAt + ", endedAt=" + this.endedAt + ", crashed=" + this.crashed + ", app=" + this.app + ", user=" + this.user + ", os=" + this.f47379os + ", device=" + this.device + ", events=" + this.events + ", generatorType=" + this.generatorType + "}";
    }

    private AutoValue_CrashlyticsReport_Session(String str, String str2, @Nullable String str3, long j11, @Nullable Long l11, boolean z11, CrashlyticsReport.Session.Application application, @Nullable CrashlyticsReport.Session.User user2, @Nullable CrashlyticsReport.Session.OperatingSystem operatingSystem, @Nullable CrashlyticsReport.Session.Device device2, @Nullable ImmutableList<CrashlyticsReport.Session.Event> immutableList, int i11) {
        this.generator = str;
        this.identifier = str2;
        this.appQualitySessionId = str3;
        this.startedAt = j11;
        this.endedAt = l11;
        this.crashed = z11;
        this.app = application;
        this.user = user2;
        this.f47379os = operatingSystem;
        this.device = device2;
        this.events = immutableList;
        this.generatorType = i11;
    }
}
