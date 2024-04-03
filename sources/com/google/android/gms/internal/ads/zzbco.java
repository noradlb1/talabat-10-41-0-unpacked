package com.google.android.gms.internal.ads;

public final class zzbco extends zzgkl<zzbco, zzbcn> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzbco zzb;
    private int zze;
    private String zzf = "";
    private int zzg;
    private zzgkq zzh = zzgkl.zzaB();
    private zzbdu zzi;

    static {
        zzbco zzbco = new zzbco();
        zzb = zzbco;
        zzgkl.zzaK(zzbco.class, zzbco);
    }

    private zzbco() {
    }

    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgkl.zzaJ(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဌ\u0001\u0003\u0016\u0004ဉ\u0002", new Object[]{"zze", "zzf", "zzg", zzbcj.zza, "zzh", "zzi"});
        } else if (i12 == 3) {
            return new zzbco();
        } else {
            if (i12 == 4) {
                return new zzbcn((zzbbd) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
