package j$.util.concurrent;

import j$.util.C0189n;
import j$.util.G;
import j$.util.function.C0152f0;
import j$.util.function.Consumer;
import java.util.Comparator;

final class X implements G {

    /* renamed from: a  reason: collision with root package name */
    long f28690a;

    /* renamed from: b  reason: collision with root package name */
    final long f28691b;

    /* renamed from: c  reason: collision with root package name */
    final long f28692c;

    /* renamed from: d  reason: collision with root package name */
    final long f28693d;

    X(long j11, long j12, long j13, long j14) {
        this.f28690a = j11;
        this.f28691b = j12;
        this.f28692c = j13;
        this.f28693d = j14;
    }

    public final /* synthetic */ boolean a(Consumer consumer) {
        return C0189n.p(this, consumer);
    }

    /* renamed from: b */
    public final void forEachRemaining(C0152f0 f0Var) {
        f0Var.getClass();
        long j11 = this.f28690a;
        long j12 = this.f28691b;
        if (j11 < j12) {
            this.f28690a = j12;
            ThreadLocalRandom current = ThreadLocalRandom.current();
            do {
                f0Var.accept(current.e(this.f28692c, this.f28693d));
                j11++;
            } while (j11 < j12);
        }
    }

    public final int characteristics() {
        return 17728;
    }

    /* renamed from: e */
    public final boolean tryAdvance(C0152f0 f0Var) {
        f0Var.getClass();
        long j11 = this.f28690a;
        if (j11 >= this.f28691b) {
            return false;
        }
        f0Var.accept(ThreadLocalRandom.current().e(this.f28692c, this.f28693d));
        this.f28690a = j11 + 1;
        return true;
    }

    public final long estimateSize() {
        return this.f28691b - this.f28690a;
    }

    /* renamed from: f */
    public final X trySplit() {
        long j11 = this.f28690a;
        long j12 = (this.f28691b + j11) >>> 1;
        if (j12 <= j11) {
            return null;
        }
        this.f28690a = j12;
        return new X(j11, j12, this.f28692c, this.f28693d);
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        C0189n.h(this, consumer);
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
}
