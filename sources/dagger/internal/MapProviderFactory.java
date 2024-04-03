package dagger.internal;

import dagger.Lazy;
import dagger.internal.AbstractMapFactory;
import java.util.Map;
import javax.inject.Provider;

public final class MapProviderFactory<K, V> extends AbstractMapFactory<K, V, Provider<V>> implements Lazy<Map<K, Provider<V>>> {

    public static final class Builder<K, V> extends AbstractMapFactory.Builder<K, V, Provider<V>> {
        public MapProviderFactory<K, V> build() {
            return new MapProviderFactory<>(this.f13834a);
        }

        private Builder(int i11) {
            super(i11);
        }

        public Builder<K, V> put(K k11, Provider<V> provider) {
            super.put(k11, provider);
            return this;
        }

        public Builder<K, V> putAll(Provider<Map<K, Provider<V>>> provider) {
            super.putAll(provider);
            return this;
        }
    }

    public static <K, V> Builder<K, V> builder(int i11) {
        return new Builder<>(i11);
    }

    private MapProviderFactory(Map<K, Provider<V>> map) {
        super(map);
    }

    public Map<K, Provider<V>> get() {
        return b();
    }
}
