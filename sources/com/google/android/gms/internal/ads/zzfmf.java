package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class zzfmf implements Runnable {
    public final /* synthetic */ Context zza;
    public final /* synthetic */ TaskCompletionSource zzb;

    public /* synthetic */ zzfmf(Context context, TaskCompletionSource taskCompletionSource) {
        this.zza = context;
        this.zzb = taskCompletionSource;
    }

    public final void run() {
        this.zzb.setResult(zzfoj.zzb(this.zza, "GLAS", (String) null));
    }
}
