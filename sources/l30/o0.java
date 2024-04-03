package l30;

import j$.util.function.Consumer;
import org.junit.platform.commons.util.Preconditions;

public final /* synthetic */ class o0 implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f26493b;

    public /* synthetic */ o0(String str) {
        this.f26493b = str;
    }

    public final void accept(Object obj) {
        Preconditions.notNull(obj, this.f26493b);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }
}
