package com.google.android.recaptcha.internal;

public final class zzlu extends zzhf implements zziq {
    /* access modifiers changed from: private */
    public static final zzlu zzb;
    private int zzd = 0;
    private Object zze;
    private zzlx zzf;
    private int zzg;
    private zzla zzh;
    private zzlj zzi;

    static {
        zzlu zzlu = new zzlu();
        zzb = zzlu;
        zzhf.zzC(zzlu.class, zzlu);
    }

    private zzlu() {
    }

    public final Object zzh(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzhf.zzz(zzb, "\u0000\u001c\u0001\u0000\u0001\u001c\u001c\u0000\u0000\u0000\u0001\t\u0002\f\u0003\t\u0004?\u0000\u0005?\u0000\u0006?\u0000\u0007?\u0000\b?\u0000\t?\u0000\n?\u0000\u000b?\u0000\f?\u0000\r?\u0000\u000e?\u0000\u000f?\u0000\u0010?\u0000\u0011?\u0000\u0012?\u0000\u0013?\u0000\u0014?\u0000\u0015?\u0000\u0016?\u0000\u0017?\u0000\u0018?\u0000\u0019\t\u001a?\u0000\u001b?\u0000\u001c?\u0000", new Object[]{"zze", "zzd", "zzf", "zzg", "zzh", "zzi"});
        } else if (i12 == 3) {
            return new zzlu();
        } else {
            if (i12 == 4) {
                return new zzlt((zzls) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
