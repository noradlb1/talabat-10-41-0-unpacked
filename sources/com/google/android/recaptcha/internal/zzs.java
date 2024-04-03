package com.google.android.recaptcha.internal;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class zzs extends Exception {
    @Nullable
    private final Throwable zza;
    @NotNull
    private final zznb zzb;
    @NotNull
    private final int zzc;
    @NotNull
    private final int zzd;

    public zzs(@NotNull int i11, @NotNull int i12, @Nullable Throwable th2) {
        this.zzc = i11;
        this.zzd = i12;
        this.zza = th2;
        zznb zzf = zznc.zzf();
        zzf.zze(i12);
        zzf.zzp(i11);
        this.zzb = zzf;
    }

    @Nullable
    public final Throwable getCause() {
        return this.zza;
    }

    @NotNull
    public final zznb zza() {
        return this.zzb;
    }
}
