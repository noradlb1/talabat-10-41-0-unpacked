package com.google.android.recaptcha.internal;

public final class zzfx extends zzhb {
    /* access modifiers changed from: private */
    public static final zzfx zzd;
    private int zze;
    private boolean zzf;
    private zzgf zzg;
    private zzhm zzh = zziz.zze();
    private byte zzi = 2;

    static {
        zzfx zzfx = new zzfx();
        zzd = zzfx;
        zzhf.zzC(zzfx.class, zzfx);
    }

    private zzfx() {
    }

    public static zzfx zzg() {
        return zzd;
    }

    public final Object zzh(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return Byte.valueOf(this.zzi);
        }
        byte b11 = 1;
        if (i12 == 2) {
            return new zzja(zzd, "\u0001\u0003\u0000\u0001\u0001ϧ\u0003\u0000\u0001\u0002\u0001ဇ\u0000\u0002ᐉ\u0001ϧЛ", new Object[]{"zze", "zzf", "zzg", "zzh", zzgj.class});
        } else if (i12 == 3) {
            return new zzfx();
        } else {
            if (i12 == 4) {
                return new zzfw((zzfv) null);
            }
            if (i12 == 5) {
                return zzd;
            }
            if (obj == null) {
                b11 = 0;
            }
            this.zzi = b11;
            return null;
        }
    }
}
