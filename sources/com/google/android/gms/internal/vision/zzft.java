package com.google.android.gms.internal.vision;

import java.io.IOException;

public abstract class zzft {
    int zzsf;
    int zzsg;
    private int zzsh;
    zzfy zzsi;
    private boolean zzsj;

    private zzft() {
        this.zzsg = 100;
        this.zzsh = Integer.MAX_VALUE;
        this.zzsj = false;
    }

    public static zzft zza(byte[] bArr, int i11, int i12, boolean z11) {
        zzfv zzfv = new zzfv(bArr, 0, i12, false);
        try {
            zzfv.zzas(i12);
            return zzfv;
        } catch (zzhc e11) {
            throw new IllegalArgumentException(e11);
        }
    }

    public static int zzau(int i11) {
        return (-(i11 & 1)) ^ (i11 >>> 1);
    }

    public static long zzr(long j11) {
        return (-(j11 & 1)) ^ (j11 >>> 1);
    }

    public abstract double readDouble() throws IOException;

    public abstract float readFloat() throws IOException;

    public abstract String readString() throws IOException;

    public abstract void zzaq(int i11) throws zzhc;

    public abstract boolean zzar(int i11) throws IOException;

    public abstract int zzas(int i11) throws zzhc;

    public abstract void zzat(int i11);

    public abstract boolean zzdt() throws IOException;

    public abstract long zzdw() throws IOException;

    public abstract long zzdx() throws IOException;

    public abstract int zzdy() throws IOException;

    public abstract long zzdz() throws IOException;

    public abstract int zzea() throws IOException;

    public abstract boolean zzeb() throws IOException;

    public abstract String zzec() throws IOException;

    public abstract zzfh zzed() throws IOException;

    public abstract int zzee() throws IOException;

    public abstract int zzef() throws IOException;

    public abstract int zzeg() throws IOException;

    public abstract long zzeh() throws IOException;

    public abstract int zzei() throws IOException;

    public abstract long zzej() throws IOException;

    public abstract int zzex() throws IOException;

    public abstract long zzey() throws IOException;

    public abstract int zzez();
}
