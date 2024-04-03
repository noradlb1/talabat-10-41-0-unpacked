package com.google.android.gms.internal.ads;

public final class zzbbo extends zzgkl<zzbbo, zzbbn> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzbbo zzb;
    private int zze;
    private boolean zzf;
    private int zzg;

    static {
        zzbbo zzbbo = new zzbbo();
        zzb = zzbbo;
        zzgkl.zzaK(zzbbo.class, zzbbo);
    }

    private zzbbo() {
    }

    public static zzbbn zza() {
        return (zzbbn) zzb.zzat();
    }

    public static zzbbo zzd() {
        return zzb;
    }

    public static /* synthetic */ void zze(zzbbo zzbbo, boolean z11) {
        zzbbo.zze |= 1;
        zzbbo.zzf = z11;
    }

    public static /* synthetic */ void zzf(zzbbo zzbbo, int i11) {
        zzbbo.zze |= 2;
        zzbbo.zzg = i11;
    }

    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgkl.zzaJ(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဋ\u0001", new Object[]{"zze", "zzf", "zzg"});
        } else if (i12 == 3) {
            return new zzbbo();
        } else {
            if (i12 == 4) {
                return new zzbbn((zzbbd) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
