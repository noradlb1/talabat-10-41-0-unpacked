package com.google.android.gms.internal.ads;

import java.util.Arrays;

public final class zzfyo<P> {
    private final P zza;
    private final byte[] zzb;
    private final int zzc;
    private final int zzd;

    public zzfyo(P p11, byte[] bArr, int i11, int i12, int i13) {
        this.zza = p11;
        this.zzb = Arrays.copyOf(bArr, bArr.length);
        this.zzc = i11;
        this.zzd = i12;
    }

    public final P zza() {
        return this.zza;
    }

    public final byte[] zzb() {
        byte[] bArr = this.zzb;
        if (bArr == null) {
            return null;
        }
        return Arrays.copyOf(bArr, bArr.length);
    }

    public final int zzc() {
        return this.zzc;
    }

    public final int zzd() {
        return this.zzd;
    }
}
