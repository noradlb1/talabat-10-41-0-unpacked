package com.google.android.libraries.places.internal;

public final class zzyk extends zzabs<zzyk, zzyj> implements zzada {
    /* access modifiers changed from: private */
    public static final zzyk zzb;
    private int zze;
    private int zzf;
    private zzabz<String> zzg = zzabs.zzB();
    private zzabz<zzym> zzh = zzabs.zzB();

    static {
        zzyk zzyk = new zzyk();
        zzb = zzyk;
        zzabs.zzG(zzyk.class, zzyk);
    }

    private zzyk() {
    }

    public final Object zzd(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzabs.zzF(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0002\u0000\u0001င\u0000\u0002\u001a\u0003\u001b", new Object[]{"zze", "zzf", "zzg", "zzh", zzym.class});
        } else if (i12 == 3) {
            return new zzyk();
        } else {
            if (i12 == 4) {
                return new zzyj((zztv) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
