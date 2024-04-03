package com.google.android.libraries.places.internal;

public final class zzxz extends zzabs<zzxz, zzxy> implements zzada {
    /* access modifiers changed from: private */
    public static final zzxz zzb;
    private zzabz<String> zze = zzabs.zzB();
    private zzabz<zzua> zzf = zzabs.zzB();

    static {
        zzxz zzxz = new zzxz();
        zzb = zzxz;
        zzabs.zzG(zzxz.class, zzxz);
    }

    private zzxz() {
    }

    public final Object zzd(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzabs.zzF(zzb, "\u0001\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0002\u0000\u0001\u001a\u0002\u001b", new Object[]{"zze", "zzf", zzua.class});
        } else if (i12 == 3) {
            return new zzxz();
        } else {
            if (i12 == 4) {
                return new zzxy((zztv) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
