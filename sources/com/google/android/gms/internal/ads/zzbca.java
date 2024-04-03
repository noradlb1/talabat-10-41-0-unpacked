package com.google.android.gms.internal.ads;

public final class zzbca extends zzgkl<zzbca, zzbbz> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzbca zzb;
    private int zze;
    private String zzf = "";
    private zzgku<zzbbw> zzg = zzgkl.zzaE();
    private int zzh = 1000;
    private int zzi = 1000;
    private int zzj = 1000;

    static {
        zzbca zzbca = new zzbca();
        zzb = zzbca;
        zzgkl.zzaK(zzbca.class, zzbca);
    }

    private zzbca() {
    }

    public static zzbca zzc() {
        return zzb;
    }

    public static /* synthetic */ void zzd(zzbca zzbca, String str) {
        str.getClass();
        zzbca.zze |= 1;
        zzbca.zzf = str;
    }

    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            zzgkp zzgkp = zzbcj.zza;
            return zzgkl.zzaJ(zzb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b\u0003ဌ\u0001\u0004ဌ\u0002\u0005ဌ\u0003", new Object[]{"zze", "zzf", "zzg", zzbbw.class, "zzh", zzgkp, "zzi", zzgkp, "zzj", zzgkp});
        } else if (i12 == 3) {
            return new zzbca();
        } else {
            if (i12 == 4) {
                return new zzbbz((zzbbd) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
