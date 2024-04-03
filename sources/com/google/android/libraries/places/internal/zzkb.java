package com.google.android.libraries.places.internal;

public final class zzkb extends zzabs<zzkb, zzka> implements zzada {
    /* access modifiers changed from: private */
    public static final zzkb zzb;
    private int zze;
    private zzkj zzf;
    private int zzg;

    static {
        zzkb zzkb = new zzkb();
        zzb = zzkb;
        zzabs.zzG(zzkb.class, zzkb);
    }

    private zzkb() {
    }

    public final Object zzd(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzabs.zzF(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဋ\u0001", new Object[]{"zze", "zzf", "zzg"});
        } else if (i12 == 3) {
            return new zzkb();
        } else {
            if (i12 == 4) {
                return new zzka((zzjz) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
