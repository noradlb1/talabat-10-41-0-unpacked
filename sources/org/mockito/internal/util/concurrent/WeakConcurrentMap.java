package org.mockito.internal.util.concurrent;

import j$.util.Iterator;
import j$.util.concurrent.ConcurrentHashMap;
import j$.util.function.Consumer;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

public class WeakConcurrentMap<K, V> extends ReferenceQueue<K> implements Runnable, Iterable<Map.Entry<K, V>> {
    private static final AtomicLong ID = new AtomicLong();
    public final ConcurrentMap<WeakKey<K>, V> target = new ConcurrentHashMap();
    private final Thread thread;

    public class EntryIterator implements Iterator<Map.Entry<K, V>>, j$.util.Iterator {
        private final Iterator<Map.Entry<WeakKey<K>, V>> iterator;
        private Map.Entry<WeakKey<K>, V> nextEntry;
        private K nextKey;

        private void findNext() {
            while (this.iterator.hasNext()) {
                Map.Entry<WeakKey<K>, V> next = this.iterator.next();
                this.nextEntry = next;
                K k11 = next.getKey().get();
                this.nextKey = k11;
                if (k11 != null) {
                    return;
                }
            }
            this.nextEntry = null;
            this.nextKey = null;
        }

        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
        }

        public boolean hasNext() {
            return this.nextKey != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        private EntryIterator(java.util.Iterator<Map.Entry<WeakKey<K>, V>> it) {
            this.iterator = it;
            findNext();
        }

        public Map.Entry<K, V> next() {
            K k11 = this.nextKey;
            if (k11 != null) {
                try {
                    return new SimpleEntry(k11, this.nextEntry);
                } finally {
                    findNext();
                }
            } else {
                throw new NoSuchElementException();
            }
        }
    }

    public static class LatentKey<T> {

        /* renamed from: a  reason: collision with root package name */
        public final T f63259a;
        private final int hashCode;

        public LatentKey(T t11) {
            this.f63259a = t11;
            this.hashCode = System.identityHashCode(t11);
        }

        public boolean equals(Object obj) {
            if (obj instanceof LatentKey) {
                if (((LatentKey) obj).f63259a == this.f63259a) {
                    return true;
                }
                return false;
            } else if (((WeakKey) obj).get() == this.f63259a) {
                return true;
            } else {
                return false;
            }
        }

        public int hashCode() {
            return this.hashCode;
        }
    }

    public class SimpleEntry implements Map.Entry<K, V> {

        /* renamed from: b  reason: collision with root package name */
        public final Map.Entry<WeakKey<K>, V> f63260b;
        private final K key;

        public K getKey() {
            return this.key;
        }

        public V getValue() {
            return this.f63260b.getValue();
        }

        public V setValue(V v11) {
            v11.getClass();
            return this.f63260b.setValue(v11);
        }

        private SimpleEntry(K k11, Map.Entry<WeakKey<K>, V> entry) {
            this.key = k11;
            this.f63260b = entry;
        }
    }

    public static class WeakKey<T> extends WeakReference<T> {
        private final int hashCode;

        public WeakKey(T t11, ReferenceQueue<? super T> referenceQueue) {
            super(t11, referenceQueue);
            this.hashCode = System.identityHashCode(t11);
        }

        public boolean equals(Object obj) {
            if (obj instanceof LatentKey) {
                if (((LatentKey) obj).f63259a == get()) {
                    return true;
                }
                return false;
            } else if (((WeakKey) obj).get() == get()) {
                return true;
            } else {
                return false;
            }
        }

        public int hashCode() {
            return this.hashCode;
        }
    }

    public static class WithInlinedExpunction<K, V> extends WeakConcurrentMap<K, V> {
        public WithInlinedExpunction() {
            super(false);
        }

        public int approximateSize() {
            expungeStaleEntries();
            return WeakConcurrentMap.super.approximateSize();
        }

        public boolean containsKey(K k11) {
            expungeStaleEntries();
            return WeakConcurrentMap.super.containsKey(k11);
        }

        public V get(K k11) {
            expungeStaleEntries();
            return WeakConcurrentMap.super.get(k11);
        }

        public java.util.Iterator<Map.Entry<K, V>> iterator() {
            expungeStaleEntries();
            return WeakConcurrentMap.super.iterator();
        }

        public V put(K k11, V v11) {
            expungeStaleEntries();
            return WeakConcurrentMap.super.put(k11, v11);
        }

        public V remove(K k11) {
            expungeStaleEntries();
            return WeakConcurrentMap.super.remove(k11);
        }
    }

    public WeakConcurrentMap(boolean z11) {
        if (z11) {
            Thread thread2 = new Thread(this);
            this.thread = thread2;
            thread2.setName("weak-ref-cleaner-" + ID.getAndIncrement());
            thread2.setPriority(1);
            thread2.setDaemon(true);
            thread2.start();
            return;
        }
        this.thread = null;
    }

    public V a(K k11) {
        return null;
    }

    public int approximateSize() {
        return this.target.size();
    }

    public void clear() {
        this.target.clear();
    }

    public boolean containsKey(K k11) {
        k11.getClass();
        return this.target.containsKey(new LatentKey(k11));
    }

    public void expungeStaleEntries() {
        while (true) {
            Reference poll = poll();
            if (poll != null) {
                this.target.remove(poll);
            } else {
                return;
            }
        }
    }

    public V get(K k11) {
        V putIfAbsent;
        k11.getClass();
        V v11 = this.target.get(new LatentKey(k11));
        if (v11 != null) {
            return v11;
        }
        V a11 = a(k11);
        if (a11 == null || (putIfAbsent = this.target.putIfAbsent(new WeakKey(k11, this), a11)) == null) {
            return a11;
        }
        return putIfAbsent;
    }

    public Thread getCleanerThread() {
        return this.thread;
    }

    public java.util.Iterator<Map.Entry<K, V>> iterator() {
        return new EntryIterator(this.target.entrySet().iterator());
    }

    public V put(K k11, V v11) {
        if (k11 != null && v11 != null) {
            return this.target.put(new WeakKey(k11, this), v11);
        }
        throw null;
    }

    public V remove(K k11) {
        k11.getClass();
        return this.target.remove(new LatentKey(k11));
    }

    public void run() {
        while (true) {
            try {
                this.target.remove(remove());
            } catch (InterruptedException unused) {
                clear();
                return;
            }
        }
    }
}
