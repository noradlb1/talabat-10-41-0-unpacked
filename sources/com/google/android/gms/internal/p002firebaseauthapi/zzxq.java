package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import com.google.firebase.auth.internal.zzai;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxq  reason: invalid package */
final class zzxq implements zzabu {
    final /* synthetic */ zzabu zza;
    final /* synthetic */ zzadr zzb;
    final /* synthetic */ zzxr zzc;

    public zzxq(zzxr zzxr, zzabu zzabu, zzadr zzadr) {
        this.zzc = zzxr;
        this.zza = zzabu;
        this.zzb = zzadr;
    }

    public final void zza(@Nullable String str) {
        this.zzc.zzb.zzh(zzai.zza(str));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        List zzb2 = ((zzadh) obj).zzb();
        if (zzb2 == null || zzb2.isEmpty()) {
            this.zza.zza("No users.");
            return;
        }
        zzaed zzaed = new zzaed();
        zzaed.zze(this.zzb.zze());
        zzaed.zzb(this.zzc.zza);
        zzxr zzxr = this.zzc;
        zzyp.zzf(zzxr.zzc, zzxr.zzb, this.zzb, (zzadi) zzb2.get(0), zzaed, this.zza);
    }
}
