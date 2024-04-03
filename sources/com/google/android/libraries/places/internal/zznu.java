package com.google.android.libraries.places.internal;

public final class zznu extends zzabs<zznu, zznt> implements zzada {
    /* access modifiers changed from: private */
    public static final zznu zzb;
    private int zze;
    private long zzf;
    private long zzg;

    static {
        zznu zznu = new zznu();
        zzb = zznu;
        zzabs.zzG(zznu.class, zznu);
    }

    private zznu() {
    }

    public final Object zzd(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzabs.zzF(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဂ\u0001", new Object[]{"zze", "zzf", "zzg"});
        } else if (i12 == 3) {
            return new zznu();
        } else {
            if (i12 == 4) {
                return new zznt((zzns) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
