package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjh  reason: invalid package */
public final class zzjh extends zzls {
    public zzjh() {
        super(zzsp.class, zzss.class, new zzjf(zzbk.class));
    }

    public static /* bridge */ /* synthetic */ zzkj zzh(int i11, int i12, int i13, int i14) {
        zzsl zza = zzsm.zza();
        zza.zzc(i11);
        zza.zzb(i12);
        zza.zza(i13);
        zzsi zza2 = zzsj.zza();
        zza2.zza((zzsm) zza.zzi());
        return new zzkj((zzsj) zza2.zzi(), i14);
    }

    public final zzkk zza() {
        return new zzjg(this, zzsj.class);
    }

    public final zzsw zzb() {
        return zzsw.ASYMMETRIC_PRIVATE;
    }

    public final /* synthetic */ zzaif zzc(zzafv zzafv) throws zzahi {
        return zzsp.zzd(zzafv, zzagn.zza());
    }

    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.HpkePrivateKey";
    }

    public final /* bridge */ /* synthetic */ void zze(zzaif zzaif) throws GeneralSecurityException {
        zzsp zzsp = (zzsp) zzaif;
        if (zzsp.zzf().zzp()) {
            throw new GeneralSecurityException("Private key is empty.");
        } else if (zzsp.zzk()) {
            zzwc.zzc(zzsp.zza(), 0);
            zzjk.zza(zzsp.zze().zzb());
        } else {
            throw new GeneralSecurityException("Missing public key.");
        }
    }

    public final /* synthetic */ zzaif zzg(zzaif zzaif) throws GeneralSecurityException {
        return ((zzsp) zzaif).zze();
    }
}
