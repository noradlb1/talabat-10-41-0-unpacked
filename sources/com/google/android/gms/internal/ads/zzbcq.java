package com.google.android.gms.internal.ads;

public final class zzbcq extends zzgkl<zzbcq, zzbcp> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzbcq zzb;
    private int zze;
    private int zzf;
    private zzgkq zzg = zzgkl.zzaB();

    static {
        zzbcq zzbcq = new zzbcq();
        zzb = zzbcq;
        zzgkl.zzaK(zzbcq.class, zzbcq);
    }

    private zzbcq() {
    }

    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgkl.zzaJ(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဌ\u0000\u0002\u0016", new Object[]{"zze", "zzf", zzbcj.zza, "zzg"});
        } else if (i12 == 3) {
            return new zzbcq();
        } else {
            if (i12 == 4) {
                return new zzbcp((zzbbd) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
