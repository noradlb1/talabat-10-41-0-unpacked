package com.google.common.graph;

import com.google.common.base.Function;
import com.google.common.graph.DirectedGraphConnections;

public final /* synthetic */ class h implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f44658b;

    public /* synthetic */ h(Object obj) {
        this.f44658b = obj;
    }

    public final Object apply(Object obj) {
        return DirectedGraphConnections.lambda$incidentEdgeIterator$2(this.f44658b, (DirectedGraphConnections.NodeConnection) obj);
    }
}
