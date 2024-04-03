package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyc  reason: invalid package */
final class zzyc implements zzabu {
    final /* synthetic */ zzabu zza;
    final /* synthetic */ zzadr zzb;
    final /* synthetic */ zzyd zzc;

    public zzyc(zzyd zzyd, zzabu zzabu, zzadr zzadr) {
        this.zzc = zzyd;
        this.zza = zzabu;
        this.zzb = zzadr;
    }

    public final void zza(@Nullable String str) {
        this.zza.zza(str);
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        List zzb2 = ((zzadh) obj).zzb();
        if (zzb2 == null || zzb2.isEmpty()) {
            this.zza.zza("No users");
        } else {
            this.zzc.zza.zzk(this.zzb, (zzadi) zzb2.get(0));
        }
    }
}
