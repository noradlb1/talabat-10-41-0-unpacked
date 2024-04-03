package com.google.common.cache;

import java.util.concurrent.Callable;

public final /* synthetic */ class a implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CacheLoader f44628b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f44629c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Object f44630d;

    public /* synthetic */ a(CacheLoader cacheLoader, Object obj, Object obj2) {
        this.f44628b = cacheLoader;
        this.f44629c = obj;
        this.f44630d = obj2;
    }

    public final Object call() {
        return this.f44628b.reload(this.f44629c, this.f44630d).get();
    }
}
