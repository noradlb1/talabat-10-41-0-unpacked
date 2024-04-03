package l30;

import j$.util.function.Consumer;
import j$.util.function.Supplier;
import org.junit.platform.commons.util.Preconditions;

public final /* synthetic */ class n0 implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Supplier f26492b;

    public /* synthetic */ n0(Supplier supplier) {
        this.f26492b = supplier;
    }

    public final void accept(Object obj) {
        Preconditions.notNull(obj, (Supplier<String>) this.f26492b);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }
}
