package com.google.android.gms.internal.ads;

import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class zzfmg implements Runnable {
    public final /* synthetic */ TaskCompletionSource zza;

    public /* synthetic */ zzfmg(TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    public final void run() {
        this.zza.setResult(zzfoj.zzc());
    }
}
