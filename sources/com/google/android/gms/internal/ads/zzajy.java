package com.google.android.gms.internal.ads;

public final class zzajy extends zzgkl<zzajy, zzajx> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzajy zzb;
    private int zze;
    private long zzf;
    private String zzg = "";
    private zzgjf zzh = zzgjf.zzb;

    static {
        zzajy zzajy = new zzajy();
        zzb = zzajy;
        zzgkl.zzaK(zzajy.class, zzajy);
    }

    private zzajy() {
    }

    public static zzajy zzd() {
        return zzb;
    }

    public final long zza() {
        return this.zzf;
    }

    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgkl.zzaJ(zzb, "\u0001\u0003\u0000\u0001\u0001\u0004\u0003\u0000\u0000\u0000\u0001ဂ\u0000\u0003ဈ\u0001\u0004ည\u0002", new Object[]{"zze", "zzf", "zzg", "zzh"});
        } else if (i12 == 3) {
            return new zzajy();
        } else {
            if (i12 == 4) {
                return new zzajx((zzaiy) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final boolean zze() {
        return (this.zze & 1) != 0;
    }
}
