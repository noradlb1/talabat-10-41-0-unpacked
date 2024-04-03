package org.junit.jupiter.api.condition;

import j$.util.function.Supplier;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import org.junit.jupiter.api.extension.ConditionEvaluationResult;

public final /* synthetic */ class d implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Annotation f57117a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AnnotatedElement f57118b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ConditionEvaluationResult f57119c;

    public /* synthetic */ d(Annotation annotation, AnnotatedElement annotatedElement, ConditionEvaluationResult conditionEvaluationResult) {
        this.f57117a = annotation;
        this.f57118b = annotatedElement;
        this.f57119c = conditionEvaluationResult;
    }

    public final Object get() {
        return String.format("Evaluation of %s on [%s] resulted in: %s", new Object[]{this.f57117a, this.f57118b, this.f57119c});
    }
}
