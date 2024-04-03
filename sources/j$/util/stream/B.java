package j$.util.stream;

final class B extends E {

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ int f28896t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ B(C0204c cVar, int i11, int i12) {
        super(cVar, i11);
        this.f28896t = i12;
    }

    /* access modifiers changed from: package-private */
    public final C0272p2 v1(int i11, C0272p2 p2Var) {
        switch (this.f28896t) {
            case 0:
                return p2Var;
            case 1:
                return new Z(this, p2Var, 3);
            default:
                return new C0235i0(this, p2Var, 1);
        }
    }
}
