package com.google.android.libraries.places.internal;

public final class zzxx extends zzabs<zzxx, zzxw> implements zzada {
    /* access modifiers changed from: private */
    public static final zzxx zzb;
    private zzabz<String> zze = zzabs.zzB();

    static {
        zzxx zzxx = new zzxx();
        zzb = zzxx;
        zzabs.zzG(zzxx.class, zzxx);
    }

    private zzxx() {
    }

    public final Object zzd(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzabs.zzF(zzb, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", new Object[]{"zze"});
        } else if (i12 == 3) {
            return new zzxx();
        } else {
            if (i12 == 4) {
                return new zzxw((zztv) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
