package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Objects;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
final class StandardMutableValueGraph<N, V> extends StandardValueGraph<N, V> implements MutableValueGraph<N, V> {
    private final ElementOrder<N> incidentEdgeOrder;

    public StandardMutableValueGraph(AbstractGraphBuilder<? super N> abstractGraphBuilder) {
        super(abstractGraphBuilder);
        this.incidentEdgeOrder = abstractGraphBuilder.incidentEdgeOrder.cast();
    }

    @CanIgnoreReturnValue
    private GraphConnections<N, V> addNodeInternal(N n11) {
        boolean z11;
        GraphConnections<N, V> newConnections = newConnections();
        if (this.nodeConnections.put(n11, newConnections) == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkState(z11);
        return newConnections;
    }

    private GraphConnections<N, V> newConnections() {
        if (isDirected()) {
            return DirectedGraphConnections.of(this.incidentEdgeOrder);
        }
        return UndirectedGraphConnections.of(this.incidentEdgeOrder);
    }

    @CanIgnoreReturnValue
    public boolean addNode(N n11) {
        Preconditions.checkNotNull(n11, "node");
        if (containsNode(n11)) {
            return false;
        }
        addNodeInternal(n11);
        return true;
    }

    public ElementOrder<N> incidentEdgeOrder() {
        return this.incidentEdgeOrder;
    }

    @CheckForNull
    @CanIgnoreReturnValue
    public V putEdgeValue(N n11, N n12, V v11) {
        Preconditions.checkNotNull(n11, "nodeU");
        Preconditions.checkNotNull(n12, "nodeV");
        Preconditions.checkNotNull(v11, "value");
        if (!allowsSelfLoops()) {
            Preconditions.checkArgument(!n11.equals(n12), "Cannot add self-loop edge on node %s, as self-loops are not allowed. To construct a graph that allows self-loops, call allowsSelfLoops(true) on the Builder.", (Object) n11);
        }
        GraphConnections graphConnections = this.nodeConnections.get(n11);
        if (graphConnections == null) {
            graphConnections = addNodeInternal(n11);
        }
        V addSuccessor = graphConnections.addSuccessor(n12, v11);
        GraphConnections graphConnections2 = this.nodeConnections.get(n12);
        if (graphConnections2 == null) {
            graphConnections2 = addNodeInternal(n12);
        }
        graphConnections2.addPredecessor(n11, v11);
        if (addSuccessor == null) {
            long j11 = this.edgeCount + 1;
            this.edgeCount = j11;
            Graphs.checkPositive(j11);
        }
        return addSuccessor;
    }

    @CheckForNull
    @CanIgnoreReturnValue
    public V removeEdge(N n11, N n12) {
        Preconditions.checkNotNull(n11, "nodeU");
        Preconditions.checkNotNull(n12, "nodeV");
        GraphConnections graphConnections = this.nodeConnections.get(n11);
        GraphConnections graphConnections2 = this.nodeConnections.get(n12);
        if (graphConnections == null || graphConnections2 == null) {
            return null;
        }
        V removeSuccessor = graphConnections.removeSuccessor(n12);
        if (removeSuccessor != null) {
            graphConnections2.removePredecessor(n11);
            long j11 = this.edgeCount - 1;
            this.edgeCount = j11;
            Graphs.checkNonNegative(j11);
        }
        return removeSuccessor;
    }

    @CanIgnoreReturnValue
    public boolean removeNode(N n11) {
        boolean z11;
        Preconditions.checkNotNull(n11, "node");
        GraphConnections graphConnections = this.nodeConnections.get(n11);
        if (graphConnections == null) {
            return false;
        }
        if (allowsSelfLoops() && graphConnections.removeSuccessor(n11) != null) {
            graphConnections.removePredecessor(n11);
            this.edgeCount--;
        }
        for (Object withoutCaching : graphConnections.successors()) {
            GraphConnections withoutCaching2 = this.nodeConnections.getWithoutCaching(withoutCaching);
            Objects.requireNonNull(withoutCaching2);
            withoutCaching2.removePredecessor(n11);
            this.edgeCount--;
        }
        if (isDirected()) {
            for (Object withoutCaching3 : graphConnections.predecessors()) {
                GraphConnections withoutCaching4 = this.nodeConnections.getWithoutCaching(withoutCaching3);
                Objects.requireNonNull(withoutCaching4);
                if (withoutCaching4.removeSuccessor(n11) != null) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                Preconditions.checkState(z11);
                this.edgeCount--;
            }
        }
        this.nodeConnections.remove(n11);
        Graphs.checkNonNegative(this.edgeCount);
        return true;
    }

    @CheckForNull
    @CanIgnoreReturnValue
    public V removeEdge(EndpointPair<N> endpointPair) {
        validateEndpoints(endpointPair);
        return removeEdge(endpointPair.nodeU(), endpointPair.nodeV());
    }

    @CheckForNull
    @CanIgnoreReturnValue
    public V putEdgeValue(EndpointPair<N> endpointPair, V v11) {
        validateEndpoints(endpointPair);
        return putEdgeValue(endpointPair.nodeU(), endpointPair.nodeV(), v11);
    }
}
