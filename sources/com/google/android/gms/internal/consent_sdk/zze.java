package com.google.android.gms.internal.consent_sdk;

import androidx.annotation.AnyThread;
import androidx.annotation.Nullable;
import java.util.concurrent.Executor;

public final class zze {
    private final Executor zza;

    public zze(Executor executor) {
        this.zza = executor;
    }

    @AnyThread
    public final void zza(@Nullable String str, @Nullable String str2, zzi... zziArr) {
        this.zza.execute(new zzg(str, str2, zziArr));
    }

    @AnyThread
    public final Executor zza() {
        return this.zza;
    }
}
