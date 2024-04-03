package com.google.firebase.messaging;

import android.content.Context;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f47432b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f47433c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f47434d;

    public /* synthetic */ i(Context context, boolean z11, TaskCompletionSource taskCompletionSource) {
        this.f47432b = context;
        this.f47433c = z11;
        this.f47434d = taskCompletionSource;
    }

    public final void run() {
        ProxyNotificationInitializer.lambda$setEnableProxyNotification$0(this.f47432b, this.f47433c, this.f47434d);
    }
}
