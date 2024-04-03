package com.google.android.gms.internal.ads;

public final class zzgfc extends zzgkl<zzgfc, zzgfb> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzgfc zzb;
    /* access modifiers changed from: private */
    public int zze;
    /* access modifiers changed from: private */
    public int zzf;

    static {
        zzgfc zzgfc = new zzgfc();
        zzb = zzgfc;
        zzgkl.zzaK(zzgfc.class, zzgfc);
    }

    private zzgfc() {
    }

    public static zzgfb zzc() {
        return (zzgfb) zzb.zzat();
    }

    public static zzgfc zze() {
        return zzb;
    }

    public final int zza() {
        return this.zzf;
    }

    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgkl.zzaJ(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002\u000b", new Object[]{"zze", "zzf"});
        } else if (i12 == 3) {
            return new zzgfc();
        } else {
            if (i12 == 4) {
                return new zzgfb((zzgfa) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final int zzg() {
        int zzb2 = zzget.zzb(this.zze);
        if (zzb2 == 0) {
            return 1;
        }
        return zzb2;
    }
}
