package com.google.common.graph;

import com.google.common.base.Preconditions;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
class StandardValueGraph<N, V> extends AbstractValueGraph<N, V> {
    private final boolean allowsSelfLoops;
    long edgeCount;
    private final boolean isDirected;
    final MapIteratorCache<N, GraphConnections<N, V>> nodeConnections;
    private final ElementOrder<N> nodeOrder;

    public StandardValueGraph(AbstractGraphBuilder<? super N> abstractGraphBuilder) {
        this(abstractGraphBuilder, abstractGraphBuilder.nodeOrder.createMap(abstractGraphBuilder.expectedNodeCount.or(10).intValue()), 0);
    }

    private final GraphConnections<N, V> checkedConnections(N n11) {
        GraphConnections<N, V> graphConnections = this.nodeConnections.get(n11);
        if (graphConnections != null) {
            return graphConnections;
        }
        Preconditions.checkNotNull(n11);
        throw new IllegalArgumentException("Node " + n11 + " is not an element of this graph.");
    }

    @CheckForNull
    private final V edgeValueOrDefaultInternal(N n11, N n12, @CheckForNull V v11) {
        V v12;
        GraphConnections graphConnections = this.nodeConnections.get(n11);
        if (graphConnections == null) {
            v12 = null;
        } else {
            v12 = graphConnections.value(n12);
        }
        if (v12 == null) {
            return v11;
        }
        return v12;
    }

    private final boolean hasEdgeConnectingInternal(N n11, N n12) {
        GraphConnections graphConnections = this.nodeConnections.get(n11);
        if (graphConnections == null || !graphConnections.successors().contains(n12)) {
            return false;
        }
        return true;
    }

    public Set<N> adjacentNodes(N n11) {
        return checkedConnections(n11).adjacentNodes();
    }

    public boolean allowsSelfLoops() {
        return this.allowsSelfLoops;
    }

    public final boolean containsNode(@CheckForNull N n11) {
        return this.nodeConnections.containsKey(n11);
    }

    public long edgeCount() {
        return this.edgeCount;
    }

    @CheckForNull
    public V edgeValueOrDefault(N n11, N n12, @CheckForNull V v11) {
        return edgeValueOrDefaultInternal(Preconditions.checkNotNull(n11), Preconditions.checkNotNull(n12), v11);
    }

    public boolean hasEdgeConnecting(N n11, N n12) {
        return hasEdgeConnectingInternal(Preconditions.checkNotNull(n11), Preconditions.checkNotNull(n12));
    }

    public Set<EndpointPair<N>> incidentEdges(N n11) {
        final GraphConnections checkedConnections = checkedConnections(n11);
        return new IncidentEdgeSet<N>(this, this, n11) {
            public Iterator<EndpointPair<N>> iterator() {
                return checkedConnections.incidentEdgeIterator(this.node);
            }
        };
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

    @CheckForNull
    public V edgeValueOrDefault(EndpointPair<N> endpointPair, @CheckForNull V v11) {
        validateEndpoints(endpointPair);
        return edgeValueOrDefaultInternal(endpointPair.nodeU(), endpointPair.nodeV(), v11);
    }

    public boolean hasEdgeConnecting(EndpointPair<N> endpointPair) {
        Preconditions.checkNotNull(endpointPair);
        return isOrderingCompatible(endpointPair) && hasEdgeConnectingInternal(endpointPair.nodeU(), endpointPair.nodeV());
    }

    public Set<N> predecessors(N n11) {
        return checkedConnections(n11).predecessors();
    }

    public Set<N> successors(N n11) {
        return checkedConnections(n11).successors();
    }

    public StandardValueGraph(AbstractGraphBuilder<? super N> abstractGraphBuilder, Map<N, GraphConnections<N, V>> map, long j11) {
        MapIteratorCache<N, GraphConnections<N, V>> mapIteratorCache;
        this.isDirected = abstractGraphBuilder.directed;
        this.allowsSelfLoops = abstractGraphBuilder.allowsSelfLoops;
        this.nodeOrder = abstractGraphBuilder.nodeOrder.cast();
        if (map instanceof TreeMap) {
            mapIteratorCache = new MapRetrievalCache<>(map);
        } else {
            mapIteratorCache = new MapIteratorCache<>(map);
        }
        this.nodeConnections = mapIteratorCache;
        this.edgeCount = Graphs.checkNonNegative(j11);
    }
}
