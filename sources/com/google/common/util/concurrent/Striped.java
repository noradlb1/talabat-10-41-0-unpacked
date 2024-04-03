package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.MapMaker;
import com.google.common.math.IntMath;
import i9.k;
import i9.l;
import i9.m;
import i9.n;
import i9.o;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
@J2ktIncompatible
public abstract class Striped<L> {
    private static final int ALL_SET = -1;
    private static final int LARGE_LAZY_CUTOFF = 1024;

    public static class CompactStriped<L> extends PowerOfTwoStriped<L> {
        private final Object[] array;

        public L getAt(int i11) {
            return this.array[i11];
        }

        public int size() {
            return this.array.length;
        }

        private CompactStriped(int i11, Supplier<L> supplier) {
            super(i11);
            int i12 = 0;
            Preconditions.checkArgument(i11 <= 1073741824, "Stripes must be <= 2^30)");
            this.array = new Object[(this.mask + 1)];
            while (true) {
                Object[] objArr = this.array;
                if (i12 < objArr.length) {
                    objArr[i12] = supplier.get();
                    i12++;
                } else {
                    return;
                }
            }
        }
    }

    @VisibleForTesting
    public static class LargeLazyStriped<L> extends PowerOfTwoStriped<L> {
        final ConcurrentMap<Integer, L> locks;
        final int size;
        final Supplier<L> supplier;

        public LargeLazyStriped(int i11, Supplier<L> supplier2) {
            super(i11);
            int i12;
            int i13 = this.mask;
            if (i13 == -1) {
                i12 = Integer.MAX_VALUE;
            } else {
                i12 = i13 + 1;
            }
            this.size = i12;
            this.supplier = supplier2;
            this.locks = new MapMaker().weakValues().makeMap();
        }

        public L getAt(int i11) {
            if (this.size != Integer.MAX_VALUE) {
                Preconditions.checkElementIndex(i11, size());
            }
            L l11 = this.locks.get(Integer.valueOf(i11));
            if (l11 != null) {
                return l11;
            }
            L l12 = this.supplier.get();
            return MoreObjects.firstNonNull(this.locks.putIfAbsent(Integer.valueOf(i11), l12), l12);
        }

        public int size() {
            return this.size;
        }
    }

    public static class PaddedLock extends ReentrantLock {
        long unused1;
        long unused2;
        long unused3;

        public PaddedLock() {
            super(false);
        }
    }

    public static class PaddedSemaphore extends Semaphore {
        long unused1;
        long unused2;
        long unused3;

        public PaddedSemaphore(int i11) {
            super(i11, false);
        }
    }

    public static abstract class PowerOfTwoStriped<L> extends Striped<L> {
        final int mask;

        public PowerOfTwoStriped(int i11) {
            super();
            boolean z11;
            int i12;
            if (i11 > 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            Preconditions.checkArgument(z11, "Stripes must be positive");
            if (i11 > 1073741824) {
                i12 = -1;
            } else {
                i12 = Striped.ceilToPowerOfTwo(i11) - 1;
            }
            this.mask = i12;
        }

        public final L get(Object obj) {
            return getAt(indexFor(obj));
        }

        public final int indexFor(Object obj) {
            return Striped.smear(obj.hashCode()) & this.mask;
        }
    }

    @VisibleForTesting
    public static class SmallLazyStriped<L> extends PowerOfTwoStriped<L> {
        final AtomicReferenceArray<ArrayReference<? extends L>> locks;
        final ReferenceQueue<L> queue = new ReferenceQueue<>();
        final int size;
        final Supplier<L> supplier;

        public static final class ArrayReference<L> extends WeakReference<L> {
            final int index;

            public ArrayReference(L l11, int i11, ReferenceQueue<L> referenceQueue) {
                super(l11, referenceQueue);
                this.index = i11;
            }
        }

        public SmallLazyStriped(int i11, Supplier<L> supplier2) {
            super(i11);
            int i12;
            int i13 = this.mask;
            if (i13 == -1) {
                i12 = Integer.MAX_VALUE;
            } else {
                i12 = i13 + 1;
            }
            this.size = i12;
            this.locks = new AtomicReferenceArray<>(i12);
            this.supplier = supplier2;
        }

        private void drainQueue() {
            while (true) {
                Reference<? extends L> poll = this.queue.poll();
                if (poll != null) {
                    ArrayReference arrayReference = (ArrayReference) poll;
                    o.a(this.locks, arrayReference.index, arrayReference, (Object) null);
                } else {
                    return;
                }
            }
        }

