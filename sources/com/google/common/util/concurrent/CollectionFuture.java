package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.AggregateFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
abstract class CollectionFuture<V, C> extends AggregateFuture<V, C> {
    @CheckForNull
    private List<Present<V>> values;

    public static final class ListFuture<V> extends CollectionFuture<V, List<V>> {
        public ListFuture(ImmutableCollection<? extends ListenableFuture<? extends V>> immutableCollection, boolean z11) {
            super(immutableCollection, z11);
            init();
        }

        public List<V> combine(List<Present<V>> list) {
            ArrayList newArrayListWithCapacity = Lists.newArrayListWithCapacity(list.size());
            Iterator<Present<V>> it = list.iterator();
            while (it.hasNext()) {
                Present next = it.next();
                newArrayListWithCapacity.add(next != null ? next.value : null);
            }
            return Collections.unmodifiableList(newArrayListWithCapacity);
        }
    }

    public static final class Present<V> {
        @ParametricNullness
        final V value;

        public Present(@ParametricNullness V v11) {
            this.value = v11;
        }
    }

    public CollectionFuture(ImmutableCollection<? extends ListenableFuture<? extends V>> immutableCollection, boolean z11) {
        super(immutableCollection, z11, true);
        List<Present<V>> list;
        if (immutableCollection.isEmpty()) {
            list = Collections.emptyList();
        } else {
            list = Lists.newArrayListWithCapacity(immutableCollection.size());
        }
        for (int i11 = 0; i11 < immutableCollection.size(); i11++) {
            list.add((Object) null);
        }
        this.values = list;
    }

    public final void collectOneValue(int i11, @ParametricNullness V v11) {
        List<Present<V>> list = this.values;
        if (list != null) {
            list.set(i11, new Present(v11));
        }
    }

    public abstract C combine(List<Present<V>> list);

    public final void handleAllCompleted() {
        List<Present<V>> list = this.values;
        if (list != null) {
            set(combine(list));
        }
    }

    public void releaseResources(AggregateFuture.ReleaseResourcesReason releaseResourcesReason) {
        super.releaseResources(releaseResourcesReason);
        this.values = null;
    }
}
