package org.mockito.internal.util.concurrent;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.Map;
import org.mockito.internal.util.concurrent.WeakConcurrentMap;

public class WeakConcurrentSet<V> implements Runnable, Iterable<V> {

    /* renamed from: b  reason: collision with root package name */
    public final WeakConcurrentMap<V, Boolean> f63262b;

    /* renamed from: org.mockito.internal.util.concurrent.WeakConcurrentSet$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f63263a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                org.mockito.internal.util.concurrent.WeakConcurrentSet$Cleaner[] r0 = org.mockito.internal.util.concurrent.WeakConcurrentSet.Cleaner.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f63263a = r0
                org.mockito.internal.util.concurrent.WeakConcurrentSet$Cleaner r1 = org.mockito.internal.util.concurrent.WeakConcurrentSet.Cleaner.INLINE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f63263a     // Catch:{ NoSuchFieldError -> 0x001d }
                org.mockito.internal.util.concurrent.WeakConcurrentSet$Cleaner r1 = org.mockito.internal.util.concurrent.WeakConcurrentSet.Cleaner.THREAD     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f63263a     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.mockito.internal.util.concurrent.WeakConcurrentSet$Cleaner r1 = org.mockito.internal.util.concurrent.WeakConcurrentSet.Cleaner.MANUAL     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.mockito.internal.util.concurrent.WeakConcurrentSet.AnonymousClass1.<clinit>():void");
        }
    }

    public enum Cleaner {
        THREAD,
        INLINE,
        MANUAL
    }

    public static class ReducingIterator<V> implements Iterator<V>, j$.util.Iterator {
        private final Iterator<Map.Entry<V, Boolean>> iterator;

        public /* synthetic */ ReducingIterator(Iterator it, AnonymousClass1 r22) {
            this(it);
        }

        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
        }

        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        public V next() {
            return this.iterator.next().getKey();
        }

        public void remove() {
            this.iterator.remove();
        }

        private ReducingIterator(java.util.Iterator<Map.Entry<V, Boolean>> it) {
            this.iterator = it;
        }
    }

    public WeakConcurrentSet(Cleaner cleaner) {
        int i11 = AnonymousClass1.f63263a[cleaner.ordinal()];
        boolean z11 = true;
        if (i11 == 1) {
            this.f63262b = new WeakConcurrentMap.WithInlinedExpunction();
        } else if (i11 == 2 || i11 == 3) {
            this.f63262b = new WeakConcurrentMap<>(cleaner != Cleaner.THREAD ? false : z11);
        } else {
            throw new AssertionError();
        }
    }

    public boolean add(V v11) {
        return this.f63262b.put(v11, Boolean.TRUE) == null;
    }

    public int approximateSize() {
        return this.f63262b.approximateSize();
    }

    public void clear() {
        this.f63262b.clear();
    }

    public boolean contains(V v11) {
        return this.f63262b.containsKey(v11);
    }

    public void expungeStaleEntries() {
        this.f63262b.expungeStaleEntries();
    }

    public Thread getCleanerThread() {
        return this.f63262b.getCleanerThread();
    }

    public java.util.Iterator<V> iterator() {
        return new ReducingIterator(this.f63262b.iterator(), (AnonymousClass1) null);
    }

    public boolean remove(V v11) {
        return this.f63262b.remove(v11) != null;
    }

    public void run() {
        this.f63262b.run();
    }
}
