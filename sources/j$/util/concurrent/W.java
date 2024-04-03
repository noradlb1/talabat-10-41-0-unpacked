package j$.util.concurrent;

import j$.util.C0189n;
import j$.util.D;
import j$.util.function.Consumer;
import j$.util.function.K;
import java.util.Comparator;

final class W implements D {

    /* renamed from: a  reason: collision with root package name */
    long f28686a;

    /* renamed from: b  reason: collision with root package name */
    final long f28687b;

    /* renamed from: c  reason: collision with root package name */
    final int f28688c;

    /* renamed from: d  reason: collision with root package name */
    final int f28689d;

    W(long j11, long j12, int i11, int i12) {
        this.f28686a = j11;
        this.f28687b = j12;
        this.f28688c = i11;
        this.f28689d = i12;
    }

    public final /* synthetic */ boolean a(Consumer consumer) {
        return C0189n.n(this, consumer);
    }

    /* renamed from: c */
    public final void forEachRemaining(K k11) {
        k11.getClass();
        long j11 = this.f28686a;
        long j12 = this.f28687b;
        if (j11 < j12) {
            this.f28686a = j12;
            ThreadLocalRandom current = ThreadLocalRandom.current();
            do {
                k11.accept(current.d(this.f28688c, this.f28689d));
                j11++;
            } while (j11 < j12);
        }
    }

    public final int characteristics() {
        return 17728;
    }

    public final long estimateSize() {
        return this.f28687b - this.f28686a;
    }

    /* renamed from: f */
    public final W trySplit() {
        long j11 = this.f28686a;
        long j12 = (this.f28687b + j11) >>> 1;
        if (j12 <= j11) {
            return null;
        }
        this.f28686a = j12;
        return new W(j11, j12, this.f28688c, this.f28689d);
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        C0189n.g(this, consumer);
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

    /* renamed from: j */
    public final boolean tryAdvance(K k11) {
        k11.getClass();
        long j11 = this.f28686a;
        if (j11 >= this.f28687b) {
            return false;
        }
        k11.accept(ThreadLocalRandom.current().d(this.f28688c, this.f28689d));
        this.f28686a = j11 + 1;
        return true;
    }
}
