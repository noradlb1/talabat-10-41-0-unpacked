package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

final class AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame extends CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame {
    private final String file;
    private final int importance;
    private final long offset;

    /* renamed from: pc  reason: collision with root package name */
    private final long f47387pc;
    private final String symbol;

    public static final class Builder extends CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder {
        private String file;
        private Integer importance;
        private Long offset;

        /* renamed from: pc  reason: collision with root package name */
        private Long f47388pc;
        private String symbol;

        public CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame build() {
            String str = "";
            if (this.f47388pc == null) {
                str = str + " pc";
            }
            if (this.symbol == null) {
                str = str + " symbol";
            }
            if (this.offset == null) {
                str = str + " offset";
            }
            if (this.importance == null) {
                str = str + " importance";
            }
            if (str.isEmpty()) {
                return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame(this.f47388pc.longValue(), this.symbol, this.file, this.offset.longValue(), this.importance.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder setFile(String str) {
            this.file = str;
            return this;
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder setImportance(int i11) {
            this.importance = Integer.valueOf(i11);
            return this;
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder setOffset(long j11) {
            this.offset = Long.valueOf(j11);
            return this;
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder setPc(long j11) {
            this.f47388pc = Long.valueOf(j11);
            return this;
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder setSymbol(String str) {
            if (str != null) {
                this.symbol = str;
                return this;
            }
            throw new NullPointerException("Null symbol");
        }
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame)) {
            return false;
        }
        CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame frame = (CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame) obj;
        if (this.f47387pc == frame.getPc() && this.symbol.equals(frame.getSymbol()) && ((str = this.file) != null ? str.equals(frame.getFile()) : frame.getFile() == null) && this.offset == frame.getOffset() && this.importance == frame.getImportance()) {
            return true;
        }
        return false;
    }

    @Nullable
    public String getFile() {
        return this.file;
    }

    public int getImportance() {
        return this.importance;
    }

    public long getOffset() {
        return this.offset;
    }

    public long getPc() {
        return this.f47387pc;
    }

    @NonNull
    public String getSymbol() {
        return this.symbol;
    }

    public int hashCode() {
        int i11;
        long j11 = this.f47387pc;
        int hashCode = (((((int) (j11 ^ (j11 >>> 32))) ^ 1000003) * 1000003) ^ this.symbol.hashCode()) * 1000003;
        String str = this.file;
        if (str == null) {
            i11 = 0;
        } else {
            i11 = str.hashCode();
        }
        long j12 = this.offset;
        return ((((hashCode ^ i11) * 1000003) ^ ((int) ((j12 >>> 32) ^ j12))) * 1000003) ^ this.importance;
    }

    public String toString() {
        return "Frame{pc=" + this.f47387pc + ", symbol=" + this.symbol + ", file=" + this.file + ", offset=" + this.offset + ", importance=" + this.importance + "}";
    }

    private AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame(long j11, String str, @Nullable String str2, long j12, int i11) {
        this.f47387pc = j11;
        this.symbol = str;
        this.file = str2;
        this.offset = j12;
        this.importance = i11;
    }
}
