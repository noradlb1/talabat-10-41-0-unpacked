package com.google.android.gms.internal.ads;

public final class zzaof extends zzgkl<zzaof, zzaoe> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzaof zzb;
    private int zze;
    private zzaoi zzf;
    private zzgjf zzg;
    private zzgjf zzh;

    static {
        zzaof zzaof = new zzaof();
        zzb = zzaof;
        zzgkl.zzaK(zzaof.class, zzaof);
    }

    private zzaof() {
        zzgjf zzgjf = zzgjf.zzb;
        this.zzg = zzgjf;
        this.zzh = zzgjf;
    }

    public static zzaof zzc(zzgjf zzgjf, zzgjx zzgjx) throws zzgkx {
        return (zzaof) zzgkl.zzay(zzb, zzgjf, zzgjx);
    }

    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgkl.zzaJ(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ည\u0001\u0003ည\u0002", new Object[]{"zze", "zzf", "zzg", "zzh"});
        } else if (i12 == 3) {
            return new zzaof();
        } else {
            if (i12 == 4) {
                return new zzaoe((zzaod) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final zzaoi zzd() {
        zzaoi zzaoi = this.zzf;
        return zzaoi == null ? zzaoi.zzg() : zzaoi;
    }

    public final zzgjf zze() {
        return this.zzh;
    }

    public final zzgjf zzf() {
        return this.zzg;
    }
}
