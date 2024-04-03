package com.google.android.gms.internal.ads;

public final class zzbdu extends zzgkl<zzbdu, zzbdt> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzbdu zzb;
    private int zze;
    private int zzf;
    private int zzg;

    static {
        zzbdu zzbdu = new zzbdu();
        zzb = zzbdu;
        zzgkl.zzaK(zzbdu.class, zzbdu);
    }

    private zzbdu() {
    }

    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgkl.zzaJ(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001", new Object[]{"zze", "zzf", "zzg"});
        } else if (i12 == 3) {
            return new zzbdu();
        } else {
            if (i12 == 4) {
                return new zzbdt((zzbbd) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
