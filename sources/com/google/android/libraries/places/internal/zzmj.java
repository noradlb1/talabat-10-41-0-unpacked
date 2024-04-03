package com.google.android.libraries.places.internal;

public final class zzmj extends zzabs<zzmj, zzmi> implements zzada {
    /* access modifiers changed from: private */
    public static final zzmj zzb;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;

    static {
        zzmj zzmj = new zzmj();
        zzb = zzmj;
        zzabs.zzG(zzmj.class, zzmj);
    }

    private zzmj() {
    }

    public final Object zzd(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzabs.zzF(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002\u0004င\u0003", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi"});
        } else if (i12 == 3) {
            return new zzmj();
        } else {
            if (i12 == 4) {
                return new zzmi((zzmh) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
