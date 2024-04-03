package com.google.android.gms.internal.ads;

public final class zzgob extends zzgkl<zzgob, zzgoa> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzgob zzb;
    private int zze;
    private String zzf = "";

    static {
        zzgob zzgob = new zzgob();
        zzb = zzgob;
        zzgkl.zzaK(zzgob.class, zzgob);
    }

    private zzgob() {
    }

    public static zzgoa zza() {
        return (zzgoa) zzb.zzat();
    }

    public static /* synthetic */ void zzd(zzgob zzgob, String str) {
        zzgob.zze |= 1;
        zzgob.zzf = str;
    }

    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgkl.zzaJ(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဈ\u0000", new Object[]{"zze", "zzf"});
        } else if (i12 == 3) {
            return new zzgob();
        } else {
            if (i12 == 4) {
                return new zzgoa((zzgnx) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
