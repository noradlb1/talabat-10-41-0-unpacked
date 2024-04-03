package com.google.android.gms.internal.ads;

public final class zzgfp extends zzgkl<zzgfp, zzgfo> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzgfp zzb;
    private zzgff zze;
    private int zzf;
    private int zzg;
    private int zzh;

    static {
        zzgfp zzgfp = new zzgfp();
        zzb = zzgfp;
        zzgkl.zzaK(zzgfp.class, zzgfp);
    }

    private zzgfp() {
    }

    public final int zza() {
        return this.zzg;
    }

    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgkl.zzaJ(zzb, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\t\u0002\f\u0003\u000b\u0004\f", new Object[]{"zze", "zzf", "zzg", "zzh"});
        } else if (i12 == 3) {
            return new zzgfp();
        } else {
            if (i12 == 4) {
                return new zzgfo((zzgfm) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final zzgff zzc() {
        zzgff zzgff = this.zze;
        return zzgff == null ? zzgff.zzd() : zzgff;
    }

    public final boolean zze() {
        return this.zze != null;
    }

    public final int zzf() {
        int i11 = this.zzf;
        int i12 = 2;
        if (i11 != 0) {
            i12 = i11 != 1 ? i11 != 2 ? i11 != 3 ? 0 : 5 : 4 : 3;
        }
        if (i12 == 0) {
            return 1;
        }
        return i12;
    }

    public final int zzg() {
        int zzb2 = zzggj.zzb(this.zzh);
        if (zzb2 == 0) {
            return 1;
        }
        return zzb2;
    }
}
