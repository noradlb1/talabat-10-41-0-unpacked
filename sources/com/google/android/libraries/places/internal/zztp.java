package com.google.android.libraries.places.internal;

public final class zztp extends zzabs<zztp, zztn> implements zzada {
    /* access modifiers changed from: private */
    public static final zztp zzb;
    private int zze;
    private int zzf;
    private long zzg;

    static {
        zztp zztp = new zztp();
        zzb = zztp;
        zzabs.zzG(zztp.class, zztp);
    }

    private zztp() {
    }

    public final Object zzd(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzabs.zzF(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဃ\u0001", new Object[]{"zze", "zzf", zzto.zza, "zzg"});
        } else if (i12 == 3) {
            return new zztp();
        } else {
            if (i12 == 4) {
                return new zztn((zzrg) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
