package com.google.android.libraries.places.internal;

public final class zzyv extends zzabs<zzyv, zzyt> implements zzada {
    /* access modifiers changed from: private */
    public static final zzyv zzb;
    private int zze;
    private int zzf;
    private zzyg zzg;

    static {
        zzyv zzyv = new zzyv();
        zzb = zzyv;
        zzabs.zzG(zzyv.class, zzyv);
    }

    private zzyv() {
    }

    public final Object zzd(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzabs.zzF(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဉ\u0001", new Object[]{"zze", "zzf", zzyu.zza, "zzg"});
        } else if (i12 == 3) {
            return new zzyv();
        } else {
            if (i12 == 4) {
                return new zzyt((zztv) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
