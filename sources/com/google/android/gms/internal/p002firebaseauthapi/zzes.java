package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzes  reason: invalid package */
public final class zzes extends zzkl {
    public zzes() {
        super(zzpz.class, new zzeq(zzbd.class));
    }

    public static /* bridge */ /* synthetic */ zzkj zzg(int i11, int i12) {
        zzqb zzc = zzqc.zzc();
        zzc.zza(i11);
        return new zzkj((zzqc) zzc.zzi(), i12);
    }

    public final zzkk zza() {
        return new zzer(this, zzqc.class);
    }

    public final zzsw zzb() {
        return zzsw.SYMMETRIC;
    }

    public final /* synthetic */ zzaif zzc(zzafv zzafv) throws zzahi {
        return zzpz.zzd(zzafv, zzagn.zza());
    }

    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.AesGcmKey";
    }

    public final /* bridge */ /* synthetic */ void zze(zzaif zzaif) throws GeneralSecurityException {
        zzpz zzpz = (zzpz) zzaif;
        zzwc.zzc(zzpz.zza(), 0);
        zzwc.zzb(zzpz.zze().zzd());
    }

    public final int zzf() {
        return 2;
    }
}
