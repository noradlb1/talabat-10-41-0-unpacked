package com.deliveryhero.impression.compose;

import j$.util.Map;
import j$.util.concurrent.ConcurrentHashMap;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Function;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010&\n\u0002\b\b\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0000\u0018\u0000 '*\u0004\b\u0000\u0010\u00012\u001c\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001'B)\b\u0002\u0012 \u0010\u0005\u001a\u001c\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007J%\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001a\u001a\u00028\u0000¢\u0006\u0002\u0010\u001bJ\u001f\u0010\u001c\u001a\u00020\u001d2\u0014\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003H\u0001J\u0016\u0010\u001f\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00028\u0000H\u0001¢\u0006\u0002\u0010 J\"\u0010!\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0018\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0002\u0010\"J&\u0010!\u001a\u0004\u0018\u00018\u00002\u0014\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003H\u0003¢\u0006\u0002\u0010#J\t\u0010$\u001a\u00020\u001dH\u0001J\u001f\u0010%\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0018\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\"J(\u0010&\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001a\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001bR(\u0010\u0005\u001a\u001c\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003\u0012\u0004\u0012\u00028\u00000\u0006X\u0004¢\u0006\u0002\n\u0000R2\u0010\b\u001a\"\u0012\u001e\u0012\u001c\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003\u0012\u0004\u0012\u00028\u00000\n0\tX\u0005¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR&\u0010\r\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00030\tX\u0005¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u0012\u0010\u000f\u001a\u00020\u0004X\u0005¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013X\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006("}, d2 = {"Lcom/deliveryhero/impression/compose/TwoDimenMap;", "T", "", "Lkotlin/Pair;", "", "delegateMap", "", "(Ljava/util/Map;)V", "entries", "", "", "getEntries", "()Ljava/util/Set;", "keys", "getKeys", "size", "getSize", "()I", "values", "", "getValues", "()Ljava/util/Collection;", "addIfNotExists", "", "position", "parentPosition", "value", "(ILjava/lang/Integer;Ljava/lang/Object;)V", "containsKey", "", "key", "containsValue", "(Ljava/lang/Object;)Z", "get", "(ILjava/lang/Integer;)Ljava/lang/Object;", "(Lkotlin/Pair;)Ljava/lang/Object;", "isEmpty", "remove", "set", "Companion", "impression-tracking_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TwoDimenMap<T> implements Map<Pair<? extends Integer, ? extends Integer>, T>, KMappedMarker, j$.util.Map {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private final Map<Pair<Integer, Integer>, T> delegateMap;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0001\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/deliveryhero/impression/compose/TwoDimenMap$Companion;", "", "()V", "create", "Lcom/deliveryhero/impression/compose/TwoDimenMap;", "T", "impression-tracking_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final <T> TwoDimenMap<T> create() {
            return new TwoDimenMap<>(new ConcurrentHashMap(), (DefaultConstructorMarker) null);
        }
    }

    private TwoDimenMap(Map<Pair<Integer, Integer>, T> map) {
        this.delegateMap = map;
    }

    public /* synthetic */ TwoDimenMap(Map map, DefaultConstructorMarker defaultConstructorMarker) {
        this(map);
    }

    public final void addIfNotExists(int i11, @Nullable Integer num, T t11) {
        if (get(i11, num) == null) {
            set(i11, num, t11);
        }
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* synthetic */ Object compute(Object obj, BiFunction biFunction) {
        return compute(obj, BiFunction.VivifiedWrapper.convert(biFunction));
    }

    public T compute(Pair<Integer, Integer> pair, j$.util.function.BiFunction<? super Pair<Integer, Integer>, ? super T, ? extends T> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* synthetic */ Object computeIfAbsent(Object obj, Function function) {
        return computeIfAbsent(obj, Function.VivifiedWrapper.convert(function));
    }

    public T computeIfAbsent(Pair<Integer, Integer> pair, j$.util.function.Function<? super Pair<Integer, Integer>, ? extends T> function) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* synthetic */ Object computeIfPresent(Object obj, java.util.function.BiFunction biFunction) {
        return computeIfPresent(obj, BiFunction.VivifiedWrapper.convert(biFunction));
    }

    public T computeIfPresent(Pair<Integer, Integer> pair, j$.util.function.BiFunction<? super Pair<Integer, Integer>, ? super T, ? extends T> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ boolean containsKey(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        return containsKey((Pair<Integer, Integer>) (Pair) obj);
    }

    public boolean containsKey(@NotNull Pair<Integer, Integer> pair) {
        Intrinsics.checkNotNullParameter(pair, "key");
        return this.delegateMap.containsKey(pair);
    }

    public boolean containsValue(Object obj) {
        return this.delegateMap.containsValue(obj);
    }

    public final /* bridge */ Set<Map.Entry<Pair<Integer, Integer>, T>> entrySet() {
        return getEntries();
    }

    public /* synthetic */ void forEach(BiConsumer biConsumer) {
        Map.CC.$default$forEach(this, biConsumer);
    }

    public /* synthetic */ void forEach(java.util.function.BiConsumer biConsumer) {
        forEach(BiConsumer.VivifiedWrapper.convert(biConsumer));
    }

    public final /* bridge */ T get(Object obj) {
        if (!(obj instanceof Pair)) {
            return null;
        }
        return get((Pair<Integer, Integer>) (Pair) obj);
    }

    @Nullable
    public T get(@NotNull Pair<Integer, Integer> pair) {
        Intrinsics.checkNotNullParameter(pair, "key");
        return this.delegateMap.get(pair);
    }

    @NotNull
    public Set<Map.Entry<Pair<Integer, Integer>, T>> getEntries() {
        return this.delegateMap.entrySet();
    }

    @NotNull
    public Set<Pair<Integer, Integer>> getKeys() {
        return this.delegateMap.keySet();
    }

    public /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
        return Map.CC.$default$getOrDefault(this, obj, obj2);
    }

    public int getSize() {
        return this.delegateMap.size();
    }

    @NotNull
    public Collection<T> getValues() {
        return this.delegateMap.values();
    }

    public boolean isEmpty() {
        return this.delegateMap.isEmpty();
    }

    public final /* bridge */ Set<Pair<Integer, Integer>> keySet() {
        return getKeys();
    }

    public /* synthetic */ Object merge(Object obj, Object obj2, java.util.function.BiFunction biFunction) {
        return merge(obj, obj2, BiFunction.VivifiedWrapper.convert(biFunction));
    }

    public T merge(Pair<Integer, Integer> pair, T t11, j$.util.function.BiFunction<? super T, ? super T, ? extends T> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public T put(Pair<Integer, Integer> pair, T t11) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void putAll(java.util.Map<? extends Pair<? extends Integer, ? extends Integer>, ? extends T> map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public T putIfAbsent(Pair<Integer, Integer> pair, T t11) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Nullable
    public final T remove(int i11, @Nullable Integer num) {
        return this.delegateMap.remove(new Pair(Integer.valueOf(i11), num));
    }

    public T remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public T replace(Pair<Integer, Integer> pair, T t11) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean replace(Pair<Integer, Integer> pair, T t11, T t12) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void replaceAll(j$.util.function.BiFunction<? super Pair<Integer, Integer>, ? super T, ? extends T> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* synthetic */ void replaceAll(java.util.function.BiFunction biFunction) {
        replaceAll(BiFunction.VivifiedWrapper.convert(biFunction));
    }

    public final void set(int i11, @Nullable Integer num, T t11) {
        this.delegateMap.put(new Pair(Integer.valueOf(i11), num), t11);
    }

    public final /* bridge */ int size() {
        return getSize();
    }

    public final /* bridge */ Collection<T> values() {
        return getValues();
    }

    @Nullable
    public final T get(int i11, @Nullable Integer num) {
        return this.delegateMap.get(new Pair(Integer.valueOf(i11), num));
    }
}
