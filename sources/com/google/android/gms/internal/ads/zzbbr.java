package com.google.android.gms.internal.ads;

public final class zzbbr extends zzgkl<zzbbr, zzbbl> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzbbr zzb;
    private zzgku<zzbbk> zze = zzgkl.zzaE();

    static {
        zzbbr zzbbr = new zzbbr();
        zzb = zzbbr;
        zzgkl.zzaK(zzbbr.class, zzbbr);
    }

    private zzbbr() {
    }

    public static zzbbl zza() {
        return (zzbbl) zzb.zzat();
    }

    public static /* synthetic */ void zzd(zzbbr zzbbr, zzbbk zzbbk) {
        zzbbk.getClass();
        zzgku<zzbbk> zzgku = zzbbr.zze;
        if (!zzgku.zzc()) {
            zzbbr.zze = zzgkl.zzaF(zzgku);
        }
        zzbbr.zze.add(zzbbk);
    }

    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgkl.zzaJ(zzb, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zze", zzbbk.class});
        } else if (i12 == 3) {
            return new zzbbr();
        } else {
            if (i12 == 4) {
                return new zzbbl((zzbbd) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
