package com.google.common.util.concurrent;

import com.google.common.util.concurrent.SimpleTimeLimiter;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

public final /* synthetic */ class o implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Method f44723b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f44724c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Object[] f44725d;

    public /* synthetic */ o(Method method, Object obj, Object[] objArr) {
        this.f44723b = method;
        this.f44724c = obj;
        this.f44725d = objArr;
    }

    public final Object call() {
        return SimpleTimeLimiter.AnonymousClass1.lambda$invoke$0(this.f44723b, this.f44724c, this.f44725d);
    }
}
