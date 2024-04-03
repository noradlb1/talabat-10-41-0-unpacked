package androidx.collection;

import androidx.annotation.Nullable;
import j$.util.Iterator;
import j$.util.Map;
import j$.util.function.Consumer;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

abstract class MapCollections<K, V> {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public MapCollections<K, V>.EntrySet f1032a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public MapCollections<K, V>.KeySet f1033b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public MapCollections<K, V>.ValuesCollection f1034c;

    public final class ArrayIterator<T> implements Iterator<T>, j$.util.Iterator {

        /* renamed from: b  reason: collision with root package name */
        public final int f1035b;

        /* renamed from: c  reason: collision with root package name */
        public int f1036c;

        /* renamed from: d  reason: collision with root package name */
        public int f1037d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f1038e = false;

        public ArrayIterator(int i11) {
            this.f1035b = i11;
            this.f1036c = MapCollections.this.d();
        }

        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
        }

        public boolean hasNext() {
            return this.f1037d < this.f1036c;
        }

        public T next() {
            if (hasNext()) {
                T b11 = MapCollections.this.b(this.f1037d, this.f1035b);
                this.f1037d++;
                this.f1038e = true;
                return b11;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            if (this.f1038e) {
                int i11 = this.f1037d - 1;
                this.f1037d = i11;
                this.f1036c--;
                this.f1038e = false;
                MapCollections.this.h(i11);
                return;
            }
            throw new IllegalStateException();
        }
    }

    public final class EntrySet implements Set<Map.Entry<K, V>> {
        public EntrySet() {
        }

        public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
            int d11 = MapCollections.this.d();
            for (Map.Entry entry : collection) {
                MapCollections.this.g(entry.getKey(), entry.getValue());
            }
            if (d11 != MapCollections.this.d()) {
                return true;
            }
            return false;
        }

        public void clear() {
            MapCollections.this.a();
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int e11 = MapCollections.this.e(entry.getKey());
            if (e11 < 0) {
                return false;
            }
            return ContainerHelpers.equal(MapCollections.this.b(e11, 1), entry.getValue());
        }

        public boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public boolean equals(Object obj) {
            return MapCollections.equalsSetHelper(this, obj);
        }

        public int hashCode() {
            int i11;
            int i12;
            int i13 = 0;
            for (int d11 = MapCollections.this.d() - 1; d11 >= 0; d11--) {
                Object b11 = MapCollections.this.b(d11, 0);
                Object b12 = MapCollections.this.b(d11, 1);
                if (b11 == null) {
                    i11 = 0;
                } else {
                    i11 = b11.hashCode();
                }
                if (b12 == null) {
                    i12 = 0;
                } else {
                    i12 = b12.hashCode();
                }
                i13 += i11 ^ i12;
            }
            return i13;
        }

        public boolean isEmpty() {
            return MapCollections.this.d() == 0;
        }

