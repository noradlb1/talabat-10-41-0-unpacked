package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

@ElementTypesAreNonnullByDefault
class StandardNetwork<N, E> extends AbstractNetwork<N, E> {
    private final boolean allowsParallelEdges;
    private final boolean allowsSelfLoops;
    private final ElementOrder<E> edgeOrder;
    final MapIteratorCache<E, N> edgeToReferenceNode;
    private final boolean isDirected;
    final MapIteratorCache<N, NetworkConnections<N, E>> nodeConnections;
    private final ElementOrder<N> nodeOrder;

    public StandardNetwork(NetworkBuilder<? super N, ? super E> networkBuilder) {
        this(networkBuilder, networkBuilder.nodeOrder.createMap(networkBuilder.expectedNodeCount.or(10).intValue()), networkBuilder.edgeOrder.createMap(networkBuilder.expectedEdgeCount.or(20).intValue()));
    }

    public Set<N> adjacentNodes(N n11) {
        return checkedConnections(n11).adjacentNodes();
    }

    public boolean allowsParallelEdges() {
        return this.allowsParallelEdges;
    }

    public boolean allowsSelfLoops() {
        return this.allowsSelfLoops;
    }

    public final NetworkConnections<N, E> checkedConnections(N n11) {
        NetworkConnections<N, E> networkConnections = this.nodeConnections.get(n11);
        if (networkConnections != null) {
            return networkConnections;
        }
        Preconditions.checkNotNull(n11);
        throw new IllegalArgumentException(String.format("Node %s is not an element of this graph.", new Object[]{n11}));
    }

    public final N checkedReferenceNode(E e11) {
        N n11 = this.edgeToReferenceNode.get(e11);
        if (n11 != null) {
            return n11;
        }
        Preconditions.checkNotNull(e11);
        throw new IllegalArgumentException(String.format("Edge %s is not an element of this graph.", new Object[]{e11}));
    }

    public final boolean containsEdge(E e11) {
        return this.edgeToReferenceNode.containsKey(e11);
    }

    public final boolean containsNode(N n11) {
        return this.nodeConnections.containsKey(n11);
    }

    public ElementOrder<E> edgeOrder() {
        return this.edgeOrder;
    }

    public Set<E> edges() {
        return this.edgeToReferenceNode.unmodifiableKeySet();
    }

    public Set<E> edgesConnecting(N n11, N n12) {
        NetworkConnections checkedConnections = checkedConnections(n11);
        if (!this.allowsSelfLoops && n11 == n12) {
            return ImmutableSet.of();
        }
        Preconditions.checkArgument(containsNode(n12), "Node %s is not an element of this graph.", (Object) n12);
        return checkedConnections.edgesConnecting(n12);
    }

    public Set<E> inEdges(N n11) {
        return checkedConnections(n11).inEdges();
    }

    public Set<E> incidentEdges(N n11) {
        return checkedConnections(n11).incidentEdges();
    }

    public EndpointPair<N> incidentNodes(E e11) {
        Object checkedReferenceNode = checkedReferenceNode(e11);
        NetworkConnections networkConnections = this.nodeConnections.get(checkedReferenceNode);
        Objects.requireNonNull(networkConnections);
        return EndpointPair.of((Network<?, ?>) this, checkedReferenceNode, networkConnections.adjacentNode(e11));
    }

    public boolean isDirected() {
        return this.isDirected;
    }

    public ElementOrder<N> nodeOrder() {
        return this.nodeOrder;
    }

    public Set<N> nodes() {
        return this.nodeConnections.unmodifiableKeySet();
    }

    public Set<E> outEdges(N n11) {
        return checkedConnections(n11).outEdges();
    }

    public Set<N> predecessors(N n11) {
        return checkedConnections(n11).predecessors();
    }

    public Set<N> successors(N n11) {
        return checkedConnections(n11).successors();
    }

    public StandardNetwork(NetworkBuilder<? super N, ? super E> networkBuilder, Map<N, NetworkConnections<N, E>> map, Map<E, N> map2) {
        MapIteratorCache<N, NetworkConnections<N, E>> mapIteratorCache;
        this.isDirected = networkBuilder.directed;
        this.allowsParallelEdges = networkBuilder.allowsParallelEdges;
        this.allowsSelfLoops = networkBuilder.allowsSelfLoops;
        this.nodeOrder = networkBuilder.nodeOrder.cast();
        this.edgeOrder = networkBuilder.edgeOrder.cast();
        if (map instanceof TreeMap) {
            mapIteratorCache = new MapRetrievalCache<>(map);
        } else {
            mapIteratorCache = new MapIteratorCache<>(map);
        }
        this.nodeConnections = mapIteratorCache;
        this.edgeToReferenceNode = new MapIteratorCache<>(map2);
    }
}
