package com.google.android.gms.internal.ads;

public final class zzgep extends zzgkl<zzgep, zzgeo> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzgep zzb;
    /* access modifiers changed from: private */
    public int zze;
    /* access modifiers changed from: private */
    public int zzf;
    /* access modifiers changed from: private */
    public zzgjf zzg = zzgjf.zzb;

    static {
        zzgep zzgep = new zzgep();
        zzb = zzgep;
        zzgkl.zzaK(zzgep.class, zzgep);
    }

    private zzgep() {
    }

    public static zzgeo zza() {
        return (zzgeo) zzb.zzat();
    }

    public static zzgep zzd() {
        return zzb;
    }

    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgkl.zzaJ(zzb, "\u0000\u0003\u0000\u0000\u0001\u000b\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u000b\n", new Object[]{"zze", "zzf", "zzg"});
        } else if (i12 == 3) {
            return new zzgep();
        } else {
            if (i12 == 4) {
                return new zzgeo((zzgen) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final zzgjf zze() {
        return this.zzg;
    }

    public final int zzg() {
        int i11 = this.zze;
        int i12 = 2;
        if (i11 != 0) {
            i12 = i11 != 2 ? i11 != 3 ? i11 != 4 ? i11 != 5 ? 0 : 7 : 6 : 5 : 4;
        }
        if (i12 == 0) {
            return 1;
        }
        return i12;
    }

    public final int zzh() {
        int zzb2 = zzget.zzb(this.zzf);
        if (zzb2 == 0) {
            return 1;
        }
        return zzb2;
    }
}
