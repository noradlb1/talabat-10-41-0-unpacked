package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import com.google.firebase.auth.internal.zzai;
import com.google.firebase.auth.zze;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxv  reason: invalid package */
final class zzxv implements zzabu {
    final /* synthetic */ zzaan zza;
    final /* synthetic */ zzyp zzb;

    public zzxv(zzyp zzyp, zzaan zzaan) {
        this.zzb = zzyp;
        this.zza = zzaan;
    }

    public final void zza(@Nullable String str) {
        this.zza.zzh(zzai.zza(str));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzaew zzaew = (zzaew) obj;
        this.zzb.zzQ(new zzadr(zzaew.zzd(), zzaew.zzc(), Long.valueOf(zzaew.zzb()), "Bearer"), (String) null, (String) null, Boolean.valueOf(zzaew.zze()), (zze) null, this.zza, this);
    }
}
