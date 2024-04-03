package com.uxcam.datamodel;

import com.uxcam.internals.hm;
import java.util.ArrayList;
import java.util.List;

public class UXConfig {

    /* renamed from: a  reason: collision with root package name */
    public final List f12941a;

    /* renamed from: b  reason: collision with root package name */
    public String f12942b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f12943c;

    /* renamed from: d  reason: collision with root package name */
    public MultiSessionRecordStatus f12944d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f12945e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f12946f;

    public static class Builder {
        /* access modifiers changed from: private */
        public final String appKey;
        /* access modifiers changed from: private */
        public boolean isAutomaticScreenNameTaggingEnabled = true;
        /* access modifiers changed from: private */
        public boolean isCrashHandlingEnabled = true;
        /* access modifiers changed from: private */
        public boolean isImprovedScreenCaptureEnabled = false;
        /* access modifiers changed from: private */
        public MultiSessionRecordStatus multiSessionRecordStatus = MultiSessionRecordStatus.ENABLED;
        /* access modifiers changed from: private */
        public List occlusions = new ArrayList();

        public Builder(String str) {
            this.appKey = str;
            if (hm.a()) {
                UXConfig e11 = hm.e();
                this.isAutomaticScreenNameTaggingEnabled = e11.f12943c;
                this.multiSessionRecordStatus = e11.f12944d;
                this.isCrashHandlingEnabled = e11.f12945e;
                this.isImprovedScreenCaptureEnabled = e11.f12946f;
            }
        }

        public UXConfig build() {
            return new UXConfig(this);
        }

        public Builder enableAutomaticScreenNameTagging(boolean z11) {
            this.isAutomaticScreenNameTaggingEnabled = z11;
            return this;
        }

        public Builder enableCrashHandling(boolean z11) {
            this.isCrashHandlingEnabled = z11;
            return this;
        }

        public Builder enableImprovedScreenCapture(boolean z11) {
            this.isImprovedScreenCaptureEnabled = z11;
            return this;
        }

        public Builder enableMultiSessionRecord(boolean z11) {
            this.multiSessionRecordStatus = z11 ? MultiSessionRecordStatus.ENABLED : MultiSessionRecordStatus.DISABLED_BUT_NOT_STARTED;
            return this;
        }

        public Builder occlusions(List list) {
            this.occlusions = list;
            return this;
        }
    }

    public enum MultiSessionRecordStatus {
        ENABLED,
        DISABLED_BUT_NOT_STARTED,
        DISABLED
    }

    public UXConfig(Builder builder) {
        this.f12942b = builder.appKey;
        this.f12943c = builder.isAutomaticScreenNameTaggingEnabled;
        this.f12944d = builder.multiSessionRecordStatus;
        this.f12945e = builder.isCrashHandlingEnabled;
        this.f12946f = builder.isImprovedScreenCaptureEnabled;
        this.f12941a = builder.occlusions;
    }

    public void e(UXConfig uXConfig) {
        this.f12942b = uXConfig.f12942b;
        this.f12943c = uXConfig.f12943c;
        this.f12944d = uXConfig.f12944d;
        this.f12945e = uXConfig.f12945e;
        this.f12946f = uXConfig.f12946f;
    }
}
