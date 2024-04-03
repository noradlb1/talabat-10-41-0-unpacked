package com.google.android.gms.internal.ads;

public final class zzaix extends zzgkl<zzaix, zzaiw> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzaix zzb;
    private int zze;
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";
    private String zzj = "";
    private String zzk = "";

    static {
        zzaix zzaix = new zzaix();
        zzb = zzaix;
        zzgkl.zzaK(zzaix.class, zzaix);
    }

    private zzaix() {
    }

    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgkl.zzaJ(zzb, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဈ\u0005", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        } else if (i12 == 3) {
            return new zzaix();
        } else {
            if (i12 == 4) {
                return new zzaiw((zzaiq) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
