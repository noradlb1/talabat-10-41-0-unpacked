package com.google.android.gms.internal.places;

public abstract class zzai {
    private int zzeo;
    private int zzep;
    private boolean zzeq;

    private zzai() {
        this.zzeo = 100;
        this.zzep = Integer.MAX_VALUE;
        this.zzeq = false;
    }

    public static long zzb(long j11) {
        return (-(j11 & 1)) ^ (j11 >>> 1);
    }

    public static zzai zzb(byte[] bArr, int i11, int i12, boolean z11) {
        zzak zzak = new zzak(bArr, 0, i12, false);
        try {
            zzak.zzl(i12);
            return zzak;
        } catch (zzbk e11) {
            throw new IllegalArgumentException(e11);
        }
    }

    public static int zzm(int i11) {
        return (-(i11 & 1)) ^ (i11 >>> 1);
    }

    public abstract int zzaj();

    public abstract int zzl(int i11) throws zzbk;
}
