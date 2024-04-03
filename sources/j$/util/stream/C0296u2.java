package j$.util.stream;

/* renamed from: j$.util.stream.u2  reason: case insensitive filesystem */
final class C0296u2 extends C0247k2 {

    /* renamed from: b  reason: collision with root package name */
    long f29242b;

    /* renamed from: c  reason: collision with root package name */
    long f29243c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ C0301v2 f29244d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0296u2(C0301v2 v2Var, C0272p2 p2Var) {
        super(p2Var);
        this.f29244d = v2Var;
        this.f29242b = v2Var.f29252t;
        long j11 = v2Var.f29253u;
        this.f29243c = j11 < 0 ? Long.MAX_VALUE : j11;
    }

    public final void accept(long j11) {
        long j12 = this.f29242b;
        if (j12 == 0) {
            long j13 = this.f29243c;
            if (j13 > 0) {
                this.f29243c = j13 - 1;
                this.f29169a.accept(j11);
                return;
            }
            return;
        }
        this.f29242b = j12 - 1;
    }

    public final void f(long j11) {
        this.f29169a.f(C0314y0.A0(j11, this.f29244d.f29252t, this.f29243c));
    }

    public final boolean h() {
        return this.f29243c == 0 || this.f29169a.h();
    }
}
