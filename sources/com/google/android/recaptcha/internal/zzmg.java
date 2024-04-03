package com.google.android.recaptcha.internal;

import java.util.List;

public final class zzmg extends zzhf implements zziq {
    /* access modifiers changed from: private */
    public static final zzmg zzb;
    private zzhm zzd = zzhf.zzw();

    static {
        zzmg zzmg = new zzmg();
        zzb = zzmg;
        zzhf.zzC(zzmg.class, zzmg);
    }

    private zzmg() {
    }

    public static zzmg zzg() {
        return zzb;
    }

    public final Object zzh(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzhf.zzz(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001Ț", new Object[]{"zzd"});
        } else if (i12 == 3) {
            return new zzmg();
        } else {
            if (i12 == 4) {
                return new zzmf((zzme) null);
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
