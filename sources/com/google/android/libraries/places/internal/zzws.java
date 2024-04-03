package com.google.android.libraries.places.internal;

public final class zzws extends zzabs<zzws, zzwr> implements zzada {
    /* access modifiers changed from: private */
    public static final zzws zzb;

    static {
        zzws zzws = new zzws();
        zzb = zzws;
        zzabs.zzG(zzws.class, zzws);
    }

    private zzws() {
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
            return new zzws();
        }
        if (i12 == 4) {
            return new zzwr((zztv) null);
        }
        if (i12 != 5) {
            return null;
        }
        return zzb;
    }
}
