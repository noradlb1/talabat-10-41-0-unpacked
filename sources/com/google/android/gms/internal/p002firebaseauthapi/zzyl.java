package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import com.google.firebase.auth.internal.zzai;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyl  reason: invalid package */
final class zzyl implements zzabu {
    final /* synthetic */ String zza;
    final /* synthetic */ zzaan zzb;
    final /* synthetic */ zzyp zzc;

    public zzyl(zzyp zzyp, String str, zzaan zzaan) {
        this.zzc = zzyp;
        this.zza = str;
        this.zzb = zzaan;
    }

    public final void zza(@Nullable String str) {
        this.zzb.zzh(zzai.zza(str));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzadr zzadr = (zzadr) obj;
        zzaed zzaed = new zzaed();
        zzaed.zze(zzadr.zze());
        zzaed.zzd(this.zza);
        zzyp.zze(this.zzc, this.zzb, zzadr, zzaed, this);
    }
}
