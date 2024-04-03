package com.google.android.libraries.places.internal;

public final class zzsw extends zzabs<zzsw, zzsv> implements zzada {
    /* access modifiers changed from: private */
    public static final zzsw zzb;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl;

    static {
        zzsw zzsw = new zzsw();
        zzb = zzsw;
        zzabs.zzG(zzsw.class, zzsw);
    }

    private zzsw() {
    }

    public final Object zzd(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzabs.zzF(zzb, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002\u0004င\u0003\u0005င\u0004\u0006င\u0005\u0007င\u0006", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl"});
        } else if (i12 == 3) {
            return new zzsw();
        } else {
            if (i12 == 4) {
                return new zzsv((zzrg) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
