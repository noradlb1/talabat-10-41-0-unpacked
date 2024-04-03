package j$.util.stream;

import j$.util.function.Predicate;

/* renamed from: j$.util.stream.q0  reason: case insensitive filesystem */
final class C0275q0 extends C0294u0 {

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ C0299v0 f29200c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ Predicate f29201d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0275q0(Predicate predicate, C0299v0 v0Var) {
        super(v0Var);
        this.f29200c = v0Var;
        this.f29201d = predicate;
    }

    public final void accept(Object obj) {
        if (!this.f29240a) {
            boolean test = this.f29201d.test(obj);
            C0299v0 v0Var = this.f29200c;
            if (test == v0Var.f29250a) {
                this.f29240a = true;
                this.f29241b = v0Var.f29251b;
            }
        }
    }
}
