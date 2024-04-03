package com.google.android.libraries.places.internal;

public final class zzkl extends zzabs<zzkl, zzkk> implements zzada {
    /* access modifiers changed from: private */
    public static final zzkl zzb;
    private int zze;
    private zzkj zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;

    static {
        zzkl zzkl = new zzkl();
        zzb = zzkl;
        zzabs.zzG(zzkl.class, zzkl);
    }

    private zzkl() {
    }

    public final Object zzd(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzabs.zzF(zzb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဋ\u0001\u0003ဋ\u0002\u0004ဋ\u0003\u0005ဋ\u0004", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
        } else if (i12 == 3) {
            return new zzkl();
        } else {
            if (i12 == 4) {
                return new zzkk((zzjz) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
