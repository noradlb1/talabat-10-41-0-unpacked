package com.google.android.recaptcha.internal;

import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

public final class zzg {
    private zzg() {
    }

    public /* synthetic */ zzg(DefaultConstructorMarker defaultConstructorMarker) {
    }

    @NotNull
    public static final zzh zza(@NotNull zzmw zzmw) {
        zzh zzh = (zzh) zzh.zzb.get(zzmw);
        if (zzh == null) {
            return new zzh(zzf.zzb, zzd.zzb);
        }
        return zzh;
    }
}
