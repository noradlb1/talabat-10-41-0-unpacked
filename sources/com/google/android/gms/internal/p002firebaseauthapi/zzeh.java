package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzeh  reason: invalid package */
public final /* synthetic */ class zzeh implements zzle {
    public static final /* synthetic */ zzeh zza = new zzeh();

    private /* synthetic */ zzeh() {
    }

    public final zzlw zza(zzce zzce) {
        zzud zzud;
        zzeg zzeg = (zzeg) zzce;
        int i11 = zzel.zza;
        zztb zza2 = zztc.zza();
        zza2.zzb("type.googleapis.com/google.crypto.tink.AesEaxKey");
        zzps zzb = zzpt.zzb();
        zzpv zzb2 = zzpw.zzb();
        zzb2.zza(zzeg.zza());
        zzb.zzb((zzpw) zzb2.zzi());
        zzb.zza(zzeg.zzb());
        zza2.zzc(((zzpt) zzb.zzi()).zzo());
        zzee zzc = zzeg.zzc();
        if (zzee.zza.equals(zzc)) {
            zzud = zzud.TINK;
        } else if (zzee.zzb.equals(zzc)) {
            zzud = zzud.CRUNCHY;
        } else if (zzee.zzc.equals(zzc)) {
            zzud = zzud.RAW;
        } else {
            throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(zzc)));
        }
        zza2.zza(zzud);
        return zzlu.zzb((zztc) zza2.zzi());
    }
}
