package com.google.android.libraries.places.internal;

public final class zzmt extends zzabs<zzmt, zzms> implements zzada {
    /* access modifiers changed from: private */
    public static final zzmt zzb;
    private int zze;
    private int zzf = 0;
    private Object zzg;

    static {
        zzmt zzmt = new zzmt();
        zzb = zzmt;
        zzabs.zzG(zzmt.class, zzmt);
    }

    private zzmt() {
    }

    public final Object zzd(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzabs.zzF(zzb, "\u0001\u0003\u0001\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ြ\u0000\u0002ြ\u0000\u0003ြ\u0000", new Object[]{"zzg", "zzf", "zze", zzmx.class, zzmr.class, zzmv.class});
        } else if (i12 == 3) {
            return new zzmt();
        } else {
            if (i12 == 4) {
                return new zzms((zzmp) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
