package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.MessageDigest;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvy  reason: invalid package */
public final class zzvy implements zzcd {
    private final zzop zza;
    private final int zzb;
    private final byte[] zzc = new byte[0];

    public zzvy(zzop zzop, int i11) throws GeneralSecurityException {
        this.zza = zzop;
        this.zzb = i11;
        if (i11 >= 10) {
            zzop.zza(new byte[0], i11);
            return;
        }
        throw new InvalidAlgorithmParameterException("tag size too small, need at least 10 bytes");
    }

    public final void zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (!MessageDigest.isEqual(zzuu.zzb(this.zzc, this.zza.zza(bArr2, this.zzb)), bArr)) {
            throw new GeneralSecurityException("invalid MAC");
        }
    }
}
