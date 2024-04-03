package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

final class AutoValue_CrashlyticsReport_ApplicationExitInfo extends CrashlyticsReport.ApplicationExitInfo {
    private final ImmutableList<CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch> buildIdMappingForArch;
    private final int importance;
    private final int pid;
    private final String processName;
    private final long pss;
    private final int reasonCode;
    private final long rss;
    private final long timestamp;
    private final String traceFile;

    public static final class Builder extends CrashlyticsReport.ApplicationExitInfo.Builder {
        private ImmutableList<CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch> buildIdMappingForArch;
        private Integer importance;
        private Integer pid;
        private String processName;
        private Long pss;
        private Integer reasonCode;
        private Long rss;
        private Long timestamp;
        private String traceFile;

        public CrashlyticsReport.ApplicationExitInfo build() {
            String str = "";
            if (this.pid == null) {
                str = str + " pid";
            }
            if (this.processName == null) {
                str = str + " processName";
            }
            if (this.reasonCode == null) {
                str = str + " reasonCode";
            }
            if (this.importance == null) {
                str = str + " importance";
            }
            if (this.pss == null) {
                str = str + " pss";
            }
            if (this.rss == null) {
                str = str + " rss";
            }
            if (this.timestamp == null) {
                str = str + " timestamp";
            }
            if (str.isEmpty()) {
                return new AutoValue_CrashlyticsReport_ApplicationExitInfo(this.pid.intValue(), this.processName, this.reasonCode.intValue(), this.importance.intValue(), this.pss.longValue(), this.rss.longValue(), this.timestamp.longValue(), this.traceFile, this.buildIdMappingForArch);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public CrashlyticsReport.ApplicationExitInfo.Builder setBuildIdMappingForArch(@Nullable ImmutableList<CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch> immutableList) {
            this.buildIdMappingForArch = immutableList;
            return this;
        }

        public CrashlyticsReport.ApplicationExitInfo.Builder setImportance(int i11) {
            this.importance = Integer.valueOf(i11);
            return this;
        }

        public CrashlyticsReport.ApplicationExitInfo.Builder setPid(int i11) {
            this.pid = Integer.valueOf(i11);
            return this;
        }

        public CrashlyticsReport.ApplicationExitInfo.Builder setProcessName(String str) {
            if (str != null) {
                this.processName = str;
                return this;
            }
            throw new NullPointerException("Null processName");
        }

        public CrashlyticsReport.ApplicationExitInfo.Builder setPss(long j11) {
            this.pss = Long.valueOf(j11);
            return this;
        }

        public CrashlyticsReport.ApplicationExitInfo.Builder setReasonCode(int i11) {
            this.reasonCode = Integer.valueOf(i11);
            return this;
        }

        public CrashlyticsReport.ApplicationExitInfo.Builder setRss(long j11) {
            this.rss = Long.valueOf(j11);
            return this;
        }

        public CrashlyticsReport.ApplicationExitInfo.Builder setTimestamp(long j11) {
            this.timestamp = Long.valueOf(j11);
            return this;
        }

        public CrashlyticsReport.ApplicationExitInfo.Builder setTraceFile(@Nullable String str) {
            this.traceFile = str;
            return this;
        }
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.ApplicationExitInfo)) {
            return false;
        }
        CrashlyticsReport.ApplicationExitInfo applicationExitInfo = (CrashlyticsReport.ApplicationExitInfo) obj;
        if (this.pid == applicationExitInfo.getPid() && this.processName.equals(applicationExitInfo.getProcessName()) && this.reasonCode == applicationExitInfo.getReasonCode() && this.importance == applicationExitInfo.getImportance() && this.pss == applicationExitInfo.getPss() && this.rss == applicationExitInfo.getRss() && this.timestamp == applicationExitInfo.getTimestamp() && ((str = this.traceFile) != null ? str.equals(applicationExitInfo.getTraceFile()) : applicationExitInfo.getTraceFile() == null)) {
            ImmutableList<CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch> immutableList = this.buildIdMappingForArch;
            if (immutableList == null) {
                if (applicationExitInfo.getBuildIdMappingForArch() == null) {
                    return true;
                }
            } else if (immutableList.equals(applicationExitInfo.getBuildIdMappingForArch())) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public ImmutableList<CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch> getBuildIdMappingForArch() {
        return this.buildIdMappingForArch;
    }

    @NonNull
    public int getImportance() {
        return this.importance;
    }

    @NonNull
    public int getPid() {
        return this.pid;
    }

    @NonNull
    public String getProcessName() {
        return this.processName;
    }

    @NonNull
    public long getPss() {
        return this.pss;
    }

    @NonNull
    public int getReasonCode() {
        return this.reasonCode;
    }

    @NonNull
    public long getRss() {
        return this.rss;
    }

    @NonNull
    public long getTimestamp() {
        return this.timestamp;
    }

    @Nullable
    public String getTraceFile() {
        return this.traceFile;
    }

    public int hashCode() {
        int i11;
        long j11 = this.pss;
        long j12 = this.rss;
        long j13 = this.timestamp;
        int hashCode = (((((((((((((this.pid ^ 1000003) * 1000003) ^ this.processName.hashCode()) * 1000003) ^ this.reasonCode) * 1000003) ^ this.importance) * 1000003) ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003) ^ ((int) (j12 ^ (j12 >>> 32)))) * 1000003) ^ ((int) (j13 ^ (j13 >>> 32)))) * 1000003;
        String str = this.traceFile;
        int i12 = 0;
        if (str == null) {
            i11 = 0;
        } else {
            i11 = str.hashCode();
        }
        int i13 = (hashCode ^ i11) * 1000003;
        ImmutableList<CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch> immutableList = this.buildIdMappingForArch;
        if (immutableList != null) {
            i12 = immutableList.hashCode();
        }
        return i13 ^ i12;
    }

    public String toString() {
        return "ApplicationExitInfo{pid=" + this.pid + ", processName=" + this.processName + ", reasonCode=" + this.reasonCode + ", importance=" + this.importance + ", pss=" + this.pss + ", rss=" + this.rss + ", timestamp=" + this.timestamp + ", traceFile=" + this.traceFile + ", buildIdMappingForArch=" + this.buildIdMappingForArch + "}";
    }

    private AutoValue_CrashlyticsReport_ApplicationExitInfo(int i11, String str, int i12, int i13, long j11, long j12, long j13, @Nullable String str2, @Nullable ImmutableList<CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch> immutableList) {
        this.pid = i11;
        this.processName = str;
        this.reasonCode = i12;
        this.importance = i13;
        this.pss = j11;
        this.rss = j12;
        this.timestamp = j13;
        this.traceFile = str2;
        this.buildIdMappingForArch = immutableList;
    }
}
