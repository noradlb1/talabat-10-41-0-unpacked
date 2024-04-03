package org.junit.runners.parameterized;

import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.Parameterized;
import org.junit.runners.model.FrameworkField;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;

public class BlockJUnit4ClassRunnerWithParameters extends BlockJUnit4ClassRunner {

    /* renamed from: name  reason: collision with root package name */
    private final String f62634name;
    private final Object[] parameters;

    public BlockJUnit4ClassRunnerWithParameters(TestWithParameters testWithParameters) throws InitializationError {
        super(testWithParameters.getTestClass().getJavaClass());
        this.parameters = testWithParameters.getParameters().toArray(new Object[testWithParameters.getParameters().size()]);
        this.f62634name = testWithParameters.getName();
    }

    private Object createTestUsingConstructorInjection() throws Exception {
        return getTestClass().getOnlyConstructor().newInstance(this.parameters);
    }

    private Object createTestUsingFieldInjection() throws Exception {
        List<FrameworkField> annotatedFieldsByParameter = getAnnotatedFieldsByParameter();
        if (annotatedFieldsByParameter.size() == this.parameters.length) {
            Object newInstance = getTestClass().getJavaClass().newInstance();
            for (FrameworkField field : annotatedFieldsByParameter) {
                Field field2 = field.getField();
                int value = ((Parameterized.Parameter) field2.getAnnotation(Parameterized.Parameter.class)).value();
                try {
                    field2.set(newInstance, this.parameters[value]);
                } catch (IllegalArgumentException e11) {
                    throw new Exception(getTestClass().getName() + ": Trying to set " + field2.getName() + " with the value " + this.parameters[value] + " that is not the right type (" + this.parameters[value].getClass().getSimpleName() + " instead of " + field2.getType().getSimpleName() + ").", e11);
                }
            }
            return newInstance;
        }
        throw new Exception("Wrong number of parameters and @Parameter fields. @Parameter fields counted: " + annotatedFieldsByParameter.size() + ", available parameters: " + this.parameters.length + RealDiscoveryConfigurationRepository.VERSION_DELIMETER);
    }

    private boolean fieldsAreAnnotated() {
        return !getAnnotatedFieldsByParameter().isEmpty();
    }

    private List<FrameworkField> getAnnotatedFieldsByParameter() {
        return getTestClass().getAnnotatedFields(Parameterized.Parameter.class);
    }

    public void A(List<Throwable> list) {
        super.A(list);
        if (fieldsAreAnnotated()) {
            List<FrameworkField> annotatedFieldsByParameter = getAnnotatedFieldsByParameter();
            int size = annotatedFieldsByParameter.size();
            int[] iArr = new int[size];
            for (FrameworkField field : annotatedFieldsByParameter) {
                int value = ((Parameterized.Parameter) field.getField().getAnnotation(Parameterized.Parameter.class)).value();
                if (value < 0 || value > annotatedFieldsByParameter.size() - 1) {
                    list.add(new Exception("Invalid @Parameter value: " + value + ". @Parameter fields counted: " + annotatedFieldsByParameter.size() + ". Please use an index between 0 and " + (annotatedFieldsByParameter.size() - 1) + RealDiscoveryConfigurationRepository.VERSION_DELIMETER));
                } else {
                    iArr[value] = iArr[value] + 1;
                }
            }
            for (int i11 = 0; i11 < size; i11++) {
                int i12 = iArr[i11];
                if (i12 == 0) {
                    list.add(new Exception("@Parameter(" + i11 + ") is never used."));
                } else if (i12 > 1) {
                    list.add(new Exception("@Parameter(" + i11 + ") is used more than once (" + i12 + ")."));
                }
            }
        }
    }

    public Statement c(RunNotifier runNotifier) {
        return b(runNotifier);
    }

    public Object createTest() throws Exception {
        if (fieldsAreAnnotated()) {
            return createTestUsingFieldInjection();
        }
        return createTestUsingConstructorInjection();
    }

    public String i() {
        return this.f62634name;
    }

    public Annotation[] j() {
        return new Annotation[0];
    }

    public String y(FrameworkMethod frameworkMethod) {
        return frameworkMethod.getName() + i();
    }

    public void z(List<Throwable> list) {
        D(list);
        if (fieldsAreAnnotated()) {
            F(list);
        }
    }
}
