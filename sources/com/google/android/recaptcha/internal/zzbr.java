package com.google.android.recaptcha.internal;

import org.jetbrains.annotations.NotNull;

public final class zzbr implements zzca {
    @NotNull
    public static final zzbr zza = new zzbr();

    private zzbr() {
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
                if (true != (zza3 instanceof String)) {
                    zza3 = null;
                }
                String str2 = (String) zza3;
                if (str2 != null) {
                    zzbh.zze().zzf(i11, str.concat(str2));
                    return;
                }
                throw new zzs(4, 5, (Throwable) null);
            }
            throw new zzs(4, 5, (Throwable) null);
        }
        throw new zzs(4, 3, (Throwable) null);
    }
}
