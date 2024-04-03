package j$.util.stream;

import j$.util.function.A0;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.BinaryOperator;
import j$.util.function.D0;
import j$.util.function.Supplier;
import j$.util.function.x0;

final class C1 extends C0314y0 {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f28901h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ Object f28902i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ Object f28903j;

    /* renamed from: k  reason: collision with root package name */
    final /* synthetic */ Object f28904k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C1(C0218e3 e3Var, Object obj, Object obj2, Object obj3, int i11) {
        super(e3Var);
        this.f28901h = i11;
        this.f28902i = obj;
        this.f28904k = obj2;
        this.f28903j = obj3;
    }

    public final S1 f1() {
        int i11 = this.f28901h;
        Object obj = this.f28902i;
        Object obj2 = this.f28904k;
        Object obj3 = this.f28903j;
        switch (i11) {
            case 0:
                return new C0319z1((Supplier) obj3, (D0) obj2, (BinaryOperator) obj);
            case 1:
                return new F1((Supplier) obj3, (x0) obj2, (BinaryOperator) obj);
            case 2:
                return new H1(obj3, (BiFunction) obj2, (BinaryOperator) obj);
            case 3:
                return new L1((Supplier) obj3, (BiConsumer) obj2, (BiConsumer) obj);
            default:
                return new P1((Supplier) obj3, (A0) obj2, (BinaryOperator) obj);
        }
    }
}
