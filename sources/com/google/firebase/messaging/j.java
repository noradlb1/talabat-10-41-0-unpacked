package com.google.firebase.messaging;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

public final /* synthetic */ class j implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RequestDeduplicator f47435a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f47436b;

    public /* synthetic */ j(RequestDeduplicator requestDeduplicator, String str) {
        this.f47435a = requestDeduplicator;
        this.f47436b = str;
    }

    public final Object then(Task task) {
        return this.f47435a.lambda$getOrStartGetTokenRequest$0(this.f47436b, task);
    }
}
