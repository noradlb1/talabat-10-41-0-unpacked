package com.google.android.libraries.places.internal;

public final class zzsm extends zzabs<zzsm, zzsl> implements zzada {
    /* access modifiers changed from: private */
    public static final zzsm zzb;
    private int zze;
    private int zzf;

    static {
        zzsm zzsm = new zzsm();
        zzb = zzsm;
        zzabs.zzG(zzsm.class, zzsm);
    }

    private zzsm() {
    }

    public final Object zzd(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzabs.zzF(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001င\u0000", new Object[]{"zze", "zzf"});
        } else if (i12 == 3) {
            return new zzsm();
        } else {
            if (i12 == 4) {
                return new zzsl((zzrg) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
