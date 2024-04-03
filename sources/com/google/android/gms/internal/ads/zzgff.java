package com.google.android.gms.internal.ads;

public final class zzgff extends zzgkl<zzgff, zzgfe> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzgff zzb;
    /* access modifiers changed from: private */
    public String zze = "";
    /* access modifiers changed from: private */
    public zzgjf zzf = zzgjf.zzb;
    /* access modifiers changed from: private */
    public int zzg;

    static {
        zzgff zzgff = new zzgff();
        zzb = zzgff;
        zzgkl.zzaK(zzgff.class, zzgff);
    }

    private zzgff() {
    }

    public static zzgfe zza() {
        return (zzgfe) zzb.zzat();
    }

    public static zzgff zzd() {
        return zzb;
    }

    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgkl.zzaJ(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zze", "zzf", "zzg"});
        } else if (i12 == 3) {
            return new zzgff();
        } else {
            if (i12 == 4) {
                return new zzgfe((zzgfd) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final zzgjf zze() {
        return this.zzf;
    }

    public final String zzf() {
        return this.zze;
    }

    public final int zzi() {
        int i11 = this.zzg;
        int i12 = 2;
        if (i11 != 0) {
            i12 = i11 != 1 ? i11 != 2 ? i11 != 3 ? i11 != 4 ? 0 : 6 : 5 : 4 : 3;
        }
        if (i12 == 0) {
            return 1;
        }
        return i12;
    }
}
