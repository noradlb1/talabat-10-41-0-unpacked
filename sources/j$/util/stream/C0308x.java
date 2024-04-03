package j$.util.stream;

/* renamed from: j$.util.stream.x  reason: case insensitive filesystem */
final class C0308x extends E {

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ int f29265t;

    /* renamed from: u  reason: collision with root package name */
    final /* synthetic */ Object f29266u;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0308x(C0204c cVar, int i11, Object obj, int i12) {
        super(cVar, i11);
        this.f29265t = i12;
        this.f29266u = obj;
    }

    /* access modifiers changed from: package-private */
    public final C0272p2 v1(int i11, C0272p2 p2Var) {
        switch (this.f29265t) {
            case 0:
                return new C0298v(this, p2Var, 1);
            case 1:
                return new A(this, p2Var);
            case 2:
                return new C0298v(this, p2Var, 4);
            case 3:
                return new C0298v(this, p2Var, 5);
            case 4:
                return new Z(this, p2Var, 6);
            case 5:
                return new C0235i0(this, p2Var, 4);
            case 6:
                return new C0197a2(this, p2Var, 5);
            default:
                return new C0274q(this, p2Var);
        }
    }
}
