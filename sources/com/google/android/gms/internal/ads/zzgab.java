package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

public final class zzgab implements zzfxu {
    private static final byte[] zza = new byte[0];
    private final zzgfi zzb;
    private final zzfxu zzc;

    public zzgab(zzgfi zzgfi, zzfxu zzfxu) {
        this.zzb = zzgfi;
        this.zzc = zzfxu;
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] zzar = zzfza.zzd(this.zzb).zzar();
        byte[] zza2 = this.zzc.zza(zzar, zza);
        byte[] zza3 = ((zzfxu) zzfza.zzh(this.zzb.zzf(), zzar, zzfxu.class)).zza(bArr, bArr2);
        int length = zza2.length;
        return ByteBuffer.allocate(length + 4 + zza3.length).putInt(length).put(zza2).put(zza3).array();
    }
}
