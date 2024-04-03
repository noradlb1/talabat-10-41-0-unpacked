package com.google.android.gms.internal.ads;

public final class zzbbq extends zzgkl<zzbbq, zzbbp> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzbbq zzb;
    private int zze;
    private boolean zzf;
    private boolean zzg;
    private int zzh;

    static {
        zzbbq zzbbq = new zzbbq();
        zzb = zzbbq;
        zzgkl.zzaK(zzbbq.class, zzbbq);
    }

    private zzbbq() {
    }

    public static zzbbp zza() {
        return (zzbbp) zzb.zzat();
    }

    public static /* synthetic */ void zzd(zzbbq zzbbq, boolean z11) {
        zzbbq.zze |= 1;
        zzbbq.zzf = z11;
    }

    public static /* synthetic */ void zze(zzbbq zzbbq, boolean z11) {
        zzbbq.zze |= 2;
        zzbbq.zzg = z11;
    }

    public static /* synthetic */ void zzf(zzbbq zzbbq, int i11) {
        zzbbq.zze |= 4;
        zzbbq.zzh = i11;
    }

    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgkl.zzaJ(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဋ\u0002", new Object[]{"zze", "zzf", "zzg", "zzh"});
        } else if (i12 == 3) {
            return new zzbbq();
        } else {
            if (i12 == 4) {
                return new zzbbp((zzbbd) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
