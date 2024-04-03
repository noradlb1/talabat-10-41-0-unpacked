package f30;

import j$.util.function.Consumer;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.engine.execution.ExtensionValuesStore;
import org.junit.platform.engine.support.hierarchical.ThrowableCollector;

public final /* synthetic */ class e implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ThrowableCollector f62042b;

    public /* synthetic */ e(ThrowableCollector throwableCollector) {
        this.f62042b = throwableCollector;
    }

    public final void accept(Object obj) {
        ExtensionValuesStore.lambda$closeAllStoredCloseableValues$3(this.f62042b, (ExtensionContext.Store.CloseableResource) obj);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }
}
