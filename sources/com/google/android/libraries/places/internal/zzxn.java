package com.google.android.libraries.places.internal;

public final class zzxn extends zzabs<zzxn, zzxm> implements zzada {
    /* access modifiers changed from: private */
    public static final zzxn zzb;
    private zzabz<String> zze = zzabs.zzB();

    static {
        zzxn zzxn = new zzxn();
        zzb = zzxn;
        zzabs.zzG(zzxn.class, zzxn);
    }

    private zzxn() {
    }

    public static zzxm zza() {
        return (zzxm) zzb.zzx();
    }

    public static /* synthetic */ void zzc(zzxn zzxn, Iterable iterable) {
        zzabz<String> zzabz = zzxn.zze;
        if (!zzabz.zzc()) {
            zzxn.zze = zzabs.zzC(zzabz);
        }
        zzaaj.zzt(iterable, zzxn.zze);
    }

    public final Object zzd(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzabs.zzF(zzb, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", new Object[]{"zze"});
        } else if (i12 == 3) {
            return new zzxn();
        } else {
            if (i12 == 4) {
                return new zzxm((zztv) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
