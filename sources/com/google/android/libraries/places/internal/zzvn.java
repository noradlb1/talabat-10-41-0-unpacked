package com.google.android.libraries.places.internal;

public final class zzvn extends zzabs<zzvn, zzvl> implements zzada {
    /* access modifiers changed from: private */
    public static final zzvn zzb;
    private int zze;
    private int zzf;

    static {
        zzvn zzvn = new zzvn();
        zzb = zzvn;
        zzabs.zzG(zzvn.class, zzvn);
    }

    private zzvn() {
    }

    public final Object zzd(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzabs.zzF(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဌ\u0000", new Object[]{"zze", "zzf", zzvm.zza});
        } else if (i12 == 3) {
            return new zzvn();
        } else {
            if (i12 == 4) {
                return new zzvl((zztv) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
