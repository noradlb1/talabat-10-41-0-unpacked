package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabs  reason: invalid package */
public class zzabs {
    zzaao zza;
    Executor zzb;

    public final Task zzU(zzabr zzabr) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.zzb.execute(new zzabq(this, zzabr, taskCompletionSource));
        return taskCompletionSource.getTask();
    }
}
