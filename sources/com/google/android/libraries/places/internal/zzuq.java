package com.google.android.libraries.places.internal;

public final class zzuq extends zzabs<zzuq, zzup> implements zzada {
    /* access modifiers changed from: private */
    public static final zzuq zzb;
    private int zze;
    private String zzf = "";
    private String zzg = "";

    static {
        zzuq zzuq = new zzuq();
        zzb = zzuq;
        zzabs.zzG(zzuq.class, zzuq);
    }

    private zzuq() {
    }

    public final Object zzd(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzabs.zzF(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zze", "zzf", "zzg"});
        } else if (i12 == 3) {
            return new zzuq();
        } else {
            if (i12 == 4) {
                return new zzup((zztv) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
