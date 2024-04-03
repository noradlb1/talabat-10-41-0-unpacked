package d30;

import j$.util.function.Consumer;
import org.junit.jupiter.api.extension.TestWatcher;
import org.junit.jupiter.engine.descriptor.MethodBasedTestDescriptor;
import org.junit.jupiter.engine.execution.JupiterEngineExecutionContext;

public final /* synthetic */ class d1 implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MethodBasedTestDescriptor f61838b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Consumer f61839c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ JupiterEngineExecutionContext f61840d;

    public /* synthetic */ d1(MethodBasedTestDescriptor methodBasedTestDescriptor, Consumer consumer, JupiterEngineExecutionContext jupiterEngineExecutionContext) {
        this.f61838b = methodBasedTestDescriptor;
        this.f61839c = consumer;
        this.f61840d = jupiterEngineExecutionContext;
    }

    public final void accept(Object obj) {
        this.f61838b.lambda$invokeTestWatchers$3(this.f61839c, this.f61840d, (TestWatcher) obj);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }
}
