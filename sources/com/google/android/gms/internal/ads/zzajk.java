package com.google.android.gms.internal.ads;

public final class zzajk extends zzgkl<zzajk, zzajj> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzajk zzb;
    private int zze;
    private long zzf = -1;
    private int zzg = 1000;

    static {
        zzajk zzajk = new zzajk();
        zzb = zzajk;
        zzgkl.zzaK(zzajk.class, zzajk);
    }

    private zzajk() {
    }

    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgkl.zzaJ(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဌ\u0001", new Object[]{"zze", "zzf", "zzg", zzajv.zza});
        } else if (i12 == 3) {
            return new zzajk();
        } else {
            if (i12 == 4) {
                return new zzajj((zzaiy) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
