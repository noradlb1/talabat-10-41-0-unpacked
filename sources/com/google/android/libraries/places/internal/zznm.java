package com.google.android.libraries.places.internal;

public final class zznm extends zzabs<zznm, zznl> implements zzada {
    /* access modifiers changed from: private */
    public static final zznm zzb;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;

    static {
        zznm zznm = new zznm();
        zzb = zznm;
        zzabs.zzG(zznm.class, zznm);
    }

    private zznm() {
    }

    public final Object zzd(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzabs.zzF(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002", new Object[]{"zze", "zzf", "zzg", "zzh"});
        } else if (i12 == 3) {
            return new zznm();
        } else {
            if (i12 == 4) {
                return new zznl((zznd) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
