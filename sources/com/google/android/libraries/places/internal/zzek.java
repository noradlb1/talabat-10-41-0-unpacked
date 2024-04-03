package com.google.android.libraries.places.internal;

import androidx.annotation.Nullable;
import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.Task;

abstract class zzek<T> {
    private Task<T> zza;

    public /* synthetic */ zzek(zzej zzej) {
    }

    public abstract CancellationTokenSource zza();

    @Nullable
    public final Task<T> zzc() {
        return this.zza;
    }

    public final void zzd(Task<T> task) {
        this.zza = task;
    }
}
