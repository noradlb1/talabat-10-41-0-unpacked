package com.google.android.libraries.places.internal;

public final class zzaah extends zzabs<zzaah, zzaag> implements zzada {
    /* access modifiers changed from: private */
    public static final zzaah zzb;
    private int zze;
    private int zzf;
    private int zzg;

    static {
        zzaah zzaah = new zzaah();
        zzb = zzaah;
        zzabs.zzG(zzaah.class, zzaah);
    }

    private zzaah() {
    }

    public final Object zzd(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzabs.zzF(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001", new Object[]{"zze", "zzf", "zzg"});
        } else if (i12 == 3) {
            return new zzaah();
        } else {
            if (i12 == 4) {
                return new zzaag((zzaaf) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
