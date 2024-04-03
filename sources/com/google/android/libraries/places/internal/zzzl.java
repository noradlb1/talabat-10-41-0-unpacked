package com.google.android.libraries.places.internal;

public final class zzzl extends zzabs<zzzl, zzzk> implements zzada {
    /* access modifiers changed from: private */
    public static final zzzl zzb;
    private zzabz<zzzw> zze = zzabs.zzB();

    static {
        zzzl zzzl = new zzzl();
        zzb = zzzl;
        zzabs.zzG(zzzl.class, zzzl);
    }

    private zzzl() {
    }

    public final Object zzd(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzabs.zzF(zzb, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zze", zzzw.class});
        } else if (i12 == 3) {
            return new zzzl();
        } else {
            if (i12 == 4) {
                return new zzzk((zzzj) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
