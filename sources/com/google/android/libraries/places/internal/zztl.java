package com.google.android.libraries.places.internal;

public final class zztl extends zzabs<zztl, zztj> implements zzada {
    /* access modifiers changed from: private */
    public static final zztl zzb;
    private int zze;
    private int zzf;

    static {
        zztl zztl = new zztl();
        zzb = zztl;
        zzabs.zzG(zztl.class, zztl);
    }

    private zztl() {
    }

    public final Object zzd(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzabs.zzF(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဌ\u0000", new Object[]{"zze", "zzf", zztk.zza});
        } else if (i12 == 3) {
            return new zztl();
        } else {
            if (i12 == 4) {
                return new zztj((zzrg) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
