package com.google.android.gms.internal.ads;

public final class zzbbi extends zzgkl<zzbbi, zzbbh> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzbbi zzb;
    private int zze;
    private int zzf;
    private int zzg = 1000;
    private zzbby zzh;
    private zzbca zzi;
    private zzgku<zzbbw> zzj = zzgkl.zzaE();
    private zzbcc zzk;
    private zzbdm zzl;
    private zzbdc zzm;
    private zzbcq zzn;
    private zzbcs zzo;
    private zzgku<zzbdy> zzp = zzgkl.zzaE();

    static {
        zzbbi zzbbi = new zzbbi();
        zzb = zzbbi;
        zzgkl.zzaK(zzbbi.class, zzbbi);
    }

    private zzbbi() {
    }

    public static zzbbi zzc() {
        return zzb;
    }

    public static /* synthetic */ void zze(zzbbi zzbbi, zzbbg zzbbg) {
        zzbbi.zzf = zzbbg.zza();
        zzbbi.zze |= 1;
    }

    public static /* synthetic */ void zzf(zzbbi zzbbi, zzbca zzbca) {
        zzbca.getClass();
        zzbbi.zzi = zzbca;
        zzbbi.zze |= 8;
    }

    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgkl.zzaJ(zzb, "\u0001\u000b\u0000\u0001\u0007\u0011\u000b\u0000\u0002\u0000\u0007ဌ\u0000\bဌ\u0001\tဉ\u0002\nဉ\u0003\u000b\u001b\fဉ\u0004\rဉ\u0005\u000eဉ\u0006\u000fဉ\u0007\u0010ဉ\b\u0011\u001b", new Object[]{"zze", "zzf", zzbbg.zzc(), "zzg", zzbcj.zza, "zzh", "zzi", "zzj", zzbbw.class, "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", zzbdy.class});
        } else if (i12 == 3) {
            return new zzbbi();
        } else {
            if (i12 == 4) {
                return new zzbbh((zzbbd) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final zzbca zzd() {
        zzbca zzbca = this.zzi;
        return zzbca == null ? zzbca.zzc() : zzbca;
    }
}
