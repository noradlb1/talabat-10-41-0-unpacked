package com.google.android.gms.internal.ads;

public final class zzbbk extends zzgkl<zzbbk, zzbbj> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzbbk zzb;
    private int zze;
    private int zzf;
    private zzbbo zzg;
    private zzbbq zzh;

    static {
        zzbbk zzbbk = new zzbbk();
        zzb = zzbbk;
        zzgkl.zzaK(zzbbk.class, zzbbk);
    }

    private zzbbk() {
    }

    public static zzbbj zza() {
        return (zzbbj) zzb.zzat();
    }

    public static /* synthetic */ void zzd(zzbbk zzbbk, zzbbo zzbbo) {
        zzbbo.getClass();
        zzbbk.zzg = zzbbo;
        zzbbk.zze |= 2;
    }

    public static /* synthetic */ void zze(zzbbk zzbbk, zzbbq zzbbq) {
        zzbbq.getClass();
        zzbbk.zzh = zzbbq;
        zzbbk.zze |= 4;
    }

    public static /* synthetic */ void zzf(zzbbk zzbbk, int i11) {
        zzbbk.zzf = 1;
        zzbbk.zze = 1 | zzbbk.zze;
    }

    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgkl.zzaJ(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zze", "zzf", zzbbm.zza, "zzg", "zzh"});
        } else if (i12 == 3) {
            return new zzbbk();
        } else {
            if (i12 == 4) {
                return new zzbbj((zzbbd) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
