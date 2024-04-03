package com.google.android.recaptcha.internal;

import java.io.IOException;
import java.io.InputStream;

public final class zzmi extends zzhf implements zziq {
    /* access modifiers changed from: private */
    public static final zzmi zzb;
    private zzmg zzd;
    private zzmg zze;

    static {
        zzmi zzmi = new zzmi();
        zzb = zzmi;
        zzhf.zzC(zzmi.class, zzmi);
    }

    private zzmi() {
    }

    public static zzmi zzj(InputStream inputStream) throws IOException {
        return (zzmi) zzhf.zzt(zzb, inputStream);
    }

    public final zzmg zzf() {
        zzmg zzmg = this.zzd;
        return zzmg == null ? zzmg.zzg() : zzmg;
    }

    public final zzmg zzg() {
        zzmg zzmg = this.zze;
        return zzmg == null ? zzmg.zzg() : zzmg;
    }

    public final Object zzh(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzhf.zzz(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\t", new Object[]{"zzd", "zze"});
        } else if (i12 == 3) {
            return new zzmi();
        } else {
            if (i12 == 4) {
                return new zzmh((zzme) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
