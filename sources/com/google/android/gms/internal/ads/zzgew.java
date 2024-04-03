package com.google.android.gms.internal.ads;

public final class zzgew extends zzgkl<zzgew, zzgev> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzgew zzb;
    /* access modifiers changed from: private */
    public int zze;
    private zzgfc zzf;
    /* access modifiers changed from: private */
    public zzgjf zzg = zzgjf.zzb;

    static {
        zzgew zzgew = new zzgew();
        zzb = zzgew;
        zzgkl.zzaK(zzgew.class, zzgew);
    }

    private zzgew() {
    }

    public static zzgev zzc() {
        return (zzgev) zzb.zzat();
    }

    public static zzgew zze() {
        return zzb;
    }

    public static zzgew zzf(zzgjf zzgjf, zzgjx zzgjx) throws zzgkx {
        return (zzgew) zzgkl.zzay(zzb, zzgjf, zzgjx);
    }

    public static /* synthetic */ void zzj(zzgew zzgew, zzgfc zzgfc) {
        zzgfc.getClass();
        zzgew.zzf = zzgfc;
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
            return new zzgew();
        } else {
            if (i12 == 4) {
                return new zzgev((zzgeu) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final zzgfc zzg() {
        zzgfc zzgfc = this.zzf;
        return zzgfc == null ? zzgfc.zze() : zzgfc;
    }

    public final zzgjf zzh() {
        return this.zzg;
    }
}
