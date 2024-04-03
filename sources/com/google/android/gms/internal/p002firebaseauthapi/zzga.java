package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzga  reason: invalid package */
public final /* synthetic */ class zzga implements zzle {
    public static final /* synthetic */ zzga zza = new zzga();

    private /* synthetic */ zzga() {
    }

    public final zzlw zza(zzce zzce) {
        zzud zzud;
        int i11 = zzge.zza;
        zztb zza2 = zztc.zza();
        zza2.zzb("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key");
        zza2.zzc(zzqu.zzb().zzo());
        zzfy zza3 = ((zzfz) zzce).zza();
        if (zzfy.zza.equals(zza3)) {
            zzud = zzud.TINK;
        } else if (zzfy.zzb.equals(zza3)) {
            zzud = zzud.CRUNCHY;
        } else if (zzfy.zzc.equals(zza3)) {
            zzud = zzud.RAW;
        } else {
            throw new GeneralSecurityException("Unable to serialize variant: ".concat(zza3.toString()));
        }
        zza2.zza(zzud);
        return zzlu.zzb((zztc) zza2.zzi());
    }
}
