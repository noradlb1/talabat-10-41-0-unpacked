package d30;

import j$.util.function.Consumer;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestInstancePostProcessor;
import org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor;

public final /* synthetic */ class r implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ClassBasedTestDescriptor f61907b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f61908c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ExtensionContext f61909d;

    public /* synthetic */ r(ClassBasedTestDescriptor classBasedTestDescriptor, Object obj, ExtensionContext extensionContext) {
        this.f61907b = classBasedTestDescriptor;
        this.f61908c = obj;
        this.f61909d = extensionContext;
    }

    public final void accept(Object obj) {
        this.f61907b.lambda$invokeTestInstancePostProcessors$11(this.f61908c, this.f61909d, (TestInstancePostProcessor) obj);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }
}
