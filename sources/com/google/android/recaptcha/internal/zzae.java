package com.google.android.recaptcha.internal;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class zzae {
    @NotNull
    private final String zza;
    private final long zzb;
    private final int zzc;

    public zzae(@NotNull String str, long j11, int i11) {
        this.zza = str;
        this.zzb = j11;
        this.zzc = i11;
    }

    public final boolean equals(@Nullable Object obj) {
        if (!(obj instanceof zzae)) {
            return false;
        }
        zzae zzae = (zzae) obj;
        if (Intrinsics.areEqual((Object) zzae.zza, (Object) this.zza) && zzae.zzb == this.zzb && zzae.zzc == this.zzc) {
            return true;
        }
        return false;
    }

    public final int zza() {
        return this.zzc;
    }

    public final long zzb() {
        return this.zzb;
    }

    @NotNull
    public final String zzc() {
        return this.zza;
    }
}
