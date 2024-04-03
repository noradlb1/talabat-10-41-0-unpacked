package com.google.android.gms.internal.ads;

public final class zzgdd extends zzgkl<zzgdd, zzgdc> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzgdd zzb;
    /* access modifiers changed from: private */
    public int zze;
    private int zzf;

    static {
        zzgdd zzgdd = new zzgdd();
        zzb = zzgdd;
        zzgkl.zzaK(zzgdd.class, zzgdd);
    }

    private zzgdd() {
    }

    public static zzgdc zzc() {
        return (zzgdc) zzb.zzat();
    }

    public static zzgdd zze(zzgjf zzgjf, zzgjx zzgjx) throws zzgkx {
        return (zzgdd) zzgkl.zzay(zzb, zzgjf, zzgjx);
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
            return zzgkl.zzaJ(zzb, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002\u000b\u0003\u000b", new Object[]{"zze", "zzf"});
        } else if (i12 == 3) {
            return new zzgdd();
        } else {
            if (i12 == 4) {
                return new zzgdc((zzgdb) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
