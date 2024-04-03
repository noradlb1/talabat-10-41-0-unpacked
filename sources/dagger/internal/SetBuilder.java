package dagger.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class SetBuilder<T> {
    private static final String SET_CONTRIBUTIONS_CANNOT_BE_NULL = "Set contributions cannot be null";
    private final List<T> contributions;

    private SetBuilder(int i11) {
        this.contributions = new ArrayList(i11);
    }

    public static <T> SetBuilder<T> newSetBuilder(int i11) {
        return new SetBuilder<>(i11);
    }

    public SetBuilder<T> add(T t11) {
        this.contributions.add(Preconditions.checkNotNull(t11, SET_CONTRIBUTIONS_CANNOT_BE_NULL));
        return this;
    }

    public SetBuilder<T> addAll(Collection<? extends T> collection) {
        for (Object checkNotNull : collection) {
            Preconditions.checkNotNull(checkNotNull, SET_CONTRIBUTIONS_CANNOT_BE_NULL);
        }
        this.contributions.addAll(collection);
        return this;
    }

    public Set<T> build() {
        if (this.contributions.isEmpty()) {
            return Collections.emptySet();
        }
        if (this.contributions.size() == 1) {
            return Collections.singleton(this.contributions.get(0));
        }
        return Collections.unmodifiableSet(new HashSet(this.contributions));
    }
}
