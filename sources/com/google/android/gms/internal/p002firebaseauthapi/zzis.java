package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzis  reason: invalid package */
public final class zzis {
    public static final zztc zza;
    public static final zztc zzb;
    public static final zztc zzc;
    private static final byte[] zzd;

    static {
        byte[] bArr = new byte[0];
        zzd = bArr;
        zztc zztc = zzcv.zza;
        zzud zzud = zzud.TINK;
        zztc zztc2 = zztc;
        byte[] bArr2 = bArr;
        zza = zza(4, 5, 3, zztc2, zzud, bArr2);
        zzb = zza(4, 5, 4, zztc2, zzud.RAW, bArr2);
        zzc = zza(4, 5, 3, zzcv.zze, zzud, bArr2);
    }

    public static zztc zza(int i11, int i12, int i13, zztc zztc, zzud zzud, byte[] bArr) {
        zzrb zza2 = zzrc.zza();
        zzrn zza3 = zzro.zza();
        zza3.zzb(4);
        zza3.zzc(5);
        zza3.zza(zzafv.zzn(bArr, 0, 0));
        zzqy zza4 = zzqz.zza();
        zza4.zza(zztc);
        zzre zzb2 = zzrf.zzb();
        zzb2.zzb((zzro) zza3.zzi());
        zzb2.zza((zzqz) zza4.zzi());
        zzb2.zzc(i13);
        zza2.zza((zzrf) zzb2.zzi());
        zztb zza5 = zztc.zza();
        new zzik();
        zza5.zzb("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey");
        zza5.zza(zzud);
        zza5.zzc(((zzrc) zza2.zzi()).zzo());
        return (zztc) zza5.zzi();
    }
}
