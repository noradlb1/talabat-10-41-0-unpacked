package com.google.android.gms.internal.ads;

public final class zzajc extends zzgkl<zzajc, zzajb> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzajc zzb;
    private int zze;
    private int zzf;

    static {
        zzajc zzajc = new zzajc();
        zzb = zzajc;
        zzgkl.zzaK(zzajc.class, zzajc);
    }

    private zzajc() {
    }

    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgkl.zzaJ(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဌ\u0000", new Object[]{"zze", "zzf", zzajg.zza});
        } else if (i12 == 3) {
            return new zzajc();
        } else {
            if (i12 == 4) {
                return new zzajb((zzaiy) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
