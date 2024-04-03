package com.google.android.libraries.places.internal;

public final class zzyz extends zzabs<zzyz, zzyy> implements zzada {
    /* access modifiers changed from: private */
    public static final zzyz zzb;
    private int zze;
    private long zzf;
    private int zzg;

    static {
        zzyz zzyz = new zzyz();
        zzb = zzyz;
        zzabs.zzG(zzyz.class, zzyz);
    }

    private zzyz() {
    }

    public final Object zzd(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzabs.zzF(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဏ\u0001", new Object[]{"zze", "zzf", "zzg"});
        } else if (i12 == 3) {
            return new zzyz();
        } else {
            if (i12 == 4) {
                return new zzyy((zzyx) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
