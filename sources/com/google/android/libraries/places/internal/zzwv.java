package com.google.android.libraries.places.internal;

public final class zzwv extends zzabs<zzwv, zzwt> implements zzada {
    /* access modifiers changed from: private */
    public static final zzwv zzb;
    private int zze;
    private zzvf zzf;
    private int zzg;
    private int zzh;
    private zzxn zzi;

    static {
        zzwv zzwv = new zzwv();
        zzb = zzwv;
        zzabs.zzG(zzwv.class, zzwv);
    }

    private zzwv() {
    }

    public static zzwt zza() {
        return (zzwt) zzb.zzx();
    }

    public static /* synthetic */ void zzc(zzwv zzwv, int i11) {
        zzwv.zze |= 4;
        zzwv.zzh = i11;
    }

    public static /* synthetic */ void zze(zzwv zzwv, zzxn zzxn) {
        zzxn.getClass();
        zzwv.zzi = zzxn;
        zzwv.zze |= 8;
    }

    public static /* synthetic */ void zzf(zzwv zzwv, int i11) {
        zzwv.zzg = i11 - 1;
        zzwv.zze |= 2;
    }

    public final Object zzd(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzabs.zzF(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဌ\u0001\u0003င\u0002\u0004ဉ\u0003", new Object[]{"zze", "zzf", "zzg", zzwu.zza, "zzh", "zzi"});
        } else if (i12 == 3) {
            return new zzwv();
        } else {
            if (i12 == 4) {
                return new zzwt((zztv) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
