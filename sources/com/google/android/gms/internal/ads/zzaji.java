package com.google.android.gms.internal.ads;

public final class zzaji extends zzgkl<zzaji, zzajh> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzaji zzb;
    private int zze;
    private int zzf;
    private long zzg = -1;

    static {
        zzaji zzaji = new zzaji();
        zzb = zzaji;
        zzgkl.zzaK(zzaji.class, zzaji);
    }

    private zzaji() {
    }

    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgkl.zzaJ(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဂ\u0001", new Object[]{"zze", "zzf", zzaje.zza, "zzg"});
        } else if (i12 == 3) {
            return new zzaji();
        } else {
            if (i12 == 4) {
                return new zzajh((zzaiy) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
