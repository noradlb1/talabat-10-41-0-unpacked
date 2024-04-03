package com.google.common.graph;

import com.google.common.base.Function;

public final /* synthetic */ class g implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f44657b;

    public /* synthetic */ g(Object obj) {
        this.f44657b = obj;
    }

    public final Object apply(Object obj) {
        return EndpointPair.ordered(this.f44657b, obj);
    }
}
