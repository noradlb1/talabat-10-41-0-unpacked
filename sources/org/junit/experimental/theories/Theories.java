package org.junit.experimental.theories;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.experimental.theories.internal.Assignments;
import org.junit.experimental.theories.internal.ParameterizedAssertionError;
import org.junit.internal.AssumptionViolatedException;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;
import org.junit.runners.model.TestClass;

public class Theories extends BlockJUnit4ClassRunner {

    public static class TheoryAnchor extends Statement {
        private List<AssumptionViolatedException> fInvalidParameters = new ArrayList();
        private int successes = 0;
        private final TestClass testClass;
        private final FrameworkMethod testMethod;

        public TheoryAnchor(FrameworkMethod frameworkMethod, TestClass testClass2) {
            this.testMethod = frameworkMethod;
            this.testClass = testClass2;
        }

        private TestClass getTestClass() {
            return this.testClass;
        }

        /* access modifiers changed from: private */
        public Statement methodCompletesWithParameters(final FrameworkMethod frameworkMethod, final Assignments assignments, final Object obj) {
            return new Statement() {
                public void evaluate() throws Throwable {
                    Object[] methodArguments = assignments.getMethodArguments();
                    if (!TheoryAnchor.this.nullsOk()) {
                        Assume.assumeNotNull(methodArguments);
                    }
                    frameworkMethod.invokeExplosively(obj, methodArguments);
                }
            };
        }

        /* access modifiers changed from: private */
        public boolean nullsOk() {
            Theory theory = (Theory) this.testMethod.getMethod().getAnnotation(Theory.class);
            if (theory == null) {
                return false;
            }
            return theory.nullsAccepted();
        }

        public void c(AssumptionViolatedException assumptionViolatedException) {
            this.fInvalidParameters.add(assumptionViolatedException);
        }

        public void d() {
            this.successes++;
        }

        public void e(Throwable th2, Object... objArr) throws Throwable {
            if (objArr.length == 0) {
                throw th2;
            }
            throw new ParameterizedAssertionError(th2, this.testMethod.getName(), objArr);
        }

        public void evaluate() throws Throwable {
            boolean z11;
            f(Assignments.allUnassigned(this.testMethod.getMethod(), getTestClass()));
            if (this.testMethod.getAnnotation(Theory.class) != null) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (this.successes == 0 && z11) {
                Assert.fail("Never found parameters that satisfied method assumptions.  Violated assumptions: " + this.fInvalidParameters);
            }
        }

        public void f(Assignments assignments) throws Throwable {
            if (!assignments.isComplete()) {
                h(assignments);
            } else {
                g(assignments);
            }
        }

        public void g(final Assignments assignments) throws Throwable {
            new BlockJUnit4ClassRunner(getTestClass().getJavaClass()) {
                public Object createTest() throws Exception {
                    Object[] constructorArguments = assignments.getConstructorArguments();
                    if (!TheoryAnchor.this.nullsOk()) {
                        Assume.assumeNotNull(constructorArguments);
                    }
                    return getTestClass().getOnlyConstructor().newInstance(constructorArguments);
                }

                public void e(List<Throwable> list) {
                }

                public Statement methodBlock(FrameworkMethod frameworkMethod) {
                    final Statement methodBlock = super.methodBlock(frameworkMethod);
                    return new Statement() {
                        public void evaluate() throws Throwable {
                            try {
                                methodBlock.evaluate();
                                TheoryAnchor.this.d();
                            } catch (AssumptionViolatedException e11) {
                                TheoryAnchor.this.c(e11);
                            } catch (Throwable th2) {
                                AnonymousClass1 r12 = AnonymousClass1.this;
                                TheoryAnchor theoryAnchor = TheoryAnchor.this;
                                theoryAnchor.e(th2, assignments.getArgumentStrings(theoryAnchor.nullsOk()));
                            }
                        }
                    };
                }

                public Statement u(FrameworkMethod frameworkMethod, Object obj) {
                    return TheoryAnchor.this.methodCompletesWithParameters(frameworkMethod, assignments, obj);
                }
            }.methodBlock(this.testMethod).evaluate();
        }

        public void h(Assignments assignments) throws Throwable {
            for (PotentialAssignment assignNext : assignments.potentialsForNextUnassigned()) {
                f(assignments.assignNext(assignNext));
            }
        }
    }

    public Theories(Class<?> cls) throws InitializationError {
        super(cls);
    }

    private void validateDataPointFields(List<Throwable> list) {
        for (Field field : getTestClass().getJavaClass().getDeclaredFields()) {
            if (field.getAnnotation(DataPoint.class) != null || field.getAnnotation(DataPoints.class) != null) {
                if (!Modifier.isStatic(field.getModifiers())) {
                    list.add(new Error("DataPoint field " + field.getName() + " must be static"));
                }
                if (!Modifier.isPublic(field.getModifiers())) {
                    list.add(new Error("DataPoint field " + field.getName() + " must be public"));
                }
            }
        }
    }

    private void validateDataPointMethods(List<Throwable> list) {
        for (Method method : getTestClass().getJavaClass().getDeclaredMethods()) {
            if (method.getAnnotation(DataPoint.class) != null || method.getAnnotation(DataPoints.class) != null) {
                if (!Modifier.isStatic(method.getModifiers())) {
                    list.add(new Error("DataPoint method " + method.getName() + " must be static"));
                }
                if (!Modifier.isPublic(method.getModifiers())) {
                    list.add(new Error("DataPoint method " + method.getName() + " must be public"));
                }
            }
        }
    }

    private void validateParameterSupplier(Class<? extends ParameterSupplier> cls, List<Throwable> list) {
        Constructor[] constructors = cls.getConstructors();
        if (constructors.length != 1) {
            list.add(new Error("ParameterSupplier " + cls.getName() + " must have only one constructor (either empty or taking only a TestClass)"));
            return;
        }
        Class[] parameterTypes = constructors[0].getParameterTypes();
        if (parameterTypes.length != 0 && !parameterTypes[0].equals(TestClass.class)) {
            list.add(new Error("ParameterSupplier " + cls.getName() + " constructor must take either nothing or a single TestClass instance"));
        }
    }

    public void E(List<Throwable> list) {
        for (FrameworkMethod next : q()) {
            if (next.getAnnotation(Theory.class) != null) {
                next.validatePublicVoid(false, list);
                next.validateNoTypeParametersOnArgs(list);
            } else {
                next.validatePublicVoidNoArg(false, list);
            }
            Iterator<ParameterSignature> it = ParameterSignature.signatures(next.getMethod()).iterator();
            while (it.hasNext()) {
                ParametersSuppliedBy parametersSuppliedBy = (ParametersSuppliedBy) it.next().findDeepAnnotation(ParametersSuppliedBy.class);
                if (parametersSuppliedBy != null) {
                    validateParameterSupplier(parametersSuppliedBy.value(), list);
                }
            }
        }
    }

    public void e(List<Throwable> list) {
        super.e(list);
        validateDataPointFields(list);
        validateDataPointMethods(list);
    }

    public Statement methodBlock(FrameworkMethod frameworkMethod) {
        return new TheoryAnchor(frameworkMethod, getTestClass());
    }

    public List<FrameworkMethod> q() {
        ArrayList arrayList = new ArrayList(super.q());
        List<FrameworkMethod> annotatedMethods = getTestClass().getAnnotatedMethods(Theory.class);
        arrayList.removeAll(annotatedMethods);
        arrayList.addAll(annotatedMethods);
        return arrayList;
    }

    public void z(List<Throwable> list) {
        D(list);
    }
}
