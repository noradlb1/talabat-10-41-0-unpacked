package org.junit.rules;

import java.util.ArrayList;
import java.util.List;
import org.junit.internal.AssumptionViolatedException;
import org.junit.runner.Description;
import org.junit.runners.model.MultipleFailureException;
import org.junit.runners.model.Statement;

public abstract class TestWatcher implements TestRule {
    /* access modifiers changed from: private */
    public void failedQuietly(Throwable th2, Description description, List<Throwable> list) {
        try {
            f(th2, description);
        } catch (Throwable th3) {
            list.add(th3);
        }
    }

    /* access modifiers changed from: private */
    public void finishedQuietly(Description description, List<Throwable> list) {
        try {
            g(description);
        } catch (Throwable th2) {
            list.add(th2);
        }
    }

    /* access modifiers changed from: private */
    public void skippedQuietly(AssumptionViolatedException assumptionViolatedException, Description description, List<Throwable> list) {
        try {
            if (assumptionViolatedException instanceof org.junit.AssumptionViolatedException) {
                h((org.junit.AssumptionViolatedException) assumptionViolatedException, description);
            } else {
                i(assumptionViolatedException, description);
            }
        } catch (Throwable th2) {
            list.add(th2);
        }
    }

    /* access modifiers changed from: private */
    public void startingQuietly(Description description, List<Throwable> list) {
        try {
            j(description);
        } catch (Throwable th2) {
            list.add(th2);
        }
    }

    /* access modifiers changed from: private */
    public void succeededQuietly(Description description, List<Throwable> list) {
        try {
            k(description);
        } catch (Throwable th2) {
            list.add(th2);
        }
    }

    public Statement apply(final Statement statement, final Description description) {
        return new Statement() {
            public void evaluate() throws Throwable {
                ArrayList arrayList = new ArrayList();
                TestWatcher.this.startingQuietly(description, arrayList);
                try {
                    statement.evaluate();
                    TestWatcher.this.succeededQuietly(description, arrayList);
                } catch (AssumptionViolatedException e11) {
                    arrayList.add(e11);
                    TestWatcher.this.skippedQuietly(e11, description, arrayList);
                } catch (Throwable th2) {
                    TestWatcher.this.finishedQuietly(description, arrayList);
                    throw th2;
                }
                TestWatcher.this.finishedQuietly(description, arrayList);
                MultipleFailureException.assertEmpty(arrayList);
            }
        };
    }

    public void f(Throwable th2, Description description) {
    }

    public void g(Description description) {
    }

    public void h(org.junit.AssumptionViolatedException assumptionViolatedException, Description description) {
        i(assumptionViolatedException, description);
    }

    @Deprecated
    public void i(AssumptionViolatedException assumptionViolatedException, Description description) {
    }

    public void j(Description description) {
    }

    public void k(Description description) {
    }
}
