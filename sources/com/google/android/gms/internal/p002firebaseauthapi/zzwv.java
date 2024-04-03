package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.auth.internal.zzbc;
import com.google.firebase.auth.zze;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwv  reason: invalid package */
public final class zzwv {
    @SafeParcelable.Field(getter = "getMfaPendingCredential", id = 1)
    final String zza;
    @SafeParcelable.Field(getter = "getMfaInfoList", id = 2)
    final List zzb;
    @SafeParcelable.Field(getter = "getDefaultOAuthCredential", id = 3)
    final zze zzc;

    @SafeParcelable.Constructor
    public zzwv(String str, List list, @Nullable zze zze) {
        this.zza = str;
        this.zzb = list;
        this.zzc = zze;
    }

    public final zze zza() {
        return this.zzc;
    }

    public final String zzb() {
        return this.zza;
    }

    public final List zzc() {
        return zzbc.zzb(this.zzb);
    }
}
