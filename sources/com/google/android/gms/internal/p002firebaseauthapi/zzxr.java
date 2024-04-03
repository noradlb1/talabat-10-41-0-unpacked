package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import com.google.firebase.auth.internal.zzai;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxr  reason: invalid package */
final class zzxr implements zzabu {
    final /* synthetic */ String zza;
    final /* synthetic */ zzaan zzb;
    final /* synthetic */ zzyp zzc;

    public zzxr(zzyp zzyp, String str, zzaan zzaan) {
        this.zzc = zzyp;
        this.zza = str;
        this.zzb = zzaan;
    }

    public final void zza(@Nullable String str) {
        this.zzb.zzh(zzai.zza(str));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzadr zzadr = (zzadr) obj;
        this.zzc.zza.zzg(new zzadg(zzadr.zze()), new zzxq(this, this, zzadr));
    }
}
