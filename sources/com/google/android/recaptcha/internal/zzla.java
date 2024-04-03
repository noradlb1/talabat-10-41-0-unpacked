package com.google.android.recaptcha.internal;

public final class zzla extends zzhf implements zziq {
    /* access modifiers changed from: private */
    public static final zzla zzb;
    private String zzd = "";
    private String zze = "";
    /* access modifiers changed from: private */
    public int zzf;
    private String zzg = "";
    /* access modifiers changed from: private */
    public String zzh = "";
    private int zzi;

    static {
        zzla zzla = new zzla();
        zzb = zzla;
        zzhf.zzC(zzla.class, zzla);
    }

    private zzla() {
    }

    public static /* synthetic */ void zzG(zzla zzla, String str) {
        str.getClass();
        zzla.zzd = str;
    }

    public static zzkz zzg() {
        return (zzkz) zzb.zzp();
    }

    public static zzla zzj() {
        return zzb;
    }

    public final int zzf() {
        return this.zzf;
    }

    public final Object zzh(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzhf.zzz(zzb, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0000\u0000\u0000\u0001Ȉ\u0002\u0004\u0003Ȉ\u0004\u0004\u0005Ȉ\u0006Ȉ", new Object[]{"zzd", "zzf", "zzh", "zzi", "zze", "zzg"});
        } else if (i12 == 3) {
            return new zzla();
        } else {
            if (i12 == 4) {
                return new zzkz((zzky) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final String zzk() {
        return this.zzd;
    }
}
