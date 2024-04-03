package j$.util.stream;

import j$.util.Spliterator;
import java.util.concurrent.CountedCompleter;
import java.util.concurrent.ForkJoinPool;

/* renamed from: j$.util.stream.f  reason: case insensitive filesystem */
abstract class C0219f extends CountedCompleter {

    /* renamed from: g  reason: collision with root package name */
    private static final int f29136g = (ForkJoinPool.getCommonPoolParallelism() << 2);

    /* renamed from: a  reason: collision with root package name */
    protected final C0314y0 f29137a;

    /* renamed from: b  reason: collision with root package name */
    protected Spliterator f29138b;

    /* renamed from: c  reason: collision with root package name */
    protected long f29139c;

    /* renamed from: d  reason: collision with root package name */
    protected C0219f f29140d;

    /* renamed from: e  reason: collision with root package name */
    protected C0219f f29141e;

    /* renamed from: f  reason: collision with root package name */
    private Object f29142f;

    protected C0219f(C0219f fVar, Spliterator spliterator) {
        super(fVar);
        this.f29138b = spliterator;
        this.f29137a = fVar.f29137a;
        this.f29139c = fVar.f29139c;
    }

    protected C0219f(C0314y0 y0Var, Spliterator spliterator) {
        super((CountedCompleter) null);
        this.f29137a = y0Var;
        this.f29138b = spliterator;
        this.f29139c = 0;
    }

    public static int b() {
        return f29136g;
    }

    public static long g(long j11) {
        long j12 = j11 / ((long) f29136g);
        if (j12 > 0) {
            return j12;
        }
        return 1;
    }

    /* access modifiers changed from: protected */
    public abstract Object a();

    /* access modifiers changed from: protected */
    public Object c() {
        return this.f29142f;
    }

    public void compute() {
        Spliterator trySplit;
        Spliterator spliterator = this.f29138b;
        long estimateSize = spliterator.estimateSize();
        long j11 = this.f29139c;
        if (j11 == 0) {
            j11 = g(estimateSize);
            this.f29139c = j11;
        }
        boolean z11 = false;
        C0219f fVar = this;
        while (estimateSize > j11 && (trySplit = spliterator.trySplit()) != null) {
            C0219f e11 = fVar.e(trySplit);
            fVar.f29140d = e11;
            C0219f e12 = fVar.e(spliterator);
            fVar.f29141e = e12;
            fVar.setPendingCount(1);
            if (z11) {
                spliterator = trySplit;
                fVar = e11;
                e11 = e12;
            } else {
                fVar = e12;
            }
            z11 = !z11;
            e11.fork();
            estimateSize = spliterator.estimateSize();
        }
        fVar.f(fVar.a());
        fVar.tryComplete();
    }

    /* access modifiers changed from: protected */
    public final C0219f d() {
        return (C0219f) getCompleter();
    }

    /* access modifiers changed from: protected */
    public abstract C0219f e(Spliterator spliterator);

    /* access modifiers changed from: protected */
    public void f(Object obj) {
        this.f29142f = obj;
    }

    public Object getRawResult() {
        return this.f29142f;
    }

    public void onCompletion(CountedCompleter countedCompleter) {
        this.f29138b = null;
        this.f29141e = null;
        this.f29140d = null;
    }

    /* access modifiers changed from: protected */
    public final void setRawResult(Object obj) {
        if (obj != null) {
            throw new IllegalStateException();
        }
    }
}
