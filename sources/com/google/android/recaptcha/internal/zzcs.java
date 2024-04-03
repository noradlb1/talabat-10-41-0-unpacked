package com.google.android.recaptcha.internal;

import org.jetbrains.annotations.NotNull;

public final class zzcs implements zzca {
    @NotNull
    public static final zzcs zza = new zzcs();

    private zzcs() {
    }

    public final void zza(int i11, @NotNull zzbh zzbh, @NotNull zznl... zznlArr) throws zzs {
        if (zznlArr.length == 1) {
            Object zza2 = zzbh.zze().zza(zznlArr[0]);
            if (true != (zza2 instanceof Byte)) {
                zza2 = null;
            }
            Byte b11 = (Byte) zza2;
            if (b11 != null) {
                zzbh.zzj(b11.byteValue());
                return;
            }
            throw new zzs(4, 5, (Throwable) null);
        }
        throw new zzs(4, 3, (Throwable) null);
    }
}
