package com.google.common.graph;

import com.google.common.base.Function;
import com.google.common.graph.Graphs;

public final /* synthetic */ class i implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Graphs.TransposedGraph.AnonymousClass1 f44659b;

    public /* synthetic */ i(Graphs.TransposedGraph.AnonymousClass1 r12) {
        this.f44659b = r12;
    }

    public final Object apply(Object obj) {
        return this.f44659b.lambda$iterator$0((EndpointPair) obj);
    }
}
