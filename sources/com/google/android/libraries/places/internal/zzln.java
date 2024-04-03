package com.google.android.libraries.places.internal;

public final class zzln extends zzabs<zzln, zzli> implements zzada {
    /* access modifiers changed from: private */
    public static final zzln zzb;
    private int zze;
    private int zzf;
    private zzlm zzg;

    static {
        zzln zzln = new zzln();
        zzb = zzln;
        zzabs.zzG(zzln.class, zzln);
    }

    private zzln() {
    }

    public final Object zzd(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzabs.zzF(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဉ\u0001", new Object[]{"zze", "zzf", zzlj.zza, "zzg"});
        } else if (i12 == 3) {
            return new zzln();
        } else {
            if (i12 == 4) {
                return new zzli((zzlh) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
