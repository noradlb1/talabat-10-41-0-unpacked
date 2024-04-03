package com.google.android.recaptcha.internal;

public final class zzma extends zzhf implements zziq {
    /* access modifiers changed from: private */
    public static final zzma zzb;
    private String zzd = "";
    private zzld zze;
    private zzkx zzf;
    private zzlg zzg;
    private String zzh = "";
    private String zzi = "";

    static {
        zzma zzma = new zzma();
        zzb = zzma;
        zzhf.zzC(zzma.class, zzma);
    }

    private zzma() {
    }

    public static /* synthetic */ void zzG(zzma zzma, zzkx zzkx) {
        zzkx.getClass();
        zzma.zzf = zzkx;
    }

    public static zzlz zzf() {
        return (zzlz) zzb.zzp();
    }

    public static /* synthetic */ void zzi(zzma zzma, String str) {
        str.getClass();
        zzma.zzd = str;
    }

    public static /* synthetic */ void zzj(zzma zzma, String str) {
        str.getClass();
        zzma.zzh = str;
    }

    public static /* synthetic */ void zzk(zzma zzma, String str) {
        str.getClass();
        zzma.zzi = str;
    }

    public final Object zzh(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzhf.zzz(zzb, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0000\u0000\u0000\u0001Ȉ\u0002\t\u0003\t\u0004\t\u0005Ȉ\u0006Ȉ", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
        } else if (i12 == 3) {
            return new zzma();
        } else {
            if (i12 == 4) {
                return new zzlz((zzly) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
