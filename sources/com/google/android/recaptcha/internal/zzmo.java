package com.google.android.recaptcha.internal;

public final class zzmo extends zzhf implements zziq {
    /* access modifiers changed from: private */
    public static final zzmo zzb;
    private String zzd = "";
    private String zze = "";
    private String zzf = "";

    static {
        zzmo zzmo = new zzmo();
        zzb = zzmo;
        zzhf.zzC(zzmo.class, zzmo);
    }

    private zzmo() {
    }

    public final Object zzh(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzhf.zzz(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ", new Object[]{"zzd", "zze", "zzf"});
        } else if (i12 == 3) {
            return new zzmo();
        } else {
            if (i12 == 4) {
                return new zzmn((zzmm) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
