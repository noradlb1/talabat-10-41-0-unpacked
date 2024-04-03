package com.google.common.graph;

import com.google.common.base.Function;

public final /* synthetic */ class j implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f44660b;

    public /* synthetic */ j(Object obj) {
        this.f44660b = obj;
    }

    public final Object apply(Object obj) {
        return EndpointPair.unordered(this.f44660b, obj);
    }
}
