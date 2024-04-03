package com.google.android.libraries.places.internal;

public final class zznf extends zzabs<zznf, zzne> implements zzada {
    /* access modifiers changed from: private */
    public static final zznf zzb;
    private int zze;
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl;

    static {
        zznf zznf = new zznf();
        zzb = zznf;
        zzabs.zzG(zznf.class, zznf);
    }

    private zznf() {
    }

    public final Object zzd(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzabs.zzF(zzb, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဋ\u0003\u0005ဋ\u0004\u0006ဋ\u0005\u0007ဋ\u0006", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl"});
        } else if (i12 == 3) {
            return new zznf();
        } else {
            if (i12 == 4) {
                return new zzne((zznd) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
