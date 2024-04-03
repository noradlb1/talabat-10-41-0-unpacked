package com.google.android.gms.internal.ads;

public final class zzgol extends zzgkl<zzgol, zzgoi> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzgol zzb;
    private int zze;
    private zzgok zzf;
    private zzgku<zzgod> zzg = zzgkl.zzaE();
    private zzgjf zzh;
    private zzgjf zzi;
    private int zzj;
    private zzgjf zzk;
    private byte zzl = 2;

    static {
        zzgol zzgol = new zzgol();
        zzb = zzgol;
        zzgkl.zzaK(zzgol.class, zzgol);
    }

    private zzgol() {
        zzgjf zzgjf = zzgjf.zzb;
        this.zzh = zzgjf;
        this.zzi = zzgjf;
        this.zzk = zzgjf;
    }

    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return Byte.valueOf(this.zzl);
        }
        byte b11 = 1;
        if (i12 == 2) {
            return zzgkl.zzaJ(zzb, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0001\u0001ဉ\u0000\u0002Л\u0003ည\u0001\u0004ည\u0002\u0005င\u0003\u0006ည\u0004", new Object[]{"zze", "zzf", "zzg", zzgod.class, "zzh", "zzi", "zzj", "zzk"});
        } else if (i12 == 3) {
            return new zzgol();
        } else {
            if (i12 == 4) {
                return new zzgoi((zzgnx) null);
            }
            if (i12 == 5) {
                return zzb;
            }
            if (obj == null) {
                b11 = 0;
            }
            this.zzl = b11;
            return null;
        }
    }
}
