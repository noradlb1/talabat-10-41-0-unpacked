package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfj  reason: invalid package */
public final class zzfj extends zzkl {
    public zzfj() {
        super(zzqf.class, new zzfh(zzbd.class));
    }

    public static void zzg(boolean z11) throws GeneralSecurityException {
        if (zzi()) {
            zzcq.zzg(new zzfj(), true);
            int i11 = zzft.zza;
            zzft.zzc(zzky.zzc());
        }
    }

    public static /* bridge */ /* synthetic */ zzkj zzh(int i11, int i12) {
        zzqh zzc = zzqi.zzc();
        zzc.zza(i11);
        return new zzkj((zzqi) zzc.zzi(), i12);
    }

    private static boolean zzi() {
        try {
            Cipher.getInstance("AES/GCM-SIV/NoPadding");
            return true;
        } catch (NoSuchAlgorithmException | NoSuchPaddingException unused) {
            return false;
        }
    }

    public final zzkk zza() {
        return new zzfi(this, zzqi.class);
    }

    public final zzsw zzb() {
        return zzsw.SYMMETRIC;
    }

    public final /* synthetic */ zzaif zzc(zzafv zzafv) throws zzahi {
        return zzqf.zzd(zzafv, zzagn.zza());
    }

    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.AesGcmSivKey";
    }

    public final /* bridge */ /* synthetic */ void zze(zzaif zzaif) throws GeneralSecurityException {
        zzqf zzqf = (zzqf) zzaif;
        zzwc.zzc(zzqf.zza(), 0);
        zzwc.zzb(zzqf.zze().zzd());
    }
}
