package com.google.android.libraries.places.internal;

public final class zznr extends zzabs<zznr, zznq> implements zzada {
    /* access modifiers changed from: private */
    public static final zznr zzb;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl;
    private int zzm;
    private int zzn;

    static {
        zznr zznr = new zznr();
        zzb = zznr;
        zzabs.zzG(zznr.class, zznr);
    }

    private zznr() {
    }

    public final Object zzd(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzabs.zzF(zzb, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0000\u0000\u0001ဋ\u0000\u0002ဋ\u0001\u0003ဋ\u0002\u0004ဋ\u0003\u0005ဋ\u0004\u0006ဋ\u0005\u0007ဋ\u0006\bဋ\u0007\tဋ\b", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn"});
        } else if (i12 == 3) {
            return new zznr();
        } else {
            if (i12 == 4) {
                return new zznq((zznd) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
