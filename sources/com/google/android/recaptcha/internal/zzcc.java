package com.google.android.recaptcha.internal;

import org.jetbrains.annotations.NotNull;

public final class zzcc implements zzca {
    @NotNull
    public static final zzcc zza = new zzcc();

    private zzcc() {
    }

    public final void zza(int i11, @NotNull zzbh zzbh, @NotNull zznl... zznlArr) throws zzs {
        if (zznlArr.length == 1) {
            Object zza2 = zzbh.zze().zza(zznlArr[0]);
            if (true != (zza2 instanceof Object)) {
                zza2 = null;
            }
            if (zza2 != null) {
                try {
                    if (zza2 instanceof String) {
                        zza2 = zzbz.zza(this, (String) zza2, zzbh.zza());
                    }
                    zzbh.zze().zzf(i11, zzbg.zza(zza2));
                } catch (Exception e11) {
                    throw new zzs(6, 8, e11);
                }
            } else {
                throw new zzs(4, 5, (Throwable) null);
            }
        } else {
            throw new zzs(4, 3, (Throwable) null);
        }
    }
}
