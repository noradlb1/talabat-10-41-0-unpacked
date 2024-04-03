package com.google.android.libraries.places.internal;

public final class zzqt extends zzabs<zzqt, zzqs> implements zzada {
    /* access modifiers changed from: private */
    public static final zzqt zzb;
    private int zze;
    private boolean zzf;
    private boolean zzg;

    static {
        zzqt zzqt = new zzqt();
        zzb = zzqt;
        zzabs.zzG(zzqt.class, zzqt);
    }

    private zzqt() {
    }

    public final Object zzd(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzabs.zzF(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001", new Object[]{"zze", "zzf", "zzg"});
        } else if (i12 == 3) {
            return new zzqt();
        } else {
            if (i12 == 4) {
                return new zzqs((zzpp) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
