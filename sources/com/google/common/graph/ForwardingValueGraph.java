package com.google.common.graph;

import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
abstract class ForwardingValueGraph<N, V> extends AbstractValueGraph<N, V> {
    public Set<N> adjacentNodes(N n11) {
        return delegate().adjacentNodes(n11);
    }

    public boolean allowsSelfLoops() {
        return delegate().allowsSelfLoops();
    }

    public int degree(N n11) {
        return delegate().degree(n11);
    }

    public abstract ValueGraph<N, V> delegate();

    public long edgeCount() {
        return (long) delegate().edges().size();
    }

    @CheckForNull
    public V edgeValueOrDefault(N n11, N n12, @CheckForNull V v11) {
        return delegate().edgeValueOrDefault(n11, n12, v11);
    }

    public boolean hasEdgeConnecting(N n11, N n12) {
        return delegate().hasEdgeConnecting(n11, n12);
    }

    public int inDegree(N n11) {
        return delegate().inDegree(n11);
    }

    public ElementOrder<N> incidentEdgeOrder() {
        return delegate().incidentEdgeOrder();
    }

    public boolean isDirected() {
        return delegate().isDirected();
    }

    public ElementOrder<N> nodeOrder() {
        return delegate().nodeOrder();
    }

    public Set<N> nodes() {
        return delegate().nodes();
    }

    public int outDegree(N n11) {
        return delegate().outDegree(n11);
    }

    @CheckForNull
    public V edgeValueOrDefault(EndpointPair<N> endpointPair, @CheckForNull V v11) {
        return delegate().edgeValueOrDefault(endpointPair, v11);
    }

    public boolean hasEdgeConnecting(EndpointPair<N> endpointPair) {
        return delegate().hasEdgeConnecting(endpointPair);
    }

    public Set<N> predecessors(N n11) {
        return delegate().predecessors((Object) n11);
    }

    public Set<N> successors(N n11) {
        return delegate().successors((Object) n11);
    }
}
