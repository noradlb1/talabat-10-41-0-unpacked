package org.junit.jupiter.api.condition;

import j$.util.Collection;
import j$.util.Optional;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.junit.platform.commons.util.AnnotationUtils;
import y20.a;

abstract class AbstractRepeatableAnnotationCondition<A extends Annotation> implements ExecutionCondition {
    private final Class<A> annotationType;
    private final Logger logger = LoggerFactory.getLogger(getClass());

    public AbstractRepeatableAnnotationCondition(Class<A> cls) {
        this.annotationType = cls;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ConditionEvaluationResult lambda$evaluateExecutionCondition$0(AnnotatedElement annotatedElement, Annotation annotation) {
        ConditionEvaluationResult c11 = c(annotation);
        logResult(annotation, annotatedElement, c11);
        return c11;
    }

    private void logResult(A a11, AnnotatedElement annotatedElement, ConditionEvaluationResult conditionEvaluationResult) {
        this.logger.trace(new d(a11, annotatedElement, conditionEvaluationResult));
    }

    public abstract ConditionEvaluationResult c(A a11);

    public abstract ConditionEvaluationResult d();

    public final ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext extensionContext) {
        Optional<AnnotatedElement> element = extensionContext.getElement();
        if (!element.isPresent()) {
            return d();
        }
        AnnotatedElement annotatedElement = element.get();
        return (ConditionEvaluationResult) Collection.EL.stream(AnnotationUtils.findRepeatableAnnotations(annotatedElement, this.annotationType)).map(new c(this, annotatedElement)).filter(new a()).findFirst().orElse(d());
    }
}
