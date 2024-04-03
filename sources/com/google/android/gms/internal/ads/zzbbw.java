package com.google.android.gms.internal.ads;

public final class zzbbw extends zzgkl<zzbbw, zzbbv> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzbbw zzb;
    private int zze;
    private int zzf;
    private zzbdq zzg;

    static {
        zzbbw zzbbw = new zzbbw();
        zzb = zzbbw;
        zzgkl.zzaK(zzbbw.class, zzbbw);
    }

    private zzbbw() {
    }

    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgkl.zzaJ(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဉ\u0001", new Object[]{"zze", "zzf", zzbbu.zzc(), "zzg"});
        } else if (i12 == 3) {
            return new zzbbw();
        } else {
            if (i12 == 4) {
                return new zzbbv((zzbbd) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
