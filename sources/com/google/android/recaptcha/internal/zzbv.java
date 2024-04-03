package com.google.android.recaptcha.internal;

import java.lang.reflect.Proxy;
import org.jetbrains.annotations.NotNull;

public final class zzbv implements zzca {
    @NotNull
    public static final zzbv zza = new zzbv();

    private zzbv() {
    }

    public final void zza(int i11, @NotNull zzbh zzbh, @NotNull zznl... zznlArr) throws zzs {
        int i12;
        int length = zznlArr.length;
        if (length == 4 || length == 5) {
            Object zza2 = zzbh.zze().zza(zznlArr[0]);
            if (true != (zza2 instanceof String)) {
                zza2 = null;
            }
            String str = (String) zza2;
            if (str != null) {
                Object zza3 = zzbh.zze().zza(zznlArr[1]);
                if (true != (zza3 instanceof Object)) {
                    zza3 = null;
                }
                if (zza3 != null) {
                    Object zza4 = zzbh.zze().zza(zznlArr[2]);
                    if (true != (zza4 instanceof String)) {
                        zza4 = null;
                    }
                    String str2 = (String) zza4;
                    if (str2 != null) {
                        String zza5 = zzbz.zza(this, str2, zzbh.zza());
                        Object zza6 = zzbh.zze().zza(zznlArr[3]);
                        if (length == 5) {
                            Object zza7 = zzbh.zze().zza(zznlArr[4]);
                            if (true != (zza7 instanceof Integer)) {
                                zza7 = null;
                            }
                            Integer num = (Integer) zza7;
                            if (num != null) {
                                i12 = num.intValue();
                            } else {
                                throw new zzs(4, 5, (Throwable) null);
                            }
                        } else {
                            i12 = -1;
                        }
                        try {
                            byte zza8 = zzbh.zza();
                            if (zza3 instanceof String) {
                                zza3 = zzbz.zza(this, (String) zza3, zza8);
                            }
                            Class zza9 = zzbg.zza(zza3);
                            zzbh.zze().zzf(i11, Proxy.newProxyInstance(zza9.getClassLoader(), new Class[]{zza9}, new zzbd(new zzbu(zzbh, str, i12), zza5, zza6)));
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
            throw new zzs(4, 3, (Throwable) null);
        }
    }
}
