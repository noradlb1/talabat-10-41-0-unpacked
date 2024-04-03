package com.google.android.play.integrity.internal;

import androidx.annotation.Nullable;
import com.google.android.gms.tasks.TaskCompletionSource;

public abstract class l implements Runnable {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final TaskCompletionSource f44578a;

    public l() {
        this.f44578a = null;
    }

    public l(@Nullable TaskCompletionSource taskCompletionSource) {
        this.f44578a = taskCompletionSource;
    }

    public void a(Exception exc) {
        TaskCompletionSource taskCompletionSource = this.f44578a;
        if (taskCompletionSource != null) {
            taskCompletionSource.trySetException(exc);
        }
    }

    public abstract void b();

    @Nullable
    public final TaskCompletionSource c() {
        return this.f44578a;
    }

    public final void run() {
        try {
            b();
        } catch (Exception e11) {
            a(e11);
        }
    }
}
