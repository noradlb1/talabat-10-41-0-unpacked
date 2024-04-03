package com.google.android.libraries.places.internal;

public final class zzuc extends zzabs<zzuc, zzub> implements zzada {
    /* access modifiers changed from: private */
    public static final zzuc zzb;
    private int zze;
    private int zzf;

    static {
        zzuc zzuc = new zzuc();
        zzb = zzuc;
        zzabs.zzG(zzuc.class, zzuc);
    }

    private zzuc() {
    }

    public static zzub zza() {
        return (zzub) zzb.zzx();
    }

    public static /* synthetic */ void zzc(zzuc zzuc, int i11) {
        zzuc.zze |= 1;
        zzuc.zzf = i11;
    }

    public final Object zzd(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzabs.zzF(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001င\u0000", new Object[]{"zze", "zzf"});
        } else if (i12 == 3) {
            return new zzuc();
        } else {
            if (i12 == 4) {
                return new zzub((zztv) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
