package com.google.android.recaptcha.internal;

import java.lang.reflect.Proxy;
import org.jetbrains.annotations.NotNull;

public final class zzbw implements zzca {
    @NotNull
    public static final zzbw zza = new zzbw();

    private zzbw() {
    }

    public final void zza(int i11, @NotNull zzbh zzbh, @NotNull zznl... zznlArr) throws zzs {
        int length = zznlArr.length;
        Object obj = null;
        if (length == 4 || length == 5) {
            Object zza2 = zzbh.zze().zza(zznlArr[0]);
            if (true != (zza2 instanceof Integer)) {
                zza2 = null;
            }
            Integer num = (Integer) zza2;
            if (num != null) {
                int intValue = num.intValue();
                Object zza3 = zzbh.zze().zza(zznlArr[1]);
                if (true != (zza3 instanceof Integer)) {
                    zza3 = null;
                }
                Integer num2 = (Integer) zza3;
                if (num2 != null) {
                    int intValue2 = num2.intValue();
                    Object zza4 = zzbh.zze().zza(zznlArr[2]);
                    if (true != (zza4 instanceof String)) {
                        zza4 = null;
                    }
                    String str = (String) zza4;
                    if (str != null) {
                        String zza5 = zzbz.zza(this, str, zzbh.zza());
                        Object zza6 = zzbh.zze().zza(zznlArr[3]);
                        if (true != (zza6 instanceof String)) {
                            zza6 = null;
                        }
                        String str2 = (String) zza6;
                        if (str2 != null) {
                            String zza7 = zzbz.zza(this, str2, zzbh.zza());
                            if (length == 5) {
                                obj = zzbh.zze().zza(zznlArr[4]);
                            }
                            zzbe zzbe = new zzbe(intValue2);
                            try {
                                Class zza8 = zzbg.zza(zza5);
                                zzbh.zze().zzf(intValue, Proxy.newProxyInstance(zza8.getClassLoader(), new Class[]{zza8}, new zzbf(zzbe, zza7, obj)));
                                zzbh.zze().zzf(i11, zzbe);
                            } catch (Exception e11) {
                                throw new zzs(6, 20, e11);
                            }
                        } else {
                            throw new zzs(4, 5, (Throwable) null);
                        }
                    } else {
                        throw new zzs(4, 5, (Throwable) null);
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
