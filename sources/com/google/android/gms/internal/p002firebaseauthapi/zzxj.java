package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import com.google.firebase.auth.internal.zzai;
import com.google.firebase.auth.zze;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxj  reason: invalid package */
final class zzxj implements zzabu {
    final /* synthetic */ zzaan zza;
    final /* synthetic */ zzyp zzb;

    public zzxj(zzyp zzyp, zzaan zzaan) {
        this.zzb = zzyp;
        this.zza = zzaan;
    }

    public final void zza(@Nullable String str) {
        this.zza.zzh(zzai.zza(str));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzafa zzafa = (zzafa) obj;
        this.zzb.zzQ(new zzadr(zzafa.zze(), zzafa.zzc(), Long.valueOf(zzafa.zzb()), "Bearer"), (String) null, (String) null, Boolean.valueOf(zzafa.zzg()), (zze) null, this.zza, this);
    }
}
