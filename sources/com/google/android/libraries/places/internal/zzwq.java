package com.google.android.libraries.places.internal;

public final class zzwq extends zzabs<zzwq, zzwp> implements zzada {
    /* access modifiers changed from: private */
    public static final zzwq zzb;
    private int zze;
    private zzna zzf;
    private byte zzg = 2;

    static {
        zzwq zzwq = new zzwq();
        zzb = zzwq;
        zzabs.zzG(zzwq.class, zzwq);
    }

    private zzwq() {
    }

    public final Object zzd(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return Byte.valueOf(this.zzg);
        }
        byte b11 = 1;
        if (i12 == 2) {
            return zzabs.zzF(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0001\u0001ᐉ\u0000", new Object[]{"zze", "zzf"});
        } else if (i12 == 3) {
            return new zzwq();
        } else {
            if (i12 == 4) {
                return new zzwp((zztv) null);
            }
            if (i12 == 5) {
                return zzb;
            }
            if (obj == null) {
                b11 = 0;
            }
            this.zzg = b11;
            return null;
        }
    }
}
