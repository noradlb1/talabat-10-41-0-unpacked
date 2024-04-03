package j$.util.stream;

import j$.util.Spliterator;
import java.util.concurrent.CountedCompleter;

final class W extends CountedCompleter {

    /* renamed from: a  reason: collision with root package name */
    private Spliterator f29056a;

    /* renamed from: b  reason: collision with root package name */
    private final C0272p2 f29057b;

    /* renamed from: c  reason: collision with root package name */
    private final C0314y0 f29058c;

    /* renamed from: d  reason: collision with root package name */
    private long f29059d;

    W(W w11, Spliterator spliterator) {
        super(w11);
        this.f29056a = spliterator;
        this.f29057b = w11.f29057b;
        this.f29059d = w11.f29059d;
        this.f29058c = w11.f29058c;
    }

    W(C0314y0 y0Var, Spliterator spliterator, C0272p2 p2Var) {
        super((CountedCompleter) null);
        this.f29057b = p2Var;
        this.f29058c = y0Var;
        this.f29056a = spliterator;
        this.f29059d = 0;
    }

    public final void compute() {
        Spliterator trySplit;
        Spliterator spliterator = this.f29056a;
        long estimateSize = spliterator.estimateSize();
        long j11 = this.f29059d;
        if (j11 == 0) {
            j11 = C0219f.g(estimateSize);
            this.f29059d = j11;
        }
        boolean k11 = C0213d3.SHORT_CIRCUIT.k(this.f29058c.T0());
        C0272p2 p2Var = this.f29057b;
        boolean z11 = false;
        W w11 = this;
        while (true) {
            if (k11 && p2Var.h()) {
                break;
            } else if (estimateSize <= j11 || (trySplit = spliterator.trySplit()) == null) {
                w11.f29058c.J0(spliterator, p2Var);
            } else {
                W w12 = new W(w11, trySplit);
                w11.addToPendingCount(1);
                if (z11) {
                    spliterator = trySplit;
                } else {
                    W w13 = w11;
                    w11 = w12;
                    w12 = w13;
                }
                z11 = !z11;
                w11.fork();
                w11 = w12;
                estimateSize = spliterator.estimateSize();
            }
        }
        w11.f29058c.J0(spliterator, p2Var);
        w11.f29056a = null;
        w11.propagateCompletion();
    }
}