        public java.util.Iterator<Map.Entry<K, V>> iterator() {
            return new MapIterator();
        }

        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public int size() {
            return MapCollections.this.d();
        }

        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        public boolean add(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        public <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }
    }

    public final class KeySet implements Set<K> {
        public KeySet() {
        }

        public boolean add(K k11) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            MapCollections.this.a();
        }

        public boolean contains(Object obj) {
            return MapCollections.this.e(obj) >= 0;
        }

        public boolean containsAll(Collection<?> collection) {
            return MapCollections.containsAllHelper(MapCollections.this.c(), collection);
        }

        public boolean equals(Object obj) {
            return MapCollections.equalsSetHelper(this, obj);
        }

        public int hashCode() {
            int i11;
            int i12 = 0;
            for (int d11 = MapCollections.this.d() - 1; d11 >= 0; d11--) {
                Object b11 = MapCollections.this.b(d11, 0);
                if (b11 == null) {
                    i11 = 0;
                } else {
                    i11 = b11.hashCode();
                }
                i12 += i11;
            }
            return i12;
        }

        public boolean isEmpty() {
            return MapCollections.this.d() == 0;
        }

        public java.util.Iterator<K> iterator() {
            return new ArrayIterator(0);
        }

        public boolean remove(Object obj) {
            int e11 = MapCollections.this.e(obj);
            if (e11 < 0) {
                return false;
            }
            MapCollections.this.h(e11);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            return MapCollections.removeAllHelper(MapCollections.this.c(), collection);
        }

        public boolean retainAll(Collection<?> collection) {
            return MapCollections.retainAllHelper(MapCollections.this.c(), collection);
        }

        public int size() {
            return MapCollections.this.d();
        }

        public Object[] toArray() {
            return MapCollections.this.toArrayHelper(0);
        }

        public <T> T[] toArray(T[] tArr) {
            return MapCollections.this.toArrayHelper(tArr, 0);
        }
    }

    public final class MapIterator implements java.util.Iterator<Map.Entry<K, V>>, Map.Entry<K, V>, j$.util.Iterator, Map.Entry {

        /* renamed from: b  reason: collision with root package name */
        public int f1042b;

        /* renamed from: c  reason: collision with root package name */
        public int f1043c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f1044d = false;

        public MapIterator() {
            this.f1042b = MapCollections.this.d() - 1;
            this.f1043c = -1;
        }

        public boolean equals(Object obj) {
            if (!this.f1044d) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            } else if (!(obj instanceof Map.Entry)) {
                return false;
            } else {
                Map.Entry entry = (Map.Entry) obj;
                if (!ContainerHelpers.equal(entry.getKey(), MapCollections.this.b(this.f1043c, 0)) || !ContainerHelpers.equal(entry.getValue(), MapCollections.this.b(this.f1043c, 1))) {
                    return false;
                }
                return true;
            }
        }

        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
        }

        public K getKey() {
            if (this.f1044d) {
                return MapCollections.this.b(this.f1043c, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public V getValue() {
            if (this.f1044d) {
                return MapCollections.this.b(this.f1043c, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public boolean hasNext() {
            return this.f1043c < this.f1042b;
        }

        public int hashCode() {
            int i11;
            if (this.f1044d) {
                int i12 = 0;
                Object b11 = MapCollections.this.b(this.f1043c, 0);
                Object b12 = MapCollections.this.b(this.f1043c, 1);
                if (b11 == null) {
                    i11 = 0;
                } else {
                    i11 = b11.hashCode();
                }
                if (b12 != null) {
                    i12 = b12.hashCode();
                }
                return i11 ^ i12;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public void remove() {
            if (this.f1044d) {
                MapCollections.this.h(this.f1043c);
                this.f1043c--;
                this.f1042b--;
                this.f1044d = false;
                return;
            }
            throw new IllegalStateException();
        }

        public V setValue(V v11) {
            if (this.f1044d) {
                return MapCollections.this.i(this.f1043c, v11);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }

        public Map.Entry<K, V> next() {
            if (hasNext()) {
                this.f1043c++;
                this.f1044d = true;
                return this;
            }
            throw new NoSuchElementException();
        }
    }

    public final class ValuesCollection implements Collection<V> {
        public ValuesCollection() {
        }

        public boolean add(V v11) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            MapCollections.this.a();
        }

        public boolean contains(Object obj) {
            return MapCollections.this.f(obj) >= 0;
        }

        public boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public boolean isEmpty() {
            return MapCollections.this.d() == 0;
        }

        public java.util.Iterator<V> iterator() {
            return new ArrayIterator(1);
        }

        public boolean remove(Object obj) {
            int f11 = MapCollections.this.f(obj);
            if (f11 < 0) {
                return false;
            }
            MapCollections.this.h(f11);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            int d11 = MapCollections.this.d();
            int i11 = 0;
            boolean z11 = false;
            while (i11 < d11) {
                if (collection.contains(MapCollections.this.b(i11, 1))) {
                    MapCollections.this.h(i11);
                    i11--;
                    d11--;
                    z11 = true;
                }
                i11++;
            }
            return z11;
        }

        public boolean retainAll(Collection<?> collection) {
            int d11 = MapCollections.this.d();
            int i11 = 0;
            boolean z11 = false;
            while (i11 < d11) {
                if (!collection.contains(MapCollections.this.b(i11, 1))) {
                    MapCollections.this.h(i11);
                    i11--;
                    d11--;
                    z11 = true;
                }
                i11++;
            }
            return z11;
        }

        public int size() {
            return MapCollections.this.d();
        }

        public Object[] toArray() {
            return MapCollections.this.toArrayHelper(1);
        }

        public <T> T[] toArray(T[] tArr) {
            return MapCollections.this.toArrayHelper(tArr, 1);
        }
    }

    public static <K, V> boolean containsAllHelper(java.util.Map<K, V> map, Collection<?> collection) {
        for (Object containsKey : collection) {
            if (!map.containsKey(containsKey)) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean equalsSetHelper(Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() != set2.size() || !set.containsAll(set2)) {
                    return false;
                }
                return true;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public static <K, V> boolean removeAllHelper(java.util.Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        for (Object remove : collection) {
            map.remove(remove);
        }
        if (size != map.size()) {
            return true;
        }
        return false;
    }

    public static <K, V> boolean retainAllHelper(java.util.Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        java.util.Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        if (size != map.size()) {
            return true;
        }
        return false;
    }

    public abstract void a();

    public abstract Object b(int i11, int i12);

    public abstract java.util.Map<K, V> c();

    public abstract int d();

    public abstract int e(Object obj);

    public abstract int f(Object obj);

    public abstract void g(K k11, V v11);

    public Set<Map.Entry<K, V>> getEntrySet() {
        if (this.f1032a == null) {
            this.f1032a = new EntrySet();
        }
        return this.f1032a;
    }

    public Set<K> getKeySet() {
        if (this.f1033b == null) {
            this.f1033b = new KeySet();
        }
        return this.f1033b;
    }

    public Collection<V> getValues() {
        if (this.f1034c == null) {
            this.f1034c = new ValuesCollection();
        }
        return this.f1034c;
    }

    public abstract void h(int i11);

    public abstract V i(int i11, V v11);

    public Object[] toArrayHelper(int i11) {
        int d11 = d();
        Object[] objArr = new Object[d11];
        for (int i12 = 0; i12 < d11; i12++) {
            objArr[i12] = b(i12, i11);
        }
        return objArr;
    }

    public <T> T[] toArrayHelper(T[] tArr, int i11) {
        int d11 = d();
        if (tArr.length < d11) {
            tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), d11);
        }
        for (int i12 = 0; i12 < d11; i12++) {
            tArr[i12] = b(i12, i11);
        }
        if (tArr.length > d11) {
            tArr[d11] = null;
        }
        return tArr;
    }
}
