package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractScheduledService;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AbstractScheduledService.ServiceDelegate f44708b;

    public /* synthetic */ g(AbstractScheduledService.ServiceDelegate serviceDelegate) {
        this.f44708b = serviceDelegate;
    }

    public final void run() {
        this.f44708b.lambda$doStart$1();
    }
}
