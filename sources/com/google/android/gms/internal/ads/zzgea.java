package com.google.android.gms.internal.ads;

public final class zzgea extends zzgkl<zzgea, zzgdz> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzgea zzb;
    private zzgfi zze;

    static {
        zzgea zzgea = new zzgea();
        zzb = zzgea;
        zzgkl.zzaK(zzgea.class, zzgea);
    }

    private zzgea() {
    }

    public static zzgdz zza() {
        return (zzgdz) zzb.zzat();
    }

    public static zzgea zzd() {
        return zzb;
    }

    public static /* synthetic */ void zzf(zzgea zzgea, zzgfi zzgfi) {
        zzgfi.getClass();
        zzgea.zze = zzgfi;
    }

    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgkl.zzaJ(zzb, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0000\u0000\u0000\u0002\t", new Object[]{"zze"});
        } else if (i12 == 3) {
            return new zzgea();
        } else {
            if (i12 == 4) {
                return new zzgdz((zzgdy) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final zzgfi zze() {
        zzgfi zzgfi = this.zze;
        return zzgfi == null ? zzgfi.zzd() : zzgfi;
    }
}
