package org.junit.validator;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.runners.model.Annotatable;
import org.junit.runners.model.FrameworkField;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.TestClass;

public final class AnnotationsValidator implements TestClassValidator {
    private static final List<AnnotatableValidator<?>> VALIDATORS = Arrays.asList(new AnnotatableValidator[]{new ClassValidator(), new MethodValidator(), new FieldValidator()});

    public static abstract class AnnotatableValidator<T extends Annotatable> {
        private static final AnnotationValidatorFactory ANNOTATION_VALIDATOR_FACTORY = new AnnotationValidatorFactory();

        private AnnotatableValidator() {
        }

        private List<Exception> validateAnnotatable(T t11) {
            ArrayList arrayList = new ArrayList();
            for (Annotation annotationType : t11.getAnnotations()) {
                ValidateWith validateWith = (ValidateWith) annotationType.annotationType().getAnnotation(ValidateWith.class);
                if (validateWith != null) {
                    arrayList.addAll(b(ANNOTATION_VALIDATOR_FACTORY.createAnnotationValidator(validateWith), t11));
                }
            }
            return arrayList;
        }

        public abstract Iterable<T> a(TestClass testClass);

        public abstract List<Exception> b(AnnotationValidator annotationValidator, T t11);

        public List<Exception> validateTestClass(TestClass testClass) {
            ArrayList arrayList = new ArrayList();
            for (Annotatable validateAnnotatable : a(testClass)) {
                arrayList.addAll(validateAnnotatable(validateAnnotatable));
            }
            return arrayList;
        }
    }

    public static class ClassValidator extends AnnotatableValidator<TestClass> {
        private ClassValidator() {
            super();
        }

        public Iterable<TestClass> a(TestClass testClass) {
            return Collections.singletonList(testClass);
        }

        /* renamed from: c */
        public List<Exception> b(AnnotationValidator annotationValidator, TestClass testClass) {
            return annotationValidator.validateAnnotatedClass(testClass);
        }
    }

    public static class FieldValidator extends AnnotatableValidator<FrameworkField> {
        private FieldValidator() {
            super();
        }

        public Iterable<FrameworkField> a(TestClass testClass) {
            return testClass.getAnnotatedFields();
        }

        /* renamed from: c */
        public List<Exception> b(AnnotationValidator annotationValidator, FrameworkField frameworkField) {
            return annotationValidator.validateAnnotatedField(frameworkField);
        }
    }

    public static class MethodValidator extends AnnotatableValidator<FrameworkMethod> {
        private MethodValidator() {
            super();
        }

        public Iterable<FrameworkMethod> a(TestClass testClass) {
            return testClass.getAnnotatedMethods();
        }

        /* renamed from: c */
        public List<Exception> b(AnnotationValidator annotationValidator, FrameworkMethod frameworkMethod) {
            return annotationValidator.validateAnnotatedMethod(frameworkMethod);
        }
    }

    public List<Exception> validateTestClass(TestClass testClass) {
        ArrayList arrayList = new ArrayList();
        for (AnnotatableValidator<?> validateTestClass : VALIDATORS) {
            arrayList.addAll(validateTestClass.validateTestClass(testClass));
        }
        return arrayList;
    }
}
