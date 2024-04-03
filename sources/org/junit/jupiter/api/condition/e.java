package org.junit.jupiter.api.condition;

import j$.util.function.Function;
import java.lang.annotation.Annotation;

public final /* synthetic */ class e implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BooleanExecutionCondition f57120a;

    public /* synthetic */ e(BooleanExecutionCondition booleanExecutionCondition) {
        this.f57120a = booleanExecutionCondition;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return this.f57120a.lambda$evaluateExecutionCondition$0((Annotation) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
