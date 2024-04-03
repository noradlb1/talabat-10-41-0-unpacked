package com.google.android.libraries.places.internal;

public final class zzys extends zzabs<zzys, zzyr> implements zzada {
    /* access modifiers changed from: private */
    public static final zzys zzb;
    private int zze;
    private int zzf;
    private int zzg;

    static {
        zzys zzys = new zzys();
        zzb = zzys;
        zzabs.zzG(zzys.class, zzys);
    }

    private zzys() {
    }

    public final Object zzd(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzabs.zzF(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001", new Object[]{"zze", "zzf", "zzg"});
        } else if (i12 == 3) {
            return new zzys();
        } else {
            if (i12 == 4) {
                return new zzyr((zztv) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
