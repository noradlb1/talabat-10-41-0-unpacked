package com.google.android.gms.internal.ads;

public final class zzgcf extends zzgkl<zzgcf, zzgce> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzgcf zzb;
    private zzgcl zze;
    private zzgez zzf;

    static {
        zzgcf zzgcf = new zzgcf();
        zzb = zzgcf;
        zzgkl.zzaK(zzgcf.class, zzgcf);
    }

    private zzgcf() {
    }

    public static zzgce zza() {
        return (zzgce) zzb.zzat();
    }

    public static zzgcf zzd(zzgjf zzgjf, zzgjx zzgjx) throws zzgkx {
        return (zzgcf) zzgkl.zzay(zzb, zzgjf, zzgjx);
    }

    public static /* synthetic */ void zzg(zzgcf zzgcf, zzgcl zzgcl) {
        zzgcl.getClass();
        zzgcf.zze = zzgcl;
    }

    public static /* synthetic */ void zzh(zzgcf zzgcf, zzgez zzgez) {
        zzgez.getClass();
        zzgcf.zzf = zzgez;
    }

    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgkl.zzaJ(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\t", new Object[]{"zze", "zzf"});
        } else if (i12 == 3) {
            return new zzgcf();
        } else {
            if (i12 == 4) {
                return new zzgce((zzgcd) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final zzgcl zze() {
        zzgcl zzgcl = this.zze;
        return zzgcl == null ? zzgcl.zze() : zzgcl;
    }

    public final zzgez zzf() {
        zzgez zzgez = this.zzf;
        return zzgez == null ? zzgez.zze() : zzgez;
    }
}
