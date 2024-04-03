package org.junit.jupiter.engine.descriptor;

import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.Extension;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor;

public final /* synthetic */ class i0 implements TestMethodTestDescriptor.CallbackInvoker {
    public final void invoke(Extension extension, ExtensionContext extensionContext) {
        ((BeforeEachCallback) extension).beforeEach(extensionContext);
    }
}
