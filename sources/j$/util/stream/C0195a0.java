package j$.util.stream;

/* renamed from: j$.util.stream.a0  reason: case insensitive filesystem */
final class C0195a0 extends C0255m0 {

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ int f29079t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0195a0(C0204c cVar, int i11, int i12) {
        super(cVar, i11);
        this.f29079t = i12;
    }

    /* access modifiers changed from: package-private */
    public final C0272p2 v1(int i11, C0272p2 p2Var) {
        switch (this.f29079t) {
            case 0:
                return new Z(this, p2Var, 2);
            default:
                return p2Var;
        }
    }
}
