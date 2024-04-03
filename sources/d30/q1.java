package d30;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor;
import org.junit.jupiter.engine.execution.JupiterEngineExecutionContext;
import org.junit.platform.engine.support.hierarchical.ThrowableCollector;

public final /* synthetic */ class q1 implements ThrowableCollector.Executable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TestMethodTestDescriptor f61904a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ExtensionContext f61905b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ JupiterEngineExecutionContext f61906c;

    public /* synthetic */ q1(TestMethodTestDescriptor testMethodTestDescriptor, ExtensionContext extensionContext, JupiterEngineExecutionContext jupiterEngineExecutionContext) {
        this.f61904a = testMethodTestDescriptor;
        this.f61905b = extensionContext;
        this.f61906c = jupiterEngineExecutionContext;
    }

    public final void execute() {
        this.f61904a.lambda$invokeTestMethod$7(this.f61905b, this.f61906c);
    }
}
