package org.junit.internal.runners.statements;

import org.junit.runners.model.Statement;

public class Fail extends Statement {
    private final Throwable error;

    public Fail(Throwable th2) {
        this.error = th2;
    }

    public void evaluate() throws Throwable {
        throw this.error;
    }
}
