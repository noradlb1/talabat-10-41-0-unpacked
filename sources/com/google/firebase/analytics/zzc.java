package com.google.firebase.analytics;

import androidx.annotation.Nullable;
import java.util.concurrent.Callable;

final class zzc implements Callable {
    final /* synthetic */ FirebaseAnalytics zza;

    public zzc(FirebaseAnalytics firebaseAnalytics) {
        this.zza = firebaseAnalytics;
    }

    @Nullable
    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        return this.zza.zzb.zzh();
    }
}
