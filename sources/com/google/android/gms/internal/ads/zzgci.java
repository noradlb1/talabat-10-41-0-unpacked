package com.google.android.gms.internal.ads;

public final class zzgci extends zzgkl<zzgci, zzgch> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzgci zzb;
    /* access modifiers changed from: private */
    public int zze;
    private zzgco zzf;
    /* access modifiers changed from: private */
    public zzgjf zzg = zzgjf.zzb;

    static {
        zzgci zzgci = new zzgci();
        zzb = zzgci;
        zzgkl.zzaK(zzgci.class, zzgci);
    }

    private zzgci() {
    }

    public static zzgch zzc() {
        return (zzgch) zzb.zzat();
    }

    public static zzgci zze() {
        return zzb;
    }

    public static zzgci zzf(zzgjf zzgjf, zzgjx zzgjx) throws zzgkx {
        return (zzgci) zzgkl.zzay(zzb, zzgjf, zzgjx);
    }

    public static /* synthetic */ void zzj(zzgci zzgci, zzgco zzgco) {
        zzgco.getClass();
        zzgci.zzf = zzgco;
    }

    public final int zza() {
        return this.zze;
    }

    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgkl.zzaJ(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zze", "zzf", "zzg"});
        } else if (i12 == 3) {
            return new zzgci();
        } else {
            if (i12 == 4) {
                return new zzgch((zzgcg) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final zzgco zzg() {
        zzgco zzgco = this.zzf;
        return zzgco == null ? zzgco.zze() : zzgco;
    }

    public final zzgjf zzh() {
        return this.zzg;
    }
}
