package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import com.google.firebase.auth.internal.zzai;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzym  reason: invalid package */
final class zzym implements zzabu {
    final /* synthetic */ String zza;
    final /* synthetic */ zzaan zzb;
    final /* synthetic */ zzyp zzc;

    public zzym(zzyp zzyp, String str, zzaan zzaan) {
        this.zzc = zzyp;
        this.zza = str;
        this.zzb = zzaan;
    }

    public final void zza(@Nullable String str) {
        this.zzb.zzh(zzai.zza(str));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzadr zzadr = (zzadr) obj;
        String zze = zzadr.zze();
        zzaed zzaed = new zzaed();
        zzaed.zze(zze);
        zzaed.zzg(this.zza);
        zzyp.zze(this.zzc, this.zzb, zzadr, zzaed, this);
    }
}
