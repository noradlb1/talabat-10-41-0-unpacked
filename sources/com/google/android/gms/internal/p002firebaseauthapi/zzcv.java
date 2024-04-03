package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzcv  reason: invalid package */
public final class zzcv {
    public static final zztc zza = zzb(16);
    public static final zztc zzb = zzb(32);
    public static final zztc zzc = zza(16, 16);
    public static final zztc zzd = zza(32, 16);
    public static final zztc zze = zzc(16, 16, 32, 16, 5);
    public static final zztc zzf = zzc(32, 16, 32, 32, 5);
    public static final zztc zzg;
    public static final zztc zzh;

    static {
        zztb zza2 = zztc.zza();
        new zzfx();
        zza2.zzb("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key");
        zzud zzud = zzud.TINK;
        zza2.zza(zzud);
        zzg = (zztc) zza2.zzi();
        zztb zza3 = zztc.zza();
        new zzgp();
        zza3.zzb("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key");
        zza3.zza(zzud);
        zzh = (zztc) zza3.zzi();
    }

    public static zztc zza(int i11, int i12) {
        zzps zzb2 = zzpt.zzb();
        zzb2.zza(i11);
        zzpv zzb3 = zzpw.zzb();
        zzb3.zza(16);
        zzb2.zzb((zzpw) zzb3.zzi());
        zztb zza2 = zztc.zza();
        zza2.zzc(((zzpt) zzb2.zzi()).zzo());
        new zzeb();
        zza2.zzb("type.googleapis.com/google.crypto.tink.AesEaxKey");
        zza2.zza(zzud.TINK);
        return (zztc) zza2.zzi();
    }

    public static zztc zzb(int i11) {
        zzqb zzc2 = zzqc.zzc();
        zzc2.zza(i11);
        zztb zza2 = zztc.zza();
        zza2.zzc(((zzqc) zzc2.zzi()).zzo());
        new zzes();
        zza2.zzb("type.googleapis.com/google.crypto.tink.AesGcmKey");
        zza2.zza(zzud.TINK);
        return (zztc) zza2.zzi();
    }

    public static zztc zzc(int i11, int i12, int i13, int i14, int i15) {
        zzpj zzb2 = zzpk.zzb();
        zzpm zzb3 = zzpn.zzb();
        zzb3.zza(16);
        zzb2.zzb((zzpn) zzb3.zzi());
        zzb2.zza(i11);
        zzsa zzc2 = zzsb.zzc();
        zzsd zzb4 = zzse.zzb();
        zzb4.zzb(5);
        zzb4.zza(i14);
        zzc2.zzb((zzse) zzb4.zzi());
        zzc2.zza(32);
        zzpd zza2 = zzpe.zza();
        zza2.zza((zzpk) zzb2.zzi());
        zza2.zzb((zzsb) zzc2.zzi());
        zztb zza3 = zztc.zza();
        zza3.zzc(((zzpe) zza2.zzi()).zzo());
        new zzdg();
        zza3.zzb("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey");
        zza3.zza(zzud.TINK);
        return (zztc) zza3.zzi();
    }
}
