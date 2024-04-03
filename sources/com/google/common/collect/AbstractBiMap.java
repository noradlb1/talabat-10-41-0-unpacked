package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.j2objc.annotations.RetainedWith;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
abstract class AbstractBiMap<K, V> extends ForwardingMap<K, V> implements BiMap<K, V>, Serializable {
    @GwtIncompatible
    @J2ktIncompatible
    private static final long serialVersionUID = 0;
    /* access modifiers changed from: private */
    public transient Map<K, V> delegate;
    @CheckForNull
    private transient Set<Map.Entry<K, V>> entrySet;
    @RetainedWith
    transient AbstractBiMap<V, K> inverse;
    @CheckForNull
    private transient Set<K> keySet;
    @CheckForNull
    private transient Set<V> valueSet;

    public class BiMapEntry extends ForwardingMapEntry<K, V> {
        private final Map.Entry<K, V> delegate;

        public BiMapEntry(Map.Entry<K, V> entry) {
            this.delegate = entry;
        }

        public V setValue(V v11) {
            AbstractBiMap.this.checkValue(v11);
            Preconditions.checkState(AbstractBiMap.this.entrySet().contains(this), "entry no longer in map");
            if (Objects.equal(v11, getValue())) {
                return v11;
            }
            Preconditions.checkArgument(!AbstractBiMap.this.containsValue(v11), "value already present: %s", (Object) v11);
            V value = this.delegate.setValue(v11);
            Preconditions.checkState(Objects.equal(v11, AbstractBiMap.this.get(getKey())), "entry no longer in map");
            AbstractBiMap.this.updateInverseMap(getKey(), true, value, v11);
            return value;
        }

        public Map.Entry<K, V> delegate() {
            return this.delegate;
        }
    }

    public class EntrySet extends ForwardingSet<Map.Entry<K, V>> {
        final Set<Map.Entry<K, V>> esDelegate;

        private EntrySet() {
            this.esDelegate = AbstractBiMap.this.delegate.entrySet();
        }

        public void clear() {
            AbstractBiMap.this.clear();
        }

        public boolean contains(@CheckForNull Object obj) {
            return Maps.containsEntryImpl(delegate(), obj);
        }

        public boolean containsAll(Collection<?> collection) {
            return standardContainsAll(collection);
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return AbstractBiMap.this.entrySetIterator();
        }

        public boolean remove(@CheckForNull Object obj) {
            if (!this.esDelegate.contains(obj) || !(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            AbstractBiMap.this.inverse.delegate.remove(entry.getValue());
            this.esDelegate.remove(entry);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            return standardRemoveAll(collection);
        }

        public boolean retainAll(Collection<?> collection) {
            return standardRetainAll(collection);
        }

        public Object[] toArray() {
            return standardToArray();
        }

        public <T> T[] toArray(T[] tArr) {
            return standardToArray(tArr);
        }

        public Set<Map.Entry<K, V>> delegate() {
            return this.esDelegate;
        }
    }

    public static class Inverse<K, V> extends AbstractBiMap<K, V> {
        @GwtIncompatible
        @J2ktIncompatible
        private static final long serialVersionUID = 0;

        public Inverse(Map<K, V> map, AbstractBiMap<V, K> abstractBiMap) {
            super(map, abstractBiMap);
        }

        @GwtIncompatible
        @J2ktIncompatible
        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            setInverse((AbstractBiMap) objectInputStream.readObject());
        }

        @GwtIncompatible
        @J2ktIncompatible
        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(inverse());
        }

        @ParametricNullness
        public K checkKey(@ParametricNullness K k11) {
            return this.inverse.checkValue(k11);
        }

        @ParametricNullness
        public V checkValue(@ParametricNullness V v11) {
            return this.inverse.checkKey(v11);
        }

        public /* bridge */ /* synthetic */ Object delegate() {
            return AbstractBiMap.super.delegate();
        }

        @GwtIncompatible
        @J2ktIncompatible
        public Object readResolve() {
            return inverse().inverse();
        }

        public /* bridge */ /* synthetic */ Collection values() {
            return AbstractBiMap.super.values();
        }
    }

    public class ValueSet extends ForwardingSet<V> {
        final Set<V> valuesDelegate;

        private ValueSet() {
            this.valuesDelegate = AbstractBiMap.this.inverse.keySet();
        }

        public Iterator<V> iterator() {
            return Maps.valueIterator(AbstractBiMap.this.entrySet().iterator());
        }

        public Object[] toArray() {
            return standardToArray();
        }

        public String toString() {
            return standardToString();
        }

        public <T> T[] toArray(T[] tArr) {
            return standardToArray(tArr);
        }

        public Set<V> delegate() {
            return this.valuesDelegate;
        }
    }

    @CheckForNull
    private V putInBothMaps(@ParametricNullness K k11, @ParametricNullness V v11, boolean z11) {
        checkKey(k11);
        checkValue(v11);
        boolean containsKey = containsKey(k11);
        if (containsKey && Objects.equal(v11, get(k11))) {
            return v11;
        }
        if (z11) {
            inverse().remove(v11);
        } else {
            Preconditions.checkArgument(!containsValue(v11), "value already present: %s", (Object) v11);
        }
        V put = this.delegate.put(k11, v11);
        updateInverseMap(k11, containsKey, put, v11);
        return put;
    }

