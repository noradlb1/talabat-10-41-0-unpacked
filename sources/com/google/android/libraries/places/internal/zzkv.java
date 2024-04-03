package com.google.android.libraries.places.internal;

public final class zzkv extends zzabs<zzkv, zzku> implements zzada {
    /* access modifiers changed from: private */
    public static final zzkv zzb;
    private int zze;
    private zzabz<zzkq> zzf = zzabs.zzB();
    private int zzg;

    static {
        zzkv zzkv = new zzkv();
        zzb = zzkv;
        zzabs.zzG(zzkv.class, zzkv);
    }

    private zzkv() {
    }

    public final Object zzd(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzabs.zzF(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002င\u0000", new Object[]{"zze", "zzf", zzkq.class, "zzg"});
        } else if (i12 == 3) {
            return new zzkv();
        } else {
            if (i12 == 4) {
                return new zzku((zzko) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
