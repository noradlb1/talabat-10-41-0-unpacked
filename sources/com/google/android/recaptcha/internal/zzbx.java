package com.google.android.recaptcha.internal;

import java.lang.reflect.Array;
import org.jetbrains.annotations.NotNull;

public final class zzbx implements zzca {
    @NotNull
    public static final zzbx zza = new zzbx();

    private zzbx() {
    }

    public final void zza(int i11, @NotNull zzbh zzbh, @NotNull zznl... zznlArr) throws zzs {
        if (zznlArr.length == 2) {
            Object zza2 = zzbh.zze().zza(zznlArr[0]);
            if (true != (zza2 instanceof Object)) {
                zza2 = null;
            }
            if (zza2 != null) {
                Object zza3 = zzbh.zze().zza(zznlArr[1]);
                if (true != (zza3 instanceof Integer)) {
                    zza3 = null;
                }
                Integer num = (Integer) zza3;
                if (num != null) {
                    int intValue = num.intValue();
                    try {
                        if (zza2 instanceof String) {
                            zza2 = zzbz.zza(this, (String) zza2, zzbh.zza());
                        }
                        zzbh.zze().zzf(i11, Array.newInstance(zzbg.zza(zza2), intValue));
                    } catch (Exception e11) {
                        throw new zzs(6, 21, e11);
                    }
                } else {
                    throw new zzs(4, 5, (Throwable) null);
                }
            } else {
                throw new zzs(4, 5, (Throwable) null);
            }
        } else {
            throw new zzs(4, 3, (Throwable) null);
        }
    }
}
