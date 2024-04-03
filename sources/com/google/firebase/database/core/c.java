package com.google.firebase.database.core;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.database.DataSnapshot;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f47404b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DataSnapshot f47405c;

    public /* synthetic */ c(TaskCompletionSource taskCompletionSource, DataSnapshot dataSnapshot) {
        this.f47404b = taskCompletionSource;
        this.f47405c = dataSnapshot;
    }

    public final void run() {
        this.f47404b.trySetResult(this.f47405c);
    }
}
