package j$.util.stream;

import j$.util.Spliterator;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountedCompleter;

final class V extends CountedCompleter {

    /* renamed from: h  reason: collision with root package name */
    public static final /* synthetic */ int f29047h = 0;

    /* renamed from: a  reason: collision with root package name */
    private final C0314y0 f29048a;

    /* renamed from: b  reason: collision with root package name */
    private Spliterator f29049b;

    /* renamed from: c  reason: collision with root package name */
    private final long f29050c;

    /* renamed from: d  reason: collision with root package name */
    private final ConcurrentHashMap f29051d;

    /* renamed from: e  reason: collision with root package name */
    private final C0272p2 f29052e;

    /* renamed from: f  reason: collision with root package name */
    private final V f29053f;

    /* renamed from: g  reason: collision with root package name */
    private H0 f29054g;

    V(V v11, Spliterator spliterator, V v12) {
        super(v11);
        this.f29048a = v11.f29048a;
        this.f29049b = spliterator;
        this.f29050c = v11.f29050c;
        this.f29051d = v11.f29051d;
        this.f29052e = v11.f29052e;
        this.f29053f = v12;
    }

    protected V(C0314y0 y0Var, Spliterator spliterator, C0272p2 p2Var) {
        super((CountedCompleter) null);
        this.f29048a = y0Var;
        this.f29049b = spliterator;
        this.f29050c = C0219f.g(spliterator.estimateSize());
        this.f29051d = new ConcurrentHashMap(Math.max(16, C0219f.b() << 1));
        this.f29052e = p2Var;
        this.f29053f = null;
    }

    public final void compute() {
        Spliterator trySplit;
        Spliterator spliterator = this.f29049b;
        long j11 = this.f29050c;
        boolean z11 = false;
        V v11 = this;
        while (spliterator.estimateSize() > j11 && (trySplit = spliterator.trySplit()) != null) {
            V v12 = new V(v11, trySplit, v11.f29053f);
            V v13 = new V(v11, spliterator, v12);
            v11.addToPendingCount(1);
            v13.addToPendingCount(1);
            v11.f29051d.put(v12, v13);
            if (v11.f29053f != null) {
                v12.addToPendingCount(1);
                if (v11.f29051d.replace(v11.f29053f, v11, v12)) {
                    v11.addToPendingCount(-1);
                } else {
                    v12.addToPendingCount(-1);
                }
            }
            if (z11) {
                spliterator = trySplit;
                v11 = v12;
                v12 = v13;
            } else {
                v11 = v13;
            }
            z11 = !z11;
            v12.fork();
        }
        if (v11.getPendingCount() > 0) {
            C0199b bVar = new C0199b(16);
            C0314y0 y0Var = v11.f29048a;
            C0 c12 = y0Var.c1(y0Var.N0(spliterator), bVar);
            v11.f29048a.g1(spliterator, c12);
            v11.f29054g = c12.build();
            v11.f29049b = null;
        }
        v11.tryComplete();
    }

    public final void onCompletion(CountedCompleter countedCompleter) {
        H0 h02 = this.f29054g;
        if (h02 != null) {
            h02.forEach(this.f29052e);
            this.f29054g = null;
        } else {
            Spliterator spliterator = this.f29049b;
            if (spliterator != null) {
                this.f29048a.g1(spliterator, this.f29052e);
                this.f29049b = null;
            }
        }
        V v11 = (V) this.f29051d.remove(this);
        if (v11 != null) {
            v11.tryComplete();
        }
    }
}
