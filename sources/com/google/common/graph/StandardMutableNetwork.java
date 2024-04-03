package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Objects;

@ElementTypesAreNonnullByDefault
final class StandardMutableNetwork<N, E> extends StandardNetwork<N, E> implements MutableNetwork<N, E> {
    public StandardMutableNetwork(NetworkBuilder<? super N, ? super E> networkBuilder) {
        super(networkBuilder);
    }

    @CanIgnoreReturnValue
    private NetworkConnections<N, E> addNodeInternal(N n11) {
        boolean z11;
        NetworkConnections<N, E> newConnections = newConnections();
        if (this.nodeConnections.put(n11, newConnections) == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkState(z11);
        return newConnections;
    }

    private NetworkConnections<N, E> newConnections() {
        if (isDirected()) {
            if (allowsParallelEdges()) {
                return DirectedMultiNetworkConnections.of();
            }
            return DirectedNetworkConnections.of();
        } else if (allowsParallelEdges()) {
            return UndirectedMultiNetworkConnections.of();
        } else {
            return UndirectedNetworkConnections.of();
        }
    }

    @CanIgnoreReturnValue
    public boolean addEdge(N n11, N n12, E e11) {
        Preconditions.checkNotNull(n11, "nodeU");
        Preconditions.checkNotNull(n12, "nodeV");
        Preconditions.checkNotNull(e11, "edge");
        boolean z11 = false;
        if (containsEdge(e11)) {
            EndpointPair incidentNodes = incidentNodes(e11);
            EndpointPair of2 = EndpointPair.of((Network<?, ?>) this, n11, n12);
            Preconditions.checkArgument(incidentNodes.equals(of2), "Edge %s already exists between the following nodes: %s, so it cannot be reused to connect the following nodes: %s.", e11, incidentNodes, of2);
            return false;
        }
        NetworkConnections networkConnections = this.nodeConnections.get(n11);
        if (!allowsParallelEdges()) {
            if (networkConnections == null || !networkConnections.successors().contains(n12)) {
                z11 = true;
            }
            Preconditions.checkArgument(z11, "Nodes %s and %s are already connected by a different edge. To construct a graph that allows parallel edges, call allowsParallelEdges(true) on the Builder.", (Object) n11, (Object) n12);
        }
        boolean equals = n11.equals(n12);
        if (!allowsSelfLoops()) {
            Preconditions.checkArgument(!equals, "Cannot add self-loop edge on node %s, as self-loops are not allowed. To construct a graph that allows self-loops, call allowsSelfLoops(true) on the Builder.", (Object) n11);
        }
        if (networkConnections == null) {
            networkConnections = addNodeInternal(n11);
        }
        networkConnections.addOutEdge(e11, n12);
        NetworkConnections networkConnections2 = this.nodeConnections.get(n12);
        if (networkConnections2 == null) {
            networkConnections2 = addNodeInternal(n12);
        }
        networkConnections2.addInEdge(e11, n11, equals);
        this.edgeToReferenceNode.put(e11, n11);
        return true;
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

    @CanIgnoreReturnValue
    public boolean removeEdge(E e11) {
        Preconditions.checkNotNull(e11, "edge");
        N n11 = this.edgeToReferenceNode.get(e11);
        boolean z11 = false;
        if (n11 == null) {
            return false;
        }
        NetworkConnections networkConnections = this.nodeConnections.get(n11);
        Objects.requireNonNull(networkConnections);
        NetworkConnections networkConnections2 = networkConnections;
        Object adjacentNode = networkConnections2.adjacentNode(e11);
        NetworkConnections networkConnections3 = this.nodeConnections.get(adjacentNode);
        Objects.requireNonNull(networkConnections3);
        NetworkConnections networkConnections4 = networkConnections3;
        networkConnections2.removeOutEdge(e11);
        if (allowsSelfLoops() && n11.equals(adjacentNode)) {
            z11 = true;
        }
        networkConnections4.removeInEdge(e11, z11);
        this.edgeToReferenceNode.remove(e11);
        return true;
    }

    @CanIgnoreReturnValue
    public boolean removeNode(N n11) {
        Preconditions.checkNotNull(n11, "node");
        NetworkConnections networkConnections = this.nodeConnections.get(n11);
        if (networkConnections == null) {
            return false;
        }
        UnmodifiableIterator it = ImmutableList.copyOf(networkConnections.incidentEdges()).iterator();
        while (it.hasNext()) {
            removeEdge(it.next());
        }
        this.nodeConnections.remove(n11);
        return true;
    }

    @CanIgnoreReturnValue
    public boolean addEdge(EndpointPair<N> endpointPair, E e11) {
        validateEndpoints(endpointPair);
        return addEdge(endpointPair.nodeU(), endpointPair.nodeV(), e11);
    }
}
