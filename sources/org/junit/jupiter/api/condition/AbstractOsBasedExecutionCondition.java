package org.junit.jupiter.api.condition;

import j$.util.Optional;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.platform.commons.util.AnnotationUtils;

abstract class AbstractOsBasedExecutionCondition<A extends Annotation> implements ExecutionCondition {

    /* renamed from: a  reason: collision with root package name */
    public static final String f57109a = System.getProperty("os.arch");

    /* renamed from: b  reason: collision with root package name */
    public static final String f57110b = System.getProperty("os.name");
    private final Class<A> annotationType;

    public AbstractOsBasedExecutionCondition(Class<A> cls) {
        this.annotationType = cls;
    }

    /* access modifiers changed from: private */
    public ConditionEvaluationResult enabledByDefault() {
        return ConditionEvaluationResult.enabled(String.format("@%s is not present", new Object[]{this.annotationType.getSimpleName()}));
    }

    public String b(boolean z11, boolean z12, boolean z13) {
        String str;
        String str2;
        StringBuilder sb2 = new StringBuilder();
        if (z11) {
            str = "Enabled";
        } else {
            str = "Disabled";
        }
        sb2.append(str);
        if (z12) {
            str2 = " on operating system: ";
        } else {
            str2 = " on architecture: ";
        }
        sb2.append(str2);
        if (z12 && z13) {
            sb2.append(String.format("%s (%s)", new Object[]{f57110b, f57109a}));
        } else if (z12) {
            sb2.append(f57110b);
        } else {
            sb2.append(f57109a);
        }
        return sb2.toString();
    }

    public abstract ConditionEvaluationResult c(A a11);

    public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext extensionContext) {
        return (ConditionEvaluationResult) AnnotationUtils.findAnnotation((Optional<? extends AnnotatedElement>) extensionContext.getElement(), this.annotationType).map(new a(this)).orElseGet(new b(this));
    }
}
