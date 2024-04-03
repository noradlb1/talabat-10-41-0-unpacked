package com.google.android.recaptcha.internal;

import org.jetbrains.annotations.NotNull;

public final class zzcv implements zzca {
    @NotNull
    public static final zzcv zza = new zzcv();

    private zzcv() {
    }

    public final void zza(int i11, @NotNull zzbh zzbh, @NotNull zznl... zznlArr) throws zzs {
        int length = zznlArr.length;
        if (length == 2) {
            Object zza2 = zzbh.zze().zza(zznlArr[0]);
            if (true != (zza2 instanceof String)) {
                zza2 = null;
            }
            String str = (String) zza2;
            if (str != null) {
                Object zza3 = zzbh.zze().zza(zznlArr[1]);
                if (true != (zza3 instanceof zzm)) {
                    zza3 = null;
                }
                zzm zzm = (zzm) zza3;
                if (zzm != null) {
                    byte[] zzd = zzar.zza(zzbh.zzc(), zzm).zzd();
                    zzbh.zzd().zzb(str, zzek.zzh().zzi(zzd, 0, zzd.length));
                    return;
                }
                throw new zzs(4, 5, (Throwable) null);
            }
            throw new zzs(4, 5, (Throwable) null);
        } else if (length == 0) {
            zzbh.zze().zzf(i11, new zzm());
        } else {
            throw new zzs(4, 3, (Throwable) null);
        }
    }
}
