package com.google.android.recaptcha.internal;

import org.jetbrains.annotations.NotNull;

public final class zzbo implements zzca {
    @NotNull
    public static final zzbo zza = new zzbo();

    private zzbo() {
    }

    public final void zza(int i11, @NotNull zzbh zzbh, @NotNull zznl... zznlArr) throws zzs {
        int length = zznlArr.length;
        if (length != 0) {
            zznd zzf = zzng.zzf();
            int i12 = 0;
            while (i12 < length) {
                Object zza2 = zzbh.zze().zza(zznlArr[i12]);
                if (zza2 != null) {
                    zzne zzf2 = zznf.zzf();
                    if (zza2 instanceof Integer) {
                        zzf2.zzt(((Number) zza2).intValue());
                    } else if (zza2 instanceof Short) {
                        zzf2.zzs(((Number) zza2).shortValue());
                    } else if (zza2 instanceof Byte) {
                        zzf2.zze(zzfi.zzm(new byte[]{((Number) zza2).byteValue()}, 0, 1));
                    } else if (zza2 instanceof Long) {
                        zzf2.zzu(((Number) zza2).longValue());
                    } else if (zza2 instanceof Double) {
                        zzf2.zzq(((Number) zza2).doubleValue());
                    } else if (zza2 instanceof Float) {
                        zzf2.zzr(((Number) zza2).floatValue());
                    } else if (zza2 instanceof Boolean) {
                        zzf2.zzd(((Boolean) zza2).booleanValue());
                    } else if (zza2 instanceof Character) {
                        zzf2.zzp(zza2.toString());
                    } else if (zza2 instanceof String) {
                        zzf2.zzv((String) zza2);
                    } else {
                        zzf2.zzv(zza2.toString());
                    }
                    zzf.zze((zznf) zzf2.zzj());
                    i12++;
                } else {
                    throw new zzs(4, 4, (Throwable) null);
                }
            }
            zzbi zze = zzbh.zze();
            byte[] zzd = ((zzng) zzf.zzj()).zzd();
            zze.zzf(i11, zzek.zzh().zzi(zzd, 0, zzd.length));
            return;
        }
        throw new zzs(4, 3, (Throwable) null);
    }
}
