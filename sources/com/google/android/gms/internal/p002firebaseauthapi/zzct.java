package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzct  reason: invalid package */
public final class zzct {
    public static final String zza = "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey";
    public static final String zzb = "type.googleapis.com/google.crypto.tink.AesGcmKey";
    @Deprecated
    static final zzug zzc;
    @Deprecated
    static final zzug zzd;
    @Deprecated
    static final zzug zze;

    static {
        new zzdg();
        new zzes();
        new zzfj();
        new zzeb();
        new zzgh();
        new zzgl();
        new zzfx();
        new zzgp();
        zzug zzb2 = zzug.zzb();
        zzc = zzb2;
        zzd = zzb2;
        zze = zzb2;
        try {
            zza();
        } catch (GeneralSecurityException e11) {
            throw new ExceptionInInitializerError(e11);
        }
    }

    public static void zza() throws GeneralSecurityException {
        zzcz.zze();
        zznw.zza();
        zzcq.zzg(new zzdg(), true);
        int i11 = zzdr.zza;
        zzdr.zzc(zzky.zzc());
        zzcq.zzg(new zzes(), true);
        int i12 = zzfc.zza;
        zzfc.zzc(zzky.zzc());
        if (!zzhk.zzb()) {
            zzcq.zzg(new zzeb(), true);
            int i13 = zzel.zza;
            zzel.zzc(zzky.zzc());
            zzfj.zzg(true);
            zzcq.zzg(new zzfx(), true);
            int i14 = zzge.zza;
            zzge.zzc(zzky.zzc());
            zzcq.zzg(new zzgh(), true);
            zzcq.zzg(new zzgl(), true);
            zzcq.zzg(new zzgp(), true);
            int i15 = zzgw.zza;
            zzgw.zzc(zzky.zzc());
        }
    }
}
