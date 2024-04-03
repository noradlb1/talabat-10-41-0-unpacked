package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import com.google.firebase.auth.internal.zzai;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyf  reason: invalid package */
final class zzyf implements zzabu {
    final /* synthetic */ zzaan zza;
    final /* synthetic */ zzyp zzb;

    public zzyf(zzyp zzyp, zzaan zzaan) {
        this.zzb = zzyp;
        this.zza = zzaan;
    }

    public final void zza(@Nullable String str) {
        this.zza.zzh(zzai.zza(str));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        this.zzb.zza.zzb(new zzact(((zzadr) obj).zze()), new zzye(this, this));
    }
}
