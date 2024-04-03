package com.google.android.gms.internal.icing;

public final class zzaq extends zzda<zzaq, zzan> implements zzef {
    /* access modifiers changed from: private */
    public static final zzaq zze;
    private zzdg<zzap> zzb = zzda.zzw();

    static {
        zzaq zzaq = new zzaq();
        zze = zzaq;
        zzda.zzq(zzaq.class, zzaq);
    }

    private zzaq() {
    }

    public static zzan zza() {
        return (zzan) zze.zzl();
    }

    public static /* synthetic */ void zzc(zzaq zzaq, Iterable iterable) {
        zzdg<zzap> zzdg = zzaq.zzb;
        if (!zzdg.zza()) {
            zzaq.zzb = zzda.zzx(zzdg);
        }
        zzbs.zzk(iterable, zzaq.zzb);
    }

    public final Object zzf(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzda.zzr(zze, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzb", zzap.class});
        } else if (i12 == 3) {
            return new zzaq();
        } else {
            if (i12 == 4) {
                return new zzan((zzam) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zze;
        }
    }
}
