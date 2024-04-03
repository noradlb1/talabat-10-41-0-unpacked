package org.junit.jupiter.engine.descriptor;

import org.junit.jupiter.api.extension.Extension;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor;
import org.junit.platform.engine.support.hierarchical.ThrowableCollector;

public final /* synthetic */ class j0 implements ThrowableCollector.Executable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TestMethodTestDescriptor.CallbackInvoker f62449a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Extension f62450b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ExtensionContext f62451c;

    public /* synthetic */ j0(TestMethodTestDescriptor.CallbackInvoker callbackInvoker, Extension extension, ExtensionContext extensionContext) {
        this.f62449a = callbackInvoker;
        this.f62450b = extension;
        this.f62451c = extensionContext;
    }

    public final void execute() {
        this.f62449a.invoke(this.f62450b, this.f62451c);
    }
}
