package d30;

import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.platform.engine.support.hierarchical.ThrowableCollector;

public final /* synthetic */ class y implements ThrowableCollector.Executable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BeforeAllCallback f61928a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ExtensionContext f61929b;

    public /* synthetic */ y(BeforeAllCallback beforeAllCallback, ExtensionContext extensionContext) {
        this.f61928a = beforeAllCallback;
        this.f61929b = extensionContext;
    }

    public final void execute() {
        this.f61928a.beforeAll(this.f61929b);
    }
}
