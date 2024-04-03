package com.google.android.recaptcha.internal;

import java.lang.reflect.Field;
import org.jetbrains.annotations.NotNull;

public final class zzch implements zzca {
    @NotNull
    public static final zzch zza = new zzch();

    private zzch() {
    }

    public final void zza(int i11, @NotNull zzbh zzbh, @NotNull zznl... zznlArr) throws zzs {
        if (zznlArr.length == 1) {
            Object zza2 = zzbh.zze().zza(zznlArr[0]);
            if (true != (zza2 instanceof Field)) {
                zza2 = null;
            }
            Field field = (Field) zza2;
            if (field != null) {
                try {
                    zzbh.zze().zzf(i11, field.get((Object) null));
                } catch (Exception e11) {
                    throw new zzs(6, 16, e11);
                }
            } else {
                throw new zzs(4, 5, (Throwable) null);
            }
        } else {
            throw new zzs(4, 3, (Throwable) null);
        }
    }
}
