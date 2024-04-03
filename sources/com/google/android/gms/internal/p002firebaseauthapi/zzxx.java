package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import com.google.firebase.auth.internal.zzai;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxx  reason: invalid package */
final class zzxx implements zzabu {
    final /* synthetic */ zzacw zza;
    final /* synthetic */ zzaan zzb;
    final /* synthetic */ zzyp zzc;

    public zzxx(zzyp zzyp, zzacw zzacw, zzaan zzaan) {
        this.zzc = zzyp;
        this.zza = zzacw;
        this.zzb = zzaan;
    }

    public final void zza(@Nullable String str) {
        this.zzb.zzh(zzai.zza(str));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        this.zza.zzb(((zzadr) obj).zze());
        this.zzc.zza.zzd(this.zza, new zzxw(this));
    }
}
