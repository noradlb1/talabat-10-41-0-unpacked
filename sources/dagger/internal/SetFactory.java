package dagger.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.inject.Provider;

public final class SetFactory<T> implements Factory<Set<T>> {
    private static final Factory<Set<Object>> EMPTY_FACTORY = InstanceFactory.create(Collections.emptySet());
    private final List<Provider<Collection<T>>> collectionProviders;
    private final List<Provider<T>> individualProviders;

    public static final class Builder<T> {
        private final List<Provider<Collection<T>>> collectionProviders;
        private final List<Provider<T>> individualProviders;

        public Builder<T> addCollectionProvider(Provider<? extends Collection<? extends T>> provider) {
            this.collectionProviders.add(provider);
            return this;
        }

        public Builder<T> addProvider(Provider<? extends T> provider) {
            this.individualProviders.add(provider);
            return this;
        }

        public SetFactory<T> build() {
            return new SetFactory<>(this.individualProviders, this.collectionProviders);
        }

        private Builder(int i11, int i12) {
            this.individualProviders = DaggerCollections.presizedList(i11);
            this.collectionProviders = DaggerCollections.presizedList(i12);
        }
    }

    public static <T> Builder<T> builder(int i11, int i12) {
        return new Builder<>(i11, i12);
    }

    public static <T> Factory<Set<T>> empty() {
        return EMPTY_FACTORY;
    }

    private SetFactory(List<Provider<T>> list, List<Provider<Collection<T>>> list2) {
        this.individualProviders = list;
        this.collectionProviders = list2;
    }

    public Set<T> get() {
        int size = this.individualProviders.size();
        ArrayList arrayList = new ArrayList(this.collectionProviders.size());
        int size2 = this.collectionProviders.size();
        for (int i11 = 0; i11 < size2; i11++) {
            Collection collection = (Collection) this.collectionProviders.get(i11).get();
            size += collection.size();
            arrayList.add(collection);
        }
        HashSet a11 = DaggerCollections.a(size);
        int size3 = this.individualProviders.size();
        for (int i12 = 0; i12 < size3; i12++) {
            a11.add(Preconditions.checkNotNull(this.individualProviders.get(i12).get()));
        }
        int size4 = arrayList.size();
        for (int i13 = 0; i13 < size4; i13++) {
            for (Object checkNotNull : (Collection) arrayList.get(i13)) {
                a11.add(Preconditions.checkNotNull(checkNotNull));
            }
        }
        return Collections.unmodifiableSet(a11);
    }
}
