package com.google.android.libraries.places.internal;

public final class zzmm extends zzabs<zzmm, zzmk> implements zzada {
    /* access modifiers changed from: private */
    public static final zzmm zzb;
    private int zze;
    private int zzf = 1;
    private zzmo zzg;
    private zzmj zzh;

    static {
        zzmm zzmm = new zzmm();
        zzb = zzmm;
        zzabs.zzG(zzmm.class, zzmm);
    }

    private zzmm() {
    }

    public final Object zzd(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzabs.zzF(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zze", "zzf", zzml.zza, "zzg", "zzh"});
        } else if (i12 == 3) {
            return new zzmm();
        } else {
            if (i12 == 4) {
                return new zzmk((zzmh) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
