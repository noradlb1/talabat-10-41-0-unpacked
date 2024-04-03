package com.google.android.gms.internal.ads;

public final class zzfni extends zzgkl<zzfni, zzfng> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzfni zzb;
    private int zze;
    private int zzf;
    private String zzg = "";
    private String zzh = "";
    private zzfne zzi;

    static {
        zzfni zzfni = new zzfni();
        zzb = zzfni;
        zzgkl.zzaK(zzfni.class, zzfni);
    }

    private zzfni() {
    }

    public static zzfng zza() {
        return (zzfng) zzb.zzat();
    }

    public static /* synthetic */ void zzd(zzfni zzfni, String str) {
        str.getClass();
        zzfni.zze |= 2;
        zzfni.zzg = str;
    }

    public static /* synthetic */ void zze(zzfni zzfni, zzfne zzfne) {
        zzfne.getClass();
        zzfni.zzi = zzfne;
        zzfni.zze |= 8;
    }

    public static /* synthetic */ void zzf(zzfni zzfni, int i11) {
        zzfni.zzf = 1;
        zzfni.zze = 1 | zzfni.zze;
    }

    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgkl.zzaJ(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဉ\u0003", new Object[]{"zze", "zzf", zzfnh.zza, "zzg", "zzh", "zzi"});
        } else if (i12 == 3) {
            return new zzfni();
        } else {
            if (i12 == 4) {
                return new zzfng((zzfnf) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
