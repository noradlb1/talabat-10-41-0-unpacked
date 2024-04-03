package org.junit.jupiter.engine.descriptor;

import org.junit.jupiter.api.extension.Extension;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor;
import org.junit.jupiter.engine.execution.AfterEachMethodAdapter;
import org.junit.jupiter.engine.extension.ExtensionRegistry;

public final /* synthetic */ class d0 implements TestMethodTestDescriptor.CallbackInvoker {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TestMethodTestDescriptor f62434a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ExtensionRegistry f62435b;

    public /* synthetic */ d0(TestMethodTestDescriptor testMethodTestDescriptor, ExtensionRegistry extensionRegistry) {
        this.f62434a = testMethodTestDescriptor;
        this.f62435b = extensionRegistry;
    }

    public final void invoke(Extension extension, ExtensionContext extensionContext) {
        this.f62434a.lambda$invokeAfterEachMethods$10(this.f62435b, (AfterEachMethodAdapter) extension, extensionContext);
    }
}
