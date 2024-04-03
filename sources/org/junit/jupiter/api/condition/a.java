package org.junit.jupiter.api.condition;

import j$.util.function.Function;
import java.lang.annotation.Annotation;

public final /* synthetic */ class a implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AbstractOsBasedExecutionCondition f57113a;

    public /* synthetic */ a(AbstractOsBasedExecutionCondition abstractOsBasedExecutionCondition) {
        this.f57113a = abstractOsBasedExecutionCondition;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return this.f57113a.c((Annotation) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
