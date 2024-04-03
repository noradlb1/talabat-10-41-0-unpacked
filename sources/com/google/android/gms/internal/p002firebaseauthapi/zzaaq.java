package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaaq  reason: invalid package */
public final class zzaaq {
    @Nullable
    private String zza;
    @Nullable
    private String zzb;

    private zzaaq() {
    }

    public static zzaaq zza(String str) {
        zzaaq zzaaq = new zzaaq();
        zzaaq.zza = str;
        return zzaaq;
    }

    public static zzaaq zzb(String str) {
        zzaaq zzaaq = new zzaaq();
        zzaaq.zzb = str;
        return zzaaq;
    }

    @Nullable
    public final String zzc() {
        return this.zza;
    }

    @Nullable
    public final String zzd() {
        return this.zzb;
    }
}
