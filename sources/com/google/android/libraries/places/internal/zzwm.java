package com.google.android.libraries.places.internal;

public final class zzwm extends zzabs<zzwm, zzwl> implements zzada {
    private static final zzabx<Integer, Object> zzb = new zzwk();
    /* access modifiers changed from: private */
    public static final zzwm zze;
    private zzabw zzf = zzabs.zzz();

    static {
        zzwm zzwm = new zzwm();
        zze = zzwm;
        zzabs.zzG(zzwm.class, zzwm);
    }

    private zzwm() {
    }

    public final Object zzd(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzabs.zzF(zze, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001e", new Object[]{"zzf", zztx.zza});
        } else if (i12 == 3) {
            return new zzwm();
        } else {
            if (i12 == 4) {
                return new zzwl((zztv) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zze;
        }
    }
}
