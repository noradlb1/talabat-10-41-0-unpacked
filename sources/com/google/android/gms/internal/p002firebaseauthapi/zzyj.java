package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import com.google.firebase.auth.internal.zzai;
import com.google.firebase.auth.zze;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyj  reason: invalid package */
final class zzyj implements zzabu {
    final /* synthetic */ zzaan zza;
    final /* synthetic */ zzyp zzb;

    public zzyj(zzyp zzyp, zzaan zzaan) {
        this.zzb = zzyp;
        this.zza = zzaan;
    }

    public final void zza(@Nullable String str) {
        this.zza.zzh(zzai.zza(str));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzaeg zzaeg = (zzaeg) obj;
        this.zzb.zzQ(new zzadr(zzaeg.zzd(), zzaeg.zzc(), Long.valueOf(zzaeg.zzb()), "Bearer"), (String) null, (String) null, Boolean.TRUE, (zze) null, this.zza, this);
    }
}
