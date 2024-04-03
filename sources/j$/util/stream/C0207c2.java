package j$.util.stream;

import j$.util.function.Function;

/* renamed from: j$.util.stream.c2  reason: case insensitive filesystem */
final class C0207c2 extends C0227g2 {

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ int f29100t;

    /* renamed from: u  reason: collision with root package name */
    final /* synthetic */ Function f29101u;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0207c2(C0204c cVar, int i11, Function function, int i12) {
        super(cVar, i11);
        this.f29100t = i12;
        this.f29101u = function;
    }

    /* access modifiers changed from: package-private */
    public final C0272p2 v1(int i11, C0272p2 p2Var) {
        switch (this.f29100t) {
            case 0:
                return new C0197a2(this, p2Var, 2);
            default:
                return new C0212d2(this, p2Var);
        }
    }
}
