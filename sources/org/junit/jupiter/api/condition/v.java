package org.junit.jupiter.api.condition;

import j$.util.function.Function;

public final /* synthetic */ class v implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f57141a;

    public /* synthetic */ v(String str) {
        this.f57141a = str;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return MethodBasedCondition.lambda$getConditionMethod$3(this.f57141a, (Exception) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
