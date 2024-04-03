package com.google.android.ump;

import android.content.Context;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.consent_sdk.zzbz;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

public class ConsentDebugSettings {
    private final boolean zza;
    private final int zzb;

    public static class Builder {
        private final List<String> zza = new ArrayList();
        private final Context zzb;
        /* access modifiers changed from: private */
        public int zzc = 0;
        private boolean zzd;

        public Builder(Context context) {
            this.zzb = context.getApplicationContext();
        }

        public Builder addTestDeviceHashedId(String str) {
            this.zza.add(str);
            return this;
        }

        public ConsentDebugSettings build() {
            boolean z11;
            Context context = this.zzb;
            List<String> list = this.zza;
            boolean z12 = false;
            if (zzbz.zza() || list.contains(zzbz.zza(context))) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11 || this.zzd) {
                z12 = true;
            }
            return new ConsentDebugSettings(z12, this);
        }

        public Builder setDebugGeography(int i11) {
            this.zzc = i11;
            return this;
        }

        @KeepForSdk
        public Builder setForceTesting(boolean z11) {
            this.zzd = z11;
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface DebugGeography {
        public static final int DEBUG_GEOGRAPHY_DISABLED = 0;
        public static final int DEBUG_GEOGRAPHY_EEA = 1;
        public static final int DEBUG_GEOGRAPHY_NOT_EEA = 2;
    }

    private ConsentDebugSettings(boolean z11, Builder builder) {
        this.zza = z11;
        this.zzb = builder.zzc;
    }

    public int getDebugGeography() {
        return this.zzb;
    }

    public boolean isTestDevice() {
        return this.zza;
    }
}
