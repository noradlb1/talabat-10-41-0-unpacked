package com.google.android.libraries.places.internal;

public final class zzld extends zzabs<zzld, zzlc> implements zzada {
    /* access modifiers changed from: private */
    public static final zzld zzb;
    private int zze;
    private long zzf;

    static {
        zzld zzld = new zzld();
        zzb = zzld;
        zzabs.zzG(zzld.class, zzld);
    }

    private zzld() {
    }

    public final Object zzd(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzabs.zzF(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဂ\u0000", new Object[]{"zze", "zzf"});
        } else if (i12 == 3) {
            return new zzld();
        } else {
            if (i12 == 4) {
                return new zzlc((zzko) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
