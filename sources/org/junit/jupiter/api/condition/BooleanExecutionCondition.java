package org.junit.jupiter.api.condition;

import j$.util.Optional;
import j$.util.function.Function;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.platform.commons.util.AnnotationUtils;

abstract class BooleanExecutionCondition<A extends Annotation> implements ExecutionCondition {
    private final Class<A> annotationType;
    private final Function<A, String> customDisabledReason;
    private final String disabledReason;
    private final String enabledReason;

    public BooleanExecutionCondition(Class<A> cls, String str, String str2, Function<A, String> function) {
        this.annotationType = cls;
        this.enabledReason = str;
        this.disabledReason = str2;
        this.customDisabledReason = function;
    }

    /* access modifiers changed from: private */
    public ConditionEvaluationResult enabledByDefault() {
        return ConditionEvaluationResult.enabled(String.format("@%s is not present", new Object[]{this.annotationType.getSimpleName()}));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ConditionEvaluationResult lambda$evaluateExecutionCondition$0(Annotation annotation) {
        if (c(annotation)) {
            return ConditionEvaluationResult.enabled(this.enabledReason);
        }
        return ConditionEvaluationResult.disabled(this.disabledReason, this.customDisabledReason.apply(annotation));
    }

    public abstract boolean c(A a11);

    public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext extensionContext) {
        return (ConditionEvaluationResult) AnnotationUtils.findAnnotation((Optional<? extends AnnotatedElement>) extensionContext.getElement(), this.annotationType).map(new e(this)).orElseGet(new f(this));
    }
}
