package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import com.google.firebase.auth.internal.zzai;
import com.google.firebase.auth.zze;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxw  reason: invalid package */
final class zzxw implements zzabu {
    final /* synthetic */ zzxx zza;

    public zzxw(zzxx zzxx) {
        this.zza = zzxx;
    }

    public final void zza(@Nullable String str) {
        this.zza.zzb.zzh(zzai.zza(str));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzacx zzacx = (zzacx) obj;
        zzadr zzadr = new zzadr(zzacx.zzc(), zzacx.zzb(), Long.valueOf(zzadt.zza(zzacx.zzb())), "Bearer");
        zzxx zzxx = this.zza;
        zzxx.zzc.zzQ(zzadr, (String) null, (String) null, Boolean.FALSE, (zze) null, zzxx.zzb, this);
    }
}
