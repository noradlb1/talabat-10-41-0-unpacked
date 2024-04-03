package com.google.android.libraries.places.internal;

public final class zzzr extends zzabs<zzzr, zzzq> implements zzada {
    /* access modifiers changed from: private */
    public static final zzzr zzb;
    private int zze;
    private zzaah zzf;
    private zzaah zzg;
    private zzaah zzh;

    static {
        zzzr zzzr = new zzzr();
        zzb = zzzr;
        zzabs.zzG(zzzr.class, zzzr);
    }

    private zzzr() {
    }

    public final Object zzd(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzabs.zzF(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zze", "zzf", "zzg", "zzh"});
        } else if (i12 == 3) {
            return new zzzr();
        } else {
            if (i12 == 4) {
                return new zzzq((zzzp) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
