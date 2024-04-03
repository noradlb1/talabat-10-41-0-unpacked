package com.google.android.libraries.places.internal;

public final class zzna extends zzabs<zzna, zzmz> implements zzada {
    /* access modifiers changed from: private */
    public static final zzna zzb;
    private int zze;
    private int zzf;
    private int zzg;
    private byte zzh = 2;

    static {
        zzna zzna = new zzna();
        zzb = zzna;
        zzabs.zzG(zzna.class, zzna);
    }

    private zzna() {
    }

    public final Object zzd(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return Byte.valueOf(this.zzh);
        }
        byte b11 = 1;
        if (i12 == 2) {
            return zzabs.zzF(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001ᔆ\u0000\u0002ᔆ\u0001", new Object[]{"zze", "zzf", "zzg"});
        } else if (i12 == 3) {
            return new zzna();
        } else {
            if (i12 == 4) {
                return new zzmz((zzmy) null);
            }
            if (i12 == 5) {
                return zzb;
            }
            if (obj == null) {
                b11 = 0;
            }
            this.zzh = b11;
            return null;
        }
    }
}
