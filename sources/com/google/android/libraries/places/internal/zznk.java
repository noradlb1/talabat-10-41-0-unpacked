package com.google.android.libraries.places.internal;

public final class zznk extends zzabs<zznk, zznj> implements zzada {
    /* access modifiers changed from: private */
    public static final zznk zzb;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;

    static {
        zznk zznk = new zznk();
        zzb = zznk;
        zzabs.zzG(zznk.class, zznk);
    }

    private zznk() {
    }

    public final Object zzd(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzabs.zzF(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဋ\u0000\u0002ဋ\u0001\u0003ဋ\u0002", new Object[]{"zze", "zzf", "zzg", "zzh"});
        } else if (i12 == 3) {
            return new zznk();
        } else {
            if (i12 == 4) {
                return new zznj((zznd) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
