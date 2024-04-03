package com.google.android.libraries.places.internal;

public final class zzky extends zzabs<zzky, zzkw> implements zzada {
    /* access modifiers changed from: private */
    public static final zzky zzb;
    private int zze;
    private int zzf;
    private String zzg = "";

    static {
        zzky zzky = new zzky();
        zzb = zzky;
        zzabs.zzG(zzky.class, zzky);
    }

    private zzky() {
    }

    public final Object zzd(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzabs.zzF(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဈ\u0001", new Object[]{"zze", "zzf", zzkx.zza, "zzg"});
        } else if (i12 == 3) {
            return new zzky();
        } else {
            if (i12 == 4) {
                return new zzkw((zzko) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
