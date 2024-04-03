package com.google.android.gms.internal.ads;

public final class zzbch extends zzgkl<zzbch, zzbcf> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzbch zzb;
    private int zze;
    private int zzf;
    private zzbdw zzg;
    private String zzh = "";
    private String zzi = "";

    static {
        zzbch zzbch = new zzbch();
        zzb = zzbch;
        zzgkl.zzaK(zzbch.class, zzbch);
    }

    private zzbch() {
    }

    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgkl.zzaJ(zzb, "\u0001\u0004\u0000\u0001\u0005\b\u0004\u0000\u0000\u0000\u0005ဌ\u0000\u0006ဉ\u0001\u0007ဈ\u0002\bဈ\u0003", new Object[]{"zze", "zzf", zzbcg.zza, "zzg", "zzh", "zzi"});
        } else if (i12 == 3) {
            return new zzbch();
        } else {
            if (i12 == 4) {
                return new zzbcf((zzbbd) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
