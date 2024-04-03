package org.mockito.internal.runners;

import org.junit.runner.Description;
import org.junit.runner.manipulation.Filter;
import org.junit.runner.manipulation.NoTestsRemainException;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.junit.DefaultTestFinishedEvent;
import org.mockito.internal.junit.MockitoTestListener;
import org.mockito.internal.util.Supplier;

public class DefaultInternalRunner implements InternalRunner {
    private final BlockJUnit4ClassRunner runner;

    public DefaultInternalRunner(Class<?> cls, final Supplier<MockitoTestListener> supplier) throws InitializationError {
        this.runner = new BlockJUnit4ClassRunner(cls) {
            /* access modifiers changed from: private */
            public MockitoTestListener mockitoTestListener;
            public Object target;

            public Statement H(FrameworkMethod frameworkMethod, final Object obj, Statement statement) {
                this.target = obj;
                final Statement H = super.H(frameworkMethod, obj, statement);
                return new Statement() {
                    public void evaluate() throws Throwable {
                        AutoCloseable autoCloseable;
                        if (AnonymousClass1.this.mockitoTestListener == null) {
                            AnonymousClass1 r02 = AnonymousClass1.this;
                            MockitoTestListener unused = r02.mockitoTestListener = (MockitoTestListener) supplier.get();
                            Mockito.framework().addListener(AnonymousClass1.this.mockitoTestListener);
                            autoCloseable = MockitoAnnotations.openMocks(obj);
                        } else {
                            autoCloseable = null;
                        }
                        try {
                            H.evaluate();
                        } finally {
                            if (autoCloseable != null) {
                                autoCloseable.close();
                            }
                        }
                    }
                };
            }

            public void run(final RunNotifier runNotifier) {
                runNotifier.addListener(new RunListener() {

                    /* renamed from: a  reason: collision with root package name */
                    public Throwable f63231a;

                    public void testFailure(Failure failure) throws Exception {
                        this.f63231a = failure.getException();
                    }

                    public void testFinished(Description description) throws Exception {
                        try {
                            if (AnonymousClass1.this.mockitoTestListener != null) {
                                Mockito.framework().removeListener(AnonymousClass1.this.mockitoTestListener);
                                AnonymousClass1.this.mockitoTestListener.testFinished(new DefaultTestFinishedEvent(AnonymousClass1.this.target, description.getMethodName(), this.f63231a));
                                MockitoTestListener unused = AnonymousClass1.this.mockitoTestListener = null;
                            }
                            Mockito.validateMockitoUsage();
                        } catch (Throwable th2) {
                            runNotifier.fireTestFailure(new Failure(description, th2));
                        }
                    }
                });
                super.run(runNotifier);
            }
        };
    }

    public void filter(Filter filter) throws NoTestsRemainException {
        this.runner.filter(filter);
    }

    public Description getDescription() {
        return this.runner.getDescription();
    }

    public void run(RunNotifier runNotifier) {
        this.runner.run(runNotifier);
    }
}
