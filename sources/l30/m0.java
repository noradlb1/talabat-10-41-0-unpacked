package l30;

import j$.util.function.Consumer;
import j$.util.function.Supplier;
import org.junit.platform.commons.util.Preconditions;

public final /* synthetic */ class m0 implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Supplier f26489b;

    public /* synthetic */ m0(Supplier supplier) {
        this.f26489b = supplier;
    }

    public final void accept(Object obj) {
        Preconditions.notNull(obj, (Supplier<String>) this.f26489b);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }
}
