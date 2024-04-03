package com.google.android.libraries.places.internal;

public final class zznw extends zzabs<zznw, zznv> implements zzada {
    /* access modifiers changed from: private */
    public static final zznw zzb;
    private int zze;
    private boolean zzf;
    private boolean zzg;
    private int zzh;
    private int zzi;

    static {
        zznw zznw = new zznw();
        zzb = zznw;
        zzabs.zzG(zznw.class, zznw);
    }

    private zznw() {
    }

    public final Object zzd(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzabs.zzF(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001\u0003င\u0002\u0004င\u0003", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi"});
        } else if (i12 == 3) {
            return new zznw();
        } else {
            if (i12 == 4) {
                return new zznv((zzns) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
