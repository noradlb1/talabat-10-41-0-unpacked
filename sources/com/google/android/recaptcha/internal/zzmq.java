package com.google.android.recaptcha.internal;

public final class zzmq extends zzhf implements zziq {
    /* access modifiers changed from: private */
    public static final zzmq zzb;
    private String zzd = "";
    private String zze = "";
    private int zzf;
    private int zzg;

    static {
        zzmq zzmq = new zzmq();
        zzb = zzmq;
        zzhf.zzC(zzmq.class, zzmq);
    }

    private zzmq() {
    }

    public static zzmq zzg(byte[] bArr) throws zzhp {
        return (zzmq) zzhf.zzu(zzb, bArr);
    }

    public final Object zzh(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzhf.zzz(zzb, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\f\u0004\f", new Object[]{"zzd", "zze", "zzf", "zzg"});
        } else if (i12 == 3) {
            return new zzmq();
        } else {
            if (i12 == 4) {
                return new zzmp((zzmm) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final zzmw zzi() {
        zzmw zzb2 = zzmw.zzb(this.zzf);
        return zzb2 == null ? zzmw.UNRECOGNIZED : zzb2;
    }

    public final String zzj() {
        return this.zzd;
    }

    public final String zzk() {
        return this.zze;
    }
}
