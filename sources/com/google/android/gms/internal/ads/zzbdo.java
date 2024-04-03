package com.google.android.gms.internal.ads;

public final class zzbdo extends zzgkl<zzbdo, zzbdn> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzbdo zzb;
    private int zze;
    private int zzf;
    private int zzg;

    static {
        zzbdo zzbdo = new zzbdo();
        zzb = zzbdo;
        zzgkl.zzaK(zzbdo.class, zzbdo);
    }

    private zzbdo() {
    }

    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgkl.zzaJ(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001", new Object[]{"zze", "zzf", "zzg"});
        } else if (i12 == 3) {
            return new zzbdo();
        } else {
            if (i12 == 4) {
                return new zzbdn((zzbbd) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
