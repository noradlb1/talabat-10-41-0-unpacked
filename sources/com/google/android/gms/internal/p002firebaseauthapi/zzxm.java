package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import com.google.firebase.auth.internal.zzai;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxm  reason: invalid package */
final class zzxm implements zzabu {
    final /* synthetic */ zzaez zza;
    final /* synthetic */ zzaan zzb;
    final /* synthetic */ zzyp zzc;

    public zzxm(zzyp zzyp, zzaez zzaez, zzaan zzaan) {
        this.zzc = zzyp;
        this.zza = zzaez;
        this.zzb = zzaan;
    }

    public final void zza(@Nullable String str) {
        this.zzb.zzh(zzai.zza(str));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        this.zza.zzd(((zzadr) obj).zze());
        this.zzc.zza.zzv(this.zza, new zzxl(this, this));
    }
}
