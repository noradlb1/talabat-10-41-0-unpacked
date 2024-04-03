package com.google.android.recaptcha.internal;

import java.lang.reflect.Method;
import java.util.Arrays;
import org.jetbrains.annotations.NotNull;

public final class zzci implements zzca {
    @NotNull
    public static final zzci zza = new zzci();

    private zzci() {
    }

    public final void zza(int i11, @NotNull zzbh zzbh, @NotNull zznl... zznlArr) throws zzs {
        int length = zznlArr.length;
        if (length >= 2) {
            Object zza2 = zzbh.zze().zza(zznlArr[0]);
            if (true != (zza2 instanceof Method)) {
                zza2 = null;
            }
            Method method = (Method) zza2;
            if (method != null) {
                Object zza3 = zzbh.zze().zza(zznlArr[1]);
                Object[] zzh = zzbh.zze().zzh(ArraysKt___ArraysKt.toList((T[]) zznlArr).subList(2, length));
                try {
                    zzbh.zze().zzf(i11, method.invoke(zza3, Arrays.copyOf(zzh, zzh.length)));
                } catch (Exception e11) {
                    throw new zzs(6, 15, e11);
                }
            } else {
                throw new zzs(4, 5, (Throwable) null);
            }
        } else {
            throw new zzs(4, 3, (Throwable) null);
        }
    }
}
