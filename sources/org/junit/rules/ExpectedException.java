package org.junit.rules;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
import org.hamcrest.StringDescription;
import org.junit.Assert;
import org.junit.internal.matchers.ThrowableCauseMatcher;
import org.junit.internal.matchers.ThrowableMessageMatcher;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class ExpectedException implements TestRule {
    private final ExpectedExceptionMatcherBuilder matcherBuilder = new ExpectedExceptionMatcherBuilder();
    private String missingExceptionMessage = "Expected test to throw %s";

    public class ExpectedExceptionStatement extends Statement {
        private final Statement next;

        public ExpectedExceptionStatement(Statement statement) {
            this.next = statement;
        }

        public void evaluate() throws Throwable {
            try {
                this.next.evaluate();
                if (ExpectedException.this.isAnyExceptionExpected()) {
                    ExpectedException.this.failDueToMissingException();
                }
            } catch (Throwable th2) {
                ExpectedException.this.handleException(th2);
            }
        }
    }

    private ExpectedException() {
    }

    /* access modifiers changed from: private */
    public void failDueToMissingException() throws AssertionError {
        Assert.fail(missingExceptionMessage());
    }

    /* access modifiers changed from: private */
    public void handleException(Throwable th2) throws Throwable {
        if (isAnyExceptionExpected()) {
            Assert.assertThat(th2, this.matcherBuilder.b());
            return;
        }
        throw th2;
    }

    /* access modifiers changed from: private */
    public boolean isAnyExceptionExpected() {
        return this.matcherBuilder.c();
    }

    private String missingExceptionMessage() {
        String stringDescription = StringDescription.toString(this.matcherBuilder.b());
        return String.format(this.missingExceptionMessage, new Object[]{stringDescription});
    }

    public static ExpectedException none() {
        return new ExpectedException();
    }

    public Statement apply(Statement statement, Description description) {
        return new ExpectedExceptionStatement(statement);
    }

    public void expect(Matcher<?> matcher) {
        this.matcherBuilder.a(matcher);
    }

    public void expectCause(Matcher<? extends Throwable> matcher) {
        expect((Matcher<?>) ThrowableCauseMatcher.hasCause(matcher));
    }

    public void expectMessage(String str) {
        expectMessage(CoreMatchers.containsString(str));
    }

    @Deprecated
    public ExpectedException handleAssertionErrors() {
        return this;
    }

    @Deprecated
    public ExpectedException handleAssumptionViolatedExceptions() {
        return this;
    }

    public ExpectedException reportMissingExceptionWithMessage(String str) {
        this.missingExceptionMessage = str;
        return this;
    }

    public void expect(Class<? extends Throwable> cls) {
        expect((Matcher<?>) CoreMatchers.instanceOf(cls));
    }

    public void expectMessage(Matcher<String> matcher) {
        expect((Matcher<?>) ThrowableMessageMatcher.hasMessage(matcher));
    }
}
