package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import com.google.firebase.auth.internal.zzai;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxo  reason: invalid package */
final class zzxo implements zzabu {
    final /* synthetic */ zzaes zza;
    final /* synthetic */ zzaan zzb;
    final /* synthetic */ zzyp zzc;

    public zzxo(zzyp zzyp, zzaes zzaes, zzaan zzaan) {
        this.zzc = zzyp;
        this.zza = zzaes;
        this.zzb = zzaan;
    }

    public final void zza(@Nullable String str) {
        this.zzb.zzh(zzai.zza(str));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        this.zza.zzd(true);
        this.zza.zzc(((zzadr) obj).zze());
        this.zzc.zza.zzs(this.zza, new zzxn(this, this));
    }
}
