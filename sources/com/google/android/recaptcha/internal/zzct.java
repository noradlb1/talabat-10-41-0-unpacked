package com.google.android.recaptcha.internal;

import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;

public final class zzct implements zzca {
    @NotNull
    public static final zzct zza = new zzct();

    private zzct() {
    }

    public final void zza(int i11, @NotNull zzbh zzbh, @NotNull zznl... zznlArr) throws zzs {
        Object obj;
        if (zznlArr.length == 2) {
            Object zza2 = zzbh.zze().zza(zznlArr[0]);
            if (true != (zza2 instanceof Object)) {
                zza2 = null;
            }
            if (zza2 != null) {
                Object zza3 = zzbh.zze().zza(zznlArr[1]);
                if (true != (zza3 instanceof Integer)) {
                    zza3 = null;
                }
                Integer num = (Integer) zza3;
                if (num != null) {
                    int intValue = num.intValue();
                    if (zza2 instanceof Integer) {
                        obj = Integer.valueOf(((Number) zza2).intValue() - intValue);
                    } else if (zza2 instanceof int[]) {
                        ArrayList arrayList = new ArrayList(r2);
                        for (int i12 : (int[]) zza2) {
                            arrayList.add(Integer.valueOf(i12 - intValue));
                        }
                        obj = arrayList.toArray(new Integer[0]);
                    } else {
                        throw new zzs(4, 5, (Throwable) null);
                    }
                    zzbh.zze().zzf(i11, obj);
                    return;
                }
                throw new zzs(4, 5, (Throwable) null);
            }
            throw new zzs(4, 5, (Throwable) null);
        }
        throw new zzs(4, 3, (Throwable) null);
    }
}
