package com.google.android.ump;

import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;

public class ConsentRequestParameters {
    private final boolean zza;
    private final int zzb;
    @Nullable
    private final String zzc;
    @Nullable
    private final String zzd;
    @Nullable
    private final String zze;
    @Nullable
    private final ConsentDebugSettings zzf;

    public static final class Builder {
        /* access modifiers changed from: private */
        public boolean zza;
        private int zzb = 0;
        /* access modifiers changed from: private */
        @Nullable
        public String zzc;
        /* access modifiers changed from: private */
        @Nullable
        public ConsentDebugSettings zzd;

        public final ConsentRequestParameters build() {
            return new ConsentRequestParameters(this);
        }

        @KeepForSdk
        public final Builder setAdMobAppId(@Nullable String str) {
            this.zzc = str;
            return this;
        }

        public final Builder setConsentDebugSettings(@Nullable ConsentDebugSettings consentDebugSettings) {
            this.zzd = consentDebugSettings;
            return this;
        }

        public final Builder setTagForUnderAgeOfConsent(boolean z11) {
            this.zza = z11;
            return this;
        }
    }

    private ConsentRequestParameters(Builder builder) {
        this.zza = builder.zza;
        this.zzc = null;
        this.zzb = 0;
        this.zzd = null;
        this.zze = builder.zzc;
        this.zzf = builder.zzd;
    }

    @Nullable
    public ConsentDebugSettings getConsentDebugSettings() {
        return this.zzf;
    }

    public boolean isTagForUnderAgeOfConsent() {
        return this.zza;
    }

    @Nullable
    public final String zza() {
        return this.zze;
    }
}
