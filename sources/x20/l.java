package x20;

import j$.util.function.Supplier;

public final /* synthetic */ class l implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f57970a;

    public /* synthetic */ l(String str) {
        this.f57970a = str;
    }

    public final Object get() {
        return String.format("Using custom seed for configuration parameter [%s] with value [%s].", new Object[]{"junit.jupiter.execution.order.random.seed", this.f57970a});
    }
}
