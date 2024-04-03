package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractIdleService;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AbstractIdleService.DelegateService f44705b;

    public /* synthetic */ d(AbstractIdleService.DelegateService delegateService) {
        this.f44705b = delegateService;
    }

    public final void run() {
        this.f44705b.lambda$doStart$0();
    }
}
