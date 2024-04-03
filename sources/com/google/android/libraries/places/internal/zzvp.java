package com.google.android.libraries.places.internal;

public final class zzvp extends zzabs<zzvp, zzvo> implements zzada {
    /* access modifiers changed from: private */
    public static final zzvp zzb;
    private int zze;
    private String zzf = "";
    private zzna zzg;
    private String zzh = "";
    private zzabz<String> zzi = zzabs.zzB();
    private String zzj = "";
    private String zzk = "";
    private byte zzl = 2;

    static {
        zzvp zzvp = new zzvp();
        zzb = zzvp;
        zzabs.zzG(zzvp.class, zzvp);
    }

    private zzvp() {
    }

    public final Object zzd(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return Byte.valueOf(this.zzl);
        }
        byte b11 = 1;
        if (i12 == 2) {
            return zzabs.zzF(zzb, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0001\u0001ဈ\u0000\u0002ᐉ\u0001\u0003ဈ\u0002\u0004\u001a\u0005ဈ\u0003\u0006ဈ\u0004", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        } else if (i12 == 3) {
            return new zzvp();
        } else {
            if (i12 == 4) {
                return new zzvo((zztv) null);
            }
            if (i12 == 5) {
                return zzb;
            }
            if (obj == null) {
                b11 = 0;
            }
            this.zzl = b11;
            return null;
        }
    }
}
