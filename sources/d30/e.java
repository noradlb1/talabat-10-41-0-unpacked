package d30;

import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor;
import org.junit.jupiter.engine.extension.ExtensionRegistry;
import org.junit.platform.engine.support.hierarchical.ThrowableCollector;

public final /* synthetic */ class e implements ThrowableCollector.Executable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ClassBasedTestDescriptor f61841a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Method f61842b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f61843c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ExtensionContext f61844d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ExtensionRegistry f61845e;

    public /* synthetic */ e(ClassBasedTestDescriptor classBasedTestDescriptor, Method method, Object obj, ExtensionContext extensionContext, ExtensionRegistry extensionRegistry) {
        this.f61841a = classBasedTestDescriptor;
        this.f61842b = method;
        this.f61843c = obj;
        this.f61844d = extensionContext;
        this.f61845e = extensionRegistry;
    }

    public final void execute() {
        this.f61841a.lambda$invokeAfterAllMethods$15(this.f61842b, this.f61843c, this.f61844d, this.f61845e);
    }
}
