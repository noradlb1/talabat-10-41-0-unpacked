package com.google.android.recaptcha.internal;

import org.jetbrains.annotations.NotNull;

public final class zzce implements zzca {
    @NotNull
    public static final zzce zza = new zzce();

    private zzce() {
    }

    public final void zza(int i11, @NotNull zzbh zzbh, @NotNull zznl... zznlArr) throws zzs {
        Class<?> cls;
        if (zznlArr.length == 2) {
            Object zza2 = zzbh.zze().zza(zznlArr[0]);
            if (true != (zza2 instanceof Object)) {
                zza2 = null;
            }
            if (zza2 != null) {
                if (zza2 instanceof Class) {
                    cls = (Class) zza2;
                } else {
                    cls = zza2.getClass();
                }
                Object zza3 = zzbh.zze().zza(zznlArr[1]);
                if (true != (zza3 instanceof String)) {
                    zza3 = null;
                }
                String str = (String) zza3;
                if (str != null) {
                    try {
                        zzbh.zze().zzf(i11, cls.getField(zzbz.zza(this, str, zzbh.zza())));
                    } catch (Exception e11) {
                        throw new zzs(6, 10, e11);
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
