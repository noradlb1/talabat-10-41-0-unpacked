package j$.util.stream;

/* renamed from: j$.util.stream.s2  reason: case insensitive filesystem */
final class C0286s2 extends C0242j2 {

    /* renamed from: b  reason: collision with root package name */
    long f29221b;

    /* renamed from: c  reason: collision with root package name */
    long f29222c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ C0291t2 f29223d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0286s2(C0291t2 t2Var, C0272p2 p2Var) {
        super(p2Var);
        this.f29223d = t2Var;
        this.f29221b = t2Var.f29237t;
        long j11 = t2Var.f29238u;
        this.f29222c = j11 < 0 ? Long.MAX_VALUE : j11;
    }

    public final void accept(int i11) {
        long j11 = this.f29221b;
        if (j11 == 0) {
            long j12 = this.f29222c;
            if (j12 > 0) {
                this.f29222c = j12 - 1;
                this.f29166a.accept(i11);
                return;
            }
            return;
        }
        this.f29221b = j11 - 1;
    }

    public final void f(long j11) {
        this.f29166a.f(C0314y0.A0(j11, this.f29223d.f29237t, this.f29222c));
    }

    public final boolean h() {
        return this.f29222c == 0 || this.f29166a.h();
    }
}
