package com.google.android.libraries.places.internal;

public final class zzkj extends zzabs<zzkj, zzki> implements zzada {
    /* access modifiers changed from: private */
    public static final zzkj zzb;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;

    static {
        zzkj zzkj = new zzkj();
        zzb = zzkj;
        zzabs.zzG(zzkj.class, zzkj);
    }

    private zzkj() {
    }

    public final Object zzd(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzabs.zzF(zzb, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဋ\u0000\u0002ဋ\u0001\u0003ဋ\u0002\u0004ဋ\u0003\u0005ဋ\u0004\u0006ဋ\u0005", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        } else if (i12 == 3) {
            return new zzkj();
        } else {
            if (i12 == 4) {
                return new zzki((zzjz) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
