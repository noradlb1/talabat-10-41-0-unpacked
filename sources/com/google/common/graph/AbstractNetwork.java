package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.math.IntMath;
import d9.a;
import java.util.AbstractSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@Beta
@ElementTypesAreNonnullByDefault
public abstract class AbstractNetwork<N, E> implements Network<N, E> {
    private Predicate<E> connectedPredicate(final N n11, final N n12) {
        return new Predicate<E>() {
            public boolean apply(E e11) {
                return AbstractNetwork.this.incidentNodes(e11).adjacentNode(n11).equals(n12);
            }
        };
    }

    private static <N, E> Map<E, EndpointPair<N>> edgeIncidentNodesMap(Network<N, E> network) {
        return Maps.asMap(network.edges(), new a(network));
    }

    public Set<E> adjacentEdges(E e11) {
        EndpointPair incidentNodes = incidentNodes(e11);
        return Sets.difference(Sets.union(incidentEdges(incidentNodes.nodeU()), incidentEdges(incidentNodes.nodeV())), ImmutableSet.of(e11));
    }

    public Graph<N> asGraph() {
        return new AbstractGraph<N>() {
            public Set<N> adjacentNodes(N n11) {
                return AbstractNetwork.this.adjacentNodes(n11);
            }

            public boolean allowsSelfLoops() {
                return AbstractNetwork.this.allowsSelfLoops();
            }

            public Set<EndpointPair<N>> edges() {
                if (AbstractNetwork.this.allowsParallelEdges()) {
                    return super.edges();
                }
                return new AbstractSet<EndpointPair<N>>() {
                    /* access modifiers changed from: private */
                    public /* synthetic */ EndpointPair lambda$iterator$0(Object obj) {
                        return AbstractNetwork.this.incidentNodes(obj);
                    }

                    public boolean contains(@CheckForNull Object obj) {
                        if (!(obj instanceof EndpointPair)) {
                            return false;
                        }
                        EndpointPair endpointPair = (EndpointPair) obj;
                        if (!AnonymousClass1.this.isOrderingCompatible(endpointPair) || !AnonymousClass1.this.nodes().contains(endpointPair.nodeU()) || !AnonymousClass1.this.successors(endpointPair.nodeU()).contains(endpointPair.nodeV())) {
                            return false;
                        }
                        return true;
                    }

                    public Iterator<EndpointPair<N>> iterator() {
                        return Iterators.transform(AbstractNetwork.this.edges().iterator(), new d(this));
                    }

                    public int size() {
                        return AbstractNetwork.this.edges().size();
                    }
                };
            }

            public ElementOrder<N> incidentEdgeOrder() {
                return ElementOrder.unordered();
            }

            public boolean isDirected() {
                return AbstractNetwork.this.isDirected();
            }

            public ElementOrder<N> nodeOrder() {
                return AbstractNetwork.this.nodeOrder();
            }

            public Set<N> nodes() {
                return AbstractNetwork.this.nodes();
            }

            public Set<N> predecessors(N n11) {
                return AbstractNetwork.this.predecessors((Object) n11);
            }

            public Set<N> successors(N n11) {
                return AbstractNetwork.this.successors((Object) n11);
            }
        };
    }

    public int degree(N n11) {
        if (isDirected()) {
            return IntMath.saturatedAdd(inEdges(n11).size(), outEdges(n11).size());
        }
        return IntMath.saturatedAdd(incidentEdges(n11).size(), edgesConnecting(n11, n11).size());
    }

    @CheckForNull
    public E edgeConnectingOrNull(N n11, N n12) {
        Set edgesConnecting = edgesConnecting(n11, n12);
        int size = edgesConnecting.size();
        if (size == 0) {
            return null;
        }
        if (size == 1) {
            return edgesConnecting.iterator().next();
        }
        throw new IllegalArgumentException(String.format("Cannot call edgeConnecting() when parallel edges exist between %s and %s. Consider calling edgesConnecting() instead.", new Object[]{n11, n12}));
    }

    public Set<E> edgesConnecting(N n11, N n12) {
        Set outEdges = outEdges(n11);
        Set inEdges = inEdges(n12);
        if (outEdges.size() <= inEdges.size()) {
            return Collections.unmodifiableSet(Sets.filter(outEdges, connectedPredicate(n11, n12)));
        }
        return Collections.unmodifiableSet(Sets.filter(inEdges, connectedPredicate(n12, n11)));
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Network)) {
            return false;
        }
        Network network = (Network) obj;
        if (isDirected() != network.isDirected() || !nodes().equals(network.nodes()) || !edgeIncidentNodesMap(this).equals(edgeIncidentNodesMap(network))) {
            return false;
        }
        return true;
    }

    public boolean hasEdgeConnecting(N n11, N n12) {
        Preconditions.checkNotNull(n11);
        Preconditions.checkNotNull(n12);
        return nodes().contains(n11) && successors((Object) n11).contains(n12);
    }

    public final int hashCode() {
        return edgeIncidentNodesMap(this).hashCode();
    }

    public int inDegree(N n11) {
        return isDirected() ? inEdges(n11).size() : degree(n11);
    }

    public final boolean isOrderingCompatible(EndpointPair<?> endpointPair) {
        return endpointPair.isOrdered() == isDirected();
    }

    public int outDegree(N n11) {
        return isDirected() ? outEdges(n11).size() : degree(n11);
    }

    public /* bridge */ /* synthetic */ Iterable predecessors(Object obj) {
        return predecessors(obj);
    }

    public /* bridge */ /* synthetic */ Iterable successors(Object obj) {
        return successors(obj);
    }

    public String toString() {
        return "isDirected: " + isDirected() + ", allowsParallelEdges: " + allowsParallelEdges() + ", allowsSelfLoops: " + allowsSelfLoops() + ", nodes: " + nodes() + ", edges: " + edgeIncidentNodesMap(this);
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
        return hasEdgeConnecting(endpointPair.nodeU(), endpointPair.nodeV());
    }

    @CheckForNull
    public E edgeConnectingOrNull(EndpointPair<N> endpointPair) {
        validateEndpoints(endpointPair);
        return edgeConnectingOrNull(endpointPair.nodeU(), endpointPair.nodeV());
    }

    public Set<E> edgesConnecting(EndpointPair<N> endpointPair) {
        validateEndpoints(endpointPair);
        return edgesConnecting(endpointPair.nodeU(), endpointPair.nodeV());
    }
}
