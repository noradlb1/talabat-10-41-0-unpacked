package com.google.android.libraries.places.internal;

public final class zzuo extends zzabs<zzuo, zzun> implements zzada {
    /* access modifiers changed from: private */
    public static final zzuo zzb;
    private int zze;
    private int zzf;
    private int zzg;

    static {
        zzuo zzuo = new zzuo();
        zzb = zzuo;
        zzabs.zzG(zzuo.class, zzuo);
    }

    private zzuo() {
    }

    public static zzun zza() {
        return (zzun) zzb.zzx();
    }

    public static /* synthetic */ void zzc(zzuo zzuo, int i11) {
        zzuo.zze |= 1;
        zzuo.zzf = 1;
    }

    public static /* synthetic */ void zze(zzuo zzuo, int i11) {
        zzuo.zze |= 2;
        zzuo.zzg = i11;
    }

    public final Object zzd(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzabs.zzF(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001", new Object[]{"zze", "zzf", "zzg"});
        } else if (i12 == 3) {
            return new zzuo();
        } else {
            if (i12 == 4) {
                return new zzun((zztv) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
