package com.google.android.gms.internal.ads;

import org.objenesis.strategy.PlatformDescription;

public abstract class zzgpj {
    public static zzgpj zzb(Class cls) {
        if (System.getProperty("java.vm.name").equalsIgnoreCase(PlatformDescription.DALVIK)) {
            return new zzgpe(cls.getSimpleName());
        }
        return new zzgpg(cls.getSimpleName());
    }

    public abstract void zza(String str);
}
