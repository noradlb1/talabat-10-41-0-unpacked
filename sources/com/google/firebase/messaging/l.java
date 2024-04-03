package com.google.firebase.messaging;

import android.content.Context;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;

public final /* synthetic */ class l implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f47438b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ScheduledExecutorService f47439c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ FirebaseMessaging f47440d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Metadata f47441e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ GmsRpc f47442f;

    public /* synthetic */ l(Context context, ScheduledExecutorService scheduledExecutorService, FirebaseMessaging firebaseMessaging, Metadata metadata, GmsRpc gmsRpc) {
        this.f47438b = context;
        this.f47439c = scheduledExecutorService;
        this.f47440d = firebaseMessaging;
        this.f47441e = metadata;
        this.f47442f = gmsRpc;
    }

    public final Object call() {
        return TopicsSubscriber.lambda$createInstance$0(this.f47438b, this.f47439c, this.f47440d, this.f47441e, this.f47442f);
    }
}
