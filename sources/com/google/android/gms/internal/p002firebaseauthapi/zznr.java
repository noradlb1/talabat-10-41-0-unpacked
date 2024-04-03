package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zznr  reason: invalid package */
public final /* synthetic */ class zznr implements zzle {
    public static final /* synthetic */ zznr zza = new zznr();

    private /* synthetic */ zznr() {
    }

    public final zzlw zza(zzce zzce) {
        int i11;
        zzud zzud;
        zznq zznq = (zznq) zzce;
        int i12 = zznv.zza;
        zztb zza2 = zztc.zza();
        zza2.zzb("type.googleapis.com/google.crypto.tink.HmacKey");
        zzsa zzc = zzsb.zzc();
        zzsd zzb = zzse.zzb();
        zzb.zza(zznq.zza());
        zznn zzd = zznq.zzd();
        if (zznn.zza.equals(zzd)) {
            i11 = 3;
        } else if (zznn.zzb.equals(zzd)) {
            i11 = 7;
        } else if (zznn.zzc.equals(zzd)) {
            i11 = 5;
        } else if (zznn.zzd.equals(zzd)) {
            i11 = 4;
        } else if (zznn.zze.equals(zzd)) {
            i11 = 6;
        } else {
            throw new GeneralSecurityException("Unable to serialize HashType ".concat(String.valueOf(zzd)));
        }
        zzb.zzb(i11);
        zzc.zzb((zzse) zzb.zzi());
        zzc.zza(zznq.zzb());
        zza2.zzc(((zzsb) zzc.zzi()).zzo());
        zzno zze = zznq.zze();
        if (zzno.zza.equals(zze)) {
            zzud = zzud.TINK;
        } else if (zzno.zzb.equals(zze)) {
            zzud = zzud.CRUNCHY;
        } else if (zzno.zzd.equals(zze)) {
            zzud = zzud.RAW;
        } else if (zzno.zzc.equals(zze)) {
            zzud = zzud.LEGACY;
        } else {
            throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(zze)));
        }
        zza2.zza(zzud);
        return zzlu.zzb((zztc) zza2.zzi());
    }
}
