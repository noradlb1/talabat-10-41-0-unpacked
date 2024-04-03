package com.google.android.gms.internal.ads;

public final class zzgok extends zzgkl<zzgok, zzgoj> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzgok zzb;
    private int zze;
    private int zzf;
    private zzgjf zzg;
    private zzgjf zzh;

    static {
        zzgok zzgok = new zzgok();
        zzb = zzgok;
        zzgkl.zzaK(zzgok.class, zzgok);
    }

    private zzgok() {
        zzgjf zzgjf = zzgjf.zzb;
        this.zzg = zzgjf;
        this.zzh = zzgjf;
    }

    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgkl.zzaJ(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001င\u0000\u0002ည\u0001\u0003ည\u0002", new Object[]{"zze", "zzf", "zzg", "zzh"});
        } else if (i12 == 3) {
            return new zzgok();
        } else {
            if (i12 == 4) {
                return new zzgoj((zzgnx) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
