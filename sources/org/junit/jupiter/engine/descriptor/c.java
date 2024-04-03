package org.junit.jupiter.engine.descriptor;

import org.junit.jupiter.api.extension.Extension;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.LifecycleMethodExecutionExceptionHandler;
import org.junit.jupiter.engine.descriptor.JupiterTestDescriptor;

public final /* synthetic */ class c implements JupiterTestDescriptor.ExceptionHandlerInvoker {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExtensionContext f62427a;

    public /* synthetic */ c(ExtensionContext extensionContext) {
        this.f62427a = extensionContext;
    }

    public final void invoke(Extension extension, Throwable th2) {
        ((LifecycleMethodExecutionExceptionHandler) extension).handleBeforeAllMethodExecutionException(this.f62427a, th2);
    }
}
