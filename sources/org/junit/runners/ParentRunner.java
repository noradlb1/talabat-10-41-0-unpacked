package org.junit.runners;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.internal.AssumptionViolatedException;
import org.junit.internal.runners.model.EachTestNotifier;
import org.junit.internal.runners.rules.RuleMemberValidator;
import org.junit.internal.runners.statements.RunAfters;
import org.junit.internal.runners.statements.RunBefores;
import org.junit.rules.RunRules;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.manipulation.Filter;
import org.junit.runner.manipulation.Filterable;
import org.junit.runner.manipulation.Sortable;
import org.junit.runner.manipulation.Sorter;
import org.junit.runner.notification.RunNotifier;
import org.junit.runner.notification.StoppedByUserException;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.RunnerScheduler;
import org.junit.runners.model.Statement;
import org.junit.runners.model.TestClass;
import org.junit.validator.AnnotationsValidator;
import org.junit.validator.PublicClassValidator;
import org.junit.validator.TestClassValidator;

public abstract class ParentRunner<T> extends Runner implements Filterable, Sortable {
    private static final List<TestClassValidator> VALIDATORS = Arrays.asList(new TestClassValidator[]{new AnnotationsValidator(), new PublicClassValidator()});
    private final Object childrenLock = new Object();
    private volatile Collection<T> filteredChildren = null;
    private volatile RunnerScheduler scheduler = new RunnerScheduler() {
        public void finished() {
        }

        public void schedule(Runnable runnable) {
            runnable.run();
        }
    };
    private final TestClass testClass;

    public ParentRunner(Class<?> cls) throws InitializationError {
        this.testClass = f(cls);
        validate();
    }

    private void applyValidators(List<Throwable> list) {
        if (getTestClass().getJavaClass() != null) {
            for (TestClassValidator validateTestClass : VALIDATORS) {
                list.addAll(validateTestClass.validateTestClass(getTestClass()));
            }
        }
    }

    private boolean areAllChildrenIgnored() {
        for (Object k11 : getFilteredChildren()) {
            if (!k(k11)) {
                return false;
            }
        }
        return true;
    }

    private Comparator<? super T> comparator(final Sorter sorter) {
        return new Comparator<T>() {
            public int compare(T t11, T t12) {
                return sorter.compare(ParentRunner.this.g(t11), ParentRunner.this.g(t12));
            }
        };
    }

    private Collection<T> getFilteredChildren() {
        if (this.filteredChildren == null) {
            synchronized (this.childrenLock) {
                if (this.filteredChildren == null) {
                    this.filteredChildren = Collections.unmodifiableCollection(h());
                }
            }
        }
        return this.filteredChildren;
    }

    /* access modifiers changed from: private */
    public void runChildren(final RunNotifier runNotifier) {
        RunnerScheduler runnerScheduler = this.scheduler;
        try {
            for (final Object next : getFilteredChildren()) {
                runnerScheduler.schedule(new Runnable() {
                    public void run() {
                        ParentRunner.this.l(next, runNotifier);
                    }
                });
            }
        } finally {
            runnerScheduler.finished();
        }
    }

    private boolean shouldRun(Filter filter, T t11) {
        return filter.shouldRun(g(t11));
    }

    private void validate() throws InitializationError {
        ArrayList arrayList = new ArrayList();
        e(arrayList);
        if (!arrayList.isEmpty()) {
            throw new InitializationError((List<Throwable>) arrayList);
        }
    }

    private void validateClassRules(List<Throwable> list) {
        RuleMemberValidator.CLASS_RULE_VALIDATOR.validate(getTestClass(), list);
        RuleMemberValidator.CLASS_RULE_METHOD_VALIDATOR.validate(getTestClass(), list);
    }

    private Statement withClassRules(Statement statement) {
        List<TestRule> d11 = d();
        if (d11.isEmpty()) {
            return statement;
        }
        return new RunRules(statement, d11, getDescription());
    }

    public Statement b(final RunNotifier runNotifier) {
        return new Statement() {
            public void evaluate() {
                ParentRunner.this.runChildren(runNotifier);
            }
        };
    }

    public Statement c(RunNotifier runNotifier) {
        Statement b11 = b(runNotifier);
        if (!areAllChildrenIgnored()) {
            return withClassRules(o(p(b11)));
        }
        return b11;
    }

    public List<TestRule> d() {
        Class<ClassRule> cls = ClassRule.class;
        Class<TestRule> cls2 = TestRule.class;
        List<TestRule> annotatedMethodValues = this.testClass.getAnnotatedMethodValues((Object) null, cls, cls2);
        annotatedMethodValues.addAll(this.testClass.getAnnotatedFieldValues((Object) null, cls, cls2));
        return annotatedMethodValues;
    }

    public void e(List<Throwable> list) {
        n(BeforeClass.class, true, list);
        n(AfterClass.class, true, list);
        validateClassRules(list);
        applyValidators(list);
    }

