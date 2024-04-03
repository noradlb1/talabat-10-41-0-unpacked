package com.google.android.libraries.places.internal;

public final class zzkd extends zzabs<zzkd, zzkc> implements zzada {
    /* access modifiers changed from: private */
    public static final zzkd zzb;
    private int zze;
    private zzkh zzf;
    private zzkf zzg;

    static {
        zzkd zzkd = new zzkd();
        zzb = zzkd;
        zzabs.zzG(zzkd.class, zzkd);
    }

    private zzkd() {
    }

    public final Object zzd(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzabs.zzF(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"zze", "zzf", "zzg"});
        } else if (i12 == 3) {
            return new zzkd();
        } else {
            if (i12 == 4) {
                return new zzkc((zzjz) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
