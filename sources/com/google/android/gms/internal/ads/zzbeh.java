package com.google.android.gms.internal.ads;

public final class zzbeh extends zzgkl<zzbeh, zzbeg> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzbeh zzb;
    private int zze;
    private int zzf = 1000;
    private zzbed zzg;
    private int zzh;
    private int zzi;
    private int zzj;

    static {
        zzbeh zzbeh = new zzbeh();
        zzb = zzbeh;
        zzgkl.zzaK(zzbeh.class, zzbeh);
    }

    private zzbeh() {
    }

    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgkl.zzaJ(zzb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဉ\u0001\u0003င\u0002\u0004င\u0003\u0005င\u0004", new Object[]{"zze", "zzf", zzbcj.zza, "zzg", "zzh", "zzi", "zzj"});
        } else if (i12 == 3) {
            return new zzbeh();
        } else {
            if (i12 == 4) {
                return new zzbeg((zzbbd) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
