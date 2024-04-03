package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

final class AutoValue_CrashlyticsReport_FilesPayload extends CrashlyticsReport.FilesPayload {
    private final ImmutableList<CrashlyticsReport.FilesPayload.File> files;
    private final String orgId;

    public static final class Builder extends CrashlyticsReport.FilesPayload.Builder {
        private ImmutableList<CrashlyticsReport.FilesPayload.File> files;
        private String orgId;

        public CrashlyticsReport.FilesPayload build() {
            String str = "";
            if (this.files == null) {
                str = str + " files";
            }
            if (str.isEmpty()) {
                return new AutoValue_CrashlyticsReport_FilesPayload(this.files, this.orgId);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public CrashlyticsReport.FilesPayload.Builder setFiles(ImmutableList<CrashlyticsReport.FilesPayload.File> immutableList) {
            if (immutableList != null) {
                this.files = immutableList;
                return this;
            }
            throw new NullPointerException("Null files");
        }

        public CrashlyticsReport.FilesPayload.Builder setOrgId(String str) {
            this.orgId = str;
            return this;
        }

        public Builder() {
        }

        private Builder(CrashlyticsReport.FilesPayload filesPayload) {
            this.files = filesPayload.getFiles();
            this.orgId = filesPayload.getOrgId();
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.FilesPayload)) {
            return false;
        }
        CrashlyticsReport.FilesPayload filesPayload = (CrashlyticsReport.FilesPayload) obj;
        if (this.files.equals(filesPayload.getFiles())) {
            String str = this.orgId;
            if (str == null) {
                if (filesPayload.getOrgId() == null) {
                    return true;
                }
            } else if (str.equals(filesPayload.getOrgId())) {
                return true;
            }
        }
        return false;
    }

    @NonNull
    public ImmutableList<CrashlyticsReport.FilesPayload.File> getFiles() {
        return this.files;
    }

    @Nullable
    public String getOrgId() {
        return this.orgId;
    }

    public int hashCode() {
        int i11;
        int hashCode = (this.files.hashCode() ^ 1000003) * 1000003;
        String str = this.orgId;
        if (str == null) {
            i11 = 0;
        } else {
            i11 = str.hashCode();
        }
        return hashCode ^ i11;
    }

    public CrashlyticsReport.FilesPayload.Builder toBuilder() {
        return new Builder(this);
    }

    public String toString() {
        return "FilesPayload{files=" + this.files + ", orgId=" + this.orgId + "}";
    }

    private AutoValue_CrashlyticsReport_FilesPayload(ImmutableList<CrashlyticsReport.FilesPayload.File> immutableList, @Nullable String str) {
        this.files = immutableList;
        this.orgId = str;
    }
}
