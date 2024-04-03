package com.google.firebase.messaging;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.WithinAppServiceConnection;

public final /* synthetic */ class n implements OnCompleteListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WithinAppServiceConnection.BindRequest f47444b;

    public /* synthetic */ n(WithinAppServiceConnection.BindRequest bindRequest) {
        this.f47444b = bindRequest;
    }

    public final void onComplete(Task task) {
        this.f47444b.finish();
    }
}
