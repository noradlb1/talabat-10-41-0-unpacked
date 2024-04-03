package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdu  reason: invalid package */
public final class zzdu extends zzkl {
    public zzdu() {
        super(zzph.class, new zzds(zzvu.class));
    }

    public static final void zzh(zzph zzph) throws GeneralSecurityException {
        zzwc.zzc(zzph.zza(), 0);
        zzwc.zzb(zzph.zzg().zzd());
        zzi(zzph.zzf());
    }

    /* access modifiers changed from: private */
    public static final void zzi(zzpn zzpn) throws GeneralSecurityException {
        if (zzpn.zza() < 12 || zzpn.zza() > 16) {
            throw new GeneralSecurityException("invalid IV size");
        }
    }

    public final zzkk zza() {
        return new zzdt(this, zzpk.class);
    }

    public final zzsw zzb() {
        return zzsw.SYMMETRIC;
    }

    public final /* synthetic */ zzaif zzc(zzafv zzafv) throws zzahi {
        return zzph.zze(zzafv, zzagn.zza());
    }

    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.AesCtrKey";
    }

    public final /* bridge */ /* synthetic */ void zze(zzaif zzaif) throws GeneralSecurityException {
        zzh((zzph) zzaif);
    }
}
