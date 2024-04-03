package com.google.firebase.messaging;

import com.google.firebase.messaging.WithinAppServiceConnection;

public final /* synthetic */ class o implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WithinAppServiceConnection.BindRequest f47445b;

    public /* synthetic */ o(WithinAppServiceConnection.BindRequest bindRequest) {
        this.f47445b = bindRequest;
    }

    public final void run() {
        this.f47445b.lambda$arrangeTimeout$0();
    }
}
