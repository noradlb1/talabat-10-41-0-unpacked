package com.google.android.gms.internal.gtm;

import java.io.IOException;

public abstract class zzqe {
    int zzawf;
    int zzawg;
    private int zzawh;
    zzqh zzawi;
    private boolean zzawj;

    private zzqe() {
        this.zzawg = 100;
        this.zzawh = Integer.MAX_VALUE;
        this.zzawj = false;
    }

    public static zzqe zza(byte[] bArr, int i11, int i12, boolean z11) {
        zzqg zzqg = new zzqg(bArr, i11, i12, false);
        try {
            zzqg.zzaq(i12);
            return zzqg;
        } catch (zzrk e11) {
            throw new IllegalArgumentException(e11);
        }
    }

    public static zzqe zzd(byte[] bArr, int i11, int i12) {
        return zza(bArr, i11, i12, false);
    }

    public abstract double readDouble() throws IOException;

    public abstract float readFloat() throws IOException;

    public abstract String readString() throws IOException;

    public abstract <T extends zzsk> T zza(zzsu<T> zzsu, zzqp zzqp) throws IOException;

    public abstract void zzan(int i11) throws zzrk;

    public abstract boolean zzao(int i11) throws IOException;

    public final int zzap(int i11) {
        if (i11 >= 0) {
            int i12 = this.zzawg;
            this.zzawg = i11;
            return i12;
        }
        StringBuilder sb2 = new StringBuilder(47);
        sb2.append("Recursion limit cannot be negative: ");
        sb2.append(i11);
        throw new IllegalArgumentException(sb2.toString());
    }

    public abstract int zzaq(int i11) throws zzrk;

    public abstract void zzar(int i11);

    public abstract void zzas(int i11) throws IOException;

    public abstract int zzni() throws IOException;

    public abstract long zznj() throws IOException;

    public abstract long zznk() throws IOException;

    public abstract int zznl() throws IOException;

    public abstract long zznm() throws IOException;

    public abstract int zznn() throws IOException;

    public abstract boolean zzno() throws IOException;

    public abstract String zznp() throws IOException;

    public abstract zzps zznq() throws IOException;

    public abstract int zznr() throws IOException;

    public abstract int zzns() throws IOException;

    public abstract int zznt() throws IOException;

    public abstract long zznu() throws IOException;

    public abstract int zznv() throws IOException;

    public abstract long zznw() throws IOException;

    public abstract long zznx() throws IOException;

    public abstract boolean zzny() throws IOException;

    public abstract int zznz();
}
