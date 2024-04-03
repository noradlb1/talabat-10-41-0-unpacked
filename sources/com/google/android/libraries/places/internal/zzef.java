package com.google.android.libraries.places.internal;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;

public final /* synthetic */ class zzef implements Continuation {
    public final /* synthetic */ zzeh zza;

    public /* synthetic */ zzef(zzeh zzeh) {
        this.zza = zzeh;
    }

    public final Object then(Task task) {
        zzeh zzeh = this.zza;
        int i11 = zzel.zza;
        if (zzeh.zza().getToken().isCancellationRequested()) {
            return Tasks.forCanceled();
        }
        return task;
    }
}
