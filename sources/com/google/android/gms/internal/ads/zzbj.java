package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.io.IOException;

public class zzbj extends IOException {
    public final boolean zza;
    public final int zzb;

    public zzbj(@Nullable String str, @Nullable Throwable th2, boolean z11, int i11) {
        super(str, th2);
        this.zza = z11;
        this.zzb = i11;
    }

    public static zzbj zza(@Nullable String str, @Nullable Throwable th2) {
        return new zzbj(str, th2, true, 1);
    }

    public static zzbj zzb(@Nullable String str, @Nullable Throwable th2) {
        return new zzbj(str, th2, true, 0);
    }

    public static zzbj zzc(@Nullable String str) {
        return new zzbj(str, (Throwable) null, false, 1);
    }
}
