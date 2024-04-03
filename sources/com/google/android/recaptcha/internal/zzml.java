package com.google.android.recaptcha.internal;

public final class zzml extends zzhf implements zziq {
    /* access modifiers changed from: private */
    public static final zzml zzb;
    private int zzd = 0;
    private Object zze;

    static {
        zzml zzml = new zzml();
        zzb = zzml;
        zzhf.zzC(zzml.class, zzml);
    }

    private zzml() {
    }

    public final Object zzh(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzhf.zzz(zzb, "\u0000\u0018\u0001\u0000\u0001\u0018\u0018\u0000\u0000\u0000\u0001?\u0000\u0002?\u0000\u0003?\u0000\u0004?\u0000\u0005?\u0000\u0006?\u0000\u0007?\u0000\b?\u0000\t?\u0000\n?\u0000\u000b?\u0000\f?\u0000\r?\u0000\u000e?\u0000\u000f?\u0000\u0010?\u0000\u0011?\u0000\u0012?\u0000\u0013?\u0000\u0014?\u0000\u0015?\u0000\u0016?\u0000\u0017?\u0000\u0018?\u0000", new Object[]{"zze", "zzd"});
        } else if (i12 == 3) {
            return new zzml();
        } else {
            if (i12 == 4) {
                return new zzmk((zzmj) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
