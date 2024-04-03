package org.junit.platform.engine.discovery;

import j$.util.DesugarArrays;
import j$.util.stream.Collectors;
import java.util.Objects;
import java.util.SortedSet;
import n30.j;
import n30.k;
import org.apiguardian.api.API;
import org.junit.platform.commons.util.ToStringBuilder;
import org.junit.platform.engine.DiscoverySelector;

@API(since = "1.9", status = API.Status.EXPERIMENTAL)
public class IterationSelector implements DiscoverySelector {
    private final SortedSet<Integer> iterationIndices;
    private final DiscoverySelector parentSelector;

    public IterationSelector(DiscoverySelector discoverySelector, int... iArr) {
        this.parentSelector = discoverySelector;
        this.iterationIndices = toSortedSet(iArr);
    }

    private SortedSet<Integer> toSortedSet(int[] iArr) {
        return (SortedSet) DesugarArrays.stream(iArr).boxed().collect(Collectors.collectingAndThen(Collectors.toCollection(new j()), new k()));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        IterationSelector iterationSelector = (IterationSelector) obj;
        if (!this.parentSelector.equals(iterationSelector.parentSelector) || !this.iterationIndices.equals(iterationSelector.iterationIndices)) {
            return false;
        }
        return true;
    }

    public SortedSet<Integer> getIterationIndices() {
        return this.iterationIndices;
    }

    public DiscoverySelector getParentSelector() {
        return this.parentSelector;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.parentSelector, this.iterationIndices});
    }

    public String toString() {
        return new ToStringBuilder((Object) this).append("parentSelector", this.parentSelector).append("iterationIndices", this.iterationIndices).toString();
    }
}
