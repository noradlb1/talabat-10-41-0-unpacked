package com.google.android.recaptcha.internal;

import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

public final class zzcy {
    @NotNull
    public static final zzcx zza = new zzcx((DefaultConstructorMarker) null);
    private int zzb;

    public zzcy(short s11, short s12) {
        this.zzb = Math.abs(s11);
    }

    public final short zza() {
        int i11 = ((this.zzb * 4391) + 277) % 32779;
        this.zzb = i11;
        return (short) (i11 % 255);
    }
}
