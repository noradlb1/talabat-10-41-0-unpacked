package org.junit.jupiter.engine.descriptor;

import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.Extension;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor;

public final /* synthetic */ class m0 implements TestMethodTestDescriptor.CallbackInvoker {
    public final void invoke(Extension extension, ExtensionContext extensionContext) {
        ((BeforeTestExecutionCallback) extension).beforeTestExecution(extensionContext);
    }
}
