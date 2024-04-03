package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.math.IntMath;
import java.util.AbstractSet;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
abstract class AbstractDirectedNetworkConnections<N, E> implements NetworkConnections<N, E> {
    final Map<E, N> inEdgeMap;
    final Map<E, N> outEdgeMap;
    /* access modifiers changed from: private */
    public int selfLoopCount;

    public AbstractDirectedNetworkConnections(Map<E, N> map, Map<E, N> map2, int i11) {
        boolean z11;
        this.inEdgeMap = (Map) Preconditions.checkNotNull(map);
        this.outEdgeMap = (Map) Preconditions.checkNotNull(map2);
        this.selfLoopCount = Graphs.checkNonNegative(i11);
        if (i11 > map.size() || i11 > map2.size()) {
            z11 = false;
        } else {
            z11 = true;
        }
        Preconditions.checkState(z11);
    }

    public void addInEdge(E e11, N n11, boolean z11) {
        Preconditions.checkNotNull(e11);
        Preconditions.checkNotNull(n11);
        boolean z12 = true;
        if (z11) {
            int i11 = this.selfLoopCount + 1;
            this.selfLoopCount = i11;
            Graphs.checkPositive(i11);
        }
        if (this.inEdgeMap.put(e11, n11) != null) {
            z12 = false;
        }
        Preconditions.checkState(z12);
    }

    public void addOutEdge(E e11, N n11) {
        boolean z11;
        Preconditions.checkNotNull(e11);
        Preconditions.checkNotNull(n11);
        if (this.outEdgeMap.put(e11, n11) == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkState(z11);
    }

    public N adjacentNode(E e11) {
        N n11 = this.outEdgeMap.get(e11);
        Objects.requireNonNull(n11);
        return n11;
    }

    public Set<N> adjacentNodes() {
        return Sets.union(predecessors(), successors());
    }

    public Set<E> inEdges() {
        return Collections.unmodifiableSet(this.inEdgeMap.keySet());
    }

    public Set<E> incidentEdges() {
        return new AbstractSet<E>() {
            public boolean contains(@CheckForNull Object obj) {
                return AbstractDirectedNetworkConnections.this.inEdgeMap.containsKey(obj) || AbstractDirectedNetworkConnections.this.outEdgeMap.containsKey(obj);
            }

            public int size() {
                return IntMath.saturatedAdd(AbstractDirectedNetworkConnections.this.inEdgeMap.size(), AbstractDirectedNetworkConnections.this.outEdgeMap.size() - AbstractDirectedNetworkConnections.this.selfLoopCount);
            }

            public UnmodifiableIterator<E> iterator() {
                Iterable<T> iterable;
                if (AbstractDirectedNetworkConnections.this.selfLoopCount == 0) {
                    iterable = Iterables.concat(AbstractDirectedNetworkConnections.this.inEdgeMap.keySet(), AbstractDirectedNetworkConnections.this.outEdgeMap.keySet());
                } else {
                    iterable = Sets.union(AbstractDirectedNetworkConnections.this.inEdgeMap.keySet(), AbstractDirectedNetworkConnections.this.outEdgeMap.keySet());
                }
                return Iterators.unmodifiableIterator(iterable.iterator());
            }
        };
    }

    public Set<E> outEdges() {
        return Collections.unmodifiableSet(this.outEdgeMap.keySet());
    }

    public N removeInEdge(E e11, boolean z11) {
        if (z11) {
            int i11 = this.selfLoopCount - 1;
            this.selfLoopCount = i11;
            Graphs.checkNonNegative(i11);
        }
        N remove = this.inEdgeMap.remove(e11);
        Objects.requireNonNull(remove);
        return remove;
    }

    public N removeOutEdge(E e11) {
        N remove = this.outEdgeMap.remove(e11);
        Objects.requireNonNull(remove);
        return remove;
    }
}
