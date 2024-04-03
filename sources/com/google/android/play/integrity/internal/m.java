package com.google.android.play.integrity.internal;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class m implements OnCompleteListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ v f44579a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f44580b;

    public /* synthetic */ m(v vVar, TaskCompletionSource taskCompletionSource) {
        this.f44579a = vVar;
        this.f44580b = taskCompletionSource;
    }

    public final void onComplete(Task task) {
        this.f44579a.q(this.f44580b, task);
    }
}
