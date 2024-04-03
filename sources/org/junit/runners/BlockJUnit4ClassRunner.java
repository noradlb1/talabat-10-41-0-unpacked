package org.junit.runners;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.internal.runners.model.ReflectiveCallable;
import org.junit.internal.runners.rules.RuleMemberValidator;
import org.junit.internal.runners.statements.ExpectException;
import org.junit.internal.runners.statements.Fail;
import org.junit.internal.runners.statements.FailOnTimeout;
import org.junit.internal.runners.statements.InvokeMethod;
import org.junit.internal.runners.statements.RunAfters;
import org.junit.internal.runners.statements.RunBefores;
import org.junit.rules.MethodRule;
import org.junit.rules.RunRules;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;

public class BlockJUnit4ClassRunner extends ParentRunner<FrameworkMethod> {
    private final ConcurrentHashMap<FrameworkMethod, Description> methodDescriptions = new ConcurrentHashMap<>();

    public BlockJUnit4ClassRunner(Class<?> cls) throws InitializationError {
        super(cls);
    }

    private boolean expectsException(Test test) {
        return getExpectedException(test) != null;
    }

    private Class<? extends Throwable> getExpectedException(Test test) {
        if (test == null || test.expected() == Test.None.class) {
            return null;
        }
        return test.expected();
    }

    private List<MethodRule> getMethodRules(Object obj) {
        return w(obj);
    }

    private long getTimeout(Test test) {
        if (test == null) {
            return 0;
        }
        return test.timeout();
    }

    private boolean hasOneConstructor() {
        return getTestClass().getJavaClass().getConstructors().length == 1;
    }

    private void validateMethods(List<Throwable> list) {
        RuleMemberValidator.RULE_METHOD_VALIDATOR.validate(getTestClass(), list);
    }

    private Statement withMethodRules(FrameworkMethod frameworkMethod, List<TestRule> list, Object obj, Statement statement) {
        for (MethodRule next : getMethodRules(obj)) {
            if (!list.contains(next)) {
                statement = next.apply(statement, frameworkMethod, obj);
            }
        }
        return statement;
    }

    private Statement withRules(FrameworkMethod frameworkMethod, Object obj, Statement statement) {
        List<TestRule> s11 = s(obj);
        return withTestRules(frameworkMethod, s11, withMethodRules(frameworkMethod, s11, obj, statement));
    }

    private Statement withTestRules(FrameworkMethod frameworkMethod, List<TestRule> list, Statement statement) {
        return list.isEmpty() ? statement : new RunRules(statement, list, g(frameworkMethod));
    }

    public void A(List<Throwable> list) {
        RuleMemberValidator.RULE_VALIDATOR.validate(getTestClass(), list);
    }

    @Deprecated
    public void B(List<Throwable> list) {
        n(After.class, false, list);
        n(Before.class, false, list);
        E(list);
        if (q().size() == 0) {
            list.add(new Exception("No runnable methods"));
        }
    }

    public void C(List<Throwable> list) {
        if (getTestClass().isANonStaticInnerClass()) {
            list.add(new Exception("The inner class " + getTestClass().getName() + " is not static."));
        }
    }

    public void D(List<Throwable> list) {
        if (!hasOneConstructor()) {
            list.add(new Exception("Test class should have exactly one public constructor"));
        }
    }

    public void E(List<Throwable> list) {
        n(Test.class, false, list);
    }

    public void F(List<Throwable> list) {
        if (!getTestClass().isANonStaticInnerClass() && hasOneConstructor() && getTestClass().getOnlyConstructor().getParameterTypes().length != 0) {
            list.add(new Exception("Test class should have exactly one public zero-argument constructor"));
        }
    }

    public Statement G(FrameworkMethod frameworkMethod, Object obj, Statement statement) {
        List<FrameworkMethod> annotatedMethods = getTestClass().getAnnotatedMethods(After.class);
        if (annotatedMethods.isEmpty()) {
            return statement;
        }
        return new RunAfters(statement, annotatedMethods, obj);
    }

