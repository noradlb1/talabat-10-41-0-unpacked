package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzgs  reason: invalid package */
public final /* synthetic */ class zzgs implements zzle {
    public static final /* synthetic */ zzgs zza = new zzgs();

    private /* synthetic */ zzgs() {
    }

    public final zzlw zza(zzce zzce) {
        zzud zzud;
        int i11 = zzgw.zza;
        zztb zza2 = zztc.zza();
        zza2.zzb("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key");
        zza2.zzc(zzum.zzc().zzo());
        zzgq zza3 = ((zzgr) zzce).zza();
        if (zzgq.zza.equals(zza3)) {
            zzud = zzud.TINK;
        } else if (zzgq.zzb.equals(zza3)) {
            zzud = zzud.CRUNCHY;
        } else if (zzgq.zzc.equals(zza3)) {
            zzud = zzud.RAW;
        } else {
            throw new GeneralSecurityException("Unable to serialize variant: ".concat(zza3.toString()));
        }
        zza2.zza(zzud);
        return zzlu.zzb((zztc) zza2.zzi());
    }
}
