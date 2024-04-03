package org.junit.jupiter.engine.descriptor;

import org.junit.jupiter.api.extension.Extension;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor;
import org.junit.jupiter.engine.execution.BeforeEachMethodAdapter;
import org.junit.jupiter.engine.extension.ExtensionRegistry;

public final /* synthetic */ class p0 implements TestMethodTestDescriptor.CallbackInvoker {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TestMethodTestDescriptor f62470a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ExtensionRegistry f62471b;

    public /* synthetic */ p0(TestMethodTestDescriptor testMethodTestDescriptor, ExtensionRegistry extensionRegistry) {
        this.f62470a = testMethodTestDescriptor;
        this.f62471b = extensionRegistry;
    }

    public final void invoke(Extension extension, ExtensionContext extensionContext) {
        this.f62470a.lambda$invokeBeforeEachMethods$3(this.f62471b, (BeforeEachMethodAdapter) extension, extensionContext);
    }
}
