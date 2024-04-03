package com.google.android.libraries.places.internal;

public final class zznp extends zzabs<zznp, zznn> implements zzada {
    /* access modifiers changed from: private */
    public static final zznp zzb;
    private int zze;
    private int zzf;

    static {
        zznp zznp = new zznp();
        zzb = zznp;
        zzabs.zzG(zznp.class, zznp);
    }

    private zznp() {
    }

    public final Object zzd(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzabs.zzF(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဌ\u0000", new Object[]{"zze", "zzf", zzno.zza});
        } else if (i12 == 3) {
            return new zznp();
        } else {
            if (i12 == 4) {
                return new zznn((zznd) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
