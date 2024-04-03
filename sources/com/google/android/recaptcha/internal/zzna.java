package com.google.android.recaptcha.internal;

import java.util.List;

public final class zzna extends zzhf implements zziq {
    /* access modifiers changed from: private */
    public static final zzna zzb;
    private zzhm zzd = zzhf.zzw();

    static {
        zzna zzna = new zzna();
        zzb = zzna;
        zzhf.zzC(zzna.class, zzna);
    }

    private zzna() {
    }

    public static zzna zzg(byte[] bArr) throws zzhp {
        return (zzna) zzhf.zzu(zzb, bArr);
    }

    public final Object zzh(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzhf.zzz(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzd", zznm.class});
        } else if (i12 == 3) {
            return new zzna();
        } else {
            if (i12 == 4) {
                return new zzmz((zzmm) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final List zzi() {
        return this.zzd;
    }
}
