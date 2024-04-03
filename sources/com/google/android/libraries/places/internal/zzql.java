package com.google.android.libraries.places.internal;

public final class zzql extends zzabs<zzql, zzqk> implements zzada {
    /* access modifiers changed from: private */
    public static final zzql zzb;
    private int zze;
    private zzqj zzf;
    private zzqd zzg;

    static {
        zzql zzql = new zzql();
        zzb = zzql;
        zzabs.zzG(zzql.class, zzql);
    }

    private zzql() {
    }

    public final Object zzd(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzabs.zzF(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"zze", "zzf", "zzg"});
        } else if (i12 == 3) {
            return new zzql();
        } else {
            if (i12 == 4) {
                return new zzqk((zzpp) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
