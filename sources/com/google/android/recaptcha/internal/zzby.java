package com.google.android.recaptcha.internal;

import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;

public final class zzby implements zzca {
    @NotNull
    public static final zzby zza = new zzby();

    private zzby() {
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
                    try {
                        if (zza2 instanceof Integer) {
                            obj = Integer.valueOf(((Number) zza2).intValue() / intValue);
                        } else if (zza2 instanceof int[]) {
                            ArrayList arrayList = new ArrayList(r4);
                            for (int i12 : (int[]) zza2) {
                                arrayList.add(Integer.valueOf(i12 / intValue));
                            }
                            obj = arrayList.toArray(new Integer[0]);
                        } else {
                            throw new zzs(4, 5, (Throwable) null);
                        }
                        zzbh.zze().zzf(i11, obj);
                    } catch (ArithmeticException e11) {
                        throw new zzs(4, 6, e11);
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
