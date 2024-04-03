package org.junit.runners;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.runner.Runner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.TestClass;
import org.junit.runners.parameterized.BlockJUnit4ClassRunnerWithParametersFactory;
import org.junit.runners.parameterized.ParametersRunnerFactory;
import org.junit.runners.parameterized.TestWithParameters;

public class Parameterized extends Suite {
    private static final ParametersRunnerFactory DEFAULT_FACTORY = new BlockJUnit4ClassRunnerWithParametersFactory();
    private static final List<Runner> NO_RUNNERS = Collections.emptyList();
    private final List<Runner> runners;

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Parameter {
        int value() default 0;
    }

    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Parameters {
        String name() default "{index}";
    }

    @Inherited
    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface UseParametersRunnerFactory {
        Class<? extends ParametersRunnerFactory> value() default BlockJUnit4ClassRunnerWithParametersFactory.class;
    }

    public Parameterized(Class<?> cls) throws Throwable {
        super(cls, NO_RUNNERS);
        this.runners = Collections.unmodifiableList(createRunnersForParameters(allParameters(), ((Parameters) getParametersMethod().getAnnotation(Parameters.class)).name(), getParametersRunnerFactory(cls)));
    }

    private Iterable<Object> allParameters() throws Throwable {
        Object invokeExplosively = getParametersMethod().invokeExplosively((Object) null, new Object[0]);
        if (invokeExplosively instanceof Iterable) {
            return (Iterable) invokeExplosively;
        }
        if (invokeExplosively instanceof Object[]) {
            return Arrays.asList((Object[]) invokeExplosively);
        }
        throw parametersMethodReturnedWrongType();
    }

    private List<Runner> createRunnersForParameters(Iterable<Object> iterable, String str, ParametersRunnerFactory parametersRunnerFactory) throws InitializationError, Exception {
        try {
            List<TestWithParameters> createTestsForParameters = createTestsForParameters(iterable, str);
            ArrayList arrayList = new ArrayList();
            for (TestWithParameters createRunnerForTestWithParameters : createTestsForParameters) {
                arrayList.add(parametersRunnerFactory.createRunnerForTestWithParameters(createRunnerForTestWithParameters));
            }
            return arrayList;
        } catch (ClassCastException unused) {
            throw parametersMethodReturnedWrongType();
        }
    }

    private TestWithParameters createTestWithNotNormalizedParameters(String str, int i11, Object obj) {
        Object[] objArr;
        if (obj instanceof Object[]) {
            objArr = (Object[]) obj;
        } else {
            objArr = new Object[]{obj};
        }
        return createTestWithParameters(getTestClass(), str, i11, objArr);
    }

    private static TestWithParameters createTestWithParameters(TestClass testClass, String str, int i11, Object[] objArr) {
        String format = MessageFormat.format(str.replaceAll("\\{index\\}", Integer.toString(i11)), objArr);
        return new TestWithParameters("[" + format + "]", testClass, Arrays.asList(objArr));
    }

    private List<TestWithParameters> createTestsForParameters(Iterable<Object> iterable, String str) throws Exception {
        ArrayList arrayList = new ArrayList();
        int i11 = 0;
        for (Object createTestWithNotNormalizedParameters : iterable) {
            arrayList.add(createTestWithNotNormalizedParameters(str, i11, createTestWithNotNormalizedParameters));
            i11++;
        }
        return arrayList;
    }

    private FrameworkMethod getParametersMethod() throws Exception {
        for (FrameworkMethod next : getTestClass().getAnnotatedMethods(Parameters.class)) {
            if (next.isStatic() && next.isPublic()) {
                return next;
            }
        }
        throw new Exception("No public static parameters method on class " + getTestClass().getName());
    }

    private ParametersRunnerFactory getParametersRunnerFactory(Class<?> cls) throws InstantiationException, IllegalAccessException {
        UseParametersRunnerFactory useParametersRunnerFactory = (UseParametersRunnerFactory) cls.getAnnotation(UseParametersRunnerFactory.class);
        if (useParametersRunnerFactory == null) {
            return DEFAULT_FACTORY;
        }
        return (ParametersRunnerFactory) useParametersRunnerFactory.value().newInstance();
    }

    private Exception parametersMethodReturnedWrongType() throws Exception {
        return new Exception(MessageFormat.format("{0}.{1}() must return an Iterable of arrays.", new Object[]{getTestClass().getName(), getParametersMethod().getName()}));
    }

    public List<Runner> h() {
        return this.runners;
    }
}
