package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdn  reason: invalid package */
public final /* synthetic */ class zzdn implements zzle {
    public static final /* synthetic */ zzdn zza = new zzdn();

    private /* synthetic */ zzdn() {
    }

    public final zzlw zza(zzce zzce) {
        int i11;
        zzud zzud;
        zzdm zzdm = (zzdm) zzce;
        int i12 = zzdr.zza;
        zztb zza2 = zztc.zza();
        zza2.zzb("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey");
        zzpd zza3 = zzpe.zza();
        zzpj zzb = zzpk.zzb();
        zzpm zzb2 = zzpn.zzb();
        zzb2.zza(zzdm.zzc());
        zzb.zzb((zzpn) zzb2.zzi());
        zzb.zza(zzdm.zza());
        zza3.zza((zzpk) zzb.zzi());
        zzsa zzc = zzsb.zzc();
        zzsd zzb3 = zzse.zzb();
        zzb3.zza(zzdm.zzd());
        zzdj zze = zzdm.zze();
        if (zzdj.zza.equals(zze)) {
            i11 = 3;
        } else if (zzdj.zzb.equals(zze)) {
            i11 = 7;
        } else if (zzdj.zzc.equals(zze)) {
            i11 = 5;
        } else if (zzdj.zzd.equals(zze)) {
            i11 = 4;
        } else if (zzdj.zze.equals(zze)) {
            i11 = 6;
        } else {
            throw new GeneralSecurityException("Unable to serialize HashType ".concat(String.valueOf(zze)));
        }
        zzb3.zzb(i11);
        zzc.zzb((zzse) zzb3.zzi());
        zzc.zza(zzdm.zzb());
        zza3.zzb((zzsb) zzc.zzi());
        zza2.zzc(((zzpe) zza3.zzi()).zzo());
        zzdk zzf = zzdm.zzf();
        if (zzdk.zza.equals(zzf)) {
            zzud = zzud.TINK;
        } else if (zzdk.zzb.equals(zzf)) {
            zzud = zzud.CRUNCHY;
        } else if (zzdk.zzc.equals(zzf)) {
            zzud = zzud.RAW;
        } else {
            throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(zzf)));
        }
        zza2.zza(zzud);
        return zzlu.zzb((zztc) zza2.zzi());
    }
}
