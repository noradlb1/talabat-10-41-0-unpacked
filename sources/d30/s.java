package d30;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestInstances;
import org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor;
import org.junit.jupiter.engine.extension.ExtensionRegistrar;
import org.junit.jupiter.engine.extension.ExtensionRegistry;
import org.junit.platform.engine.support.hierarchical.ThrowableCollector;

public final /* synthetic */ class s implements ThrowableCollector.Executable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ClassBasedTestDescriptor f61910a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TestInstances f61911b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ExtensionRegistry f61912c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ExtensionContext f61913d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ExtensionRegistrar f61914e;

    public /* synthetic */ s(ClassBasedTestDescriptor classBasedTestDescriptor, TestInstances testInstances, ExtensionRegistry extensionRegistry, ExtensionContext extensionContext, ExtensionRegistrar extensionRegistrar) {
        this.f61910a = classBasedTestDescriptor;
        this.f61911b = testInstances;
        this.f61912c = extensionRegistry;
        this.f61913d = extensionContext;
        this.f61914e = extensionRegistrar;
    }

    public final void execute() {
        this.f61910a.lambda$instantiateAndPostProcessTestInstance$6(this.f61911b, this.f61912c, this.f61913d, this.f61914e);
    }
}
