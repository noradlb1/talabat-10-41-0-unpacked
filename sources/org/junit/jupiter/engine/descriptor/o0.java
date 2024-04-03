package org.junit.jupiter.engine.descriptor;

import org.junit.jupiter.api.extension.Extension;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.LifecycleMethodExecutionExceptionHandler;
import org.junit.jupiter.engine.descriptor.JupiterTestDescriptor;

public final /* synthetic */ class o0 implements JupiterTestDescriptor.ExceptionHandlerInvoker {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExtensionContext f62467a;

    public /* synthetic */ o0(ExtensionContext extensionContext) {
        this.f62467a = extensionContext;
    }

    public final void invoke(Extension extension, Throwable th2) {
        ((LifecycleMethodExecutionExceptionHandler) extension).handleBeforeEachMethodExecutionException(this.f62467a, th2);
    }
}
