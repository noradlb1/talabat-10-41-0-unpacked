package com.google.android.gms.internal.ads;

public final class zzbdk extends zzgkl<zzbdk, zzbdg> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzbdk zzb;
    private int zze;
    private zzgku<zzbdf> zzf = zzgkl.zzaE();
    private int zzg;
    private int zzh;
    private long zzi;
    private String zzj = "";
    private String zzk = "";
    private long zzl;

    static {
        zzbdk zzbdk = new zzbdk();
        zzb = zzbdk;
        zzgkl.zzaK(zzbdk.class, zzbdk);
    }

    private zzbdk() {
    }

    public static zzbdg zza() {
        return (zzbdg) zzb.zzat();
    }

    public static /* synthetic */ void zzd(zzbdk zzbdk, Iterable iterable) {
        zzgku<zzbdf> zzgku = zzbdk.zzf;
        if (!zzgku.zzc()) {
            zzbdk.zzf = zzgkl.zzaF(zzgku);
        }
        zzgin.zzap(iterable, zzbdk.zzf);
    }

    public static /* synthetic */ void zze(zzbdk zzbdk, int i11) {
        zzbdk.zze |= 1;
        zzbdk.zzg = i11;
    }

    public static /* synthetic */ void zzf(zzbdk zzbdk, int i11) {
        zzbdk.zze |= 2;
        zzbdk.zzh = i11;
    }

    public static /* synthetic */ void zzg(zzbdk zzbdk, long j11) {
        zzbdk.zze |= 4;
        zzbdk.zzi = j11;
    }

    public static /* synthetic */ void zzh(zzbdk zzbdk, String str) {
        str.getClass();
        zzbdk.zze |= 8;
        zzbdk.zzj = str;
    }

    public static /* synthetic */ void zzi(zzbdk zzbdk, String str) {
        str.getClass();
        zzbdk.zze |= 16;
        zzbdk.zzk = str;
    }

    public static /* synthetic */ void zzj(zzbdk zzbdk, long j11) {
        zzbdk.zze |= 32;
        zzbdk.zzl = j11;
    }

    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgkl.zzaJ(zzb, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0001\u0000\u0001\u001b\u0002င\u0000\u0003င\u0001\u0004ဂ\u0002\u0005ဈ\u0003\u0006ဈ\u0004\u0007ဂ\u0005", new Object[]{"zze", "zzf", zzbdf.class, "zzg", "zzh", "zzi", "zzj", "zzk", "zzl"});
        } else if (i12 == 3) {
            return new zzbdk();
        } else {
            if (i12 == 4) {
                return new zzbdg((zzbbd) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
