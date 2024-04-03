package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

final class AutoValue_CrashlyticsReport_Session_Event_Application extends CrashlyticsReport.Session.Event.Application {
    private final Boolean background;
    private final ImmutableList<CrashlyticsReport.CustomAttribute> customAttributes;
    private final CrashlyticsReport.Session.Event.Application.Execution execution;
    private final ImmutableList<CrashlyticsReport.CustomAttribute> internalKeys;
    private final int uiOrientation;

    public static final class Builder extends CrashlyticsReport.Session.Event.Application.Builder {
        private Boolean background;
        private ImmutableList<CrashlyticsReport.CustomAttribute> customAttributes;
        private CrashlyticsReport.Session.Event.Application.Execution execution;
        private ImmutableList<CrashlyticsReport.CustomAttribute> internalKeys;
        private Integer uiOrientation;

        public CrashlyticsReport.Session.Event.Application build() {
            String str = "";
            if (this.execution == null) {
                str = str + " execution";
            }
            if (this.uiOrientation == null) {
                str = str + " uiOrientation";
            }
            if (str.isEmpty()) {
                return new AutoValue_CrashlyticsReport_Session_Event_Application(this.execution, this.customAttributes, this.internalKeys, this.background, this.uiOrientation.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public CrashlyticsReport.Session.Event.Application.Builder setBackground(@Nullable Boolean bool) {
            this.background = bool;
            return this;
        }

        public CrashlyticsReport.Session.Event.Application.Builder setCustomAttributes(ImmutableList<CrashlyticsReport.CustomAttribute> immutableList) {
            this.customAttributes = immutableList;
            return this;
        }

        public CrashlyticsReport.Session.Event.Application.Builder setExecution(CrashlyticsReport.Session.Event.Application.Execution execution2) {
            if (execution2 != null) {
                this.execution = execution2;
                return this;
            }
            throw new NullPointerException("Null execution");
        }

        public CrashlyticsReport.Session.Event.Application.Builder setInternalKeys(ImmutableList<CrashlyticsReport.CustomAttribute> immutableList) {
            this.internalKeys = immutableList;
            return this;
        }

        public CrashlyticsReport.Session.Event.Application.Builder setUiOrientation(int i11) {
            this.uiOrientation = Integer.valueOf(i11);
            return this;
        }

        public Builder() {
        }

        private Builder(CrashlyticsReport.Session.Event.Application application) {
            this.execution = application.getExecution();
            this.customAttributes = application.getCustomAttributes();
            this.internalKeys = application.getInternalKeys();
            this.background = application.getBackground();
            this.uiOrientation = Integer.valueOf(application.getUiOrientation());
        }
    }

    public boolean equals(Object obj) {
        ImmutableList<CrashlyticsReport.CustomAttribute> immutableList;
        ImmutableList<CrashlyticsReport.CustomAttribute> immutableList2;
        Boolean bool;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Event.Application)) {
            return false;
        }
        CrashlyticsReport.Session.Event.Application application = (CrashlyticsReport.Session.Event.Application) obj;
        if (!this.execution.equals(application.getExecution()) || ((immutableList = this.customAttributes) != null ? !immutableList.equals(application.getCustomAttributes()) : application.getCustomAttributes() != null) || ((immutableList2 = this.internalKeys) != null ? !immutableList2.equals(application.getInternalKeys()) : application.getInternalKeys() != null) || ((bool = this.background) != null ? !bool.equals(application.getBackground()) : application.getBackground() != null) || this.uiOrientation != application.getUiOrientation()) {
            return false;
        }
        return true;
    }

    @Nullable
    public Boolean getBackground() {
        return this.background;
    }

    @Nullable
    public ImmutableList<CrashlyticsReport.CustomAttribute> getCustomAttributes() {
        return this.customAttributes;
    }

    @NonNull
    public CrashlyticsReport.Session.Event.Application.Execution getExecution() {
        return this.execution;
    }

    @Nullable
    public ImmutableList<CrashlyticsReport.CustomAttribute> getInternalKeys() {
        return this.internalKeys;
    }

    public int getUiOrientation() {
        return this.uiOrientation;
    }

    public int hashCode() {
        int i11;
        int i12;
        int hashCode = (this.execution.hashCode() ^ 1000003) * 1000003;
        ImmutableList<CrashlyticsReport.CustomAttribute> immutableList = this.customAttributes;
        int i13 = 0;
        if (immutableList == null) {
            i11 = 0;
        } else {
            i11 = immutableList.hashCode();
        }
        int i14 = (hashCode ^ i11) * 1000003;
        ImmutableList<CrashlyticsReport.CustomAttribute> immutableList2 = this.internalKeys;
        if (immutableList2 == null) {
            i12 = 0;
        } else {
            i12 = immutableList2.hashCode();
        }
        int i15 = (i14 ^ i12) * 1000003;
        Boolean bool = this.background;
        if (bool != null) {
            i13 = bool.hashCode();
        }
        return ((i15 ^ i13) * 1000003) ^ this.uiOrientation;
    }

    public CrashlyticsReport.Session.Event.Application.Builder toBuilder() {
        return new Builder(this);
    }

    public String toString() {
        return "Application{execution=" + this.execution + ", customAttributes=" + this.customAttributes + ", internalKeys=" + this.internalKeys + ", background=" + this.background + ", uiOrientation=" + this.uiOrientation + "}";
    }

    private AutoValue_CrashlyticsReport_Session_Event_Application(CrashlyticsReport.Session.Event.Application.Execution execution2, @Nullable ImmutableList<CrashlyticsReport.CustomAttribute> immutableList, @Nullable ImmutableList<CrashlyticsReport.CustomAttribute> immutableList2, @Nullable Boolean bool, int i11) {
        this.execution = execution2;
        this.customAttributes = immutableList;
        this.internalKeys = immutableList2;
        this.background = bool;
        this.uiOrientation = i11;
    }
}
