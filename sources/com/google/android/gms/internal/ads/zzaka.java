package com.google.android.gms.internal.ads;

public final class zzaka extends zzgkl<zzaka, zzajz> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzaka zzb;
    private int zze;
    private String zzf = "";

    static {
        zzaka zzaka = new zzaka();
        zzb = zzaka;
        zzgkl.zzaK(zzaka.class, zzaka);
    }

    private zzaka() {
    }

    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgkl.zzaJ(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဈ\u0000", new Object[]{"zze", "zzf"});
        } else if (i12 == 3) {
            return new zzaka();
        } else {
            if (i12 == 4) {
                return new zzajz((zzaiy) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