    /* access modifiers changed from: private */
    @ParametricNullness
    @CanIgnoreReturnValue
    public V removeFromBothMaps(@CheckForNull Object obj) {
        V uncheckedCastNullableTToT = NullnessCasts.uncheckedCastNullableTToT(this.delegate.remove(obj));
        removeFromInverseMap(uncheckedCastNullableTToT);
        return uncheckedCastNullableTToT;
    }

    /* access modifiers changed from: private */
    public void removeFromInverseMap(@ParametricNullness V v11) {
        this.inverse.delegate.remove(v11);
    }

    /* access modifiers changed from: private */
    public void updateInverseMap(@ParametricNullness K k11, boolean z11, @CheckForNull V v11, @ParametricNullness V v12) {
        if (z11) {
            removeFromInverseMap(NullnessCasts.uncheckedCastNullableTToT(v11));
        }
        this.inverse.delegate.put(v12, k11);
    }

    @ParametricNullness
    @CanIgnoreReturnValue
    public K checkKey(@ParametricNullness K k11) {
        return k11;
    }

    @ParametricNullness
    @CanIgnoreReturnValue
    public V checkValue(@ParametricNullness V v11) {
        return v11;
    }

    public void clear() {
        this.delegate.clear();
        this.inverse.delegate.clear();
    }

    public boolean containsValue(@CheckForNull Object obj) {
        return this.inverse.containsKey(obj);
    }

    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        EntrySet entrySet2 = new EntrySet();
        this.entrySet = entrySet2;
        return entrySet2;
    }

    public Iterator<Map.Entry<K, V>> entrySetIterator() {
        final Iterator<Map.Entry<K, V>> it = this.delegate.entrySet().iterator();
        return new Object() {
            @CheckForNull
            Map.Entry<K, V> entry;

            public /* synthetic */ void forEachRemaining(Consumer consumer) {
                Iterator.CC.$default$forEachRemaining(this, consumer);
            }

            public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
                forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
            }

            public boolean hasNext() {
                return it.hasNext();
            }

            public void remove() {
                Map.Entry<K, V> entry2 = this.entry;
                if (entry2 != null) {
                    V value = entry2.getValue();
                    it.remove();
                    AbstractBiMap.this.removeFromInverseMap(value);
                    this.entry = null;
                    return;
                }
                throw new IllegalStateException("no calls to next() since the last call to remove()");
            }

            public Map.Entry<K, V> next() {
                Map.Entry<K, V> entry2 = (Map.Entry) it.next();
                this.entry = entry2;
                return new BiMapEntry(entry2);
            }
        };
    }

    @CheckForNull
    @CanIgnoreReturnValue
    public V forcePut(@ParametricNullness K k11, @ParametricNullness V v11) {
        return putInBothMaps(k11, v11, true);
    }

    public BiMap<V, K> inverse() {
        return this.inverse;
    }

    public Set<K> keySet() {
        Set<K> set = this.keySet;
        if (set != null) {
            return set;
        }
        KeySet keySet2 = new KeySet();
        this.keySet = keySet2;
        return keySet2;
    }

    public AbstractBiMap<V, K> makeInverse(Map<V, K> map) {
        return new Inverse(map, this);
    }

    @CheckForNull
    @CanIgnoreReturnValue
    public V put(@ParametricNullness K k11, @ParametricNullness V v11) {
        return putInBothMaps(k11, v11, false);
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry next : map.entrySet()) {
            put(next.getKey(), next.getValue());
        }
    }

    @CheckForNull
    @CanIgnoreReturnValue
    public V remove(@CheckForNull Object obj) {
        if (containsKey(obj)) {
            return removeFromBothMaps(obj);
        }
        return null;
    }

    public void setDelegates(Map<K, V> map, Map<V, K> map2) {
        boolean z11;
        boolean z12;
        boolean z13 = true;
        if (this.delegate == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkState(z11);
        if (this.inverse == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        Preconditions.checkState(z12);
        Preconditions.checkArgument(map.isEmpty());
        Preconditions.checkArgument(map2.isEmpty());
        if (map == map2) {
            z13 = false;
        }
        Preconditions.checkArgument(z13);
        this.delegate = map;
        this.inverse = makeInverse(map2);
    }

    public void setInverse(AbstractBiMap<V, K> abstractBiMap) {
        this.inverse = abstractBiMap;
    }

    public class KeySet extends ForwardingSet<K> {
        private KeySet() {
        }

        public void clear() {
            AbstractBiMap.this.clear();
        }

        public java.util.Iterator<K> iterator() {
            return Maps.keyIterator(AbstractBiMap.this.entrySet().iterator());
        }

        public boolean remove(@CheckForNull Object obj) {
            if (!contains(obj)) {
                return false;
            }
            Object unused = AbstractBiMap.this.removeFromBothMaps(obj);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            return standardRemoveAll(collection);
        }

        public boolean retainAll(Collection<?> collection) {
            return standardRetainAll(collection);
        }

        public Set<K> delegate() {
            return AbstractBiMap.this.delegate.keySet();
        }
    }

    public AbstractBiMap(Map<K, V> map, Map<V, K> map2) {
        setDelegates(map, map2);
    }

    public Map<K, V> delegate() {
        return this.delegate;
    }

    public Set<V> values() {
        Set<V> set = this.valueSet;
        if (set != null) {
            return set;
        }
        ValueSet valueSet2 = new ValueSet();
        this.valueSet = valueSet2;
        return valueSet2;
    }

    private AbstractBiMap(Map<K, V> map, AbstractBiMap<V, K> abstractBiMap) {
        this.delegate = map;
        this.inverse = abstractBiMap;
    }
}
