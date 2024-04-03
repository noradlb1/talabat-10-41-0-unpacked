package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

final class zzgad extends zzfyg<zzggh, zzgge> {
    final /* synthetic */ zzgae zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzgad(zzgae zzgae, Class cls) {
        super(cls);
        this.zza = zzgae;
    }

    public final /* synthetic */ zzglv zza(zzgjf zzgjf) throws zzgkx {
        return zzggh.zze(zzgjf, zzgjx.zza());
    }

    public final /* bridge */ /* synthetic */ Object zzc(zzglv zzglv) throws GeneralSecurityException {
        zzggd zzc = zzgge.zzc();
        zzc.zza((zzggh) zzglv);
        zzc.zzb(0);
        return (zzgge) zzc.zzah();
    }

    public final /* bridge */ /* synthetic */ void zze(zzglv zzglv) throws GeneralSecurityException {
        zzggh zzggh = (zzggh) zzglv;
        if (zzggh.zzf().isEmpty() || !zzggh.zzg()) {
            throw new GeneralSecurityException("invalid key format: missing KEK URI or DEK template");
        }
    }
}
