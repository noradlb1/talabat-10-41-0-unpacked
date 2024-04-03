package com.google.android.libraries.places.internal;

public final class zztg extends zzabs<zztg, zztf> implements zzada {
    /* access modifiers changed from: private */
    public static final zztg zzb;
    private int zze;
    private int zzf;

    static {
        zztg zztg = new zztg();
        zzb = zztg;
        zzabs.zzG(zztg.class, zztg);
    }

    private zztg() {
    }

    public final Object zzd(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzabs.zzF(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001င\u0000", new Object[]{"zze", "zzf"});
        } else if (i12 == 3) {
            return new zztg();
        } else {
            if (i12 == 4) {
                return new zztf((zzrg) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
