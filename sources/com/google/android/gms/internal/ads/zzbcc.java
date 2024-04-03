package com.google.android.gms.internal.ads;

public final class zzbcc extends zzgkl<zzbcc, zzbcb> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzbcc zzb;
    private int zze;
    private int zzf;
    private zzbdu zzg;
    private zzbdu zzh;
    private zzbdu zzi;
    private zzgku<zzbdu> zzj = zzgkl.zzaE();
    private int zzk;

    static {
        zzbcc zzbcc = new zzbcc();
        zzb = zzbcc;
        zzgkl.zzaK(zzbcc.class, zzbcc);
    }

    private zzbcc() {
    }

    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgkl.zzaJ(zzb, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001င\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဉ\u0003\u0005\u001b\u0006င\u0004", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", zzbdu.class, "zzk"});
        } else if (i12 == 3) {
            return new zzbcc();
        } else {
            if (i12 == 4) {
                return new zzbcb((zzbbd) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
