package io.reactivex.internal.queue;

import io.reactivex.annotations.Nullable;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.util.Pow2;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class SpscLinkedArrayQueue<T> implements SimplePlainQueue<T> {
    private static final Object HAS_NEXT = new Object();

    /* renamed from: j  reason: collision with root package name */
    public static final int f18452j = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();

    /* renamed from: b  reason: collision with root package name */
    public final AtomicLong f18453b = new AtomicLong();

    /* renamed from: c  reason: collision with root package name */
    public int f18454c;

    /* renamed from: d  reason: collision with root package name */
    public long f18455d;

    /* renamed from: e  reason: collision with root package name */
    public final int f18456e;

    /* renamed from: f  reason: collision with root package name */
    public AtomicReferenceArray<Object> f18457f;

    /* renamed from: g  reason: collision with root package name */
    public final int f18458g;

    /* renamed from: h  reason: collision with root package name */
    public AtomicReferenceArray<Object> f18459h;

    /* renamed from: i  reason: collision with root package name */
    public final AtomicLong f18460i = new AtomicLong();

    public SpscLinkedArrayQueue(int i11) {
        int roundToPowerOfTwo = Pow2.roundToPowerOfTwo(Math.max(8, i11));
        int i12 = roundToPowerOfTwo - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(roundToPowerOfTwo + 1);
        this.f18457f = atomicReferenceArray;
        this.f18456e = i12;
        adjustLookAheadStep(roundToPowerOfTwo);
        this.f18459h = atomicReferenceArray;
        this.f18458g = i12;
        this.f18455d = (long) (i12 - 1);
        soProducerIndex(0);
    }

    private void adjustLookAheadStep(int i11) {
        this.f18454c = Math.min(i11 / 4, f18452j);
    }

    private static int calcDirectOffset(int i11) {
        return i11;
    }

    private static int calcWrappedOffset(long j11, int i11) {
        return calcDirectOffset(((int) j11) & i11);
    }

    private long lpConsumerIndex() {
        return this.f18460i.get();
    }

    private long lpProducerIndex() {
        return this.f18453b.get();
    }

    private long lvConsumerIndex() {
        return this.f18460i.get();
    }

    private static <E> Object lvElement(AtomicReferenceArray<Object> atomicReferenceArray, int i11) {
        return atomicReferenceArray.get(i11);
    }

    private AtomicReferenceArray<Object> lvNextBufferAndUnlink(AtomicReferenceArray<Object> atomicReferenceArray, int i11) {
        int calcDirectOffset = calcDirectOffset(i11);
        AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) lvElement(atomicReferenceArray, calcDirectOffset);
        soElement(atomicReferenceArray, calcDirectOffset, (Object) null);
        return atomicReferenceArray2;
    }

    private long lvProducerIndex() {
        return this.f18453b.get();
    }

    private T newBufferPeek(AtomicReferenceArray<Object> atomicReferenceArray, long j11, int i11) {
        this.f18459h = atomicReferenceArray;
        return lvElement(atomicReferenceArray, calcWrappedOffset(j11, i11));
    }

    private T newBufferPoll(AtomicReferenceArray<Object> atomicReferenceArray, long j11, int i11) {
        this.f18459h = atomicReferenceArray;
        int calcWrappedOffset = calcWrappedOffset(j11, i11);
        T lvElement = lvElement(atomicReferenceArray, calcWrappedOffset);
        if (lvElement != null) {
            soElement(atomicReferenceArray, calcWrappedOffset, (Object) null);
            soConsumerIndex(j11 + 1);
        }
        return lvElement;
    }

    private void resize(AtomicReferenceArray<Object> atomicReferenceArray, long j11, int i11, T t11, long j12) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.f18457f = atomicReferenceArray2;
        this.f18455d = (j12 + j11) - 1;
        soElement(atomicReferenceArray2, i11, t11);
        soNext(atomicReferenceArray, atomicReferenceArray2);
        soElement(atomicReferenceArray, i11, HAS_NEXT);
        soProducerIndex(j11 + 1);
    }

    private void soConsumerIndex(long j11) {
        this.f18460i.lazySet(j11);
    }

    private static void soElement(AtomicReferenceArray<Object> atomicReferenceArray, int i11, Object obj) {
        atomicReferenceArray.lazySet(i11, obj);
    }

    private void soNext(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        soElement(atomicReferenceArray, calcDirectOffset(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private void soProducerIndex(long j11) {
        this.f18453b.lazySet(j11);
    }

    private boolean writeToQueue(AtomicReferenceArray<Object> atomicReferenceArray, T t11, long j11, int i11) {
        soElement(atomicReferenceArray, i11, t11);
        soProducerIndex(j11 + 1);
        return true;
    }

    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    public boolean isEmpty() {
        return lvProducerIndex() == lvConsumerIndex();
    }

    public boolean offer(T t11) {
        if (t11 != null) {
            AtomicReferenceArray<Object> atomicReferenceArray = this.f18457f;
            long lpProducerIndex = lpProducerIndex();
            int i11 = this.f18456e;
            int calcWrappedOffset = calcWrappedOffset(lpProducerIndex, i11);
            if (lpProducerIndex < this.f18455d) {
                return writeToQueue(atomicReferenceArray, t11, lpProducerIndex, calcWrappedOffset);
            }
            long j11 = ((long) this.f18454c) + lpProducerIndex;
            if (lvElement(atomicReferenceArray, calcWrappedOffset(j11, i11)) == null) {
                this.f18455d = j11 - 1;
                return writeToQueue(atomicReferenceArray, t11, lpProducerIndex, calcWrappedOffset);
            } else if (lvElement(atomicReferenceArray, calcWrappedOffset(1 + lpProducerIndex, i11)) == null) {
                return writeToQueue(atomicReferenceArray, t11, lpProducerIndex, calcWrappedOffset);
            } else {
                resize(atomicReferenceArray, lpProducerIndex, calcWrappedOffset, t11, (long) i11);
                return true;
            }
        } else {
            throw new NullPointerException("Null is not a valid element");
        }
    }

    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f18459h;
        long lpConsumerIndex = lpConsumerIndex();
        int i11 = this.f18458g;
        T lvElement = lvElement(atomicReferenceArray, calcWrappedOffset(lpConsumerIndex, i11));
        if (lvElement == HAS_NEXT) {
            return newBufferPeek(lvNextBufferAndUnlink(atomicReferenceArray, i11 + 1), lpConsumerIndex, i11);
        }
        return lvElement;
    }

    @Nullable
    public T poll() {
        boolean z11;
        AtomicReferenceArray<Object> atomicReferenceArray = this.f18459h;
        long lpConsumerIndex = lpConsumerIndex();
        int i11 = this.f18458g;
        int calcWrappedOffset = calcWrappedOffset(lpConsumerIndex, i11);
        T lvElement = lvElement(atomicReferenceArray, calcWrappedOffset);
        if (lvElement == HAS_NEXT) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (lvElement != null && !z11) {
            soElement(atomicReferenceArray, calcWrappedOffset, (Object) null);
            soConsumerIndex(lpConsumerIndex + 1);
            return lvElement;
        } else if (z11) {
            return newBufferPoll(lvNextBufferAndUnlink(atomicReferenceArray, i11 + 1), lpConsumerIndex, i11);
        } else {
            return null;
        }
    }

    public int size() {
        long lvConsumerIndex = lvConsumerIndex();
        while (true) {
            long lvProducerIndex = lvProducerIndex();
            long lvConsumerIndex2 = lvConsumerIndex();
            if (lvConsumerIndex == lvConsumerIndex2) {
                return (int) (lvProducerIndex - lvConsumerIndex2);
            }
            lvConsumerIndex = lvConsumerIndex2;
        }
    }

    public boolean offer(T t11, T t12) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f18457f;
        long lvProducerIndex = lvProducerIndex();
        int i11 = this.f18456e;
        long j11 = 2 + lvProducerIndex;
        if (lvElement(atomicReferenceArray, calcWrappedOffset(j11, i11)) == null) {
            int calcWrappedOffset = calcWrappedOffset(lvProducerIndex, i11);
            soElement(atomicReferenceArray, calcWrappedOffset + 1, t12);
            soElement(atomicReferenceArray, calcWrappedOffset, t11);
            soProducerIndex(j11);
            return true;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.f18457f = atomicReferenceArray2;
        int calcWrappedOffset2 = calcWrappedOffset(lvProducerIndex, i11);
        soElement(atomicReferenceArray2, calcWrappedOffset2 + 1, t12);
        soElement(atomicReferenceArray2, calcWrappedOffset2, t11);
        soNext(atomicReferenceArray, atomicReferenceArray2);
        soElement(atomicReferenceArray, calcWrappedOffset2, HAS_NEXT);
        soProducerIndex(j11);
        return true;
    }
}
