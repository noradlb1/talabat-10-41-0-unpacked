package com.google.android.recaptcha.internal;

public final class zzmu extends zzhf implements zziq {
    /* access modifiers changed from: private */
    public static final zzmu zzb;
    private int zzd;

    static {
        zzmu zzmu = new zzmu();
        zzb = zzmu;
        zzhf.zzC(zzmu.class, zzmu);
    }

    private zzmu() {
    }

    public static zzmu zzg(byte[] bArr) throws zzhp {
        return (zzmu) zzhf.zzu(zzb, bArr);
    }

    public final Object zzh(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzhf.zzz(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f", new Object[]{"zzd"});
        } else if (i12 == 3) {
            return new zzmu();
        } else {
            if (i12 == 4) {
                return new zzmt((zzmm) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final zzmw zzi() {
        zzmw zzb2 = zzmw.zzb(this.zzd);
        return zzb2 == null ? zzmw.UNRECOGNIZED : zzb2;
    }
}
