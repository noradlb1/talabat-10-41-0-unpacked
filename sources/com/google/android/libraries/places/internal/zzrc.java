package com.google.android.libraries.places.internal;

public final class zzrc extends zzabs<zzrc, zzra> implements zzada {
    /* access modifiers changed from: private */
    public static final zzrc zzb;
    private int zze;
    private String zzf = "";
    private int zzg;
    private long zzh;

    static {
        zzrc zzrc = new zzrc();
        zzb = zzrc;
        zzabs.zzG(zzrc.class, zzrc);
    }

    private zzrc() {
    }

    public final Object zzd(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzabs.zzF(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဌ\u0001\u0003ဂ\u0002", new Object[]{"zze", "zzf", "zzg", zzrb.zza, "zzh"});
        } else if (i12 == 3) {
            return new zzrc();
        } else {
            if (i12 == 4) {
                return new zzra((zzqz) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
