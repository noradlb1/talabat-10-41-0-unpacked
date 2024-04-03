package com.google.android.gms.internal.ads;

public final class zzgeg extends zzgkl<zzgeg, zzgef> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzgeg zzb;
    private zzgep zze;
    private zzgea zzf;
    /* access modifiers changed from: private */
    public int zzg;

    static {
        zzgeg zzgeg = new zzgeg();
        zzb = zzgeg;
        zzgkl.zzaK(zzgeg.class, zzgeg);
    }

    private zzgeg() {
    }

    public static zzgef zzc() {
        return (zzgef) zzb.zzat();
    }

    public static zzgeg zze() {
        return zzb;
    }

    public static /* synthetic */ void zzg(zzgeg zzgeg, zzgep zzgep) {
        zzgep.getClass();
        zzgeg.zze = zzgep;
    }

    public static /* synthetic */ void zzh(zzgeg zzgeg, zzgea zzgea) {
        zzgea.getClass();
        zzgeg.zzf = zzgea;
    }

    public final zzgea zza() {
        zzgea zzgea = this.zzf;
        return zzgea == null ? zzgea.zzd() : zzgea;
    }

    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgkl.zzaJ(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\t\u0003\f", new Object[]{"zze", "zzf", "zzg"});
        } else if (i12 == 3) {
            return new zzgeg();
        } else {
            if (i12 == 4) {
                return new zzgef((zzgee) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final zzgep zzf() {
        zzgep zzgep = this.zze;
        return zzgep == null ? zzgep.zzd() : zzgep;
    }

    public final int zzi() {
        int i11 = this.zzg;
        int i12 = 2;
        if (i11 != 0) {
            i12 = i11 != 1 ? i11 != 2 ? i11 != 3 ? 0 : 5 : 4 : 3;
        }
        if (i12 == 0) {
            return 1;
        }
        return i12;
    }
}
