package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzck implements zzcs {
    final /* synthetic */ ListenerHolder zza;
    final /* synthetic */ TaskCompletionSource zzb;

    public zzck(zzda zzda, ListenerHolder listenerHolder, TaskCompletionSource taskCompletionSource) {
        this.zza = listenerHolder;
        this.zzb = taskCompletionSource;
    }

    public final ListenerHolder zza() {
        return this.zza;
    }

    public final void zzb() {
        this.zzb.trySetResult(null);
    }

    public final void zzc(ListenerHolder listenerHolder) {
        throw new IllegalStateException();
    }
}
