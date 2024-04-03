package org.junit.jupiter.api.condition;

import j$.util.function.Function;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;

public final /* synthetic */ class c implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AbstractRepeatableAnnotationCondition f57115a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AnnotatedElement f57116b;

    public /* synthetic */ c(AbstractRepeatableAnnotationCondition abstractRepeatableAnnotationCondition, AnnotatedElement annotatedElement) {
        this.f57115a = abstractRepeatableAnnotationCondition;
        this.f57116b = annotatedElement;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return this.f57115a.lambda$evaluateExecutionCondition$0(this.f57116b, (Annotation) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
