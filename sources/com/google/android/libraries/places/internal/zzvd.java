package com.google.android.libraries.places.internal;

public final class zzvd extends zzabs<zzvd, zzvb> implements zzada {
    /* access modifiers changed from: private */
    public static final zzvd zzb;
    private int zze;
    private String zzf = "";
    private String zzg = "";
    private int zzh;

    static {
        zzvd zzvd = new zzvd();
        zzb = zzvd;
        zzabs.zzG(zzvd.class, zzvd);
    }

    private zzvd() {
    }

    public final Object zzd(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzabs.zzF(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဌ\u0002", new Object[]{"zze", "zzf", "zzg", "zzh", zzvc.zza});
        } else if (i12 == 3) {
            return new zzvd();
        } else {
            if (i12 == 4) {
                return new zzvb((zztv) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
