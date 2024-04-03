package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractScheduledService;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AbstractScheduledService.ServiceDelegate f44706b;

    public /* synthetic */ e(AbstractScheduledService.ServiceDelegate serviceDelegate) {
        this.f44706b = serviceDelegate;
    }

    public final void run() {
        this.f44706b.lambda$doStop$2();
    }
}
