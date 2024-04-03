package com.google.android.libraries.places.internal;

public final class zzlt extends zzabs<zzlt, zzlr> implements zzada {
    /* access modifiers changed from: private */
    public static final zzlt zzb;
    private int zze;
    private int zzf = 1;
    private zzlv zzg;
    private zzlx zzh;
    private zzaae zzi;
    private byte zzj = 2;

    static {
        zzlt zzlt = new zzlt();
        zzb = zzlt;
        zzabs.zzG(zzlt.class, zzlt);
    }

    private zzlt() {
    }

    public final Object zzd(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return Byte.valueOf(this.zzj);
        }
        byte b11 = 1;
        if (i12 == 2) {
            return zzabs.zzF(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0001\u0001ဌ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ᐉ\u0003", new Object[]{"zze", "zzf", zzls.zza, "zzg", "zzh", "zzi"});
        } else if (i12 == 3) {
            return new zzlt();
        } else {
            if (i12 == 4) {
                return new zzlr((zzlq) null);
            }
            if (i12 == 5) {
                return zzb;
            }
            if (obj == null) {
                b11 = 0;
            }
            this.zzj = b11;
            return null;
        }
    }
}
