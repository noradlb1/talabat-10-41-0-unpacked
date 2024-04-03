package d30;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestInstancePreDestroyCallback;
import org.junit.platform.engine.support.hierarchical.ThrowableCollector;

public final /* synthetic */ class u implements ThrowableCollector.Executable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TestInstancePreDestroyCallback f61922a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ExtensionContext f61923b;

    public /* synthetic */ u(TestInstancePreDestroyCallback testInstancePreDestroyCallback, ExtensionContext extensionContext) {
        this.f61922a = testInstancePreDestroyCallback;
        this.f61923b = extensionContext;
    }

    public final void execute() {
        this.f61922a.preDestroyTestInstance(this.f61923b);
    }
}
