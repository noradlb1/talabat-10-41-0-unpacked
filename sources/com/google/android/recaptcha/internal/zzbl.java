package com.google.android.recaptcha.internal;

import java.lang.reflect.Array;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public final class zzbl implements zzca {
    @NotNull
    public static final zzbl zza = new zzbl();

    private zzbl() {
    }

    public final void zza(int i11, @NotNull zzbh zzbh, @NotNull zznl... zznlArr) throws zzs {
        Object obj;
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
                            obj = String.valueOf(((String) zza2).charAt(intValue));
                        } else if (zza2 instanceof List) {
                            obj = ((List) zza2).get(intValue);
                        } else {
                            obj = Array.get(zza2, intValue);
                        }
                        zzbh.zze().zzf(i11, obj);
                    } catch (Exception e11) {
                        if (e11 instanceof ArrayIndexOutOfBoundsException) {
                            throw new zzs(4, 22, e11);
                        }
                        throw new zzs(4, 23, e11);
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
