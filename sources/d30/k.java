package d30;

import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor;
import org.junit.jupiter.engine.extension.ExtensionRegistry;
import org.junit.platform.engine.support.hierarchical.ThrowableCollector;

public final /* synthetic */ class k implements ThrowableCollector.Executable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ClassBasedTestDescriptor f61879a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Method f61880b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f61881c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ExtensionContext f61882d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ExtensionRegistry f61883e;

    public /* synthetic */ k(ClassBasedTestDescriptor classBasedTestDescriptor, Method method, Object obj, ExtensionContext extensionContext, ExtensionRegistry extensionRegistry) {
        this.f61879a = classBasedTestDescriptor;
        this.f61880b = method;
        this.f61881c = obj;
        this.f61882d = extensionContext;
        this.f61883e = extensionRegistry;
    }

    public final void execute() {
        this.f61879a.lambda$invokeBeforeAllMethods$13(this.f61880b, this.f61881c, this.f61882d, this.f61883e);
    }
}
