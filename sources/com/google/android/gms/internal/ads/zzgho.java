package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

public final class zzgho implements zzfxu {
    private final zzghz zza;
    private final zzfym zzb;

    public zzgho(zzghz zzghz, zzfym zzfym, int i11) {
        this.zza = zzghz;
        this.zzb = zzfym;
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] zza2 = this.zza.zza(bArr);
        byte[] copyOf = Arrays.copyOf(ByteBuffer.allocate(8).putLong(0).array(), 8);
        return zzghc.zzb(zza2, this.zzb.zza(zzghc.zzb(bArr2, zza2, copyOf)));
    }
}
