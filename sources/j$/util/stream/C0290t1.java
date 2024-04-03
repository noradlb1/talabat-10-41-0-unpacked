package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.Consumer;
import java.util.concurrent.CountedCompleter;

/* renamed from: j$.util.stream.t1  reason: case insensitive filesystem */
abstract class C0290t1 extends CountedCompleter implements C0272p2 {

    /* renamed from: a  reason: collision with root package name */
    protected final Spliterator f29230a;

    /* renamed from: b  reason: collision with root package name */
    protected final C0314y0 f29231b;

    /* renamed from: c  reason: collision with root package name */
    protected final long f29232c;

    /* renamed from: d  reason: collision with root package name */
    protected long f29233d;

    /* renamed from: e  reason: collision with root package name */
    protected long f29234e;

    /* renamed from: f  reason: collision with root package name */
    protected int f29235f;

    /* renamed from: g  reason: collision with root package name */
    protected int f29236g;

    C0290t1(int i11, Spliterator spliterator, C0314y0 y0Var) {
        this.f29230a = spliterator;
        this.f29231b = y0Var;
        this.f29232c = C0219f.g(spliterator.estimateSize());
        this.f29233d = 0;
        this.f29234e = (long) i11;
    }

    C0290t1(C0290t1 t1Var, Spliterator spliterator, long j11, long j12, int i11) {
        super(t1Var);
        this.f29230a = spliterator;
        this.f29231b = t1Var.f29231b;
        this.f29232c = t1Var.f29232c;
        this.f29233d = j11;
        this.f29234e = j12;
        if (j11 < 0 || j12 < 0 || (j11 + j12) - 1 >= ((long) i11)) {
            throw new IllegalArgumentException(String.format("offset and length interval [%d, %d + %d) is not within array size interval [0, %d)", new Object[]{Long.valueOf(j11), Long.valueOf(j11), Long.valueOf(j12), Integer.valueOf(i11)}));
        }
    }

    /* access modifiers changed from: package-private */
    public abstract C0290t1 a(Spliterator spliterator, long j11, long j12);

    public /* synthetic */ void accept(double d11) {
        C0314y0.d0();
        throw null;
    }

    public /* synthetic */ void accept(int i11) {
        C0314y0.k0();
        throw null;
    }

    public /* synthetic */ void accept(long j11) {
        C0314y0.l0();
        throw null;
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    public final void compute() {
        Spliterator trySplit;
        Spliterator spliterator = this.f29230a;
        C0290t1 t1Var = this;
        while (spliterator.estimateSize() > t1Var.f29232c && (trySplit = spliterator.trySplit()) != null) {
            t1Var.setPendingCount(1);
            long estimateSize = trySplit.estimateSize();
            t1Var.a(trySplit, t1Var.f29233d, estimateSize).fork();
            t1Var = t1Var.a(spliterator, t1Var.f29233d + estimateSize, t1Var.f29234e - estimateSize);
        }
        t1Var.f29231b.g1(spliterator, t1Var);
        t1Var.propagateCompletion();
    }

    public final /* synthetic */ void end() {
    }

    public final void f(long j11) {
        long j12 = this.f29234e;
        if (j11 <= j12) {
            int i11 = (int) this.f29233d;
            this.f29235f = i11;
            this.f29236g = i11 + ((int) j12);
            return;
        }
        throw new IllegalStateException("size passed to Sink.begin exceeds array length");
    }

    public final /* synthetic */ boolean h() {
        return false;
    }
}
