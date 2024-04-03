package com.google.firebase.database.core;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.Query;
import com.google.firebase.database.core.Repo;

public final /* synthetic */ class d implements OnCompleteListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Repo.AnonymousClass9 f47406b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f47407c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ DataSnapshot f47408d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Query f47409e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ Repo f47410f;

    public /* synthetic */ d(Repo.AnonymousClass9 r12, TaskCompletionSource taskCompletionSource, DataSnapshot dataSnapshot, Query query, Repo repo) {
        this.f47406b = r12;
        this.f47407c = taskCompletionSource;
        this.f47408d = dataSnapshot;
        this.f47409e = query;
        this.f47410f = repo;
    }

    public final void onComplete(Task task) {
        this.f47406b.lambda$run$1(this.f47407c, this.f47408d, this.f47409e, this.f47410f, task);
    }
}
