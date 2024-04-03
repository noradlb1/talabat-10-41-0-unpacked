package j$.util;

import j$.util.Map;
import j$.util.concurrent.ConcurrentMap;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Function;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;

/* renamed from: j$.util.e  reason: case insensitive filesystem */
final class C0139e implements Map, Serializable, Map {
    private static final long serialVersionUID = 1978198479659022715L;

    /* renamed from: a  reason: collision with root package name */
    private final Map f28775a;

    /* renamed from: b  reason: collision with root package name */
    final Object f28776b = this;

    /* renamed from: c  reason: collision with root package name */
    private transient Set f28777c;

    /* renamed from: d  reason: collision with root package name */
    private transient Set f28778d;

    /* renamed from: e  reason: collision with root package name */
    private transient Collection f28779e;

    C0139e(Map map) {
        Objects.requireNonNull(map);
        this.f28775a = map;
    }

    private static Set a(Set set, Object obj) {
        if (DesugarCollections.f28546e == null) {
            return Collections.synchronizedSet(set);
        }
        try {
            return (Set) DesugarCollections.f28546e.newInstance(new Object[]{set, obj});
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e11) {
            throw new Error("Unable to instantiate a synchronized list.", e11);
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        synchronized (this.f28776b) {
            objectOutputStream.defaultWriteObject();
        }
    }

    public final void clear() {
        synchronized (this.f28776b) {
            this.f28775a.clear();
        }
    }

    public final Object compute(Object obj, BiFunction biFunction) {
        Object compute;
        synchronized (this.f28776b) {
            Map map = this.f28775a;
            compute = map instanceof Map ? ((Map) map).compute(obj, biFunction) : map instanceof ConcurrentMap ? ConcurrentMap.CC.$default$compute((java.util.concurrent.ConcurrentMap) map, obj, biFunction) : Map.CC.$default$compute(map, obj, biFunction);
        }
        return compute;
    }

    public final /* synthetic */ Object compute(Object obj, java.util.function.BiFunction biFunction) {
        return compute(obj, BiFunction.VivifiedWrapper.convert(biFunction));
    }

    public final Object computeIfAbsent(Object obj, Function function) {
        Object computeIfAbsent;
        synchronized (this.f28776b) {
            computeIfAbsent = Map.EL.computeIfAbsent(this.f28775a, obj, function);
        }
        return computeIfAbsent;
    }

    public final /* synthetic */ Object computeIfAbsent(Object obj, java.util.function.Function function) {
        return computeIfAbsent(obj, Function.VivifiedWrapper.convert(function));
    }

    public final Object computeIfPresent(Object obj, BiFunction biFunction) {
        Object computeIfPresent;
        synchronized (this.f28776b) {
            computeIfPresent = Map.EL.computeIfPresent(this.f28775a, obj, biFunction);
        }
        return computeIfPresent;
    }

    public final /* synthetic */ Object computeIfPresent(Object obj, java.util.function.BiFunction biFunction) {
        return computeIfPresent(obj, BiFunction.VivifiedWrapper.convert(biFunction));
    }

    public final boolean containsKey(Object obj) {
        boolean containsKey;
        synchronized (this.f28776b) {
            containsKey = this.f28775a.containsKey(obj);
        }
        return containsKey;
    }

    public final boolean containsValue(Object obj) {
        boolean containsValue;
        synchronized (this.f28776b) {
            containsValue = this.f28775a.containsValue(obj);
        }
        return containsValue;
    }

    public final Set entrySet() {
        Set set;
        synchronized (this.f28776b) {
            if (this.f28778d == null) {
                this.f28778d = a(this.f28775a.entrySet(), this.f28776b);
            }
            set = this.f28778d;
        }
        return set;
    }

    public final boolean equals(Object obj) {
        boolean equals;
        if (this == obj) {
            return true;
        }
        synchronized (this.f28776b) {
            equals = this.f28775a.equals(obj);
        }
        return equals;
    }

    public final void forEach(BiConsumer biConsumer) {
        synchronized (this.f28776b) {
            Map.EL.forEach(this.f28775a, biConsumer);
        }
    }

    public final /* synthetic */ void forEach(java.util.function.BiConsumer biConsumer) {
        forEach(BiConsumer.VivifiedWrapper.convert(biConsumer));
    }

    public final Object get(Object obj) {
        Object obj2;
        synchronized (this.f28776b) {
            obj2 = this.f28775a.get(obj);
        }
        return obj2;
    }

    public final Object getOrDefault(Object obj, Object obj2) {
        Object orDefault;
        synchronized (this.f28776b) {
            orDefault = Map.EL.getOrDefault(this.f28775a, obj, obj2);
        }
        return orDefault;
    }

    public final int hashCode() {
        int hashCode;
        synchronized (this.f28776b) {
            hashCode = this.f28775a.hashCode();
        }
        return hashCode;
    }

    public final boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.f28776b) {
            isEmpty = this.f28775a.isEmpty();
        }
        return isEmpty;
    }

    public final Set keySet() {
        Set set;
        synchronized (this.f28776b) {
            if (this.f28777c == null) {
                this.f28777c = a(this.f28775a.keySet(), this.f28776b);
            }
            set = this.f28777c;
        }
        return set;
    }

    public final Object merge(Object obj, Object obj2, BiFunction biFunction) {
        Object merge;
        synchronized (this.f28776b) {
            java.util.Map map = this.f28775a;
            merge = map instanceof Map ? ((Map) map).merge(obj, obj2, biFunction) : map instanceof java.util.concurrent.ConcurrentMap ? ConcurrentMap.CC.$default$merge((java.util.concurrent.ConcurrentMap) map, obj, obj2, biFunction) : Map.CC.$default$merge(map, obj, obj2, biFunction);
        }
        return merge;
    }

    public final /* synthetic */ Object merge(Object obj, Object obj2, java.util.function.BiFunction biFunction) {
        return merge(obj, obj2, BiFunction.VivifiedWrapper.convert(biFunction));
    }

    public final Object put(Object obj, Object obj2) {
        Object put;
        synchronized (this.f28776b) {
            put = this.f28775a.put(obj, obj2);
        }
        return put;
    }

    public final void putAll(java.util.Map map) {
        synchronized (this.f28776b) {
            this.f28775a.putAll(map);
        }
    }

    public final Object putIfAbsent(Object obj, Object obj2) {
        Object putIfAbsent;
        synchronized (this.f28776b) {
            putIfAbsent = Map.EL.putIfAbsent(this.f28775a, obj, obj2);
        }
        return putIfAbsent;
    }

    public final Object remove(Object obj) {
        Object remove;
        synchronized (this.f28776b) {
            remove = this.f28775a.remove(obj);
        }
        return remove;
    }

    public final boolean remove(Object obj, Object obj2) {
        boolean remove;
        synchronized (this.f28776b) {
            remove = Map.EL.remove(this.f28775a, obj, obj2);
        }
        return remove;
    }

    public final Object replace(Object obj, Object obj2) {
        Object replace;
        synchronized (this.f28776b) {
            replace = Map.EL.replace(this.f28775a, obj, obj2);
        }
        return replace;
    }

    public final boolean replace(Object obj, Object obj2, Object obj3) {
        boolean replace;
        synchronized (this.f28776b) {
            java.util.Map map = this.f28775a;
            replace = map instanceof Map ? ((Map) map).replace(obj, obj2, obj3) : Map.CC.$default$replace(map, obj, obj2, obj3);
        }
        return replace;
    }

    public final void replaceAll(BiFunction biFunction) {
        synchronized (this.f28776b) {
            Map.EL.a(this.f28775a, biFunction);
        }
    }

    public final /* synthetic */ void replaceAll(java.util.function.BiFunction biFunction) {
        replaceAll(BiFunction.VivifiedWrapper.convert(biFunction));
    }

    public final int size() {
        int size;
        synchronized (this.f28776b) {
            size = this.f28775a.size();
        }
        return size;
    }

    public final String toString() {
        String obj;
        synchronized (this.f28776b) {
            obj = this.f28775a.toString();
        }
        return obj;
    }

    public final Collection values() {
        Collection collection;
        Collection collection2;
        synchronized (this.f28776b) {
            if (this.f28779e == null) {
                Collection values = this.f28775a.values();
                Object obj = this.f28776b;
                if (DesugarCollections.f28545d == null) {
                    collection2 = Collections.synchronizedCollection(values);
                } else {
                    try {
                        collection2 = (Collection) DesugarCollections.f28545d.newInstance(new Object[]{values, obj});
                    } catch (InstantiationException e11) {
                        e = e11;
                        throw new Error("Unable to instantiate a synchronized list.", e);
                    } catch (IllegalAccessException e12) {
                        e = e12;
                        throw new Error("Unable to instantiate a synchronized list.", e);
                    } catch (InvocationTargetException e13) {
                        e = e13;
                        throw new Error("Unable to instantiate a synchronized list.", e);
                    }
                }
                this.f28779e = collection2;
            }
            collection = this.f28779e;
        }
        return collection;
    }
}
