package com.google.android.libraries.places.internal;

public final class zzmc extends zzabs<zzmc, zzmb> implements zzada {
    /* access modifiers changed from: private */
    public static final zzmc zzb;
    private int zze;
    private zzabw zzf = zzabs.zzz();
    private zzabw zzg = zzabs.zzz();
    private int zzh;
    private int zzi;
    private long zzj;
    private int zzk;

    static {
        zzmc zzmc = new zzmc();
        zzb = zzmc;
        zzabs.zzG(zzmc.class, zzmc);
    }

    private zzmc() {
    }

    public final Object zzd(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzabs.zzF(zzb, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0002\u0000\u0001\u0016\u0002\u0016\u0003င\u0000\u0004င\u0001\u0005ဂ\u0002\u0006င\u0003", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        } else if (i12 == 3) {
            return new zzmc();
        } else {
            if (i12 == 4) {
                return new zzmb((zzly) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
