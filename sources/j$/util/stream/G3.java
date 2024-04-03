package j$.util.stream;

import j$.util.Spliterator;

abstract class G3 {

    /* renamed from: a  reason: collision with root package name */
    final long f28925a;

    /* renamed from: b  reason: collision with root package name */
    final long f28926b;

    /* renamed from: c  reason: collision with root package name */
    Spliterator f28927c;

    /* renamed from: d  reason: collision with root package name */
    long f28928d;

    /* renamed from: e  reason: collision with root package name */
    long f28929e;

    G3(Spliterator spliterator, long j11, long j12, long j13, long j14) {
        this.f28927c = spliterator;
        this.f28925a = j11;
        this.f28926b = j12;
        this.f28928d = j13;
        this.f28929e = j14;
    }

    public final int characteristics() {
        return this.f28927c.characteristics();
    }

    public final long estimateSize() {
        long j11 = this.f28929e;
        long j12 = this.f28925a;
        if (j12 < j11) {
            return j11 - Math.max(j12, this.f28928d);
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public abstract Spliterator f(Spliterator spliterator, long j11, long j12, long j13, long j14);

    public final Spliterator trySplit() {
        long j11 = this.f28929e;
        if (this.f28925a >= j11 || this.f28928d >= j11) {
            return null;
        }
        while (true) {
            Spliterator trySplit = this.f28927c.trySplit();
            if (trySplit == null) {
                return null;
            }
            long estimateSize = trySplit.estimateSize() + this.f28928d;
            long min = Math.min(estimateSize, this.f28926b);
            long j12 = this.f28925a;
            if (j12 >= min) {
                this.f28928d = min;
            } else {
                long j13 = this.f28926b;
                if (min >= j13) {
                    this.f28927c = trySplit;
                    this.f28929e = min;
                } else {
                    long j14 = this.f28928d;
                    if (j14 < j12 || estimateSize > j13) {
                        this.f28928d = min;
                        return f(trySplit, j12, j13, j14, min);
                    }
                    this.f28928d = min;
                    return trySplit;
                }
            }
        }
    }
}
