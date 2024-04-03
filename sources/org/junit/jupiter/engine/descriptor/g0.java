package org.junit.jupiter.engine.descriptor;

import org.junit.jupiter.api.extension.Extension;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;
import org.junit.jupiter.engine.descriptor.JupiterTestDescriptor;

public final /* synthetic */ class g0 implements JupiterTestDescriptor.ExceptionHandlerInvoker {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExtensionContext f62440a;

    public /* synthetic */ g0(ExtensionContext extensionContext) {
        this.f62440a = extensionContext;
    }

    public final void invoke(Extension extension, Throwable th2) {
        ((TestExecutionExceptionHandler) extension).handleTestExecutionException(this.f62440a, th2);
    }
}
