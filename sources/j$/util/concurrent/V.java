package j$.util.concurrent;

import j$.util.A;
import j$.util.C0189n;
import j$.util.function.C0165m;
import j$.util.function.Consumer;
import java.util.Comparator;

final class V implements A {

    /* renamed from: a  reason: collision with root package name */
    long f28682a;

    /* renamed from: b  reason: collision with root package name */
    final long f28683b;

    /* renamed from: c  reason: collision with root package name */
    final double f28684c;

    /* renamed from: d  reason: collision with root package name */
    final double f28685d;

    V(long j11, long j12, double d11, double d12) {
        this.f28682a = j11;
        this.f28683b = j12;
        this.f28684c = d11;
        this.f28685d = d12;
    }

    public final /* synthetic */ boolean a(Consumer consumer) {
        return C0189n.m(this, consumer);
    }

    public final int characteristics() {
        return 17728;
    }

    /* renamed from: d */
    public final void forEachRemaining(C0165m mVar) {
        mVar.getClass();
        long j11 = this.f28682a;
        long j12 = this.f28683b;
        if (j11 < j12) {
            this.f28682a = j12;
            ThreadLocalRandom current = ThreadLocalRandom.current();
            do {
                mVar.accept(current.c(this.f28684c, this.f28685d));
                j11++;
            } while (j11 < j12);
        }
    }

    public final long estimateSize() {
        return this.f28683b - this.f28682a;
    }

    /* renamed from: f */
    public final V trySplit() {
        long j11 = this.f28682a;
        long j12 = (this.f28683b + j11) >>> 1;
        if (j12 <= j11) {
            return null;
        }
        this.f28682a = j12;
        return new V(j11, j12, this.f28684c, this.f28685d);
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        C0189n.f(this, consumer);
    }

    public final Comparator getComparator() {
        throw new IllegalStateException();
    }

    public final /* synthetic */ long getExactSizeIfKnown() {
        return C0189n.i(this);
    }

    public final /* synthetic */ boolean hasCharacteristics(int i11) {
        return C0189n.k(this, i11);
    }

    /* renamed from: o */
    public final boolean tryAdvance(C0165m mVar) {
        mVar.getClass();
        long j11 = this.f28682a;
        if (j11 >= this.f28683b) {
            return false;
        }
        mVar.accept(ThreadLocalRandom.current().c(this.f28684c, this.f28685d));
        this.f28682a = j11 + 1;
        return true;
    }
}
