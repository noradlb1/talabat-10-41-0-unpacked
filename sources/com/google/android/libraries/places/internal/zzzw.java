package com.google.android.libraries.places.internal;

public final class zzzw extends zzabs<zzzw, zzzt> implements zzada {
    /* access modifiers changed from: private */
    public static final zzzw zzb;
    private int zze;
    private int zzf = 1;
    private int zzg = 1;
    private int zzh;

    static {
        zzzw zzzw = new zzzw();
        zzb = zzzw;
        zzabs.zzG(zzzw.class, zzzw);
    }

    private zzzw() {
    }

    public final Object zzd(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzabs.zzF(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001\u0003င\u0002", new Object[]{"zze", "zzf", zzzv.zza, "zzg", zzzu.zza, "zzh"});
        } else if (i12 == 3) {
            return new zzzw();
        } else {
            if (i12 == 4) {
                return new zzzt((zzzs) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
