package com.google.android.libraries.places.internal;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class zzco implements OnCompleteListener {
    public final /* synthetic */ zzcq zza;
    public final /* synthetic */ TaskCompletionSource zzb;

    public /* synthetic */ zzco(zzcq zzcq, TaskCompletionSource taskCompletionSource) {
        this.zza = zzcq;
        this.zzb = taskCompletionSource;
    }

    public final void onComplete(Task task) {
        this.zza.zzb(this.zzb);
    }
}
