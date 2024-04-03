package j$.util.stream;

import j$.util.function.BinaryOperator;
import j$.util.function.C0144b0;
import j$.util.function.C0157i;
import j$.util.function.G;

final class A1 extends C0314y0 {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f28892h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ Object f28893i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ A1(C0218e3 e3Var, Object obj, int i11) {
        super(e3Var);
        this.f28892h = i11;
        this.f28893i = obj;
    }

    public final S1 f1() {
        int i11 = this.f28892h;
        Object obj = this.f28893i;
        switch (i11) {
            case 0:
                return new R1((C0144b0) obj);
            case 1:
                return new D1((C0157i) obj);
            case 2:
                return new I1((BinaryOperator) obj);
            default:
                return new O1((G) obj);
        }
    }
}
