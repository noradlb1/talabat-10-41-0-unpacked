package com.google.android.libraries.places.internal;

public final class zzua extends zzabs<zzua, zzty> implements zzada {
    /* access modifiers changed from: private */
    public static final zzua zzb;
    private int zze;
    private String zzf = "";
    private int zzg;

    static {
        zzua zzua = new zzua();
        zzb = zzua;
        zzabs.zzG(zzua.class, zzua);
    }

    private zzua() {
    }

    public final Object zzd(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzabs.zzF(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဌ\u0001", new Object[]{"zze", "zzf", "zzg", zztz.zza});
        } else if (i12 == 3) {
            return new zzua();
        } else {
            if (i12 == 4) {
                return new zzty((zztv) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
