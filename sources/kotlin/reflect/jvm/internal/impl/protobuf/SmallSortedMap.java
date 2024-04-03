package kotlin.reflect.jvm.internal.impl.protobuf;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import kotlin.reflect.jvm.internal.impl.protobuf.FieldSet;

class SmallSortedMap<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    /* access modifiers changed from: private */
    public List<SmallSortedMap<K, V>.Entry> entryList;
    private boolean isImmutable;
    private volatile SmallSortedMap<K, V>.EntrySet lazyEntrySet;
    private final int maxArraySize;
    /* access modifiers changed from: private */
    public Map<K, V> overflowEntries;

    public static class EmptySet {
        private static final Iterable<Object> ITERABLE = new Iterable<Object>() {
            public Iterator<Object> iterator() {
                return EmptySet.ITERATOR;
            }
        };
        /* access modifiers changed from: private */
        public static final Iterator<Object> ITERATOR = new Object() {
            public /* synthetic */ void forEachRemaining(Consumer consumer) {
                Iterator.CC.$default$forEachRemaining(this, consumer);
            }

            public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
                forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
            }

            public boolean hasNext() {
                return false;
            }

            public Object next() {
                throw new NoSuchElementException();
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };

        public static <T> Iterable<T> b() {
            return ITERABLE;
        }
    }

    public class Entry implements Comparable<SmallSortedMap<K, V>.Entry>, Map.Entry<K, V> {
        private final K key;
        private V value;

        public Entry(SmallSortedMap smallSortedMap, Map.Entry<K, V> entry) {
            this((Comparable) entry.getKey(), entry.getValue());
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (!equals(this.key, entry.getKey()) || !equals(this.value, entry.getValue())) {
                return false;
            }
            return true;
        }

        public V getValue() {
            return this.value;
        }

        public int hashCode() {
            K k11 = this.key;
            int i11 = 0;
            int hashCode = k11 == null ? 0 : k11.hashCode();
            V v11 = this.value;
            if (v11 != null) {
                i11 = v11.hashCode();
            }
            return hashCode ^ i11;
        }

        public V setValue(V v11) {
            SmallSortedMap.this.checkMutable();
            V v12 = this.value;
            this.value = v11;
            return v12;
        }

        public String toString() {
            String valueOf = String.valueOf(this.key);
            String valueOf2 = String.valueOf(this.value);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 1 + valueOf2.length());
            sb2.append(valueOf);
            sb2.append("=");
            sb2.append(valueOf2);
            return sb2.toString();
        }

        public Entry(K k11, V v11) {
            this.key = k11;
            this.value = v11;
        }

        public int compareTo(SmallSortedMap<K, V>.Entry entry) {
            return getKey().compareTo(entry.getKey());
        }

        public K getKey() {
            return this.key;
        }

        private boolean equals(Object obj, Object obj2) {
            if (obj == null) {
                return obj2 == null;
            }
            return obj.equals(obj2);
        }
    }

    public class EntryIterator implements java.util.Iterator<Map.Entry<K, V>>, j$.util.Iterator {
        private java.util.Iterator<Map.Entry<K, V>> lazyOverflowIterator;
        private boolean nextCalledBeforeRemove;
        private int pos;

        private EntryIterator() {
            this.pos = -1;
        }

        private java.util.Iterator<Map.Entry<K, V>> getOverflowIterator() {
            if (this.lazyOverflowIterator == null) {
                this.lazyOverflowIterator = SmallSortedMap.this.overflowEntries.entrySet().iterator();
            }
            return this.lazyOverflowIterator;
        }

        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
        }

        public boolean hasNext() {
            return this.pos + 1 < SmallSortedMap.this.entryList.size() || getOverflowIterator().hasNext();
        }

        public void remove() {
            if (this.nextCalledBeforeRemove) {
                this.nextCalledBeforeRemove = false;
                SmallSortedMap.this.checkMutable();
                if (this.pos < SmallSortedMap.this.entryList.size()) {
                    SmallSortedMap smallSortedMap = SmallSortedMap.this;
                    int i11 = this.pos;
                    this.pos = i11 - 1;
                    Object unused = smallSortedMap.removeArrayEntryAt(i11);
                    return;
                }
                getOverflowIterator().remove();
                return;
            }
            throw new IllegalStateException("remove() was called before next()");
        }

        public Map.Entry<K, V> next() {
            this.nextCalledBeforeRemove = true;
            int i11 = this.pos + 1;
            this.pos = i11;
            if (i11 < SmallSortedMap.this.entryList.size()) {
                return (Map.Entry) SmallSortedMap.this.entryList.get(this.pos);
            }
            return (Map.Entry) getOverflowIterator().next();
        }
    }

    public class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        private EntrySet() {
        }

        public void clear() {
            SmallSortedMap.this.clear();
        }

        public boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = SmallSortedMap.this.get(entry.getKey());
            Object value = entry.getValue();
            if (obj2 == value || (obj2 != null && obj2.equals(value))) {
                return true;
            }
            return false;
        }

        public java.util.Iterator<Map.Entry<K, V>> iterator() {
            return new EntryIterator();
        }

        public boolean remove(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (!contains(entry)) {
                return false;
            }
            SmallSortedMap.this.remove(entry.getKey());
            return true;
        }

        public int size() {
            return SmallSortedMap.this.size();
        }

        public boolean add(Map.Entry<K, V> entry) {
            if (contains(entry)) {
                return false;
            }
            SmallSortedMap.this.put((Comparable) entry.getKey(), entry.getValue());
            return true;
        }
    }

    private int binarySearchInArray(K k11) {
        int size = this.entryList.size() - 1;
        if (size >= 0) {
            int compareTo = k11.compareTo(this.entryList.get(size).getKey());
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        int i11 = 0;
        while (i11 <= size) {
            int i12 = (i11 + size) / 2;
            int compareTo2 = k11.compareTo(this.entryList.get(i12).getKey());
            if (compareTo2 < 0) {
                size = i12 - 1;
            } else if (compareTo2 <= 0) {
                return i12;
            } else {
                i11 = i12 + 1;
            }
        }
        return -(i11 + 1);
    }

    /* access modifiers changed from: private */
    public void checkMutable() {
        if (this.isImmutable) {
            throw new UnsupportedOperationException();
        }
    }

    public static <FieldDescriptorType extends FieldSet.FieldDescriptorLite<FieldDescriptorType>> SmallSortedMap<FieldDescriptorType, Object> e(int i11) {
        return new SmallSortedMap<FieldDescriptorType, Object>(i11) {
            public void makeImmutable() {
                if (!isImmutable()) {
                    for (int i11 = 0; i11 < getNumArrayEntries(); i11++) {
                        Map.Entry arrayEntryAt = getArrayEntryAt(i11);
                        if (((FieldSet.FieldDescriptorLite) arrayEntryAt.getKey()).isRepeated()) {
                            arrayEntryAt.setValue(Collections.unmodifiableList((List) arrayEntryAt.getValue()));
                        }
                    }
                    for (Map.Entry entry : getOverflowEntries()) {
                        if (((FieldSet.FieldDescriptorLite) entry.getKey()).isRepeated()) {
                            entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                        }
                    }
                }
                SmallSortedMap.super.makeImmutable();
            }

            public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
                return SmallSortedMap.super.put((FieldSet.FieldDescriptorLite) obj, obj2);
            }
        };
    }

    private void ensureEntryArrayMutable() {
        checkMutable();
        if (this.entryList.isEmpty() && !(this.entryList instanceof ArrayList)) {
            this.entryList = new ArrayList(this.maxArraySize);
        }
    }

    private SortedMap<K, V> getOverflowEntriesMutable() {
        checkMutable();
        if (this.overflowEntries.isEmpty() && !(this.overflowEntries instanceof TreeMap)) {
            this.overflowEntries = new TreeMap();
        }
        return (SortedMap) this.overflowEntries;
    }

    /* access modifiers changed from: private */
    public V removeArrayEntryAt(int i11) {
        checkMutable();
        V value = this.entryList.remove(i11).getValue();
        if (!this.overflowEntries.isEmpty()) {
            java.util.Iterator it = getOverflowEntriesMutable().entrySet().iterator();
            this.entryList.add(new Entry(this, (Map.Entry) it.next()));
            it.remove();
        }
        return value;
    }

    public void clear() {
        checkMutable();
        if (!this.entryList.isEmpty()) {
            this.entryList.clear();
        }
        if (!this.overflowEntries.isEmpty()) {
            this.overflowEntries.clear();
        }
    }

    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        if (binarySearchInArray(comparable) >= 0 || this.overflowEntries.containsKey(comparable)) {
            return true;
        }
        return false;
    }

    public Set<Map.Entry<K, V>> entrySet() {
        if (this.lazyEntrySet == null) {
            this.lazyEntrySet = new EntrySet();
        }
        return this.lazyEntrySet;
    }

    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int binarySearchInArray = binarySearchInArray(comparable);
        if (binarySearchInArray >= 0) {
            return this.entryList.get(binarySearchInArray).getValue();
        }
        return this.overflowEntries.get(comparable);
    }

    public Map.Entry<K, V> getArrayEntryAt(int i11) {
        return this.entryList.get(i11);
    }

    public int getNumArrayEntries() {
        return this.entryList.size();
    }

    public Iterable<Map.Entry<K, V>> getOverflowEntries() {
        return this.overflowEntries.isEmpty() ? EmptySet.b() : this.overflowEntries.entrySet();
    }

    public boolean isImmutable() {
        return this.isImmutable;
    }

    public void makeImmutable() {
        Map<K, V> map;
        if (!this.isImmutable) {
            if (this.overflowEntries.isEmpty()) {
                map = Collections.emptyMap();
            } else {
                map = Collections.unmodifiableMap(this.overflowEntries);
            }
            this.overflowEntries = map;
            this.isImmutable = true;
        }
    }

    public V remove(Object obj) {
        checkMutable();
        Comparable comparable = (Comparable) obj;
        int binarySearchInArray = binarySearchInArray(comparable);
        if (binarySearchInArray >= 0) {
            return removeArrayEntryAt(binarySearchInArray);
        }
        if (this.overflowEntries.isEmpty()) {
            return null;
        }
        return this.overflowEntries.remove(comparable);
    }

    public int size() {
        return this.entryList.size() + this.overflowEntries.size();
    }

    private SmallSortedMap(int i11) {
        this.maxArraySize = i11;
        this.entryList = Collections.emptyList();
        this.overflowEntries = Collections.emptyMap();
    }

    public V put(K k11, V v11) {
        checkMutable();
        int binarySearchInArray = binarySearchInArray(k11);
        if (binarySearchInArray >= 0) {
            return this.entryList.get(binarySearchInArray).setValue(v11);
        }
        ensureEntryArrayMutable();
        int i11 = -(binarySearchInArray + 1);
        if (i11 >= this.maxArraySize) {
            return getOverflowEntriesMutable().put(k11, v11);
        }
        int size = this.entryList.size();
        int i12 = this.maxArraySize;
        if (size == i12) {
            Entry remove = this.entryList.remove(i12 - 1);
            getOverflowEntriesMutable().put(remove.getKey(), remove.getValue());
        }
        this.entryList.add(i11, new Entry(k11, v11));
        return null;
    }
}
