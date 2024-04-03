package com.google.android.recaptcha.internal;

import java.lang.reflect.Method;
import java.util.Arrays;
import org.jetbrains.annotations.NotNull;

public final class zzcj implements zzca {
    @NotNull
    public static final zzcj zza = new zzcj();

    private zzcj() {
    }

    public final void zza(int i11, @NotNull zzbh zzbh, @NotNull zznl... zznlArr) throws zzs {
        int length = zznlArr.length;
        if (length != 0) {
            Object zza2 = zzbh.zze().zza(zznlArr[0]);
            if (true != (zza2 instanceof Method)) {
                zza2 = null;
            }
            Method method = (Method) zza2;
            if (method != null) {
                Object[] zzh = zzbh.zze().zzh(ArraysKt___ArraysKt.toList((T[]) zznlArr).subList(1, length));
                try {
                    zzbh.zze().zzf(i11, method.invoke((Object) null, Arrays.copyOf(zzh, zzh.length)));
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
