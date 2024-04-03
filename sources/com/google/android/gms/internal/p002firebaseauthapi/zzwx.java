package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import com.google.firebase.auth.internal.zzai;
import com.google.firebase.auth.zze;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwx  reason: invalid package */
final class zzwx implements zzabu {
    final /* synthetic */ zzaan zza;
    final /* synthetic */ zzyp zzb;

    public zzwx(zzyp zzyp, zzaan zzaan) {
        this.zzb = zzyp;
        this.zza = zzaan;
    }

    public final void zza(@Nullable String str) {
        this.zza.zzh(zzai.zza(str));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzaey zzaey = (zzaey) obj;
        if (zzaey.zzg()) {
            this.zza.zzf(new zzwv(zzaey.zzd(), zzaey.zzf(), (zze) null));
            return;
        }
        this.zzb.zzQ(new zzadr(zzaey.zze(), zzaey.zzc(), Long.valueOf(zzaey.zzb()), "Bearer"), (String) null, (String) null, Boolean.FALSE, (zze) null, this.zza, this);
    }
}
