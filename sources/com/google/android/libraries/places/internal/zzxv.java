package com.google.android.libraries.places.internal;

public final class zzxv extends zzabs<zzxv, zzxu> implements zzada {
    /* access modifiers changed from: private */
    public static final zzxv zzb;
    private int zze;
    private int zzf;

    static {
        zzxv zzxv = new zzxv();
        zzb = zzxv;
        zzabs.zzG(zzxv.class, zzxv);
    }

    private zzxv() {
    }

    public final Object zzd(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzabs.zzF(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဋ\u0000", new Object[]{"zze", "zzf"});
        } else if (i12 == 3) {
            return new zzxv();
        } else {
            if (i12 == 4) {
                return new zzxu((zztv) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
