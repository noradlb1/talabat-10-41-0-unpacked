package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.auth.zze;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwu  reason: invalid package */
public final class zzwu {
    private final Status zza;
    private final zze zzb;
    private final String zzc;
    private final String zzd;

    @SafeParcelable.Constructor
    public zzwu(Status status, zze zze, String str, @Nullable String str2) {
        this.zza = status;
        this.zzb = zze;
        this.zzc = str;
        this.zzd = str2;
    }

    public final Status zza() {
        return this.zza;
    }

    public final zze zzb() {
        return this.zzb;
    }

    public final String zzc() {
        return this.zzc;
    }

    public final String zzd() {
        return this.zzd;
    }
}
