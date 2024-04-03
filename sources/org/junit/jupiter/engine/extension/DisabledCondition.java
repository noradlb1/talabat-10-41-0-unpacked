package org.junit.jupiter.engine.extension;

import java.lang.reflect.AnnotatedElement;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.platform.commons.util.AnnotationUtils;
import org.junit.platform.commons.util.StringUtils;

class DisabledCondition implements ExecutionCondition {
    private static final ConditionEvaluationResult ENABLED = ConditionEvaluationResult.enabled("@Disabled is not present");

    /* access modifiers changed from: private */
    /* renamed from: toResult */
    public ConditionEvaluationResult lambda$evaluateExecutionCondition$0(AnnotatedElement annotatedElement, Disabled disabled) {
        String value = disabled.value();
        if (!StringUtils.isNotBlank(value)) {
            value = annotatedElement + " is @Disabled";
        }
        return ConditionEvaluationResult.disabled(value);
    }

    public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext extensionContext) {
        AnnotatedElement orElse = extensionContext.getElement().orElse(null);
        return (ConditionEvaluationResult) AnnotationUtils.findAnnotation(orElse, Disabled.class).map(new a(this, orElse)).orElse(ENABLED);
    }
}
