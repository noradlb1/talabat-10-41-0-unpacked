package com.google.android.gms.internal.ads;

public final class zzbef extends zzgkl<zzbef, zzbee> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzbef zzb;
    private int zze;
    private zzbdw zzf;
    private int zzg = 1000;
    private zzbed zzh;
    private zzbdu zzi;

    static {
        zzbef zzbef = new zzbef();
        zzb = zzbef;
        zzgkl.zzaK(zzbef.class, zzbef);
    }

    private zzbef() {
    }

    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgkl.zzaJ(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဌ\u0001\u0003ဉ\u0002\u0004ဉ\u0003", new Object[]{"zze", "zzf", "zzg", zzbcj.zza, "zzh", "zzi"});
        } else if (i12 == 3) {
            return new zzbef();
        } else {
            if (i12 == 4) {
                return new zzbee((zzbbd) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
