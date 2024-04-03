package com.google.android.gms.internal.ads;

public final class zzbdq extends zzgkl<zzbdq, zzbdp> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzbdq zzb;
    private int zze;
    private int zzf;
    private int zzg;

    static {
        zzbdq zzbdq = new zzbdq();
        zzb = zzbdq;
        zzgkl.zzaK(zzbdq.class, zzbdq);
    }

    private zzbdq() {
    }

    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgkl.zzaJ(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001", new Object[]{"zze", "zzf", "zzg"});
        } else if (i12 == 3) {
            return new zzbdq();
        } else {
            if (i12 == 4) {
                return new zzbdp((zzbbd) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
