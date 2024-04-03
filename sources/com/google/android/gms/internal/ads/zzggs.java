package com.google.android.gms.internal.ads;

public final class zzggs extends zzgkl<zzggs, zzggr> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzggs zzb;
    private int zze;

    static {
        zzggs zzggs = new zzggs();
        zzb = zzggs;
        zzgkl.zzaK(zzggs.class, zzggs);
    }

    private zzggs() {
    }

    public static zzggs zzc() {
        return zzb;
    }

    public static zzggs zzd(zzgjf zzgjf, zzgjx zzgjx) throws zzgkx {
        return (zzggs) zzgkl.zzay(zzb, zzgjf, zzgjx);
    }

    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgkl.zzaJ(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zze"});
        } else if (i12 == 3) {
            return new zzggs();
        } else {
            if (i12 == 4) {
                return new zzggr((zzggq) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
