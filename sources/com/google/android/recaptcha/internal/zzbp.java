package com.google.android.recaptcha.internal;

import org.jetbrains.annotations.NotNull;

public final class zzbp implements zzca {
    @NotNull
    public static final zzbp zza = new zzbp();

    private zzbp() {
    }

    public final void zza(int i11, @NotNull zzbh zzbh, @NotNull zznl... zznlArr) throws zzs {
        if (zznlArr.length == 2) {
            Object zza2 = zzbh.zze().zza(zznlArr[0]);
            if (true != (zza2 instanceof String)) {
                zza2 = null;
            }
            String str = (String) zza2;
            if (str != null) {
                Object zza3 = zzbh.zze().zza(zznlArr[1]);
                if (zza3 == null) {
                    throw new zzs(4, 4, (Throwable) null);
                } else if (!(zza3 instanceof Integer) && !(zza3 instanceof Short) && !(zza3 instanceof Byte) && !(zza3 instanceof Long) && !(zza3 instanceof Double) && !(zza3 instanceof Float) && !(zza3 instanceof Boolean) && !(zza3 instanceof Character) && !(zza3 instanceof String)) {
                    throw new zzs(4, 7, (Throwable) null);
                } else {
                    zzbh.zzd().zzb(str, zza3.toString());
                }
            } else {
                throw new zzs(4, 5, (Throwable) null);
            }
        } else {
            throw new zzs(4, 3, (Throwable) null);
        }
    }
}
