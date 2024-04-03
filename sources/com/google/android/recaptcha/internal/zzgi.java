package com.google.android.recaptcha.internal;

public final class zzgi extends zzhf implements zziq {
    /* access modifiers changed from: private */
    public static final zzgi zzb;
    private int zzd;
    private String zze = "";
    private boolean zzf;
    private byte zzg = 2;

    static {
        zzgi zzgi = new zzgi();
        zzb = zzgi;
        zzhf.zzC(zzgi.class, zzgi);
    }

    private zzgi() {
    }

    public final Object zzh(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return Byte.valueOf(this.zzg);
        }
        byte b11 = 1;
        if (i12 == 2) {
            return new zzja(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001ᔈ\u0000\u0002ᔇ\u0001", new Object[]{"zzd", "zze", "zzf"});
        } else if (i12 == 3) {
            return new zzgi();
        } else {
            if (i12 == 4) {
                return new zzgh((zzfv) null);
            }
            if (i12 == 5) {
                return zzb;
            }
            if (obj == null) {
                b11 = 0;
            }
            this.zzg = b11;
            return null;
        }
    }
}
