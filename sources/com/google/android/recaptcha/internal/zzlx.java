package com.google.android.recaptcha.internal;

public final class zzlx extends zzhf implements zziq {
    /* access modifiers changed from: private */
    public static final zzlx zzb;
    private zzgn zzd;
    private zzju zze;
    private zzgn zzf;
    private zzju zzg;

    static {
        zzlx zzlx = new zzlx();
        zzb = zzlx;
        zzhf.zzC(zzlx.class, zzlx);
    }

    private zzlx() {
    }

    public static /* synthetic */ void zzG(zzlx zzlx, zzgn zzgn) {
        zzgn.getClass();
        zzlx.zzf = zzgn;
    }

    public static zzlw zzf() {
        return (zzlw) zzb.zzp();
    }

    public static /* synthetic */ void zzi(zzlx zzlx, zzgn zzgn) {
        zzgn.getClass();
        zzlx.zzd = zzgn;
    }

    public static /* synthetic */ void zzj(zzlx zzlx, zzju zzju) {
        zzju.getClass();
        zzlx.zzg = zzju;
    }

    public static /* synthetic */ void zzk(zzlx zzlx, zzju zzju) {
        zzju.getClass();
        zzlx.zze = zzju;
    }

    public final Object zzh(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzhf.zzz(zzb, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\t\u0002\t\u0003\t\u0004\t", new Object[]{"zzd", "zze", "zzf", "zzg"});
        } else if (i12 == 3) {
            return new zzlx();
        } else {
            if (i12 == 4) {
                return new zzlw((zzlv) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
