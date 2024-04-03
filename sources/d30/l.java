package d30;

import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor;
import org.junit.jupiter.engine.execution.BeforeEachMethodAdapter;
import org.junit.jupiter.engine.extension.ExtensionRegistry;

public final /* synthetic */ class l implements BeforeEachMethodAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ClassBasedTestDescriptor f61885a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Method f61886b;

    public /* synthetic */ l(ClassBasedTestDescriptor classBasedTestDescriptor, Method method) {
        this.f61885a = classBasedTestDescriptor;
        this.f61886b = method;
    }

    public final void invokeBeforeEachMethod(ExtensionContext extensionContext, ExtensionRegistry extensionRegistry) {
        this.f61885a.lambda$synthesizeBeforeEachMethodAdapter$23(this.f61886b, extensionContext, extensionRegistry);
    }
}