    public Statement H(FrameworkMethod frameworkMethod, Object obj, Statement statement) {
        List<FrameworkMethod> annotatedMethods = getTestClass().getAnnotatedMethods(Before.class);
        if (annotatedMethods.isEmpty()) {
            return statement;
        }
        return new RunBefores(statement, annotatedMethods, obj);
    }

    @Deprecated
    public Statement I(FrameworkMethod frameworkMethod, Object obj, Statement statement) {
        long timeout = getTimeout((Test) frameworkMethod.getAnnotation(Test.class));
        if (timeout <= 0) {
            return statement;
        }
        return FailOnTimeout.builder().withTimeout(timeout, TimeUnit.MILLISECONDS).build(statement);
    }

    public Object createTest() throws Exception {
        return getTestClass().getOnlyConstructor().newInstance(new Object[0]);
    }

    public void e(List<Throwable> list) {
        super.e(list);
        C(list);
        z(list);
        B(list);
        A(list);
        validateMethods(list);
    }

    public List<FrameworkMethod> h() {
        return q();
    }

    public Statement methodBlock(FrameworkMethod frameworkMethod) {
        try {
            Object run = new ReflectiveCallable() {
                public Object a() throws Throwable {
                    return BlockJUnit4ClassRunner.this.createTest();
                }
            }.run();
            return withRules(frameworkMethod, run, G(frameworkMethod, run, H(frameworkMethod, run, I(frameworkMethod, run, v(frameworkMethod, run, u(frameworkMethod, run))))));
        } catch (Throwable th2) {
            return new Fail(th2);
        }
    }

    public List<FrameworkMethod> q() {
        return getTestClass().getAnnotatedMethods(Test.class);
    }

    /* renamed from: r */
    public Description g(FrameworkMethod frameworkMethod) {
        Description description = this.methodDescriptions.get(frameworkMethod);
        if (description != null) {
            return description;
        }
        Description createTestDescription = Description.createTestDescription(getTestClass().getJavaClass(), y(frameworkMethod), frameworkMethod.getAnnotations());
        this.methodDescriptions.putIfAbsent(frameworkMethod, createTestDescription);
        return createTestDescription;
    }

    public List<TestRule> s(Object obj) {
        Class<Rule> cls = Rule.class;
        Class<TestRule> cls2 = TestRule.class;
        List<TestRule> annotatedMethodValues = getTestClass().getAnnotatedMethodValues(obj, cls, cls2);
        annotatedMethodValues.addAll(getTestClass().getAnnotatedFieldValues(obj, cls, cls2));
        return annotatedMethodValues;
    }

    /* renamed from: t */
    public boolean k(FrameworkMethod frameworkMethod) {
        return frameworkMethod.getAnnotation(Ignore.class) != null;
    }

    public Statement u(FrameworkMethod frameworkMethod, Object obj) {
        return new InvokeMethod(frameworkMethod, obj);
    }

    public Statement v(FrameworkMethod frameworkMethod, Object obj, Statement statement) {
        Test test = (Test) frameworkMethod.getAnnotation(Test.class);
        if (expectsException(test)) {
            return new ExpectException(statement, getExpectedException(test));
        }
        return statement;
    }

    public List<MethodRule> w(Object obj) {
        Class<Rule> cls = Rule.class;
        Class<MethodRule> cls2 = MethodRule.class;
        List<MethodRule> annotatedMethodValues = getTestClass().getAnnotatedMethodValues(obj, cls, cls2);
        annotatedMethodValues.addAll(getTestClass().getAnnotatedFieldValues(obj, cls, cls2));
        return annotatedMethodValues;
    }

    /* renamed from: x */
    public void l(FrameworkMethod frameworkMethod, RunNotifier runNotifier) {
        Description r11 = g(frameworkMethod);
        if (k(frameworkMethod)) {
            runNotifier.fireTestIgnored(r11);
        } else {
            m(methodBlock(frameworkMethod), r11, runNotifier);
        }
    }

    public String y(FrameworkMethod frameworkMethod) {
        return frameworkMethod.getName();
    }

    public void z(List<Throwable> list) {
        D(list);
        F(list);
    }
}
