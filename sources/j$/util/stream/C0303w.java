package j$.util.stream;

/* renamed from: j$.util.stream.w  reason: case insensitive filesystem */
final class C0303w extends C0227g2 {

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ int f29254t;

    /* renamed from: u  reason: collision with root package name */
    final /* synthetic */ Object f29255u;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0303w(C0204c cVar, int i11, Object obj, int i12) {
        super(cVar, i11);
        this.f29254t = i12;
        this.f29255u = obj;
    }

    /* access modifiers changed from: package-private */
    public final C0272p2 v1(int i11, C0272p2 p2Var) {
        switch (this.f29254t) {
            case 0:
                return new C0298v(this, p2Var, 0);
            case 1:
                return new Z(this, p2Var, 0);
            case 2:
                return new C0235i0(this, p2Var, 0);
            case 3:
                return new C0197a2(this, p2Var, 0);
            default:
                return new C0197a2(this, p2Var, 1);
        }
    }
}
