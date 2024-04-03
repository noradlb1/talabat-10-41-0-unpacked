package org.junit.jupiter.engine.descriptor;

import org.junit.jupiter.api.extension.Extension;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.LifecycleMethodExecutionExceptionHandler;
import org.junit.jupiter.engine.descriptor.JupiterTestDescriptor;

public final /* synthetic */ class q0 implements JupiterTestDescriptor.ExceptionHandlerInvoker {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExtensionContext f62473a;

    public /* synthetic */ q0(ExtensionContext extensionContext) {
        this.f62473a = extensionContext;
    }

    public final void invoke(Extension extension, Throwable th2) {
        ((LifecycleMethodExecutionExceptionHandler) extension).handleAfterEachMethodExecutionException(this.f62473a, th2);
    }
}
