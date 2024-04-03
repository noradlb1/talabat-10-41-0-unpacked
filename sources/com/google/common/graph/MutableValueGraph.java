package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import javax.annotation.CheckForNull;

@Beta
@ElementTypesAreNonnullByDefault
public interface MutableValueGraph<N, V> extends ValueGraph<N, V> {
    @CanIgnoreReturnValue
    boolean addNode(N n11);

    @CheckForNull
    @CanIgnoreReturnValue
    V putEdgeValue(EndpointPair<N> endpointPair, V v11);

    @CheckForNull
    @CanIgnoreReturnValue
    V putEdgeValue(N n11, N n12, V v11);

    @CheckForNull
    @CanIgnoreReturnValue
    V removeEdge(EndpointPair<N> endpointPair);

    @CheckForNull
    @CanIgnoreReturnValue
    V removeEdge(N n11, N n12);

    @CanIgnoreReturnValue
    boolean removeNode(N n11);
}
