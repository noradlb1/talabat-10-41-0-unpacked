package j$.util.stream;

import j$.util.C0189n;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import java.util.Comparator;

final class R3 implements Spliterator {

    /* renamed from: a  reason: collision with root package name */
    protected final Spliterator f29029a;

    /* renamed from: b  reason: collision with root package name */
    protected final Spliterator f29030b;

    /* renamed from: c  reason: collision with root package name */
    boolean f29031c = true;

    /* renamed from: d  reason: collision with root package name */
    final boolean f29032d;

    R3(Spliterator spliterator, Spliterator spliterator2) {
        this.f29029a = spliterator;
        this.f29030b = spliterator2;
        boolean z11 = true;
        this.f29032d = spliterator2.estimateSize() + spliterator.estimateSize() >= 0 ? false : z11;
    }

    public final boolean a(Consumer consumer) {
        if (this.f29031c) {
            boolean a11 = this.f29029a.a(consumer);
            if (a11) {
                return a11;
            }
            this.f29031c = false;
        }
        return this.f29030b.a(consumer);
    }

    public final int characteristics() {
        boolean z11 = this.f29031c;
        Spliterator spliterator = this.f29030b;
        if (!z11) {
            return spliterator.characteristics();
        }
        return this.f29029a.characteristics() & spliterator.characteristics() & (~((this.f29032d ? 16448 : 0) | 5));
    }

    public final long estimateSize() {
        boolean z11 = this.f29031c;
        Spliterator spliterator = this.f29030b;
        if (!z11) {
            return spliterator.estimateSize();
        }
        long estimateSize = spliterator.estimateSize() + this.f29029a.estimateSize();
        if (estimateSize >= 0) {
            return estimateSize;
        }
        return Long.MAX_VALUE;
    }

    public final void forEachRemaining(Consumer consumer) {
        if (this.f29031c) {
            this.f29029a.forEachRemaining(consumer);
        }
        this.f29030b.forEachRemaining(consumer);
    }

    public final Comparator getComparator() {
        if (!this.f29031c) {
            return this.f29030b.getComparator();
        }
        throw new IllegalStateException();
    }

    public final /* synthetic */ long getExactSizeIfKnown() {
        return C0189n.i(this);
    }

    public final /* synthetic */ boolean hasCharacteristics(int i11) {
        return C0189n.k(this, i11);
    }

    public final Spliterator trySplit() {
        Spliterator trySplit = this.f29031c ? this.f29029a : this.f29030b.trySplit();
        this.f29031c = false;
        return trySplit;
    }
}
