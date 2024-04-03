package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import com.google.firebase.auth.internal.zzai;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxt  reason: invalid package */
final class zzxt implements zzabu {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzaan zzc;
    final /* synthetic */ zzyp zzd;

    public zzxt(zzyp zzyp, String str, String str2, zzaan zzaan) {
        this.zzd = zzyp;
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzaan;
    }

    public final void zza(@Nullable String str) {
        this.zzc.zzh(zzai.zza(str));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        this.zzd.zza.zzw(new zzafb(((zzadr) obj).zze(), this.zza, this.zzb), new zzxs(this));
    }
}
