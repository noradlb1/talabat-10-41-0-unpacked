package org.junit.jupiter.api.condition;

import j$.util.Optional;
import j$.util.function.Function;
import j$.util.function.Supplier;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.platform.commons.JUnitException;
import org.junit.platform.commons.util.AnnotationUtils;
import org.junit.platform.commons.util.Preconditions;
import org.junit.platform.commons.util.ReflectionUtils;
import org.junit.platform.commons.util.StringUtils;

abstract class MethodBasedCondition<A extends Annotation> implements ExecutionCondition {
    private final Class<A> annotationType;
    private final Function<A, String> customDisabledReason;
    private final Function<A, String> methodName;

    public MethodBasedCondition(Class<A> cls, Function<A, String> function, Function<A, String> function2) {
        this.annotationType = cls;
        this.methodName = function;
        this.customDisabledReason = function2;
    }

    private boolean acceptsExtensionContextOrNoArguments(Method method) {
        int a11 = method.getParameterCount();
        if (a11 == 0) {
            return true;
        }
        if (a11 == 1 && method.getParameterTypes()[0] == ExtensionContext.class) {
            return true;
        }
        return false;
    }

    private ConditionEvaluationResult buildConditionEvaluationResult(boolean z11, A a11) {
        w wVar = new w(this, a11, z11);
        if (j(z11)) {
            return ConditionEvaluationResult.enabled((String) wVar.get());
        }
        String apply = this.customDisabledReason.apply(a11);
        if (!StringUtils.isNotBlank(apply)) {
            apply = (String) wVar.get();
        }
        return ConditionEvaluationResult.disabled(apply);
    }

    /* access modifiers changed from: private */
    public ConditionEvaluationResult enabledByDefault() {
        return ConditionEvaluationResult.enabled(String.format("@%s is not present", new Object[]{this.annotationType.getSimpleName()}));
    }

    private Method findMethod(Class<?> cls, String str) {
        return ReflectionUtils.findMethod(cls, str, (Class<?>[]) new Class[0]).orElseGet(new o(cls, str));
    }

    /* access modifiers changed from: private */
    /* renamed from: getConditionMethod */
    public Method lambda$evaluateExecutionCondition$0(String str, ExtensionContext extensionContext) {
        if (!str.contains("#")) {
            return findMethod(extensionContext.getRequiredTestClass(), str);
        }
        String[] parseFullyQualifiedMethodName = ReflectionUtils.parseFullyQualifiedMethodName(str);
        String str2 = parseFullyQualifiedMethodName[0];
        return findMethod(ReflectionUtils.tryToLoadClass(str2).getOrThrow(new v(str2)), parseFullyQualifiedMethodName[1]);
    }

    private boolean invokeConditionMethod(Method method, ExtensionContext extensionContext) {
        boolean z11;
        if (method.getReturnType() == Boolean.TYPE) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.condition(z11, (Supplier<String>) new t(method));
        Preconditions.condition(acceptsExtensionContextOrNoArguments(method), (Supplier<String>) new u(method));
        Object orElse = extensionContext.getTestInstance().orElse(null);
        if (method.getParameterCount() == 0) {
            return ((Boolean) ReflectionUtils.invokeMethod(method, orElse, new Object[0])).booleanValue();
        }
        return ((Boolean) ReflectionUtils.invokeMethod(method, orElse, extensionContext)).booleanValue();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ String lambda$buildConditionEvaluationResult$7(Annotation annotation, boolean z11) {
        return String.format("@%s(\"%s\") evaluated to %s", new Object[]{this.annotationType.getSimpleName(), this.methodName.apply(annotation), Boolean.valueOf(z11)});
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean lambda$evaluateExecutionCondition$1(ExtensionContext extensionContext, Method method) {
        return Boolean.valueOf(invokeConditionMethod(method, extensionContext));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ConditionEvaluationResult lambda$evaluateExecutionCondition$2(Optional optional, Boolean bool) {
        return buildConditionEvaluationResult(bool.booleanValue(), (Annotation) optional.get());
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ JUnitException lambda$getConditionMethod$3(String str, Exception exc) {
        return new JUnitException(String.format("Could not load class [%s]", new Object[]{str}), exc);
    }

    public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext extensionContext) {
        Optional<A> findAnnotation = AnnotationUtils.findAnnotation((Optional<? extends AnnotatedElement>) extensionContext.getElement(), this.annotationType);
        return (ConditionEvaluationResult) findAnnotation.map(this.methodName).map(new p(this, extensionContext)).map(new q(this, extensionContext)).map(new r(this, findAnnotation)).orElseGet(new s(this));
    }

    public abstract boolean j(boolean z11);
}
