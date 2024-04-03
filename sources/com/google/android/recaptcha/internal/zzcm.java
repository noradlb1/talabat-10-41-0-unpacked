package com.google.android.recaptcha.internal;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import org.jetbrains.annotations.NotNull;

public final class zzcm implements zzca {
    @NotNull
    public static final zzcm zza = new zzcm();

    private zzcm() {
    }

    public final void zza(int i11, @NotNull zzbh zzbh, @NotNull zznl... zznlArr) throws zzs {
        Constructor<?> constructor;
        int length = zznlArr.length;
        if (length != 0) {
            Object zza2 = zzbh.zze().zza(zznlArr[0]);
            if (true != (zza2 instanceof Object)) {
                zza2 = null;
            }
            if (zza2 != null) {
                if (zza2 instanceof Constructor) {
                    constructor = (Constructor) zza2;
                } else {
                    constructor = zza2.getClass().getConstructor(new Class[0]);
                }
                Object[] zzh = zzbh.zze().zzh(ArraysKt___ArraysKt.toList((T[]) zznlArr).subList(1, length));
                try {
                    zzbh.zze().zzf(i11, constructor.newInstance(Arrays.copyOf(zzh, zzh.length)));
                } catch (Exception e11) {
                    throw new zzs(6, 14, e11);
                }
            } else {
                throw new zzs(4, 5, (Throwable) null);
            }
        } else {
            throw new zzs(4, 3, (Throwable) null);
        }
    }
}
