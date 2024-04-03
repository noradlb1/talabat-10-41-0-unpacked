package com.google.android.gms.internal.ads;

public final class zzbel extends zzgkl<zzbel, zzbek> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzbel zzb;
    private int zze;
    private int zzf = 1000;
    private zzbed zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private long zzk;

    static {
        zzbel zzbel = new zzbel();
        zzb = zzbel;
        zzgkl.zzaK(zzbel.class, zzbel);
    }

    private zzbel() {
    }

    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgkl.zzaJ(zzb, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဉ\u0001\u0003င\u0002\u0004င\u0003\u0005င\u0004\u0006ဃ\u0005", new Object[]{"zze", "zzf", zzbcj.zza, "zzg", "zzh", "zzi", "zzj", "zzk"});
        } else if (i12 == 3) {
            return new zzbel();
        } else {
            if (i12 == 4) {
                return new zzbek((zzbbd) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
