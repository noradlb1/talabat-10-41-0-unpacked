package com.google.android.libraries.places.internal;

public final class zzmg extends zzabs<zzmg, zzmd> implements zzada {
    /* access modifiers changed from: private */
    public static final zzmg zzb;
    private int zze;
    private zzmc zzf;
    private zzabz<zzma> zzg = zzabs.zzB();
    private int zzh;
    private int zzi;

    static {
        zzmg zzmg = new zzmg();
        zzb = zzmg;
        zzabs.zzG(zzmg.class, zzmg);
    }

    private zzmg() {
    }

    public final Object zzd(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzabs.zzF(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဉ\u0000\u0002\u001b\u0003ဌ\u0001\u0004ဌ\u0002", new Object[]{"zze", "zzf", "zzg", zzma.class, "zzh", zzmf.zza, "zzi", zzme.zza});
        } else if (i12 == 3) {
            return new zzmg();
        } else {
            if (i12 == 4) {
                return new zzmd((zzly) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
