package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import com.google.firebase.auth.internal.zzai;
import com.google.firebase.auth.zze;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwz  reason: invalid package */
final class zzwz implements zzabu {
    final /* synthetic */ zzaan zza;
    final /* synthetic */ zzyp zzb;

    public zzwz(zzyp zzyp, zzaan zzaan) {
        this.zzb = zzyp;
        this.zza = zzaan;
    }

    public final void zza(@Nullable String str) {
        this.zza.zzh(zzai.zza(str));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzacv zzacv = (zzacv) obj;
        if (zzacv.zzg()) {
            this.zza.zzf(new zzwv(zzacv.zzd(), zzacv.zzf(), (zze) null));
            return;
        }
        this.zzb.zzQ(new zzadr(zzacv.zze(), zzacv.zzc(), Long.valueOf(zzacv.zzb()), "Bearer"), (String) null, (String) null, Boolean.valueOf(zzacv.zzh()), (zze) null, this.zza, this);
    }
}
