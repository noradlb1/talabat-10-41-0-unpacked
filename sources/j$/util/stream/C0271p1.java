package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.C0159j;
import j$.util.function.C0165m;
import java.util.Objects;

/* renamed from: j$.util.stream.p1  reason: case insensitive filesystem */
final class C0271p1 extends C0290t1 implements C0257m2 {

    /* renamed from: h  reason: collision with root package name */
    private final double[] f29195h;

    C0271p1(Spliterator spliterator, C0314y0 y0Var, double[] dArr) {
        super(dArr.length, spliterator, y0Var);
        this.f29195h = dArr;
    }

    C0271p1(C0271p1 p1Var, Spliterator spliterator, long j11, long j12) {
        super(p1Var, spliterator, j11, j12, p1Var.f29195h.length);
        this.f29195h = p1Var.f29195h;
    }

    /* access modifiers changed from: package-private */
    public final C0290t1 a(Spliterator spliterator, long j11, long j12) {
        return new C0271p1(this, spliterator, j11, j12);
    }

    public final void accept(double d11) {
        int i11 = this.f29235f;
        if (i11 < this.f29236g) {
            double[] dArr = this.f29195h;
            this.f29235f = i11 + 1;
            dArr[i11] = d11;
            return;
        }
        throw new IndexOutOfBoundsException(Integer.toString(this.f29235f));
    }

    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        p((Double) obj);
    }

    public final C0165m m(C0165m mVar) {
        Objects.requireNonNull(mVar);
        return new C0159j(this, mVar);
    }

    public final /* synthetic */ void p(Double d11) {
        C0314y0.e0(this, d11);
    }
}
