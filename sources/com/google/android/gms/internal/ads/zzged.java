package com.google.android.gms.internal.ads;

public final class zzged extends zzgkl<zzged, zzgec> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzged zzb;
    private zzgeg zze;

    static {
        zzged zzged = new zzged();
        zzb = zzged;
        zzgkl.zzaK(zzged.class, zzged);
    }

    private zzged() {
    }

    public static zzgec zza() {
        return (zzgec) zzb.zzat();
    }

    public static zzged zzd(zzgjf zzgjf, zzgjx zzgjx) throws zzgkx {
        return (zzged) zzgkl.zzay(zzb, zzgjf, zzgjx);
    }

    public static /* synthetic */ void zzf(zzged zzged, zzgeg zzgeg) {
        zzgeg.getClass();
        zzged.zze = zzgeg;
    }

    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgkl.zzaJ(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\t", new Object[]{"zze"});
        } else if (i12 == 3) {
            return new zzged();
        } else {
            if (i12 == 4) {
                return new zzgec((zzgeb) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final zzgeg zze() {
        zzgeg zzgeg = this.zze;
        return zzgeg == null ? zzgeg.zze() : zzgeg;
    }
}
