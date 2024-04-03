package com.google.firebase.messaging;

import android.content.Intent;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FcmLifecycleCallbacks f47419b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Intent f47420c;

    public /* synthetic */ a(FcmLifecycleCallbacks fcmLifecycleCallbacks, Intent intent) {
        this.f47419b = fcmLifecycleCallbacks;
        this.f47420c = intent;
    }

    public final void run() {
        this.f47419b.lambda$onActivityCreated$0(this.f47420c);
    }
}
