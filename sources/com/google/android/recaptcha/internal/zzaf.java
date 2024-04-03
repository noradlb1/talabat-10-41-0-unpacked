package com.google.android.recaptcha.internal;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class zzaf {
    @NotNull
    private final zzln zza;
    @NotNull
    private final String zzb;
    @NotNull
    private final String zzc;
    @NotNull
    private final String zzd;
    @Nullable
    private final String zze = null;

    public zzaf(@NotNull zzln zzln, @NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4) {
        this.zza = zzln;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = str3;
    }

    public final boolean equals(@Nullable Object obj) {
        if (!(obj instanceof zzaf)) {
            return false;
        }
        zzaf zzaf = (zzaf) obj;
        if (zzaf.zza != this.zza || !Intrinsics.areEqual((Object) zzaf.zzb, (Object) this.zzb) || !Intrinsics.areEqual((Object) zzaf.zzc, (Object) this.zzc) || !Intrinsics.areEqual((Object) zzaf.zzd, (Object) this.zzd) || !Intrinsics.areEqual((Object) null, (Object) null)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, this.zzb, this.zzc, this.zzd, null});
    }

    @NotNull
    public final zzln zza() {
        return this.zza;
    }

    @NotNull
    public final String zzb() {
        return this.zzb;
    }

    @NotNull
    public final String zzc() {
        return this.zzc;
    }

    @NotNull
    public final String zzd() {
        return this.zzd;
    }
}
