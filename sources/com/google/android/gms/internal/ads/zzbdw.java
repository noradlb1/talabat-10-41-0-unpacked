package com.google.android.gms.internal.ads;

public final class zzbdw extends zzgkl<zzbdw, zzbdv> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzbdw zzb;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;

    static {
        zzbdw zzbdw = new zzbdw();
        zzb = zzbdw;
        zzgkl.zzaK(zzbdw.class, zzbdw);
    }

    private zzbdw() {
    }

    public static zzbdv zza() {
        return (zzbdv) zzb.zzat();
    }

    public static /* synthetic */ void zzd(zzbdw zzbdw, int i11) {
        zzbdw.zze |= 1;
        zzbdw.zzf = i11;
    }

    public static /* synthetic */ void zze(zzbdw zzbdw, int i11) {
        zzbdw.zze |= 2;
        zzbdw.zzg = i11;
    }

    public static /* synthetic */ void zzf(zzbdw zzbdw, int i11) {
        zzbdw.zze |= 4;
        zzbdw.zzh = i11;
    }

    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgkl.zzaJ(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002", new Object[]{"zze", "zzf", "zzg", "zzh"});
        } else if (i12 == 3) {
            return new zzbdw();
        } else {
            if (i12 == 4) {
                return new zzbdv((zzbbd) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
