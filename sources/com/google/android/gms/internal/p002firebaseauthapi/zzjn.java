package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjn  reason: invalid package */
final class zzjn implements zzjc {
    private final zzix zza;

    public zzjn(zzix zzix) {
        this.zza = zzix;
    }

    public final byte[] zza(byte[] bArr, zzjd zzjd) throws GeneralSecurityException {
        byte[] zza2 = zzwd.zza(zzjd.zza().zzc(), bArr);
        byte[] zzb = zzuu.zzb(bArr, zzjd.zzb().zzc());
        byte[] zzd = zzjk.zzd(zzjk.zzb);
        zzix zzix = this.zza;
        return zzix.zzb((byte[]) null, zza2, "eae_prk", zzb, "shared_secret", zzd, zzix.zza());
    }

    public final byte[] zzb() throws GeneralSecurityException {
        if (Arrays.equals(this.zza.zzc(), zzjk.zzf)) {
            return zzjk.zzb;
        }
        throw new GeneralSecurityException("Could not determine HPKE KEM ID");
    }
}
