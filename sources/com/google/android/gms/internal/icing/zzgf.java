package com.google.android.gms.internal.icing;

public final class zzgf extends zzda<zzgf, zzge> implements zzef {
    /* access modifiers changed from: private */
    public static final zzgf zzg;
    private int zzb;
    private String zze = "";
    private zzdg<zzgd> zzf = zzda.zzw();

    static {
        zzgf zzgf = new zzgf();
        zzg = zzgf;
        zzda.zzq(zzgf.class, zzgf);
    }

    private zzgf() {
    }

    public static zzge zza() {
        return (zzge) zzg.zzl();
    }

    public static /* synthetic */ void zzc(zzgf zzgf, String str) {
        zzgf.zzb |= 1;
        zzgf.zze = str;
    }

    public static /* synthetic */ void zzd(zzgf zzgf, zzgd zzgd) {
        zzgd.getClass();
        zzdg<zzgd> zzdg = zzgf.zzf;
        if (!zzdg.zza()) {
            zzgf.zzf = zzda.zzx(zzdg);
        }
        zzgf.zzf.add(zzgd);
    }

    public final Object zzf(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzda.zzr(zzg, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b", new Object[]{"zzb", "zze", "zzf", zzgd.class});
        } else if (i12 == 3) {
            return new zzgf();
        } else {
            if (i12 == 4) {
                return new zzge((zzgb) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzg;
        }
    }
}
