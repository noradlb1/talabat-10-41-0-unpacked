package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzey  reason: invalid package */
public final /* synthetic */ class zzey implements zzle {
    public static final /* synthetic */ zzey zza = new zzey();

    private /* synthetic */ zzey() {
    }

    public final zzlw zza(zzce zzce) {
        zzud zzud;
        zzex zzex = (zzex) zzce;
        int i11 = zzfc.zza;
        zztb zza2 = zztc.zza();
        zza2.zzb("type.googleapis.com/google.crypto.tink.AesGcmKey");
        zzqb zzc = zzqc.zzc();
        zzc.zza(zzex.zza());
        zza2.zzc(((zzqc) zzc.zzi()).zzo());
        zzev zzb = zzex.zzb();
        if (zzev.zza.equals(zzb)) {
            zzud = zzud.TINK;
        } else if (zzev.zzb.equals(zzb)) {
            zzud = zzud.CRUNCHY;
        } else if (zzev.zzc.equals(zzb)) {
            zzud = zzud.RAW;
        } else {
            throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(zzb)));
        }
        zza2.zza(zzud);
        return zzlu.zzb((zztc) zza2.zzi());
    }
}
