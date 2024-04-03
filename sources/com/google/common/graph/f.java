package com.google.common.graph;

import com.google.common.base.Function;

public final /* synthetic */ class f implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f44656b;

    public /* synthetic */ f(Object obj) {
        this.f44656b = obj;
    }

    public final Object apply(Object obj) {
        return EndpointPair.ordered(obj, this.f44656b);
    }
}
