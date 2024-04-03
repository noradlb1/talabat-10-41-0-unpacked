package com.google.android.gms.internal.ads;

public final class zzgcc extends zzgkl<zzgcc, zzgcb> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzgcc zzb;
    /* access modifiers changed from: private */
    public int zze;
    private zzgci zzf;
    private zzgew zzg;

    static {
        zzgcc zzgcc = new zzgcc();
        zzb = zzgcc;
        zzgkl.zzaK(zzgcc.class, zzgcc);
    }

    private zzgcc() {
    }

    public static zzgcb zzc() {
        return (zzgcb) zzb.zzat();
    }

    public static zzgcc zze(zzgjf zzgjf, zzgjx zzgjx) throws zzgkx {
        return (zzgcc) zzgkl.zzay(zzb, zzgjf, zzgjx);
    }

    public static /* synthetic */ void zzi(zzgcc zzgcc, zzgci zzgci) {
        zzgci.getClass();
        zzgcc.zzf = zzgci;
    }

    public static /* synthetic */ void zzj(zzgcc zzgcc, zzgew zzgew) {
        zzgew.getClass();
        zzgcc.zzg = zzgew;
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
            return zzgkl.zzaJ(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\t", new Object[]{"zze", "zzf", "zzg"});
        } else if (i12 == 3) {
            return new zzgcc();
        } else {
            if (i12 == 4) {
                return new zzgcb((zzgca) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final zzgci zzf() {
        zzgci zzgci = this.zzf;
        return zzgci == null ? zzgci.zze() : zzgci;
    }

    public final zzgew zzg() {
        zzgew zzgew = this.zzg;
        return zzgew == null ? zzgew.zze() : zzgew;
    }
}
