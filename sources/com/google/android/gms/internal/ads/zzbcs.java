package com.google.android.gms.internal.ads;

public final class zzbcs extends zzgkl<zzbcs, zzbcr> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzbcs zzb;
    private int zze;
    private zzbco zzf;
    private zzgku<zzbds> zzg = zzgkl.zzaE();
    private int zzh;
    private zzbdu zzi;

    static {
        zzbcs zzbcs = new zzbcs();
        zzb = zzbcs;
        zzgkl.zzaK(zzbcs.class, zzbcs);
    }

    private zzbcs() {
    }

    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgkl.zzaJ(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဉ\u0000\u0002\u001b\u0003ဌ\u0001\u0004ဉ\u0002", new Object[]{"zze", "zzf", "zzg", zzbds.class, "zzh", zzbcj.zza, "zzi"});
        } else if (i12 == 3) {
            return new zzbcs();
        } else {
            if (i12 == 4) {
                return new zzbcr((zzbbd) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
