package com.google.android.libraries.places.internal;

public final class zzmr extends zzabs<zzmr, zzmq> implements zzada {
    /* access modifiers changed from: private */
    public static final zzmr zzb;

    static {
        zzmr zzmr = new zzmr();
        zzb = zzmr;
        zzabs.zzG(zzmr.class, zzmr);
    }

    private zzmr() {
    }

    public final Object zzd(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzabs.zzF(zzb, "\u0001\u0000", (Object[]) null);
        }
        if (i12 == 3) {
            return new zzmr();
        }
        if (i12 == 4) {
            return new zzmq((zzmp) null);
        }
        if (i12 != 5) {
            return null;
        }
        return zzb;
    }
}
