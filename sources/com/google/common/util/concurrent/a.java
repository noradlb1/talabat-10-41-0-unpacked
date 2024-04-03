package com.google.common.util.concurrent;

import com.google.common.base.Supplier;
import com.google.common.util.concurrent.AbstractExecutionThreadService;

public final /* synthetic */ class a implements Supplier {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AbstractExecutionThreadService.AnonymousClass1 f44702b;

    public /* synthetic */ a(AbstractExecutionThreadService.AnonymousClass1 r12) {
        this.f44702b = r12;
    }

    public final Object get() {
        return this.f44702b.lambda$doStart$0();
    }
}
