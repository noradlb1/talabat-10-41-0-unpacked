package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmu  reason: invalid package */
public final /* synthetic */ class zzmu implements zzle {
    public static final /* synthetic */ zzmu zza = new zzmu();

    private /* synthetic */ zzmu() {
    }

    public final zzlw zza(zzce zzce) {
        zzud zzud;
        zzmt zzmt = (zzmt) zzce;
        int i11 = zzmy.zza;
        zztb zza2 = zztc.zza();
        zza2.zzb("type.googleapis.com/google.crypto.tink.AesCmacKey");
        zzou zzb = zzov.zzb();
        zzox zzb2 = zzoy.zzb();
        zzb2.zza(zzmt.zza());
        zzb.zzb((zzoy) zzb2.zzi());
        zzb.zza(zzmt.zzb());
        zza2.zzc(((zzov) zzb.zzi()).zzo());
        zzmr zzd = zzmt.zzd();
        if (zzmr.zza.equals(zzd)) {
            zzud = zzud.TINK;
        } else if (zzmr.zzb.equals(zzd)) {
            zzud = zzud.CRUNCHY;
        } else if (zzmr.zzd.equals(zzd)) {
            zzud = zzud.RAW;
        } else if (zzmr.zzc.equals(zzd)) {
            zzud = zzud.LEGACY;
        } else {
            throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(zzd)));
        }
        zza2.zza(zzud);
        return zzlu.zzb((zztc) zza2.zzi());
    }
}
