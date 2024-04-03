package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.H;
import j$.util.function.K;
import java.util.Objects;

/* renamed from: j$.util.stream.q1  reason: case insensitive filesystem */
final class C0276q1 extends C0290t1 implements C0262n2 {

    /* renamed from: h  reason: collision with root package name */
    private final int[] f29202h;

    C0276q1(Spliterator spliterator, C0314y0 y0Var, int[] iArr) {
        super(iArr.length, spliterator, y0Var);
        this.f29202h = iArr;
    }

    C0276q1(C0276q1 q1Var, Spliterator spliterator, long j11, long j12) {
        super(q1Var, spliterator, j11, j12, q1Var.f29202h.length);
        this.f29202h = q1Var.f29202h;
    }

    /* access modifiers changed from: package-private */
    public final C0290t1 a(Spliterator spliterator, long j11, long j12) {
        return new C0276q1(this, spliterator, j11, j12);
    }

    public final void accept(int i11) {
        int i12 = this.f29235f;
        if (i12 < this.f29236g) {
            int[] iArr = this.f29202h;
            this.f29235f = i12 + 1;
            iArr[i12] = i11;
            return;
        }
        throw new IndexOutOfBoundsException(Integer.toString(this.f29235f));
    }

    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        g((Integer) obj);
    }

    public final /* synthetic */ void g(Integer num) {
        C0314y0.g0(this, num);
    }

    public final K n(K k11) {
        Objects.requireNonNull(k11);
        return new H(this, k11);
    }
}
