package com.google.android.libraries.places.internal;

public final class zzvz extends zzabs<zzvz, zzvx> implements zzada {
    /* access modifiers changed from: private */
    public static final zzvz zzb;
    private int zze;
    private int zzf;
    private int zzg;

    static {
        zzvz zzvz = new zzvz();
        zzb = zzvz;
        zzabs.zzG(zzvz.class, zzvz);
    }

    private zzvz() {
    }

    public final Object zzd(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzabs.zzF(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဋ\u0001", new Object[]{"zze", "zzf", zzvy.zza, "zzg"});
        } else if (i12 == 3) {
            return new zzvz();
        } else {
            if (i12 == 4) {
                return new zzvx((zztv) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
