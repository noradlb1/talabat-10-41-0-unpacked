package com.google.android.recaptcha.internal;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class zzbn implements zzca {
    @NotNull
    public static final zzbn zza = new zzbn();

    private zzbn() {
    }

    public final void zza(int i11, @NotNull zzbh zzbh, @NotNull zznl... zznlArr) throws zzs {
        if (zznlArr.length == 3) {
            Object zza2 = zzbh.zze().zza(zznlArr[0]);
            if (true != (zza2 instanceof Integer)) {
                zza2 = null;
            }
            Integer num = (Integer) zza2;
            if (num != null) {
                int intValue = num.intValue();
                if (intValue != 0) {
                    Object zza3 = zzbh.zze().zza(zznlArr[1]);
                    if (true != (zza3 instanceof Object)) {
                        zza3 = null;
                    }
                    if (zza3 != null) {
                        Object zza4 = zzbh.zze().zza(zznlArr[2]);
                        if (true != (zza4 instanceof Object)) {
                            zza4 = null;
                        }
                        if (zza4 == null) {
                            throw new zzs(4, 5, (Throwable) null);
                        } else if (Intrinsics.areEqual(zza3, zza4)) {
                            zzbh.zzi(zzbh.zzb() + intValue);
                        }
                    } else {
                        throw new zzs(4, 5, (Throwable) null);
                    }
                } else {
                    throw new zzs(4, 6, (Throwable) null);
                }
            } else {
                throw new zzs(4, 5, (Throwable) null);
            }
        } else {
            throw new zzs(4, 3, (Throwable) null);
        }
    }
}
