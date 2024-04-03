package j$.util.stream;

import j$.util.Spliterator;
import java.util.concurrent.atomic.AtomicLong;

abstract class N3 {

    /* renamed from: a  reason: collision with root package name */
    protected final Spliterator f28989a;

    /* renamed from: b  reason: collision with root package name */
    protected final boolean f28990b;

    /* renamed from: c  reason: collision with root package name */
    protected final int f28991c;

    /* renamed from: d  reason: collision with root package name */
    private final long f28992d;

    /* renamed from: e  reason: collision with root package name */
    private final AtomicLong f28993e;

    N3(Spliterator spliterator, long j11, long j12) {
        this.f28989a = spliterator;
        long j13 = 0;
        int i11 = (j12 > 0 ? 1 : (j12 == 0 ? 0 : -1));
        this.f28990b = i11 < 0;
        this.f28992d = i11 >= 0 ? j12 : j13;
        this.f28991c = 128;
        this.f28993e = new AtomicLong(i11 >= 0 ? j11 + j12 : j11);
    }

    N3(Spliterator spliterator, N3 n32) {
        this.f28989a = spliterator;
        this.f28990b = n32.f28990b;
        this.f28993e = n32.f28993e;
        this.f28992d = n32.f28992d;
        this.f28991c = n32.f28991c;
    }

    public final int characteristics() {
        return this.f28989a.characteristics() & -16465;
    }

    public final long estimateSize() {
        return this.f28989a.estimateSize();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long q(long r12) {
        /*
            r11 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicLong r0 = r11.f28993e
            long r1 = r0.get()
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            boolean r6 = r11.f28990b
            if (r5 != 0) goto L_0x0013
            if (r6 == 0) goto L_0x0011
            goto L_0x0012
        L_0x0011:
            r12 = r3
        L_0x0012:
            return r12
        L_0x0013:
            long r7 = java.lang.Math.min(r1, r12)
            int r5 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x0023
            long r9 = r1 - r7
            boolean r0 = r0.compareAndSet(r1, r9)
            if (r0 == 0) goto L_0x0000
        L_0x0023:
            if (r6 == 0) goto L_0x002b
            long r12 = r12 - r7
            long r12 = java.lang.Math.max(r12, r3)
            return r12
        L_0x002b:
            long r12 = r11.f28992d
            int r0 = (r1 > r12 ? 1 : (r1 == r12 ? 0 : -1))
            if (r0 <= 0) goto L_0x0038
            long r1 = r1 - r12
            long r7 = r7 - r1
            long r12 = java.lang.Math.max(r7, r3)
            return r12
        L_0x0038:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.N3.q(long):long");
    }

    /* access modifiers changed from: protected */
    public abstract Spliterator r(Spliterator spliterator);

    /* access modifiers changed from: protected */
    public final M3 s() {
        return this.f28993e.get() > 0 ? M3.MAYBE_MORE : this.f28990b ? M3.UNLIMITED : M3.NO_MORE;
    }

    public final Spliterator trySplit() {
        Spliterator trySplit;
        if (this.f28993e.get() == 0 || (trySplit = this.f28989a.trySplit()) == null) {
            return null;
        }
        return r(trySplit);
    }
}
