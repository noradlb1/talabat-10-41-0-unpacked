package org.junit.rules;

import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public abstract class ExternalResource implements TestRule {
    private Statement statement(final Statement statement) {
        return new Statement() {
            public void evaluate() throws Throwable {
                ExternalResource.this.b();
                try {
                    statement.evaluate();
                } finally {
                    ExternalResource.this.a();
                }
            }
        };
    }

    public void a() {
    }

    public Statement apply(Statement statement, Description description) {
        return statement(statement);
    }

    public void b() throws Throwable {
    }
}
