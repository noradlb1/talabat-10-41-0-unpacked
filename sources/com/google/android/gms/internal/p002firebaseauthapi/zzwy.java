package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.internal.zzai;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwy  reason: invalid package */
final class zzwy implements zzabu {
    final /* synthetic */ EmailAuthCredential zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzaan zzc;
    final /* synthetic */ zzyp zzd;

    public zzwy(zzyp zzyp, EmailAuthCredential emailAuthCredential, String str, zzaan zzaan) {
        this.zzd = zzyp;
        this.zza = emailAuthCredential;
        this.zzb = str;
        this.zzc = zzaan;
    }

    public final void zza(@Nullable String str) {
        this.zzc.zzh(zzai.zza(str));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        this.zzd.zzP(new zzacu(this.zza, ((zzadr) obj).zze(), this.zzb), this.zzc);
    }
}
