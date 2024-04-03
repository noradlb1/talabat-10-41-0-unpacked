package org.junit.jupiter.engine.descriptor;

import org.junit.jupiter.api.extension.DynamicTestInvocationContext;
import org.junit.jupiter.api.function.Executable;

class DefaultDynamicTestInvocationContext implements DynamicTestInvocationContext {
    private final Executable executable;

    public DefaultDynamicTestInvocationContext(Executable executable2) {
        this.executable = executable2;
    }

    public Executable getExecutable() {
        return this.executable;
    }
}
