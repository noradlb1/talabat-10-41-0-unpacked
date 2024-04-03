package j$.util.stream;

/* renamed from: j$.util.stream.w1  reason: case insensitive filesystem */
class C0305w1 extends C0310x1 {

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f29258c;

    /* renamed from: d  reason: collision with root package name */
    private final Object f29259d;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0305w1(G0 g02, Object obj) {
        this((H0) g02, obj, 0);
        this.f29258c = 0;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0305w1(H0 h02, Object obj, int i11) {
        super(h02);
        this.f29258c = i11;
        this.f29259d = obj;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0305w1(H0 h02, Object[] objArr) {
        this(h02, (Object) objArr, 1);
        this.f29258c = 1;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0305w1(C0305w1 w1Var, G0 g02, int i11) {
        super(w1Var, g02, i11);
        this.f29258c = 0;
        this.f29259d = w1Var.f29259d;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0305w1(C0305w1 w1Var, H0 h02, int i11) {
        super(w1Var, h02, i11);
        this.f29258c = 1;
        this.f29259d = (Object[]) w1Var.f29259d;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        switch (this.f29258c) {
            case 0:
                ((G0) this.f29268a).c(this.f29269b, this.f29259d);
                return;
            default:
                this.f29268a.e((Object[]) this.f29259d, this.f29269b);
                return;
        }
    }

    /* access modifiers changed from: package-private */
    public final C0305w1 b(int i11, int i12) {
        switch (this.f29258c) {
            case 0:
                return new C0305w1(this, ((G0) this.f29268a).a(i11), i12);
            default:
                return new C0305w1(this, this.f29268a.a(i11), i12);
        }
    }
}
