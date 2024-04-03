package com.google.android.gms.internal.ads;

public final class zzbed extends zzgkl<zzbed, zzbeb> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzbed zzb;
    private int zze;
    private int zzf;

    static {
        zzbed zzbed = new zzbed();
        zzb = zzbed;
        zzgkl.zzaK(zzbed.class, zzbed);
    }

    private zzbed() {
    }

    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgkl.zzaJ(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဌ\u0000", new Object[]{"zze", "zzf", zzbec.zza});
        } else if (i12 == 3) {
            return new zzbed();
        } else {
            if (i12 == 4) {
                return new zzbeb((zzbbd) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
