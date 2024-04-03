package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import com.google.firebase.auth.internal.zzai;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxp  reason: invalid package */
final class zzxp implements zzabu {
    final /* synthetic */ zzaan zza;
    final /* synthetic */ zzyp zzb;

    public zzxp(zzyp zzyp, zzaan zzaan) {
        this.zzb = zzyp;
        this.zza = zzaan;
    }

    public final void zza(@Nullable String str) {
        this.zza.zzh(zzai.zza(str));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzadr zzadr = (zzadr) obj;
        zzaed zzaed = new zzaed();
        zzaed.zze(zzadr.zze());
        zzaed.zzd((String) null);
        zzaed.zzg((String) null);
        zzyp.zze(this.zzb, this.zza, zzadr, zzaed, this);
    }
}
