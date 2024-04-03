package com.google.common.util.concurrent;

import com.google.common.base.Supplier;
import com.google.common.util.concurrent.AbstractScheduledService;

public final /* synthetic */ class f implements Supplier {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AbstractScheduledService.ServiceDelegate f44707b;

    public /* synthetic */ f(AbstractScheduledService.ServiceDelegate serviceDelegate) {
        this.f44707b = serviceDelegate;
    }

    public final Object get() {
        return this.f44707b.lambda$doStart$0();
    }
}
