package com.google.android.recaptcha.internal;

public final class zzlg extends zzhf implements zziq {
    /* access modifiers changed from: private */
    public static final zzlg zzb;
    private String zzd = "";
    private String zze = "";

    static {
        zzlg zzlg = new zzlg();
        zzb = zzlg;
        zzhf.zzC(zzlg.class, zzlg);
    }

    private zzlg() {
    }

    public final Object zzh(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzhf.zzz(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"zzd", "zze"});
        } else if (i12 == 3) {
            return new zzlg();
        } else {
            if (i12 == 4) {
                return new zzlf((zzle) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
