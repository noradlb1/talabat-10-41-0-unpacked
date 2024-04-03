package com.google.android.gms.internal.ads;

public final class zzgcl extends zzgkl<zzgcl, zzgck> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzgcl zzb;
    private zzgco zze;
    /* access modifiers changed from: private */
    public int zzf;

    static {
        zzgcl zzgcl = new zzgcl();
        zzb = zzgcl;
        zzgkl.zzaK(zzgcl.class, zzgcl);
    }

    private zzgcl() {
    }

    public static zzgck zzc() {
        return (zzgck) zzb.zzat();
    }

    public static zzgcl zze() {
        return zzb;
    }

    public static zzgcl zzf(zzgjf zzgjf, zzgjx zzgjx) throws zzgkx {
        return (zzgcl) zzgkl.zzay(zzb, zzgjf, zzgjx);
    }

    public static /* synthetic */ void zzh(zzgcl zzgcl, zzgco zzgco) {
        zzgco.getClass();
        zzgcl.zze = zzgco;
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
            return zzgkl.zzaJ(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\u000b", new Object[]{"zze", "zzf"});
        } else if (i12 == 3) {
            return new zzgcl();
        } else {
            if (i12 == 4) {
                return new zzgck((zzgcj) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final zzgco zzg() {
        zzgco zzgco = this.zze;
        return zzgco == null ? zzgco.zze() : zzgco;
    }
}
