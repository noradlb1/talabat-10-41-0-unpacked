package d30;

import org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor;
import org.junit.jupiter.engine.execution.JupiterEngineExecutionContext;
import org.junit.platform.engine.support.hierarchical.ThrowableCollector;

public final /* synthetic */ class p1 implements ThrowableCollector.Executable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TestMethodTestDescriptor f61898a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ JupiterEngineExecutionContext f61899b;

    public /* synthetic */ p1(TestMethodTestDescriptor testMethodTestDescriptor, JupiterEngineExecutionContext jupiterEngineExecutionContext) {
        this.f61898a = testMethodTestDescriptor;
        this.f61899b = jupiterEngineExecutionContext;
    }

    public final void execute() {
        this.f61898a.lambda$cleanUp$1(this.f61899b);
    }
}
