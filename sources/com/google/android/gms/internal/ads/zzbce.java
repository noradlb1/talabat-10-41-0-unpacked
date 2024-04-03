package com.google.android.gms.internal.ads;

public final class zzbce extends zzgkl<zzbce, zzbcd> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzbce zzb;
    private int zze;
    private String zzf = "";
    private zzbdu zzg;
    private int zzh;
    private zzbdw zzi;
    private int zzj;
    private int zzk = 1000;
    private int zzl = 1000;
    private int zzm = 1000;

    static {
        zzbce zzbce = new zzbce();
        zzb = zzbce;
        zzgkl.zzaK(zzbce.class, zzbce);
    }

    private zzbce() {
    }

    public static zzbce zzc() {
        return zzb;
    }

    public static /* synthetic */ void zzd(zzbce zzbce, String str) {
        zzbce.zze |= 1;
        zzbce.zzf = str;
    }

    public static /* synthetic */ void zze(zzbce zzbce, zzbdw zzbdw) {
        zzbdw.getClass();
        zzbce.zzi = zzbdw;
        zzbce.zze |= 8;
    }

    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            zzgkp zzgkp = zzbcj.zza;
            return zzgkl.zzaJ(zzb, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဉ\u0001\u0003င\u0002\u0004ဉ\u0003\u0005င\u0004\u0006ဌ\u0005\u0007ဌ\u0006\bဌ\u0007", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", zzgkp, "zzl", zzgkp, "zzm", zzgkp});
        } else if (i12 == 3) {
            return new zzbce();
        } else {
            if (i12 == 4) {
                return new zzbcd((zzbbd) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
