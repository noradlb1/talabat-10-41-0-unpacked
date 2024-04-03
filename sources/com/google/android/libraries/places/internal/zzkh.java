package com.google.android.libraries.places.internal;

public final class zzkh extends zzabs<zzkh, zzkg> implements zzada {
    /* access modifiers changed from: private */
    public static final zzkh zzb;
    private int zze;
    private zzkb zzf;
    private zzkl zzg;
    private zzkn zzh;
    private zzni zzi;
    private int zzj;

    static {
        zzkh zzkh = new zzkh();
        zzb = zzkh;
        zzabs.zzG(zzkh.class, zzkh);
    }

    private zzkh() {
    }

    public final Object zzd(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzabs.zzF(zzb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဉ\u0003\u0005ဋ\u0004", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
        } else if (i12 == 3) {
            return new zzkh();
        } else {
            if (i12 == 4) {
                return new zzkg((zzjz) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
