package j$.util.stream;

import j$.util.function.BiConsumer;
import j$.util.function.BinaryOperator;
import j$.util.function.Supplier;

final class J1 extends C0314y0 {

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ BinaryOperator f28951h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ BiConsumer f28952i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ Supplier f28953j;

    /* renamed from: k  reason: collision with root package name */
    final /* synthetic */ Collector f28954k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    J1(C0218e3 e3Var, BinaryOperator binaryOperator, BiConsumer biConsumer, Supplier supplier, Collector collector) {
        super(e3Var);
        this.f28951h = binaryOperator;
        this.f28952i = biConsumer;
        this.f28953j = supplier;
        this.f28954k = collector;
    }

    public final int G() {
        if (this.f28954k.characteristics().contains(C0234i.UNORDERED)) {
            return C0213d3.f29121r;
        }
        return 0;
    }

    public final S1 f1() {
        return new K1(this.f28953j, this.f28952i, this.f28951h);
    }
}
