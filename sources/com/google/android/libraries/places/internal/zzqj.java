package com.google.android.libraries.places.internal;

public final class zzqj extends zzabs<zzqj, zzqg> implements zzada {
    /* access modifiers changed from: private */
    public static final zzqj zzb;
    private int zze;
    private zzabz<zzqi> zzf = zzabs.zzB();
    private long zzg;

    static {
        zzqj zzqj = new zzqj();
        zzb = zzqj;
        zzabs.zzG(zzqj.class, zzqj);
    }

    private zzqj() {
    }

    public final Object zzd(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzabs.zzF(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002ဂ\u0000", new Object[]{"zze", "zzf", zzqi.class, "zzg"});
        } else if (i12 == 3) {
            return new zzqj();
        } else {
            if (i12 == 4) {
                return new zzqg((zzpp) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
