package com.google.android.gms.internal.icing;

public final class zzap extends zzda<zzap, zzao> implements zzef {
    /* access modifiers changed from: private */
    public static final zzap zzh;
    private int zzb;
    private String zze = "";
    private String zzf = "";
    private int zzg;

    static {
        zzap zzap = new zzap();
        zzh = zzap;
        zzda.zzq(zzap.class, zzap);
    }

    private zzap() {
    }

    public static zzao zza() {
        return (zzao) zzh.zzl();
    }

    public static /* synthetic */ void zzc(zzap zzap, String str) {
        str.getClass();
        zzap.zzb |= 1;
        zzap.zze = str;
    }

    public static /* synthetic */ void zzd(zzap zzap, String str) {
        str.getClass();
        zzap.zzb |= 2;
        zzap.zzf = str;
    }

    public static /* synthetic */ void zze(zzap zzap, int i11) {
        zzap.zzb |= 4;
        zzap.zzg = i11;
    }

    public final Object zzf(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzda.zzr(zzh, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003င\u0002", new Object[]{"zzb", "zze", "zzf", "zzg"});
        } else if (i12 == 3) {
            return new zzap();
        } else {
            if (i12 == 4) {
                return new zzao((zzam) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzh;
        }
    }
}
