package com.google.android.gms.internal.ads;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

public final /* synthetic */ class zzfme implements Continuation {
    public static final /* synthetic */ zzfme zza = new zzfme();

    private /* synthetic */ zzfme() {
    }

    public final Object then(Task task) {
        return Boolean.valueOf(task.isSuccessful());
    }
}
