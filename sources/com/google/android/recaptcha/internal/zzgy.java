package com.google.android.recaptcha.internal;

final class zzgy implements zzin {
    private static final zzgy zza = new zzgy();

    private zzgy() {
    }

    public static zzgy zza() {
        return zza;
    }

    public final zzim zzb(Class cls) {
        Class<zzhf> cls2 = zzhf.class;
        if (cls2.isAssignableFrom(cls)) {
            try {
                return (zzim) zzhf.zzr(cls.asSubclass(cls2)).zzh(3, (Object) null, (Object) null);
            } catch (Exception e11) {
                throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e11);
            }
        } else {
            throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
        }
    }

    public final boolean zzc(Class cls) {
        return zzhf.class.isAssignableFrom(cls);
    }
}
