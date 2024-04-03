package com.google.android.gms.internal.gtm;

import java.io.IOException;

public abstract class zzuw {
    protected volatile int zzbhl = -1;

    public static final void zza(zzuw zzuw, byte[] bArr, int i11, int i12) {
        try {
            zzuo zzk = zzuo.zzk(bArr, 0, i12);
            zzuw.zza(zzk);
            zzk.zzrx();
        } catch (IOException e11) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e11);
        }
    }

    private static final <T extends zzuw> T zzb(T t11, byte[] bArr, int i11, int i12) throws zzuv {
        try {
            zzun zzj = zzun.zzj(bArr, 0, i12);
            t11.zza(zzj);
            zzj.zzan(0);
            return t11;
        } catch (zzuv e11) {
            throw e11;
        } catch (IOException e12) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", e12);
        }
    }

    public String toString() {
        return zzux.zzc(this);
    }

    public abstract zzuw zza(zzun zzun) throws IOException;

    public void zza(zzuo zzuo) throws IOException {
    }

    public final int zzpe() {
        int zzy = zzy();
        this.zzbhl = zzy;
        return zzy;
    }

    /* renamed from: zzry */
    public zzuw clone() throws CloneNotSupportedException {
        return (zzuw) super.clone();
    }

    public final int zzse() {
        if (this.zzbhl < 0) {
            zzpe();
        }
        return this.zzbhl;
    }

    public int zzy() {
        return 0;
    }

    public static final <T extends zzuw> T zza(T t11, byte[] bArr) throws zzuv {
        return zzb(t11, bArr, 0, bArr.length);
    }
}
