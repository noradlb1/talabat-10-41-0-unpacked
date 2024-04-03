package com.google.android.recaptcha.internal;

public final class zzgj extends zzhf implements zziq {
    /* access modifiers changed from: private */
    public static final zzgj zzb;
    private int zzd;
    private zzhm zze = zziz.zze();
    private String zzf = "";
    private long zzg;
    private long zzh;
    private double zzi;
    private zzfi zzj = zzfi.zzb;
    private String zzk = "";
    private byte zzl = 2;

    static {
        zzgj zzgj = new zzgj();
        zzb = zzgj;
        zzhf.zzC(zzgj.class, zzgj);
    }

    private zzgj() {
    }

    public final Object zzh(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return Byte.valueOf(this.zzl);
        }
        byte b11 = 1;
        if (i12 == 2) {
            return new zzja(zzb, "\u0001\u0007\u0000\u0001\u0002\b\u0007\u0000\u0001\u0001\u0002Л\u0003ဈ\u0000\u0004ဃ\u0001\u0005ဂ\u0002\u0006က\u0003\u0007ည\u0004\bဈ\u0005", new Object[]{"zzd", "zze", zzgi.class, "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        } else if (i12 == 3) {
            return new zzgj();
        } else {
            if (i12 == 4) {
                return new zzgg((zzfv) null);
            }
            if (i12 == 5) {
                return zzb;
            }
            if (obj == null) {
                b11 = 0;
            }
            this.zzl = b11;
            return null;
        }
    }
}
