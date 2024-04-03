package f30;

import j$.util.function.Supplier;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.engine.execution.JupiterEngineExecutionContext;

public final /* synthetic */ class m implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExtensionContext f62049a;

    public /* synthetic */ m(ExtensionContext extensionContext) {
        this.f62049a = extensionContext;
    }

    public final Object get() {
        return JupiterEngineExecutionContext.lambda$close$0(this.f62049a);
    }
}
