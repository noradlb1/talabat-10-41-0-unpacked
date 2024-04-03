package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzik  reason: invalid package */
public final class zzik extends zzls {
    /* access modifiers changed from: private */
    public static final byte[] zza = new byte[0];

    public zzik() {
        super(zzri.class, zzrl.class, new zzii(zzbk.class));
    }

    public static /* bridge */ /* synthetic */ zzkj zzi(int i11, int i12, int i13, zzbu zzbu, byte[] bArr, int i14) {
        zzrb zza2 = zzrc.zza();
        zzrn zza3 = zzro.zza();
        zza3.zzb(4);
        zza3.zzc(5);
        zza3.zza(zzafv.zzn(bArr, 0, 0));
        zzqy zza4 = zzqz.zza();
        zza4.zza((zztc) zzmf.zza(new zzih(zzbu)));
        zzre zzb = zzrf.zzb();
        zzb.zzb((zzro) zza3.zzi());
        zzb.zza((zzqz) zza4.zzi());
        zzb.zzc(i13);
        zza2.zza((zzrf) zzb.zzi());
        return new zzkj((zzrc) zza2.zzi(), i14);
    }

    public final zzkk zza() {
        return new zzij(this, zzrc.class);
    }

    public final zzsw zzb() {
        return zzsw.ASYMMETRIC_PRIVATE;
    }

    public final /* synthetic */ zzaif zzc(zzafv zzafv) throws zzahi {
        return zzri.zzd(zzafv, zzagn.zza());
    }

    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey";
    }

    public final /* bridge */ /* synthetic */ void zze(zzaif zzaif) throws GeneralSecurityException {
        zzri zzri = (zzri) zzaif;
        if (!zzri.zzf().zzp()) {
            zzwc.zzc(zzri.zza(), 0);
            zzit.zza(zzri.zze().zzb());
            return;
        }
        throw new GeneralSecurityException("invalid ECIES private key");
    }

    public final /* synthetic */ zzaif zzg(zzaif zzaif) throws GeneralSecurityException {
        return ((zzri) zzaif).zze();
    }
}
