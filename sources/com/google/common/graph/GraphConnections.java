package com.google.common.graph;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
interface GraphConnections<N, V> {
    void addPredecessor(N n11, V v11);

    @CheckForNull
    @CanIgnoreReturnValue
    V addSuccessor(N n11, V v11);

    Set<N> adjacentNodes();

    Iterator<EndpointPair<N>> incidentEdgeIterator(N n11);

    Set<N> predecessors();

    void removePredecessor(N n11);

    @CheckForNull
    @CanIgnoreReturnValue
    V removeSuccessor(N n11);

    Set<N> successors();

    @CheckForNull
    V value(N n11);
}
