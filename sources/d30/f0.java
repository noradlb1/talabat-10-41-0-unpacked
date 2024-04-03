package d30;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.platform.engine.support.hierarchical.ThrowableCollector;

public final /* synthetic */ class f0 implements ThrowableCollector.Executable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AfterAllCallback f61853a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ExtensionContext f61854b;

    public /* synthetic */ f0(AfterAllCallback afterAllCallback, ExtensionContext extensionContext) {
        this.f61853a = afterAllCallback;
        this.f61854b = extensionContext;
    }

    public final void execute() {
        this.f61853a.afterAll(this.f61854b);
    }
}
