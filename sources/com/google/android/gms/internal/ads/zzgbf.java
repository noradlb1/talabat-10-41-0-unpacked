package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

public final class zzgbf {
    private final zzfxu zza;
    private final zzfxx zzb;

    public zzgbf(zzfxu zzfxu) {
        this.zza = zzfxu;
        this.zzb = null;
    }

    public zzgbf(zzfxx zzfxx) {
        this.zza = null;
        this.zzb = zzfxx;
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        zzfxu zzfxu = this.zza;
        if (zzfxu != null) {
            return zzfxu.zza(bArr, bArr2);
        }
        return this.zzb.zza(bArr, bArr2);
    }
}
