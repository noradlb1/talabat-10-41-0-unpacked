package com.google.common.cache;

import com.google.common.base.Function;
import com.google.common.cache.LocalCache;

public final /* synthetic */ class b implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LocalCache.LoadingValueReference f44631b;

    public /* synthetic */ b(LocalCache.LoadingValueReference loadingValueReference) {
        this.f44631b = loadingValueReference;
    }

    public final Object apply(Object obj) {
        return this.f44631b.lambda$loadFuture$0(obj);
    }
}
