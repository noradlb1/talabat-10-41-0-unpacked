package com.google.android.recaptcha.internal;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class zzcf implements zzca {
    @NotNull
    public static final zzcf zza = new zzcf();

    private zzcf() {
    }

    public final void zza(int i11, @NotNull zzbh zzbh, @NotNull zznl... zznlArr) throws zzs {
        Class<?> cls;
        int length = zznlArr.length;
        if (length >= 2) {
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
                    String zza4 = zzbz.zza(this, str, zzbh.zza());
                    if (!Intrinsics.areEqual((Object) zza4, (Object) "forName")) {
                        Class[] zzg = zzbh.zze().zzg(ArraysKt___ArraysKt.toList((T[]) zznlArr).subList(2, length));
                        try {
                            zzbh.zze().zzf(i11, cls.getMethod(zza4, (Class[]) Arrays.copyOf(zzg, zzg.length)));
                        } catch (Exception e11) {
                            throw new zzs(6, 13, e11);
                        }
                    } else {
                        throw new zzs(6, 48, (Throwable) null);
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
