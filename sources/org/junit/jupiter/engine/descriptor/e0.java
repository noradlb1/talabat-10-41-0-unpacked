package org.junit.jupiter.engine.descriptor;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.Extension;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor;

public final /* synthetic */ class e0 implements TestMethodTestDescriptor.CallbackInvoker {
    public final void invoke(Extension extension, ExtensionContext extensionContext) {
        ((AfterEachCallback) extension).afterEach(extensionContext);
    }
}
