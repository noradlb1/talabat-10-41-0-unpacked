package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Immutable;
import d9.d;
import d9.e;
import d9.f;
import java.util.Map;
import java.util.Set;

@ElementTypesAreNonnullByDefault
@Immutable(containerOf = {"N", "E"})
@Beta
public final class ImmutableNetwork<N, E> extends StandardNetwork<N, E> {

    public static class Builder<N, E> {
        private final MutableNetwork<N, E> mutableNetwork;

        public Builder(NetworkBuilder<N, E> networkBuilder) {
            this.mutableNetwork = networkBuilder.build();
        }

        @CanIgnoreReturnValue
        public Builder<N, E> addEdge(N n11, N n12, E e11) {
            this.mutableNetwork.addEdge(n11, n12, e11);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<N, E> addNode(N n11) {
            this.mutableNetwork.addNode(n11);
            return this;
        }

        public ImmutableNetwork<N, E> build() {
            return ImmutableNetwork.copyOf(this.mutableNetwork);
        }

        @CanIgnoreReturnValue
        public Builder<N, E> addEdge(EndpointPair<N> endpointPair, E e11) {
            this.mutableNetwork.addEdge(endpointPair, e11);
            return this;
        }
    }

    private ImmutableNetwork(Network<N, E> network) {
        super(NetworkBuilder.from(network), getNodeConnections(network), getEdgeToReferenceNode(network));
    }

    private static <N, E> Function<E, N> adjacentNodeFn(Network<N, E> network, N n11) {
        return new f(network, n11);
    }

    private static <N, E> NetworkConnections<N, E> connectionsOf(Network<N, E> network, N n11) {
        if (network.isDirected()) {
            Map<K, V> asMap = Maps.asMap(network.inEdges(n11), sourceNodeFn(network));
            Map<K, V> asMap2 = Maps.asMap(network.outEdges(n11), targetNodeFn(network));
            int size = network.edgesConnecting(n11, n11).size();
            if (network.allowsParallelEdges()) {
                return DirectedMultiNetworkConnections.ofImmutable(asMap, asMap2, size);
            }
            return DirectedNetworkConnections.ofImmutable(asMap, asMap2, size);
        }
        Map<K, V> asMap3 = Maps.asMap(network.incidentEdges(n11), adjacentNodeFn(network, n11));
        if (network.allowsParallelEdges()) {
            return UndirectedMultiNetworkConnections.ofImmutable(asMap3);
        }
        return UndirectedNetworkConnections.ofImmutable(asMap3);
    }

    public static <N, E> ImmutableNetwork<N, E> copyOf(Network<N, E> network) {
        if (network instanceof ImmutableNetwork) {
            return (ImmutableNetwork) network;
        }
        return new ImmutableNetwork<>(network);
    }

    private static <N, E> Map<E, N> getEdgeToReferenceNode(Network<N, E> network) {
        ImmutableMap.Builder builder = ImmutableMap.builder();
        for (E next : network.edges()) {
            builder.put(next, network.incidentNodes(next).nodeU());
        }
        return builder.buildOrThrow();
    }

    private static <N, E> Map<N, NetworkConnections<N, E>> getNodeConnections(Network<N, E> network) {
        ImmutableMap.Builder builder = ImmutableMap.builder();
        for (N next : network.nodes()) {
            builder.put(next, connectionsOf(network, next));
        }
        return builder.buildOrThrow();
    }

    private static <N, E> Function<E, N> sourceNodeFn(Network<N, E> network) {
        return new d(network);
    }

    private static <N, E> Function<E, N> targetNodeFn(Network<N, E> network) {
        return new e(network);
    }

    public /* bridge */ /* synthetic */ Set adjacentNodes(Object obj) {
        return super.adjacentNodes(obj);
    }

    public /* bridge */ /* synthetic */ boolean allowsParallelEdges() {
        return super.allowsParallelEdges();
    }

    public /* bridge */ /* synthetic */ boolean allowsSelfLoops() {
        return super.allowsSelfLoops();
    }

    public /* bridge */ /* synthetic */ ElementOrder edgeOrder() {
        return super.edgeOrder();
    }

    public /* bridge */ /* synthetic */ Set edges() {
        return super.edges();
    }

    public /* bridge */ /* synthetic */ Set edgesConnecting(Object obj, Object obj2) {
        return super.edgesConnecting(obj, obj2);
    }

    public /* bridge */ /* synthetic */ Set inEdges(Object obj) {
        return super.inEdges(obj);
    }

    public /* bridge */ /* synthetic */ Set incidentEdges(Object obj) {
        return super.incidentEdges(obj);
    }

    public /* bridge */ /* synthetic */ EndpointPair incidentNodes(Object obj) {
        return super.incidentNodes(obj);
    }

    public /* bridge */ /* synthetic */ boolean isDirected() {
        return super.isDirected();
    }

    public /* bridge */ /* synthetic */ ElementOrder nodeOrder() {
        return super.nodeOrder();
    }

    public /* bridge */ /* synthetic */ Set nodes() {
        return super.nodes();
    }

    public /* bridge */ /* synthetic */ Set outEdges(Object obj) {
        return super.outEdges(obj);
    }

    public /* bridge */ /* synthetic */ Set predecessors(Object obj) {
        return super.predecessors(obj);
    }

    public /* bridge */ /* synthetic */ Set successors(Object obj) {
        return super.successors(obj);
    }

    public ImmutableGraph<N> asGraph() {
        return new ImmutableGraph<>(super.asGraph());
    }

    @Deprecated
    public static <N, E> ImmutableNetwork<N, E> copyOf(ImmutableNetwork<N, E> immutableNetwork) {
        return (ImmutableNetwork) Preconditions.checkNotNull(immutableNetwork);
    }
}
