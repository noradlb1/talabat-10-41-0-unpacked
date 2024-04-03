package androidx.collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import j$.util.Map;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Function;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class ArrayMap<K, V> extends SimpleArrayMap<K, V> implements Map<K, V>, j$.util.Map {
    @Nullable
    MapCollections<K, V> mCollections;

    public ArrayMap() {
    }

    private MapCollections<K, V> getCollection() {
        if (this.mCollections == null) {
            this.mCollections = new MapCollections<K, V>() {
                public void a() {
                    ArrayMap.this.clear();
                }

                public Object b(int i11, int i12) {
                    return ArrayMap.this.mArray[(i11 << 1) + i12];
                }

                public Map<K, V> c() {
                    return ArrayMap.this;
                }

                public int d() {
                    return ArrayMap.this.mSize;
                }

                public int e(Object obj) {
                    return ArrayMap.this.indexOfKey(obj);
                }

                public int f(Object obj) {
                    return ArrayMap.this.indexOfValue(obj);
                }

                public void g(K k11, V v11) {
                    ArrayMap.this.put(k11, v11);
                }

                public void h(int i11) {
                    ArrayMap.this.removeAt(i11);
                }

                public V i(int i11, V v11) {
                    return ArrayMap.this.setValueAt(i11, v11);
                }
            };
        }
        return this.mCollections;
    }

    public /* synthetic */ Object compute(Object obj, BiFunction biFunction) {
        return Map.CC.$default$compute(this, obj, biFunction);
    }

    public /* synthetic */ Object compute(Object obj, java.util.function.BiFunction biFunction) {
        return compute(obj, BiFunction.VivifiedWrapper.convert(biFunction));
    }

    public /* synthetic */ Object computeIfAbsent(Object obj, Function function) {
        return Map.CC.$default$computeIfAbsent(this, obj, function);
    }

    public /* synthetic */ Object computeIfAbsent(Object obj, java.util.function.Function function) {
        return computeIfAbsent(obj, Function.VivifiedWrapper.convert(function));
    }

    public /* synthetic */ Object computeIfPresent(Object obj, BiFunction biFunction) {
        return Map.CC.$default$computeIfPresent(this, obj, biFunction);
    }

    public /* synthetic */ Object computeIfPresent(Object obj, java.util.function.BiFunction biFunction) {
        return computeIfPresent(obj, BiFunction.VivifiedWrapper.convert(biFunction));
    }

    public boolean containsAll(@NonNull Collection<?> collection) {
        return MapCollections.containsAllHelper(this, collection);
    }

    public Set<Map.Entry<K, V>> entrySet() {
        return getCollection().getEntrySet();
    }

    public /* synthetic */ void forEach(BiConsumer biConsumer) {
        Map.CC.$default$forEach(this, biConsumer);
    }

    public /* synthetic */ void forEach(java.util.function.BiConsumer biConsumer) {
        forEach(BiConsumer.VivifiedWrapper.convert(biConsumer));
    }

    public Set<K> keySet() {
        return getCollection().getKeySet();
    }

    public /* synthetic */ Object merge(Object obj, Object obj2, BiFunction biFunction) {
        return Map.CC.$default$merge(this, obj, obj2, biFunction);
    }

    public /* synthetic */ Object merge(Object obj, Object obj2, java.util.function.BiFunction biFunction) {
        return merge(obj, obj2, BiFunction.VivifiedWrapper.convert(biFunction));
    }

    public void putAll(java.util.Map<? extends K, ? extends V> map) {
        ensureCapacity(this.mSize + map.size());
        for (Map.Entry next : map.entrySet()) {
            put(next.getKey(), next.getValue());
        }
    }

    public boolean removeAll(@NonNull Collection<?> collection) {
        return MapCollections.removeAllHelper(this, collection);
    }

    public /* synthetic */ void replaceAll(BiFunction biFunction) {
        Map.CC.$default$replaceAll(this, biFunction);
    }

    public /* synthetic */ void replaceAll(java.util.function.BiFunction biFunction) {
        replaceAll(BiFunction.VivifiedWrapper.convert(biFunction));
    }

    public boolean retainAll(@NonNull Collection<?> collection) {
        return MapCollections.retainAllHelper(this, collection);
    }

    public Collection<V> values() {
        return getCollection().getValues();
    }

    public ArrayMap(int i11) {
        super(i11);
    }

    public ArrayMap(SimpleArrayMap simpleArrayMap) {
        super(simpleArrayMap);
    }
}
