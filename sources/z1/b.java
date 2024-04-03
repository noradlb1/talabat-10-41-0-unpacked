package z1;

import j$.util.function.Supplier;

public final /* synthetic */ class b extends ThreadLocal {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Supplier f44450a;

    public /* synthetic */ b(Supplier supplier) {
        this.f44450a = supplier;
    }

    public /* synthetic */ Object initialValue() {
        return this.f44450a.get();
    }
}
