package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import com.google.firebase.auth.internal.zzai;
import com.google.firebase.auth.zze;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxy  reason: invalid package */
final class zzxy implements zzabu {
    final /* synthetic */ zzaan zza;
    final /* synthetic */ zzyp zzb;

    public zzxy(zzyp zzyp, zzaan zzaan) {
        this.zzb = zzyp;
        this.zza = zzaan;
    }

    public final void zza(@Nullable String str) {
        this.zza.zzh(zzai.zza(str));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzacz zzacz = (zzacz) obj;
        this.zzb.zzQ(new zzadr(zzacz.zzc(), zzacz.zzb(), Long.valueOf(zzadt.zza(zzacz.zzb())), "Bearer"), (String) null, (String) null, Boolean.FALSE, (zze) null, this.zza, this);
    }
}
