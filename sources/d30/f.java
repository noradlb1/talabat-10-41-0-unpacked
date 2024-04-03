package d30;

import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor;
import org.junit.jupiter.engine.execution.AfterEachMethodAdapter;
import org.junit.jupiter.engine.extension.ExtensionRegistry;

public final /* synthetic */ class f implements AfterEachMethodAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ClassBasedTestDescriptor f61851a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Method f61852b;

    public /* synthetic */ f(ClassBasedTestDescriptor classBasedTestDescriptor, Method method) {
        this.f61851a = classBasedTestDescriptor;
        this.f61852b = method;
    }

    public final void invokeAfterEachMethod(ExtensionContext extensionContext, ExtensionRegistry extensionRegistry) {
        this.f61851a.lambda$synthesizeAfterEachMethodAdapter$24(this.f61852b, extensionContext, extensionRegistry);
    }
}
