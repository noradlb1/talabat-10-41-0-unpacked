package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfp  reason: invalid package */
public final /* synthetic */ class zzfp implements zzle {
    public static final /* synthetic */ zzfp zza = new zzfp();

    private /* synthetic */ zzfp() {
    }

    public final zzlw zza(zzce zzce) {
        zzud zzud;
        zzfo zzfo = (zzfo) zzce;
        int i11 = zzft.zza;
        zztb zza2 = zztc.zza();
        zza2.zzb("type.googleapis.com/google.crypto.tink.AesGcmSivKey");
        zzqh zzc = zzqi.zzc();
        zzc.zza(zzfo.zza());
        zza2.zzc(((zzqi) zzc.zzi()).zzo());
        zzfm zzb = zzfo.zzb();
        if (zzfm.zza.equals(zzb)) {
            zzud = zzud.TINK;
        } else if (zzfm.zzb.equals(zzb)) {
            zzud = zzud.CRUNCHY;
        } else if (zzfm.zzc.equals(zzb)) {
            zzud = zzud.RAW;
        } else {
            throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(zzb)));
        }
        zza2.zza(zzud);
        return zzlu.zzb((zztc) zza2.zzi());
    }
}
