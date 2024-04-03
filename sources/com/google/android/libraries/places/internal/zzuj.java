package com.google.android.libraries.places.internal;

public final class zzuj extends zzabs<zzuj, zzui> implements zzada {
    /* access modifiers changed from: private */
    public static final zzuj zzb;
    private int zze;
    private int zzf;

    static {
        zzuj zzuj = new zzuj();
        zzb = zzuj;
        zzabs.zzG(zzuj.class, zzuj);
    }

    private zzuj() {
    }

    public static zzui zza() {
        return (zzui) zzb.zzx();
    }

    public static /* synthetic */ void zzc(zzuj zzuj, int i11) {
        zzuj.zze |= 1;
        zzuj.zzf = i11;
    }

    public final Object zzd(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzabs.zzF(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001င\u0000", new Object[]{"zze", "zzf"});
        } else if (i12 == 3) {
            return new zzuj();
        } else {
            if (i12 == 4) {
                return new zzui((zztv) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
