package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmo  reason: invalid package */
public final class zzmo extends zzkl {
    private static final zzlk zza = zzlk.zzb(zzml.zza, zzmk.class, zzmz.class);

    public zzmo() {
        super(zzos.class, new zzmm(zzcd.class));
    }

    public static void zzi(boolean z11) throws GeneralSecurityException {
        zzcq.zzg(new zzmo(), true);
        int i11 = zzmy.zza;
        zzmy.zzc(zzky.zzc());
        zzkv.zza().zze(zza);
    }

    /* access modifiers changed from: private */
    public static void zzn(zzoy zzoy) throws GeneralSecurityException {
        if (zzoy.zza() < 10) {
            throw new GeneralSecurityException("tag size too short");
        } else if (zzoy.zza() > 16) {
            throw new GeneralSecurityException("tag size too long");
        }
    }

    /* access modifiers changed from: private */
    public static void zzo(int i11) throws GeneralSecurityException {
        if (i11 != 32) {
            throw new GeneralSecurityException("AesCmacKey size wrong, must be 32 bytes");
        }
    }

    public final zzkk zza() {
        return new zzmn(this, zzov.class);
    }

    public final zzsw zzb() {
        return zzsw.SYMMETRIC;
    }

    public final /* synthetic */ zzaif zzc(zzafv zzafv) throws zzahi {
        return zzos.zzd(zzafv, zzagn.zza());
    }

    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.AesCmacKey";
    }

    public final /* bridge */ /* synthetic */ void zze(zzaif zzaif) throws GeneralSecurityException {
        zzos zzos = (zzos) zzaif;
        zzwc.zzc(zzos.zza(), 0);
        zzo(zzos.zzf().zzd());
        zzn(zzos.zze());
    }
}
