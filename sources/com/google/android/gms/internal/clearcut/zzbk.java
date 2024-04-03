package com.google.android.gms.internal.clearcut;

public abstract class zzbk {
    private static volatile boolean zzft = true;
    private int zzfq;
    private int zzfr;
    private boolean zzfs;

    private zzbk() {
        this.zzfq = 100;
        this.zzfr = Integer.MAX_VALUE;
        this.zzfs = false;
    }

    public static long zza(long j11) {
        return (-(j11 & 1)) ^ (j11 >>> 1);
    }

    public static zzbk zza(byte[] bArr, int i11, int i12, boolean z11) {
        zzbm zzbm = new zzbm(bArr, 0, i12, false);
        try {
            zzbm.zzl(i12);
            return zzbm;
        } catch (zzco e11) {
            throw new IllegalArgumentException(e11);
        }
    }

    public static int zzm(int i11) {
        return (-(i11 & 1)) ^ (i11 >>> 1);
    }

    public abstract int zzaf();

    public abstract int zzl(int i11) throws zzco;
}
