package com.google.android.libraries.places.internal;

public final class zzvr extends zzabs<zzvr, zzvq> implements zzada {
    /* access modifiers changed from: private */
    public static final zzvr zzb;
    private int zze;
    private String zzf = "";
    private zznc zzg;
    private zzvf zzh;
    private byte zzi = 2;

    static {
        zzvr zzvr = new zzvr();
        zzb = zzvr;
        zzabs.zzG(zzvr.class, zzvr);
    }

    private zzvr() {
    }

    public static zzvq zza() {
        return (zzvq) zzb.zzx();
    }

    public static /* synthetic */ void zzc(zzvr zzvr, zzvf zzvf) {
        zzvr.zzh = zzvf;
        zzvr.zze |= 4;
    }

    public final Object zzd(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return Byte.valueOf(this.zzi);
        }
        byte b11 = 1;
        if (i12 == 2) {
            return zzabs.zzF(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0001\u0001ဈ\u0000\u0002ᐉ\u0001\u0003ဉ\u0002", new Object[]{"zze", "zzf", "zzg", "zzh"});
        } else if (i12 == 3) {
            return new zzvr();
        } else {
            if (i12 == 4) {
                return new zzvq((zztv) null);
            }
            if (i12 == 5) {
                return zzb;
            }
            if (obj == null) {
                b11 = 0;
            }
            this.zzi = b11;
            return null;
        }
    }
}
