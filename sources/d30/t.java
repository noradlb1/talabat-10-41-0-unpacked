package d30;

import j$.util.function.Consumer;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestInstanceFactoryContext;
import org.junit.jupiter.api.extension.TestInstancePreConstructCallback;
import org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor;

public final /* synthetic */ class t implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ClassBasedTestDescriptor f61915b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TestInstanceFactoryContext f61916c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ExtensionContext f61917d;

    public /* synthetic */ t(ClassBasedTestDescriptor classBasedTestDescriptor, TestInstanceFactoryContext testInstanceFactoryContext, ExtensionContext extensionContext) {
        this.f61915b = classBasedTestDescriptor;
        this.f61916c = testInstanceFactoryContext;
        this.f61917d = extensionContext;
    }

    public final void accept(Object obj) {
        this.f61915b.lambda$invokeTestInstancePreConstructCallbacks$9(this.f61916c, this.f61917d, (TestInstancePreConstructCallback) obj);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }
}
