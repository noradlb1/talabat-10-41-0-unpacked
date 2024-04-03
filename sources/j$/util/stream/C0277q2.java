package j$.util.stream;

/* renamed from: j$.util.stream.q2  reason: case insensitive filesystem */
final class C0277q2 extends C0252l2 {

    /* renamed from: b  reason: collision with root package name */
    long f29203b;

    /* renamed from: c  reason: collision with root package name */
    long f29204c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ C0281r2 f29205d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0277q2(C0281r2 r2Var, C0272p2 p2Var) {
        super(p2Var);
        this.f29205d = r2Var;
        this.f29203b = r2Var.f29212t;
        long j11 = r2Var.f29213u;
        this.f29204c = j11 < 0 ? Long.MAX_VALUE : j11;
    }

    public final void accept(Object obj) {
        long j11 = this.f29203b;
        if (j11 == 0) {
            long j12 = this.f29204c;
            if (j12 > 0) {
                this.f29204c = j12 - 1;
                this.f29177a.accept(obj);
                return;
            }
            return;
        }
        this.f29203b = j11 - 1;
    }

    public final void f(long j11) {
        this.f29177a.f(C0314y0.A0(j11, this.f29205d.f29212t, this.f29204c));
    }

    public final boolean h() {
        return this.f29204c == 0 || this.f29177a.h();
    }
}
