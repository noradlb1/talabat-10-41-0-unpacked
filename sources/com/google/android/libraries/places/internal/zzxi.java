package com.google.android.libraries.places.internal;

public final class zzxi extends zzabs<zzxi, zzxh> implements zzada {
    /* access modifiers changed from: private */
    public static final zzxi zzb;
    private int zze;
    private int zzf;

    static {
        zzxi zzxi = new zzxi();
        zzb = zzxi;
        zzabs.zzG(zzxi.class, zzxi);
    }

    private zzxi() {
    }

    public final Object zzd(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzabs.zzF(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001င\u0000", new Object[]{"zze", "zzf"});
        } else if (i12 == 3) {
            return new zzxi();
        } else {
            if (i12 == 4) {
                return new zzxh((zztv) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
