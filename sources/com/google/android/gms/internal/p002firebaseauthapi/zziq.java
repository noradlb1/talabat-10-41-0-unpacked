package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zziq  reason: invalid package */
final class zziq implements zzbl {
    final zzcl zza;
    private final zzoi zzb;

    public zziq(zzcl zzcl) {
        zzoi zzoi;
        this.zza = zzcl;
        if (zzcl.zzf()) {
            zzoi = zzku.zza().zzb().zza(zzkr.zza(zzcl), "hybrid_encrypt", "encrypt");
        } else {
            zzoi = zzkr.zza;
        }
        this.zzb = zzoi;
    }
}