    public TestClass f(Class<?> cls) {
        return new TestClass(cls);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:8|9|10|11|25) */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0010, code lost:
        continue;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0024 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void filter(org.junit.runner.manipulation.Filter r6) throws org.junit.runner.manipulation.NoTestsRemainException {
        /*
            r5 = this;
            java.lang.Object r0 = r5.childrenLock
            monitor-enter(r0)
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x0042 }
            java.util.Collection r2 = r5.getFilteredChildren()     // Catch:{ all -> 0x0042 }
            r1.<init>(r2)     // Catch:{ all -> 0x0042 }
            java.util.Iterator r2 = r1.iterator()     // Catch:{ all -> 0x0042 }
        L_0x0010:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x0042 }
            if (r3 == 0) goto L_0x002c
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x0042 }
            boolean r4 = r5.shouldRun(r6, r3)     // Catch:{ all -> 0x0042 }
            if (r4 == 0) goto L_0x0028
            r6.apply(r3)     // Catch:{ NoTestsRemainException -> 0x0024 }
            goto L_0x0010
        L_0x0024:
            r2.remove()     // Catch:{ all -> 0x0042 }
            goto L_0x0010
        L_0x0028:
            r2.remove()     // Catch:{ all -> 0x0042 }
            goto L_0x0010
        L_0x002c:
            java.util.Collection r6 = java.util.Collections.unmodifiableCollection(r1)     // Catch:{ all -> 0x0042 }
            r5.filteredChildren = r6     // Catch:{ all -> 0x0042 }
            java.util.Collection<T> r6 = r5.filteredChildren     // Catch:{ all -> 0x0042 }
            boolean r6 = r6.isEmpty()     // Catch:{ all -> 0x0042 }
            if (r6 != 0) goto L_0x003c
            monitor-exit(r0)     // Catch:{ all -> 0x0042 }
            return
        L_0x003c:
            org.junit.runner.manipulation.NoTestsRemainException r6 = new org.junit.runner.manipulation.NoTestsRemainException     // Catch:{ all -> 0x0042 }
            r6.<init>()     // Catch:{ all -> 0x0042 }
            throw r6     // Catch:{ all -> 0x0042 }
        L_0x0042:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0042 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.junit.runners.ParentRunner.filter(org.junit.runner.manipulation.Filter):void");
    }

    public abstract Description g(T t11);

    public Description getDescription() {
        Description createSuiteDescription = Description.createSuiteDescription(i(), j());
        for (Object g11 : getFilteredChildren()) {
            createSuiteDescription.addChild(g(g11));
        }
        return createSuiteDescription;
    }

    public final TestClass getTestClass() {
        return this.testClass;
    }

    public abstract List<T> h();

    public String i() {
        return this.testClass.getName();
    }

    public Annotation[] j() {
        return this.testClass.getAnnotations();
    }

    public boolean k(T t11) {
        return false;
    }

    public abstract void l(T t11, RunNotifier runNotifier);

    public final void m(Statement statement, Description description, RunNotifier runNotifier) {
        EachTestNotifier eachTestNotifier = new EachTestNotifier(runNotifier, description);
        eachTestNotifier.fireTestStarted();
        try {
            statement.evaluate();
        } catch (AssumptionViolatedException e11) {
            eachTestNotifier.addFailedAssumption(e11);
        } catch (Throwable th2) {
            eachTestNotifier.fireTestFinished();
            throw th2;
        }
        eachTestNotifier.fireTestFinished();
    }

    public void n(Class<? extends Annotation> cls, boolean z11, List<Throwable> list) {
        for (FrameworkMethod validatePublicVoidNoArg : getTestClass().getAnnotatedMethods(cls)) {
            validatePublicVoidNoArg.validatePublicVoidNoArg(z11, list);
        }
    }

    public Statement o(Statement statement) {
        List<FrameworkMethod> annotatedMethods = this.testClass.getAnnotatedMethods(AfterClass.class);
        if (annotatedMethods.isEmpty()) {
            return statement;
        }
        return new RunAfters(statement, annotatedMethods, (Object) null);
    }

    public Statement p(Statement statement) {
        List<FrameworkMethod> annotatedMethods = this.testClass.getAnnotatedMethods(BeforeClass.class);
        if (annotatedMethods.isEmpty()) {
            return statement;
        }
        return new RunBefores(statement, annotatedMethods, (Object) null);
    }

    public void run(RunNotifier runNotifier) {
        EachTestNotifier eachTestNotifier = new EachTestNotifier(runNotifier, getDescription());
        try {
            c(runNotifier).evaluate();
        } catch (AssumptionViolatedException e11) {
            eachTestNotifier.addFailedAssumption(e11);
        } catch (StoppedByUserException e12) {
            throw e12;
        } catch (Throwable th2) {
            eachTestNotifier.addFailure(th2);
        }
    }

    public void setScheduler(RunnerScheduler runnerScheduler) {
        this.scheduler = runnerScheduler;
    }

    public void sort(Sorter sorter) {
        synchronized (this.childrenLock) {
            for (Object apply : getFilteredChildren()) {
                sorter.apply(apply);
            }
            ArrayList arrayList = new ArrayList(getFilteredChildren());
            Collections.sort(arrayList, comparator(sorter));
            this.filteredChildren = Collections.unmodifiableCollection(arrayList);
        }
    }
}
