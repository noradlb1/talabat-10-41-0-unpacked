package org.junit.jupiter.engine.descriptor;

import org.junit.jupiter.api.extension.Extension;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.LifecycleMethodExecutionExceptionHandler;
import org.junit.jupiter.engine.descriptor.JupiterTestDescriptor;

public final /* synthetic */ class e implements JupiterTestDescriptor.ExceptionHandlerInvoker {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExtensionContext f62436a;

    public /* synthetic */ e(ExtensionContext extensionContext) {
        this.f62436a = extensionContext;
    }

    public final void invoke(Extension extension, Throwable th2) {
        ((LifecycleMethodExecutionExceptionHandler) extension).handleAfterAllMethodExecutionException(this.f62436a, th2);
    }
}
