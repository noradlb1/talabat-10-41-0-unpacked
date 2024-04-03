package com.google.android.gms.internal.gtm;

final class zzsb implements zzsj {
    private zzsj[] zzbco;

    public zzsb(zzsj... zzsjArr) {
        this.zzbco = zzsjArr;
    }

    public final boolean zze(Class<?> cls) {
        for (zzsj zze : this.zzbco) {
            if (zze.zze(cls)) {
                return true;
            }
        }
        return false;
    }

    public final zzsi zzf(Class<?> cls) {
        String str;
        for (zzsj zzsj : this.zzbco) {
            if (zzsj.zze(cls)) {
                return zzsj.zzf(cls);
            }
        }
        String name2 = cls.getName();
        if (name2.length() != 0) {
            str = "No factory is available for message type: ".concat(name2);
        } else {
            str = new String("No factory is available for message type: ");
        }
        throw new UnsupportedOperationException(str);
    }
}
