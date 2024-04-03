package f30;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.platform.engine.support.hierarchical.ThrowableCollector;

public final /* synthetic */ class d implements ThrowableCollector.Executable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExtensionContext.Store.CloseableResource f62041a;

    public /* synthetic */ d(ExtensionContext.Store.CloseableResource closeableResource) {
        this.f62041a = closeableResource;
    }

    public final void execute() {
        this.f62041a.close();
    }
}
