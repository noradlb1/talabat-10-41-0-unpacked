package com.google.android.recaptcha.internal;

import org.jetbrains.annotations.NotNull;

public final class zzcu implements zzca {
    @NotNull
    public static final zzcu zza = new zzcu();

    private zzcu() {
    }

    public final void zza(int i11, @NotNull zzbh zzbh, @NotNull zznl... zznlArr) throws zzs {
        if (zznlArr.length == 2) {
            Object zza2 = zzbh.zze().zza(zznlArr[0]);
            if (true != (zza2 instanceof int[])) {
                zza2 = null;
            }
            int[] iArr = (int[]) zza2;
            if (iArr != null) {
                Object zza3 = zzbh.zze().zza(zznlArr[1]);
                if (true != (zza3 instanceof String)) {
                    zza3 = null;
                }
                String str = (String) zza3;
                if (str != null) {
                    zzbi zze = zzbh.zze();
                    StringBuilder sb2 = new StringBuilder();
                    try {
                        for (int charAt : iArr) {
                            sb2.append(str.charAt(charAt));
                        }
                        zze.zzf(i11, sb2.toString());
                    } catch (Exception e11) {
                        throw new zzs(4, 22, e11);
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
