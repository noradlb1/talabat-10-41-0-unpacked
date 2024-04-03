package d30;

import j$.util.function.Consumer;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestInstancePreDestroyCallback;
import org.junit.platform.engine.support.hierarchical.ThrowableCollector;

public final /* synthetic */ class j implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ThrowableCollector f61873b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ExtensionContext f61874c;

    public /* synthetic */ j(ThrowableCollector throwableCollector, ExtensionContext extensionContext) {
        this.f61873b = throwableCollector;
        this.f61874c = extensionContext;
    }

    public final void accept(Object obj) {
        this.f61873b.execute(new u((TestInstancePreDestroyCallback) obj, this.f61874c));
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }
}
