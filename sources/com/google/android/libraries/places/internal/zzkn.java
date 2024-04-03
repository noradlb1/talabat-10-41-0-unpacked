package com.google.android.libraries.places.internal;

public final class zzkn extends zzabs<zzkn, zzkm> implements zzada {
    /* access modifiers changed from: private */
    public static final zzkn zzb;
    private int zze;
    private zzkj zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl;

    static {
        zzkn zzkn = new zzkn();
        zzb = zzkn;
        zzabs.zzG(zzkn.class, zzkn);
    }

    private zzkn() {
    }

    public final Object zzd(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzabs.zzF(zzb, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဋ\u0001\u0003ဋ\u0002\u0004ဋ\u0003\u0005ဋ\u0004\u0006ဋ\u0005\u0007ဋ\u0006", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl"});
        } else if (i12 == 3) {
            return new zzkn();
        } else {
            if (i12 == 4) {
                return new zzkm((zzjz) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
