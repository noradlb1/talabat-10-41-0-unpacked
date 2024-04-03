package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.DoNotMock;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
@Beta
@DoNotMock("Use GraphBuilder to create a real instance")
public interface Graph<N> extends BaseGraph<N> {
    Set<N> adjacentNodes(N n11);

    boolean allowsSelfLoops();

    int degree(N n11);

    Set<EndpointPair<N>> edges();

    boolean equals(@CheckForNull Object obj);

    boolean hasEdgeConnecting(EndpointPair<N> endpointPair);

    boolean hasEdgeConnecting(N n11, N n12);

    int hashCode();

    int inDegree(N n11);

    ElementOrder<N> incidentEdgeOrder();

    Set<EndpointPair<N>> incidentEdges(N n11);

    boolean isDirected();

    ElementOrder<N> nodeOrder();

    Set<N> nodes();

    int outDegree(N n11);

    /* bridge */ /* synthetic */ Iterable predecessors(Object obj);

    Set<N> predecessors(N n11);

    /* bridge */ /* synthetic */ Iterable successors(Object obj);

    Set<N> successors(N n11);
}
