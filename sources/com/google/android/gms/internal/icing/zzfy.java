package com.google.android.gms.internal.icing;

public final class zzfy extends zzda<zzfy, zzfx> implements zzef {
    /* access modifiers changed from: private */
    public static final zzfy zzl;
    private int zzb;
    private String zze = "";
    private zzdc zzf = zzda.zzv();
    private zzdf zzg = zzda.zzt();
    private zzdg<String> zzh = zzda.zzw();
    private zzdg<zzga> zzi = zzda.zzw();
    private zzcf zzj = zzcf.zzb;
    private zzdd zzk = zzda.zzu();

    static {
        zzfy zzfy = new zzfy();
        zzl = zzfy;
        zzda.zzq(zzfy.class, zzfy);
    }

    private zzfy() {
    }

    public final Object zzf(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzda.zzr(zzl, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0005\u0000\u0001ဈ\u0000\u0002\u0019\u0003\u0014\u0004\u001a\u0005\u001b\u0006ည\u0001\u0007\u0012", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", "zzi", zzga.class, "zzj", "zzk"});
        } else if (i12 == 3) {
            return new zzfy();
        } else {
            if (i12 == 4) {
                return new zzfx((zzfu) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzl;
        }
    }
}
