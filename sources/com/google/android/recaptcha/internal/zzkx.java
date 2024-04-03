package com.google.android.recaptcha.internal;

public final class zzkx extends zzhf implements zziq {
    private static final zzhl zzb = new zzkv();
    /* access modifiers changed from: private */
    public static final zzkx zzd;
    /* access modifiers changed from: private */
    public int zze;
    private String zzf = "";
    /* access modifiers changed from: private */
    public String zzg = "";
    private String zzh = "";
    private String zzi = "";
    private String zzj = "";
    private zzhk zzk = zzhf.zzv();

    static {
        zzkx zzkx = new zzkx();
        zzd = zzkx;
        zzhf.zzC(zzkx.class, zzkx);
    }

    private zzkx() {
    }

    public static /* synthetic */ void zzG(zzkx zzkx, String str) {
        str.getClass();
        zzkx.zzf = str;
    }

    public static /* synthetic */ void zzI(zzkx zzkx, String str) {
        str.getClass();
        zzkx.zzh = str;
    }

    public static zzkw zzf() {
        return (zzkw) zzd.zzp();
    }

    public static /* synthetic */ void zzj(zzkx zzkx, String str) {
        str.getClass();
        zzkx.zzi = str;
    }

    public static /* synthetic */ void zzk(zzkx zzkx, String str) {
        str.getClass();
        zzkx.zzj = str;
    }

    public final Object zzh(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzhf.zzz(zzd, "\u0000\u0007\u0000\u0000\u0001\u0007\u0007\u0000\u0001\u0000\u0001\u0004\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006Ȉ\u0007,", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        } else if (i12 == 3) {
            return new zzkx();
        } else {
            if (i12 == 4) {
                return new zzkw((zzkv) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzd;
        }
    }
}
