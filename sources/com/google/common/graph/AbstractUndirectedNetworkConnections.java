package com.google.common.graph;

import com.google.common.base.Preconditions;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
abstract class AbstractUndirectedNetworkConnections<N, E> implements NetworkConnections<N, E> {
    final Map<E, N> incidentEdgeMap;

    public AbstractUndirectedNetworkConnections(Map<E, N> map) {
        this.incidentEdgeMap = (Map) Preconditions.checkNotNull(map);
    }

    public void addInEdge(E e11, N n11, boolean z11) {
        if (!z11) {
            addOutEdge(e11, n11);
        }
    }

    public void addOutEdge(E e11, N n11) {
        boolean z11;
        if (this.incidentEdgeMap.put(e11, n11) == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkState(z11);
    }

    public N adjacentNode(E e11) {
        N n11 = this.incidentEdgeMap.get(e11);
        Objects.requireNonNull(n11);
        return n11;
    }

    public Set<E> inEdges() {
        return incidentEdges();
    }

    public Set<E> incidentEdges() {
        return Collections.unmodifiableSet(this.incidentEdgeMap.keySet());
    }

    public Set<E> outEdges() {
        return incidentEdges();
    }

    public Set<N> predecessors() {
        return adjacentNodes();
    }

    @CheckForNull
    public N removeInEdge(E e11, boolean z11) {
        if (!z11) {
            return removeOutEdge(e11);
        }
        return null;
    }

    public N removeOutEdge(E e11) {
        N remove = this.incidentEdgeMap.remove(e11);
        Objects.requireNonNull(remove);
        return remove;
    }

    public Set<N> successors() {
        return adjacentNodes();
    }
}
