package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import j$.util.concurrent.ConcurrentMap;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Function;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public abstract class ForwardingConcurrentMap<K, V> extends ForwardingMap<K, V> implements ConcurrentMap<K, V>, j$.util.concurrent.ConcurrentMap {
    public /* synthetic */ Object compute(Object obj, BiFunction biFunction) {
        return ConcurrentMap.CC.$default$compute(this, obj, biFunction);
    }

    public /* synthetic */ Object compute(Object obj, java.util.function.BiFunction biFunction) {
        return compute(obj, BiFunction.VivifiedWrapper.convert(biFunction));
    }

    public /* synthetic */ Object computeIfAbsent(Object obj, Function function) {
        return ConcurrentMap.CC.$default$computeIfAbsent(this, obj, function);
    }

    public /* synthetic */ Object computeIfAbsent(Object obj, java.util.function.Function function) {
        return computeIfAbsent(obj, Function.VivifiedWrapper.convert(function));
    }

    public /* synthetic */ Object computeIfPresent(Object obj, BiFunction biFunction) {
        return ConcurrentMap.CC.$default$computeIfPresent(this, obj, biFunction);
    }

    public /* synthetic */ Object computeIfPresent(Object obj, java.util.function.BiFunction biFunction) {
        return computeIfPresent(obj, BiFunction.VivifiedWrapper.convert(biFunction));
    }

    public abstract java.util.concurrent.ConcurrentMap<K, V> delegate();

    public /* synthetic */ void forEach(BiConsumer biConsumer) {
        ConcurrentMap.CC.$default$forEach(this, biConsumer);
    }

    public /* synthetic */ void forEach(java.util.function.BiConsumer biConsumer) {
        forEach(BiConsumer.VivifiedWrapper.convert(biConsumer));
    }

    public /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
        return ConcurrentMap.CC.$default$getOrDefault(this, obj, obj2);
    }

    public /* synthetic */ Object merge(Object obj, Object obj2, BiFunction biFunction) {
        return ConcurrentMap.CC.$default$merge(this, obj, obj2, biFunction);
    }

    public /* synthetic */ Object merge(Object obj, Object obj2, java.util.function.BiFunction biFunction) {
        return merge(obj, obj2, BiFunction.VivifiedWrapper.convert(biFunction));
    }

    @CheckForNull
    @CanIgnoreReturnValue
    public V putIfAbsent(K k11, V v11) {
        return delegate().putIfAbsent(k11, v11);
    }

    @CanIgnoreReturnValue
    public boolean remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return delegate().remove(obj, obj2);
    }

    @CheckForNull
    @CanIgnoreReturnValue
    public V replace(K k11, V v11) {
        return delegate().replace(k11, v11);
    }

    public /* synthetic */ void replaceAll(BiFunction biFunction) {
        ConcurrentMap.CC.$default$replaceAll(this, biFunction);
    }

    public /* synthetic */ void replaceAll(java.util.function.BiFunction biFunction) {
        replaceAll(BiFunction.VivifiedWrapper.convert(biFunction));
    }

    @CanIgnoreReturnValue
    public boolean replace(K k11, V v11, V v12) {
        return delegate().replace(k11, v11, v12);
    }
}
