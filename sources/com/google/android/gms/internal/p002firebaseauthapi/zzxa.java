package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxa  reason: invalid package */
final class zzxa implements zzabu {
    final /* synthetic */ zzabt zza;
    final /* synthetic */ zzaan zzb;
    final /* synthetic */ zzadr zzc;
    final /* synthetic */ zzaed zzd;
    final /* synthetic */ zzyp zze;

    public zzxa(zzyp zzyp, zzabt zzabt, zzaan zzaan, zzadr zzadr, zzaed zzaed) {
        this.zze = zzyp;
        this.zza = zzabt;
        this.zzb = zzaan;
        this.zzc = zzadr;
        this.zzd = zzaed;
    }

    public final void zza(@Nullable String str) {
        this.zza.zza(str);
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        List zzb2 = ((zzadh) obj).zzb();
        if (zzb2 == null || zzb2.isEmpty()) {
            this.zza.zza("No users");
        } else {
            zzyp.zzf(this.zze, this.zzb, this.zzc, (zzadi) zzb2.get(0), this.zzd, this.zza);
        }
    }
}
