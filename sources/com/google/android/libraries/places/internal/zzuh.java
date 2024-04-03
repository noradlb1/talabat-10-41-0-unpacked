package com.google.android.libraries.places.internal;

public final class zzuh extends zzabs<zzuh, zzug> implements zzada {
    private static final zzabx<Integer, Object> zzb = new zzue();
    /* access modifiers changed from: private */
    public static final zzuh zze;
    private int zzf;
    private zzabw zzg = zzabs.zzz();
    private int zzh;

    static {
        zzuh zzuh = new zzuh();
        zze = zzuh;
        zzabs.zzG(zzuh.class, zzuh);
    }

    private zzuh() {
    }

    public final Object zzd(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzabs.zzF(zze, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001e\u0002င\u0000", new Object[]{"zzf", "zzg", zzuf.zza, "zzh"});
        } else if (i12 == 3) {
            return new zzuh();
        } else {
            if (i12 == 4) {
                return new zzug((zztv) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zze;
        }
    }
}
