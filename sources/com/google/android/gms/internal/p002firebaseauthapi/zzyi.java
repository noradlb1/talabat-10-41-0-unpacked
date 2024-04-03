package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import com.google.firebase.auth.internal.zzai;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyi  reason: invalid package */
final class zzyi implements zzabu {
    final /* synthetic */ zzaan zza;
    final /* synthetic */ zzyp zzb;

    public zzyi(zzyp zzyp, zzaan zzaan) {
        this.zzb = zzyp;
        this.zza = zzaan;
    }

    public final void zza(@Nullable String str) {
        this.zza.zzh(zzai.zza(str));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzaeu zzaeu = (zzaeu) obj;
        if (!zzaeu.zzm()) {
            zzyp.zzd(this.zzb, zzaeu, this.zza, this);
        } else {
            this.zza.zzf(new zzwv(zzaeu.zzg(), zzaeu.zzl(), zzaeu.zzc()));
        }
    }
}
