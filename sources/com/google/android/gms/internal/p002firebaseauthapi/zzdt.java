package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdt  reason: invalid package */
final class zzdt extends zzkk {
    final /* synthetic */ zzdu zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzdt(zzdu zzdu, Class cls) {
        super(cls);
        this.zza = zzdu;
    }

    public static final zzph zzf(zzpk zzpk) throws GeneralSecurityException {
        zzpg zzb = zzph.zzb();
        zzb.zzb(zzpk.zzf());
        byte[] zza2 = zzwa.zza(zzpk.zza());
        zzb.zza(zzafv.zzn(zza2, 0, zza2.length));
        zzb.zzc(0);
        return (zzph) zzb.zzi();
    }

    public final /* bridge */ /* synthetic */ zzaif zza(zzaif zzaif) throws GeneralSecurityException {
        return zzf((zzpk) zzaif);
    }

    public final /* synthetic */ zzaif zzb(zzafv zzafv) throws zzahi {
        return zzpk.zze(zzafv, zzagn.zza());
    }

    /* renamed from: zze */
    public final void zzd(zzpk zzpk) throws GeneralSecurityException {
        zzwc.zzb(zzpk.zza());
        zzdu.zzi(zzpk.zzf());
    }
}
