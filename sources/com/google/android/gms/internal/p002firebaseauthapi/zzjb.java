package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjb  reason: invalid package */
final class zzjb implements zzbl {
    private final zzss zza;
    private final zzjc zzb;
    private final zziy zzc;
    private final zzix zzd;

    private zzjb(zzss zzss, zzjc zzjc, zzix zzix, zziy zziy) {
        this.zza = zzss;
        this.zzb = zzjc;
        this.zzd = zzix;
        this.zzc = zziy;
    }

    public static zzjb zza(zzss zzss) throws GeneralSecurityException {
        if (!zzss.zzg().zzp()) {
            zzsm zzb2 = zzss.zzb();
            return new zzjb(zzss, zzje.zzb(zzb2), zzje.zzc(zzb2), zzje.zza(zzb2));
        }
        throw new IllegalArgumentException("HpkePublicKey.public_key is empty.");
    }
}
