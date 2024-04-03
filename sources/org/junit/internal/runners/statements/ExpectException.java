package org.junit.internal.runners.statements;

import org.junit.internal.AssumptionViolatedException;
import org.junit.runners.model.Statement;

public class ExpectException extends Statement {
    private final Class<? extends Throwable> expected;
    private final Statement next;

    public ExpectException(Statement statement, Class<? extends Throwable> cls) {
        this.next = statement;
        this.expected = cls;
    }

    public void evaluate() throws Exception {
        boolean z11;
        try {
            this.next.evaluate();
            z11 = true;
        } catch (AssumptionViolatedException e11) {
            throw e11;
        } catch (Throwable th2) {
            if (this.expected.isAssignableFrom(th2.getClass())) {
                z11 = false;
            } else {
                throw new Exception("Unexpected exception, expected<" + this.expected.getName() + "> but was<" + th2.getClass().getName() + ">", th2);
            }
        }
        if (z11) {
            throw new AssertionError("Expected exception: " + this.expected.getName());
        }
    }
}
