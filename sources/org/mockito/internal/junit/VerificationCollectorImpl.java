package org.mockito.internal.junit;

import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.mockito.exceptions.base.MockitoAssertionError;
import org.mockito.internal.progress.MockingProgressImpl;
import org.mockito.internal.progress.ThreadSafeMockingProgress;
import org.mockito.internal.verification.api.VerificationData;
import org.mockito.junit.VerificationCollector;
import org.mockito.verification.VerificationMode;
import org.mockito.verification.VerificationStrategy;

public class VerificationCollectorImpl implements VerificationCollector {
    private StringBuilder builder;
    private int numberOfFailures;

    public class VerificationWrapper implements VerificationMode {
        private final VerificationMode delegate;

        public VerificationMode description(String str) {
            throw new IllegalStateException("Should not fail in this mode");
        }

        public void verify(VerificationData verificationData) {
            try {
                this.delegate.verify(verificationData);
            } catch (AssertionError e11) {
                VerificationCollectorImpl.this.append(e11.getMessage());
            }
        }

        private VerificationWrapper(VerificationMode verificationMode) {
            this.delegate = verificationMode;
        }
    }

    public VerificationCollectorImpl() {
        resetBuilder();
    }

    /* access modifiers changed from: private */
    public void append(String str) {
        this.numberOfFailures++;
        StringBuilder sb2 = this.builder;
        sb2.append(10);
        sb2.append(this.numberOfFailures);
        sb2.append(". ");
        sb2.append(str.trim());
        sb2.append(10);
    }

    private void resetBuilder() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("There were multiple verification failures:");
        this.builder = sb2;
        this.numberOfFailures = 0;
    }

    public Statement apply(final Statement statement, Description description) {
        return new Statement() {
            public void evaluate() throws Throwable {
                try {
                    VerificationCollectorImpl.this.assertLazily();
                    statement.evaluate();
                    VerificationCollectorImpl.this.collectAndReport();
                } finally {
                    ThreadSafeMockingProgress.mockingProgress().setVerificationStrategy(MockingProgressImpl.getDefaultVerificationStrategy());
                }
            }
        };
    }

    public VerificationCollector assertLazily() {
        ThreadSafeMockingProgress.mockingProgress().setVerificationStrategy(new VerificationStrategy() {
            public VerificationMode maybeVerifyLazily(VerificationMode verificationMode) {
                return new VerificationWrapper(verificationMode);
            }
        });
        return this;
    }

    public void collectAndReport() throws MockitoAssertionError {
        ThreadSafeMockingProgress.mockingProgress().setVerificationStrategy(MockingProgressImpl.getDefaultVerificationStrategy());
        if (this.numberOfFailures > 0) {
            String sb2 = this.builder.toString();
            resetBuilder();
            throw new MockitoAssertionError(sb2);
        }
    }
}
