package com.google.android.recaptcha.internal;

import java.util.Arrays;
import org.jetbrains.annotations.NotNull;

public final class zzcd implements zzca {
    @NotNull
    public static final zzcd zza = new zzcd();

    private zzcd() {
    }

    public final void zza(int i11, @NotNull zzbh zzbh, @NotNull zznl... zznlArr) throws zzs {
        int length = zznlArr.length;
        if (length != 0) {
            Object zza2 = zzbh.zze().zza(zznlArr[0]);
            if (true != (zza2 instanceof Class)) {
                zza2 = null;
            }
            Class cls = (Class) zza2;
            if (cls != null) {
                Class[] zzg = zzbh.zze().zzg(ArraysKt___ArraysKt.toList((T[]) zznlArr).subList(1, length));
                try {
                    zzbh.zze().zzf(i11, cls.getConstructor((Class[]) Arrays.copyOf(zzg, zzg.length)));
                } catch (Exception e11) {
                    throw new zzs(6, 9, e11);
                }
            } else {
                throw new zzs(4, 5, (Throwable) null);
            }
        } else {
            throw new zzs(4, 3, (Throwable) null);
        }
    }
}
