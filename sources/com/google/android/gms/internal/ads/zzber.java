package com.google.android.gms.internal.ads;

public final class zzber extends zzgkl<zzber, zzbeq> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzber zzb;
    private int zze;
    private boolean zzf;
    private int zzg;

    static {
        zzber zzber = new zzber();
        zzb = zzber;
        zzgkl.zzaK(zzber.class, zzber);
    }

    private zzber() {
    }

    public static zzbeq zza() {
        return (zzbeq) zzb.zzat();
    }

    public static /* synthetic */ void zzd(zzber zzber, boolean z11) {
        zzber.zze |= 1;
        zzber.zzf = z11;
    }

    public static /* synthetic */ void zze(zzber zzber, int i11) {
        zzber.zze |= 2;
        zzber.zzg = i11;
    }

    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgkl.zzaJ(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဇ\u0000\u0002င\u0001", new Object[]{"zze", "zzf", "zzg"});
        } else if (i12 == 3) {
            return new zzber();
        } else {
            if (i12 == 4) {
                return new zzbeq((zzbbd) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final boolean zzf() {
        return this.zzf;
    }
}
