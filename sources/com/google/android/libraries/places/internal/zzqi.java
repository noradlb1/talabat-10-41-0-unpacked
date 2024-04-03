package com.google.android.libraries.places.internal;

public final class zzqi extends zzabs<zzqi, zzqh> implements zzada {
    /* access modifiers changed from: private */
    public static final zzqi zzb;
    private int zze;
    private int zzf;
    private long zzg;

    static {
        zzqi zzqi = new zzqi();
        zzb = zzqi;
        zzabs.zzG(zzqi.class, zzqi);
    }

    private zzqi() {
    }

    public final Object zzd(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzabs.zzF(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဂ\u0001", new Object[]{"zze", "zzf", zzqm.zza, "zzg"});
        } else if (i12 == 3) {
            return new zzqi();
        } else {
            if (i12 == 4) {
                return new zzqh((zzpp) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
