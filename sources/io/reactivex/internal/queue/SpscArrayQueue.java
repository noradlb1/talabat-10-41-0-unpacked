package io.reactivex.internal.queue;

import io.reactivex.annotations.Nullable;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.util.Pow2;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class SpscArrayQueue<E> extends AtomicReferenceArray<E> implements SimplePlainQueue<E> {
    private static final Integer MAX_LOOK_AHEAD_STEP = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    private static final long serialVersionUID = -1296597691183856449L;

    /* renamed from: b  reason: collision with root package name */
    public final int f18447b = (length() - 1);

    /* renamed from: c  reason: collision with root package name */
    public final AtomicLong f18448c = new AtomicLong();

    /* renamed from: d  reason: collision with root package name */
    public long f18449d;

    /* renamed from: e  reason: collision with root package name */
    public final AtomicLong f18450e = new AtomicLong();

    /* renamed from: f  reason: collision with root package name */
    public final int f18451f;

    public SpscArrayQueue(int i11) {
        super(Pow2.roundToPowerOfTwo(i11));
        this.f18451f = Math.min(i11 / 4, MAX_LOOK_AHEAD_STEP.intValue());
    }

    public int a(long j11) {
        return ((int) j11) & this.f18447b;
    }

    public int b(long j11, int i11) {
        return ((int) j11) & i11;
    }

    public E c(int i11) {
        return get(i11);
    }

    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    public void d(long j11) {
        this.f18450e.lazySet(j11);
    }

    public void e(int i11, E e11) {
        lazySet(i11, e11);
    }

    public void f(long j11) {
        this.f18448c.lazySet(j11);
    }

    public boolean isEmpty() {
        return this.f18448c.get() == this.f18450e.get();
    }

    public boolean offer(E e11) {
        if (e11 != null) {
            int i11 = this.f18447b;
            long j11 = this.f18448c.get();
            int b11 = b(j11, i11);
            if (j11 >= this.f18449d) {
                long j12 = ((long) this.f18451f) + j11;
                if (c(b(j12, i11)) == null) {
                    this.f18449d = j12;
                } else if (c(b11) != null) {
                    return false;
                }
            }
            e(b11, e11);
            f(j11 + 1);
            return true;
        }
        throw new NullPointerException("Null is not a valid element");
    }

    @Nullable
    public E poll() {
        long j11 = this.f18450e.get();
        int a11 = a(j11);
        E c11 = c(a11);
        if (c11 == null) {
            return null;
        }
        d(j11 + 1);
        e(a11, (Object) null);
        return c11;
    }

    public boolean offer(E e11, E e12) {
        return offer(e11) && offer(e12);
    }
}
