package com.google.android.libraries.places.internal;

public final class zzyc extends zzabs<zzyc, zzya> implements zzada {
    /* access modifiers changed from: private */
    public static final zzyc zzb;
    private int zze;
    private zznc zzf;
    private int zzg;
    private int zzh;
    private String zzi = "";
    private int zzj;
    private byte zzk = 2;

    static {
        zzyc zzyc = new zzyc();
        zzb = zzyc;
        zzabs.zzG(zzyc.class, zzyc);
    }

    private zzyc() {
    }

    public final Object zzd(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return Byte.valueOf(this.zzk);
        }
        byte b11 = 1;
        if (i12 == 2) {
            return zzabs.zzF(zzb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0001\u0001ᐉ\u0000\u0002င\u0001\u0003င\u0002\u0004ဈ\u0003\u0005ဌ\u0004", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", zzyb.zza});
        } else if (i12 == 3) {
            return new zzyc();
        } else {
            if (i12 == 4) {
                return new zzya((zztv) null);
            }
            if (i12 == 5) {
                return zzb;
            }
            if (obj == null) {
                b11 = 0;
            }
            this.zzk = b11;
            return null;
        }
    }
}
