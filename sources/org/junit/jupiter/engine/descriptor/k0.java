package org.junit.jupiter.engine.descriptor;

import org.junit.jupiter.api.extension.Extension;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestInstancePreDestroyCallback;
import org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor;

public final /* synthetic */ class k0 implements TestMethodTestDescriptor.CallbackInvoker {
    public final void invoke(Extension extension, ExtensionContext extensionContext) {
        ((TestInstancePreDestroyCallback) extension).preDestroyTestInstance(extensionContext);
    }
}
