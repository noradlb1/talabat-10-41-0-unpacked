package com.google.android.recaptcha.internal;

public final class zzmy extends zzhf implements zziq {
    /* access modifiers changed from: private */
    public static final zzmy zzb;
    private int zzd = 0;
    private Object zze;

    static {
        zzmy zzmy = new zzmy();
        zzb = zzmy;
        zzhf.zzC(zzmy.class, zzmy);
    }

    private zzmy() {
    }

    public static /* synthetic */ void zzG(zzmy zzmy, zzlo zzlo) {
        zzlo.getClass();
        zzmy.zze = zzlo;
        zzmy.zzd = 1;
    }

    public static zzmx zzi() {
        return (zzmx) zzb.zzp();
    }

    public static zzmy zzk(byte[] bArr) throws zzhp {
        return (zzmy) zzhf.zzu(zzb, bArr);
    }

    public final int zzH() {
        int i11 = this.zzd;
        if (i11 == 0) {
            return 3;
        }
        int i12 = 1;
        if (i11 != 1) {
            i12 = 2;
            if (i11 != 2) {
                return 0;
            }
        }
        return i12;
    }

    public final zzlo zzf() {
        if (this.zzd == 1) {
            return (zzlo) this.zze;
        }
        return zzlo.zzG();
    }

    public final zzmd zzg() {
        if (this.zzd == 2) {
            return (zzmd) this.zze;
        }
        return zzmd.zzg();
    }

    public final Object zzh(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzhf.zzz(zzb, "\u0000\u0002\u0001\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000", new Object[]{"zze", "zzd", zzlo.class, zzmd.class});
        } else if (i12 == 3) {
            return new zzmy();
        } else {
            if (i12 == 4) {
                return new zzmx((zzmm) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
