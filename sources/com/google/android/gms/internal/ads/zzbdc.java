package com.google.android.gms.internal.ads;

public final class zzbdc extends zzgkl<zzbdc, zzbdb> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzbdc zzb;
    private int zze;
    private int zzf;
    private zzbdu zzg;

    static {
        zzbdc zzbdc = new zzbdc();
        zzb = zzbdc;
        zzgkl.zzaK(zzbdc.class, zzbdc);
    }

    private zzbdc() {
    }

    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgkl.zzaJ(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဉ\u0001", new Object[]{"zze", "zzf", zzbcj.zza, "zzg"});
        } else if (i12 == 3) {
            return new zzbdc();
        } else {
            if (i12 == 4) {
                return new zzbdb((zzbbd) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
