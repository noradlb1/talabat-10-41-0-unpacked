package j$.util.stream;

import j$.util.C0189n;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import java.util.Comparator;
import java.util.Objects;

final class F3 extends G3 implements Spliterator {
    F3(Spliterator spliterator, long j11, long j12) {
        super(spliterator, j11, j12, 0, Math.min(spliterator.estimateSize(), j12));
    }

    private F3(Spliterator spliterator, long j11, long j12, long j13, long j14) {
        super(spliterator, j11, j12, j13, j14);
    }

    public final boolean a(Consumer consumer) {
        long j11;
        Objects.requireNonNull(consumer);
        long j12 = this.f28929e;
        long j13 = this.f28925a;
        if (j13 >= j12) {
            return false;
        }
        while (true) {
            j11 = this.f28928d;
            if (j13 <= j11) {
                break;
            }
            this.f28927c.a(new N0(6));
            this.f28928d++;
        }
        if (j11 >= this.f28929e) {
            return false;
        }
        this.f28928d = j11 + 1;
        return this.f28927c.a(consumer);
    }

    /* access modifiers changed from: protected */
    public final Spliterator f(Spliterator spliterator, long j11, long j12, long j13, long j14) {
        return new F3(spliterator, j11, j12, j13, j14);
    }

    public final void forEachRemaining(Consumer consumer) {
        Objects.requireNonNull(consumer);
        long j11 = this.f28929e;
        long j12 = this.f28925a;
        if (j12 < j11) {
            long j13 = this.f28928d;
            if (j13 < j11) {
                if (j13 < j12 || this.f28927c.estimateSize() + j13 > this.f28926b) {
                    while (j12 > this.f28928d) {
                        this.f28927c.a(new N0(5));
                        this.f28928d++;
                    }
                    while (this.f28928d < this.f28929e) {
                        this.f28927c.a(consumer);
                        this.f28928d++;
                    }
                    return;
                }
                this.f28927c.forEachRemaining(consumer);
                this.f28928d = this.f28929e;
            }
        }
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
