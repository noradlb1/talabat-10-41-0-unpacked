package d30;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.engine.descriptor.TestFactoryTestDescriptor;
import org.junit.jupiter.engine.execution.JupiterEngineExecutionContext;
import org.junit.platform.engine.support.hierarchical.Node;
import org.junit.platform.engine.support.hierarchical.ThrowableCollector;

public final /* synthetic */ class j1 implements ThrowableCollector.Executable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TestFactoryTestDescriptor f61875a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ExtensionContext f61876b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ JupiterEngineExecutionContext f61877c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Node.DynamicTestExecutor f61878d;

    public /* synthetic */ j1(TestFactoryTestDescriptor testFactoryTestDescriptor, ExtensionContext extensionContext, JupiterEngineExecutionContext jupiterEngineExecutionContext, Node.DynamicTestExecutor dynamicTestExecutor) {
        this.f61875a = testFactoryTestDescriptor;
        this.f61876b = extensionContext;
        this.f61877c = jupiterEngineExecutionContext;
        this.f61878d = dynamicTestExecutor;
    }

    public final void execute() {
        this.f61875a.lambda$invokeTestMethod$1(this.f61876b, this.f61877c, this.f61878d);
    }
}
