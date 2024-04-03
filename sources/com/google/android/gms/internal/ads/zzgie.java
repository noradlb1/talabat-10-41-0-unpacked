package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

public final class zzgie implements zzfym {
    private final zzgbq zza;
    private final int zzb;

    public zzgie(zzgbq zzgbq, int i11) throws GeneralSecurityException {
        this.zza = zzgbq;
        this.zzb = i11;
        if (i11 >= 10) {
            zzgbq.zza(new byte[0], i11);
            return;
        }
        throw new InvalidAlgorithmParameterException("tag size too small, need at least 10 bytes");
    }

    public final byte[] zza(byte[] bArr) throws GeneralSecurityException {
        return this.zza.zza(bArr, this.zzb);
    }
}
