package com.google.android.libraries.places.internal;

public final class zzmv extends zzabs<zzmv, zzmu> implements zzada {
    /* access modifiers changed from: private */
    public static final zzmv zzb;
    private int zze;
    private boolean zzf;
    private long zzg;

    static {
        zzmv zzmv = new zzmv();
        zzb = zzmv;
        zzabs.zzG(zzmv.class, zzmv);
    }

    private zzmv() {
    }

    public final Object zzd(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzabs.zzF(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဃ\u0001", new Object[]{"zze", "zzf", "zzg"});
        } else if (i12 == 3) {
            return new zzmv();
        } else {
            if (i12 == 4) {
                return new zzmu((zzmp) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
