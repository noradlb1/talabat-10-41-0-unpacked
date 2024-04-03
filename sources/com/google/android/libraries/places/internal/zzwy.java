package com.google.android.libraries.places.internal;

public final class zzwy extends zzabs<zzwy, zzwx> implements zzada {
    private static final zzabx<Integer, Object> zzb = new zzww();
    /* access modifiers changed from: private */
    public static final zzwy zze;
    private zzabw zzf = zzabs.zzz();

    static {
        zzwy zzwy = new zzwy();
        zze = zzwy;
        zzabs.zzG(zzwy.class, zzwy);
    }

    private zzwy() {
    }

    public final Object zzd(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzabs.zzF(zze, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001e", new Object[]{"zzf", zzyw.zza});
        } else if (i12 == 3) {
            return new zzwy();
        } else {
            if (i12 == 4) {
                return new zzwx((zztv) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zze;
        }
    }
}
