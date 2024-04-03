package com.google.android.libraries.places.internal;

public final class zzxl extends zzabs<zzxl, zzxj> implements zzada {
    /* access modifiers changed from: private */
    public static final zzxl zzb;
    private int zze;
    private int zzf;
    private int zzg;
    private boolean zzh;

    static {
        zzxl zzxl = new zzxl();
        zzb = zzxl;
        zzabs.zzG(zzxl.class, zzxl);
    }

    private zzxl() {
    }

    public static zzxj zza() {
        return (zzxj) zzb.zzx();
    }

    public static /* synthetic */ void zzc(zzxl zzxl, int i11) {
        zzxl.zzf = 1;
        zzxl.zze = 1 | zzxl.zze;
    }

    public final Object zzd(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzabs.zzF(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002င\u0001\u0003ဇ\u0002", new Object[]{"zze", "zzf", zzxk.zza, "zzg", "zzh"});
        } else if (i12 == 3) {
            return new zzxl();
        } else {
            if (i12 == 4) {
                return new zzxj((zztv) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
