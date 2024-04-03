package org.junit.jupiter.api.condition;

import j$.util.Optional;
import j$.util.function.Function;

public final /* synthetic */ class r implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MethodBasedCondition f57136a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Optional f57137b;

    public /* synthetic */ r(MethodBasedCondition methodBasedCondition, Optional optional) {
        this.f57136a = methodBasedCondition;
        this.f57137b = optional;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return this.f57136a.lambda$evaluateExecutionCondition$2(this.f57137b, (Boolean) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
