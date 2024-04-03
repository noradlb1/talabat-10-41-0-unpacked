package com.google.android.libraries.places.internal;

public final class zzod extends zzabs<zzod, zzoc> implements zzada {
    /* access modifiers changed from: private */
    public static final zzod zzb;
    private int zze;
    private zzjy zzf;
    private long zzg;
    private long zzh;

    static {
        zzod zzod = new zzod();
        zzb = zzod;
        zzabs.zzG(zzod.class, zzod);
    }

    private zzod() {
    }

    public final Object zzd(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzabs.zzF(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဂ\u0001\u0003ဂ\u0002", new Object[]{"zze", "zzf", "zzg", "zzh"});
        } else if (i12 == 3) {
            return new zzod();
        } else {
            if (i12 == 4) {
                return new zzoc((zzns) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
