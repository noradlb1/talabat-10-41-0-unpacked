package j$.util.stream;

/* renamed from: j$.util.stream.w2  reason: case insensitive filesystem */
final class C0306w2 extends C0237i2 {

    /* renamed from: b  reason: collision with root package name */
    long f29260b;

    /* renamed from: c  reason: collision with root package name */
    long f29261c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ C0311x2 f29262d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0306w2(C0311x2 x2Var, C0272p2 p2Var) {
        super(p2Var);
        this.f29262d = x2Var;
        this.f29260b = x2Var.f29270t;
        long j11 = x2Var.f29271u;
        this.f29261c = j11 < 0 ? Long.MAX_VALUE : j11;
    }

    public final void accept(double d11) {
        long j11 = this.f29260b;
        if (j11 == 0) {
            long j12 = this.f29261c;
            if (j12 > 0) {
                this.f29261c = j12 - 1;
                this.f29160a.accept(d11);
                return;
            }
            return;
        }
        this.f29260b = j11 - 1;
    }

    public final void f(long j11) {
        this.f29160a.f(C0314y0.A0(j11, this.f29262d.f29270t, this.f29261c));
    }

    public final boolean h() {
        return this.f29261c == 0 || this.f29160a.h();
    }
}
