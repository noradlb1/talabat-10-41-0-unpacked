package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.math.IntMath;
import com.google.common.primitives.Ints;
import java.util.AbstractSet;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
abstract class AbstractBaseGraph<N> implements BaseGraph<N> {
    public int degree(N n11) {
        int i11;
        if (isDirected()) {
            return IntMath.saturatedAdd(predecessors((Object) n11).size(), successors((Object) n11).size());
        }
        Set adjacentNodes = adjacentNodes(n11);
        if (!allowsSelfLoops() || !adjacentNodes.contains(n11)) {
            i11 = 0;
        } else {
            i11 = 1;
        }
        return IntMath.saturatedAdd(adjacentNodes.size(), i11);
    }

    public long edgeCount() {
        boolean z11;
        long j11 = 0;
        for (Object degree : nodes()) {
            j11 += (long) degree(degree);
        }
        if ((1 & j11) == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkState(z11);
        return j11 >>> 1;
    }

    public Set<EndpointPair<N>> edges() {
        return new AbstractSet<EndpointPair<N>>() {
            public boolean contains(@CheckForNull Object obj) {
                if (!(obj instanceof EndpointPair)) {
                    return false;
                }
                EndpointPair endpointPair = (EndpointPair) obj;
                if (!AbstractBaseGraph.this.isOrderingCompatible(endpointPair) || !AbstractBaseGraph.this.nodes().contains(endpointPair.nodeU()) || !AbstractBaseGraph.this.successors(endpointPair.nodeU()).contains(endpointPair.nodeV())) {
                    return false;
                }
                return true;
            }

            public boolean remove(@CheckForNull Object obj) {
                throw new UnsupportedOperationException();
            }

            public int size() {
                return Ints.saturatedCast(AbstractBaseGraph.this.edgeCount());
            }

            public UnmodifiableIterator<EndpointPair<N>> iterator() {
                return EndpointPairIterator.of(AbstractBaseGraph.this);
            }
        };
    }

    public boolean hasEdgeConnecting(N n11, N n12) {
        Preconditions.checkNotNull(n11);
        Preconditions.checkNotNull(n12);
        return nodes().contains(n11) && successors((Object) n11).contains(n12);
    }

    public int inDegree(N n11) {
        return isDirected() ? predecessors((Object) n11).size() : degree(n11);
    }

    public ElementOrder<N> incidentEdgeOrder() {
        return ElementOrder.unordered();
    }

    public Set<EndpointPair<N>> incidentEdges(N n11) {
        Preconditions.checkNotNull(n11);
        Preconditions.checkArgument(nodes().contains(n11), "Node %s is not an element of this graph.", (Object) n11);
        return new IncidentEdgeSet<N>(this, this, n11) {
            /* access modifiers changed from: private */
            public /* synthetic */ EndpointPair lambda$iterator$0(Object obj) {
                return EndpointPair.ordered(obj, this.node);
            }

            /* access modifiers changed from: private */
            public /* synthetic */ EndpointPair lambda$iterator$1(Object obj) {
                return EndpointPair.ordered(this.node, obj);
            }

            /* access modifiers changed from: private */
            public /* synthetic */ EndpointPair lambda$iterator$2(Object obj) {
                return EndpointPair.unordered(this.node, obj);
            }

            public UnmodifiableIterator<EndpointPair<N>> iterator() {
                if (this.graph.isDirected()) {
                    return Iterators.unmodifiableIterator(Iterators.concat(Iterators.transform(this.graph.predecessors((Object) this.node).iterator(), new a(this)), Iterators.transform(Sets.difference(this.graph.successors((Object) this.node), ImmutableSet.of(this.node)).iterator(), new b(this))));
                }
                return Iterators.unmodifiableIterator(Iterators.transform(this.graph.adjacentNodes(this.node).iterator(), new c(this)));
            }
        };
    }

    public final boolean isOrderingCompatible(EndpointPair<?> endpointPair) {
        return endpointPair.isOrdered() == isDirected();
    }

    public int outDegree(N n11) {
        return isDirected() ? successors((Object) n11).size() : degree(n11);
    }

    public /* bridge */ /* synthetic */ Iterable predecessors(Object obj) {
        return predecessors(obj);
    }

    public /* bridge */ /* synthetic */ Iterable successors(Object obj) {
        return successors(obj);
    }

    public final void validateEndpoints(EndpointPair<?> endpointPair) {
        Preconditions.checkNotNull(endpointPair);
        Preconditions.checkArgument(isOrderingCompatible(endpointPair), "Mismatch: endpoints' ordering is not compatible with directionality of the graph");
    }

    public boolean hasEdgeConnecting(EndpointPair<N> endpointPair) {
        Preconditions.checkNotNull(endpointPair);
        if (!isOrderingCompatible(endpointPair)) {
            return false;
        }
        N nodeU = endpointPair.nodeU();
        N nodeV = endpointPair.nodeV();
        if (!nodes().contains(nodeU) || !successors((Object) nodeU).contains(nodeV)) {
            return false;
        }
        return true;
    }
}
