package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractIdleService;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AbstractIdleService.DelegateService f44704b;

    public /* synthetic */ c(AbstractIdleService.DelegateService delegateService) {
        this.f44704b = delegateService;
    }

    public final void run() {
        this.f44704b.lambda$doStop$1();
    }
}
