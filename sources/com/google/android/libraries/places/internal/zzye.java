package com.google.android.libraries.places.internal;

public final class zzye extends zzabs<zzye, zzyd> implements zzada {
    /* access modifiers changed from: private */
    public static final zzye zzb;
    private int zze;
    private int zzf;
    private String zzg = "";
    private String zzh = "";

    static {
        zzye zzye = new zzye();
        zzb = zzye;
        zzabs.zzG(zzye.class, zzye);
    }

    private zzye() {
    }

    public final Object zzd(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzabs.zzF(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဈ\u0001\u0003ဈ\u0002", new Object[]{"zze", "zzf", zztx.zza, "zzg", "zzh"});
        } else if (i12 == 3) {
            return new zzye();
        } else {
            if (i12 == 4) {
                return new zzyd((zztv) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
