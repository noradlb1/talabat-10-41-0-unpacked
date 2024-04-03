package com.google.android.gms.internal.ads;

public final class zzbej extends zzgkl<zzbej, zzbei> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzbej zzb;
    private int zze;
    private int zzf = 1000;
    private zzbed zzg;
    private zzbdu zzh;

    static {
        zzbej zzbej = new zzbej();
        zzb = zzbej;
        zzgkl.zzaK(zzbej.class, zzbej);
    }

    private zzbej() {
    }

    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgkl.zzaJ(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zze", "zzf", zzbcj.zza, "zzg", "zzh"});
        } else if (i12 == 3) {
            return new zzbej();
        } else {
            if (i12 == 4) {
                return new zzbei((zzbbd) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
