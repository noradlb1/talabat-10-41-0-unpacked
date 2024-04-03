package com.google.firebase.messaging;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.ScheduledFuture;

public final /* synthetic */ class p implements OnCompleteListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ScheduledFuture f47446b;

    public /* synthetic */ p(ScheduledFuture scheduledFuture) {
        this.f47446b = scheduledFuture;
    }

    public final void onComplete(Task task) {
        this.f47446b.cancel(false);
    }
}
