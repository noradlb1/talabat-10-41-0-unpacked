package org.junit.internal.runners;

import java.lang.annotation.Annotation;
import junit.extensions.TestDecorator;
import junit.framework.AssertionFailedError;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestListener;
import junit.framework.TestResult;
import junit.framework.TestSuite;
import org.junit.runner.Describable;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.manipulation.Filter;
import org.junit.runner.manipulation.Filterable;
import org.junit.runner.manipulation.NoTestsRemainException;
import org.junit.runner.manipulation.Sortable;
import org.junit.runner.manipulation.Sorter;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;

public class JUnit38ClassRunner extends Runner implements Filterable, Sortable {
    private volatile Test test;

    public static final class OldTestClassAdaptingListener implements TestListener {
        private final RunNotifier notifier;

        private Description asDescription(Test test) {
            if (test instanceof Describable) {
                return ((Describable) test).getDescription();
            }
            return Description.createTestDescription(getEffectiveClass(test), getName(test));
        }

        private Class<? extends Test> getEffectiveClass(Test test) {
            return test.getClass();
        }

        private String getName(Test test) {
            if (test instanceof TestCase) {
                return ((TestCase) test).getName();
            }
            return test.toString();
        }

        public void addError(Test test, Throwable th2) {
            this.notifier.fireTestFailure(new Failure(asDescription(test), th2));
        }

        public void addFailure(Test test, AssertionFailedError assertionFailedError) {
            addError(test, assertionFailedError);
        }

        public void endTest(Test test) {
            this.notifier.fireTestFinished(asDescription(test));
        }

        public void startTest(Test test) {
            this.notifier.fireTestStarted(asDescription(test));
        }

        private OldTestClassAdaptingListener(RunNotifier runNotifier) {
            this.notifier = runNotifier;
        }
    }

    public JUnit38ClassRunner(Class<?> cls) {
        this((Test) new TestSuite((Class<?>) cls.asSubclass(TestCase.class)));
    }

    private static String createSuiteDescription(TestSuite testSuite) {
        String str;
        int countTestCases = testSuite.countTestCases();
        if (countTestCases == 0) {
            str = "";
        } else {
            str = String.format(" [example: %s]", new Object[]{testSuite.testAt(0)});
        }
        return String.format("TestSuite with %s tests%s", new Object[]{Integer.valueOf(countTestCases), str});
    }

    private static Annotation[] getAnnotations(TestCase testCase) {
        try {
            return testCase.getClass().getMethod(testCase.getName(), new Class[0]).getDeclaredAnnotations();
        } catch (NoSuchMethodException | SecurityException unused) {
            return new Annotation[0];
        }
    }

    private Test getTest() {
        return this.test;
    }

    private static Description makeDescription(Test test2) {
        String str;
        if (test2 instanceof TestCase) {
            TestCase testCase = (TestCase) test2;
            return Description.createTestDescription(testCase.getClass(), testCase.getName(), getAnnotations(testCase));
        } else if (test2 instanceof TestSuite) {
            TestSuite testSuite = (TestSuite) test2;
            if (testSuite.getName() == null) {
                str = createSuiteDescription(testSuite);
            } else {
                str = testSuite.getName();
            }
            Description createSuiteDescription = Description.createSuiteDescription(str, new Annotation[0]);
            int testCount = testSuite.testCount();
            for (int i11 = 0; i11 < testCount; i11++) {
                createSuiteDescription.addChild(makeDescription(testSuite.testAt(i11)));
            }
            return createSuiteDescription;
        } else if (test2 instanceof Describable) {
            return ((Describable) test2).getDescription();
        } else {
            if (test2 instanceof TestDecorator) {
                return makeDescription(((TestDecorator) test2).getTest());
            }
            return Description.createSuiteDescription(test2.getClass());
        }
    }

    private void setTest(Test test2) {
        this.test = test2;
    }

    public TestListener createAdaptingListener(RunNotifier runNotifier) {
        return new OldTestClassAdaptingListener(runNotifier);
    }

    public void filter(Filter filter) throws NoTestsRemainException {
        if (getTest() instanceof Filterable) {
            ((Filterable) getTest()).filter(filter);
        } else if (getTest() instanceof TestSuite) {
            TestSuite testSuite = (TestSuite) getTest();
            TestSuite testSuite2 = new TestSuite(testSuite.getName());
            int testCount = testSuite.testCount();
            for (int i11 = 0; i11 < testCount; i11++) {
                Test testAt = testSuite.testAt(i11);
                if (filter.shouldRun(makeDescription(testAt))) {
                    testSuite2.addTest(testAt);
                }
            }
            setTest(testSuite2);
            if (testSuite2.testCount() == 0) {
                throw new NoTestsRemainException();
            }
        }
    }

    public Description getDescription() {
        return makeDescription(getTest());
    }

    public void run(RunNotifier runNotifier) {
        TestResult testResult = new TestResult();
        testResult.addListener(createAdaptingListener(runNotifier));
        getTest().run(testResult);
    }

    public void sort(Sorter sorter) {
        if (getTest() instanceof Sortable) {
            ((Sortable) getTest()).sort(sorter);
        }
    }

    public JUnit38ClassRunner(Test test2) {
        setTest(test2);
    }
}
