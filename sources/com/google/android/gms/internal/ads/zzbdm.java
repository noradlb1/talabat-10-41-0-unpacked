package com.google.android.gms.internal.ads;

public final class zzbdm extends zzgkl<zzbdm, zzbdl> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzbdm zzb;
    private int zze;
    private int zzf = 1000;
    private int zzg = 1000;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl;
    private int zzm;
    private int zzn;
    private int zzo;
    private zzbdo zzp;

    static {
        zzbdm zzbdm = new zzbdm();
        zzb = zzbdm;
        zzgkl.zzaK(zzbdm.class, zzbdm);
    }

    private zzbdm() {
    }

    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            zzgkp zzgkp = zzbcj.zza;
            return zzgkl.zzaJ(zzb, "\u0001\u000b\u0000\u0001\u0001\u000b\u000b\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001\u0003င\u0002\u0004င\u0003\u0005င\u0004\u0006င\u0005\u0007င\u0006\bင\u0007\tင\b\nင\t\u000bဉ\n", new Object[]{"zze", "zzf", zzgkp, "zzg", zzgkp, "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp"});
        } else if (i12 == 3) {
            return new zzbdm();
        } else {
            if (i12 == 4) {
                return new zzbdl((zzbbd) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
