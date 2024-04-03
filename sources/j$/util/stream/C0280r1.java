package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.C0146c0;
import j$.util.function.C0152f0;
import java.util.Objects;

/* renamed from: j$.util.stream.r1  reason: case insensitive filesystem */
final class C0280r1 extends C0290t1 implements C0267o2 {

    /* renamed from: h  reason: collision with root package name */
    private final long[] f29211h;

    C0280r1(Spliterator spliterator, C0314y0 y0Var, long[] jArr) {
        super(jArr.length, spliterator, y0Var);
        this.f29211h = jArr;
    }

    C0280r1(C0280r1 r1Var, Spliterator spliterator, long j11, long j12) {
        super(r1Var, spliterator, j11, j12, r1Var.f29211h.length);
        this.f29211h = r1Var.f29211h;
    }

    /* access modifiers changed from: package-private */
    public final C0290t1 a(Spliterator spliterator, long j11, long j12) {
        return new C0280r1(this, spliterator, j11, j12);
    }

    public final void accept(long j11) {
        int i11 = this.f29235f;
        if (i11 < this.f29236g) {
            long[] jArr = this.f29211h;
            this.f29235f = i11 + 1;
            jArr[i11] = j11;
            return;
        }
        throw new IndexOutOfBoundsException(Integer.toString(this.f29235f));
    }

    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        l((Long) obj);
    }

    public final C0152f0 i(C0152f0 f0Var) {
        Objects.requireNonNull(f0Var);
        return new C0146c0(this, f0Var);
    }

    public final /* synthetic */ void l(Long l11) {
        C0314y0.i0(this, l11);
    }
}
