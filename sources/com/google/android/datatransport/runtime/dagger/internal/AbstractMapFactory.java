package com.google.android.datatransport.runtime.dagger.internal;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Provider;

abstract class AbstractMapFactory<K, V, V2> implements Factory<Map<K, V2>> {
    /* access modifiers changed from: private */
    public final Map<K, Provider<V>> contributingMap;

    public static abstract class Builder<K, V, V2> {
        final LinkedHashMap<K, Provider<V>> map;

        public Builder(int i11) {
            this.map = DaggerCollections.newLinkedHashMapWithExpectedSize(i11);
        }

        public Builder<K, V, V2> put(K k11, Provider<V> provider) {
            this.map.put(Preconditions.checkNotNull(k11, "key"), Preconditions.checkNotNull(provider, "provider"));
            return this;
        }

        public Builder<K, V, V2> putAll(Provider<Map<K, V2>> provider) {
            if (provider instanceof DelegateFactory) {
                return putAll(((DelegateFactory) provider).getDelegate());
            }
            this.map.putAll(((AbstractMapFactory) provider).contributingMap);
            return this;
        }
    }

    public AbstractMapFactory(Map<K, Provider<V>> map) {
        this.contributingMap = Collections.unmodifiableMap(map);
    }

    /* access modifiers changed from: package-private */
    public final Map<K, Provider<V>> contributingMap() {
        return this.contributingMap;
    }
}