        public L getAt(int i11) {
            L l11;
            L l12;
            if (this.size != Integer.MAX_VALUE) {
                Preconditions.checkElementIndex(i11, size());
            }
            ArrayReference arrayReference = this.locks.get(i11);
            if (arrayReference == null) {
                l11 = null;
            } else {
                l11 = arrayReference.get();
            }
            if (l11 != null) {
                return l11;
            }
            L l13 = this.supplier.get();
            ArrayReference arrayReference2 = new ArrayReference(l13, i11, this.queue);
            while (!o.a(this.locks, i11, arrayReference, arrayReference2)) {
                arrayReference = this.locks.get(i11);
                if (arrayReference == null) {
                    l12 = null;
                    continue;
                } else {
                    l12 = arrayReference.get();
                    continue;
                }
                if (l12 != null) {
                    return l12;
                }
            }
            drainQueue();
            return l13;
        }

        public int size() {
            return this.size;
        }
    }

    public static final class WeakSafeCondition extends ForwardingCondition {
        private final Condition delegate;
        private final WeakSafeReadWriteLock strongReference;

        public WeakSafeCondition(Condition condition, WeakSafeReadWriteLock weakSafeReadWriteLock) {
            this.delegate = condition;
            this.strongReference = weakSafeReadWriteLock;
        }

        public Condition delegate() {
            return this.delegate;
        }
    }

    public static final class WeakSafeLock extends ForwardingLock {
        private final Lock delegate;
        private final WeakSafeReadWriteLock strongReference;

        public WeakSafeLock(Lock lock, WeakSafeReadWriteLock weakSafeReadWriteLock) {
            this.delegate = lock;
            this.strongReference = weakSafeReadWriteLock;
        }

        public Lock delegate() {
            return this.delegate;
        }

        public Condition newCondition() {
            return new WeakSafeCondition(this.delegate.newCondition(), this.strongReference);
        }
    }

    public static final class WeakSafeReadWriteLock implements ReadWriteLock {
        private final ReadWriteLock delegate = new ReentrantReadWriteLock();

        public Lock readLock() {
            return new WeakSafeLock(this.delegate.readLock(), this);
        }

        public Lock writeLock() {
            return new WeakSafeLock(this.delegate.writeLock(), this);
        }
    }

    private Striped() {
    }

    /* access modifiers changed from: private */
    public static int ceilToPowerOfTwo(int i11) {
        return 1 << IntMath.log2(i11, RoundingMode.CEILING);
    }

    public static <L> Striped<L> custom(int i11, Supplier<L> supplier) {
        return new CompactStriped(i11, supplier);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Lock lambda$lazyWeakLock$0() {
        return new ReentrantLock(false);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Semaphore lambda$lazyWeakSemaphore$2(int i11) {
        return new Semaphore(i11, false);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Semaphore lambda$semaphore$1(int i11) {
        return new PaddedSemaphore(i11);
    }

    private static <L> Striped<L> lazy(int i11, Supplier<L> supplier) {
        if (i11 < 1024) {
            return new SmallLazyStriped(i11, supplier);
        }
        return new LargeLazyStriped(i11, supplier);
    }

    public static Striped<Lock> lazyWeakLock(int i11) {
        return lazy(i11, new n());
    }

    public static Striped<ReadWriteLock> lazyWeakReadWriteLock(int i11) {
        return lazy(i11, new p());
    }

    public static Striped<Semaphore> lazyWeakSemaphore(int i11, int i12) {
        return lazy(i11, new l(i12));
    }

    public static Striped<Lock> lock(int i11) {
        return custom(i11, new q());
    }

    public static Striped<ReadWriteLock> readWriteLock(int i11) {
        return custom(i11, new m());
    }

    public static Striped<Semaphore> semaphore(int i11, int i12) {
        return custom(i11, new k(i12));
    }

    /* access modifiers changed from: private */
    public static int smear(int i11) {
        int i12 = i11 ^ ((i11 >>> 20) ^ (i11 >>> 12));
        return (i12 >>> 4) ^ ((i12 >>> 7) ^ i12);
    }

    public Iterable<L> bulkGet(Iterable<? extends Object> iterable) {
        ArrayList<E> newArrayList = Lists.newArrayList(iterable);
        if (newArrayList.isEmpty()) {
            return ImmutableList.of();
        }
        int[] iArr = new int[newArrayList.size()];
        for (int i11 = 0; i11 < newArrayList.size(); i11++) {
            iArr[i11] = indexFor(newArrayList.get(i11));
        }
        Arrays.sort(iArr);
        int i12 = iArr[0];
        newArrayList.set(0, getAt(i12));
        for (int i13 = 1; i13 < newArrayList.size(); i13++) {
            int i14 = iArr[i13];
            if (i14 == i12) {
                newArrayList.set(i13, newArrayList.get(i13 - 1));
            } else {
                newArrayList.set(i13, getAt(i14));
                i12 = i14;
            }
        }
        return Collections.unmodifiableList(newArrayList);
    }

    public abstract L get(Object obj);

    public abstract L getAt(int i11);

    public abstract int indexFor(Object obj);

    public abstract int size();
}
