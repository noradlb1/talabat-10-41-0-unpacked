package dagger.internal;

import java.util.Collections;
import java.util.Map;

public final class MapBuilder<K, V> {
    private final Map<K, V> contributions;

    private MapBuilder(int i11) {
        this.contributions = DaggerCollections.newLinkedHashMapWithExpectedSize(i11);
    }

    public static <K, V> MapBuilder<K, V> newMapBuilder(int i11) {
        return new MapBuilder<>(i11);
    }

    public Map<K, V> build() {
        if (this.contributions.isEmpty()) {
            return Collections.emptyMap();
        }
        return Collections.unmodifiableMap(this.contributions);
    }

    public MapBuilder<K, V> put(K k11, V v11) {
        this.contributions.put(k11, v11);
        return this;
    }

    public MapBuilder<K, V> putAll(Map<K, V> map) {
        this.contributions.putAll(map);
        return this;
    }
}
