package com.google.android.libraries.places.internal;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;

public final /* synthetic */ class zzeg implements Continuation {
    public final /* synthetic */ zzei zza;

    public /* synthetic */ zzeg(zzei zzei) {
        this.zza = zzei;
    }

    public final Object then(Task task) {
        zzei zzei = this.zza;
        int i11 = zzel.zza;
        if (zzei.zza().getToken().isCancellationRequested()) {
            return Tasks.forCanceled();
        }
        return task;
    }
}
