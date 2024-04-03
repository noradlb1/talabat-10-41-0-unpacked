package org.junit.jupiter.api.condition;

import j$.util.function.Function;
import org.junit.jupiter.api.extension.ExtensionContext;

public final /* synthetic */ class p implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MethodBasedCondition f57132a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ExtensionContext f57133b;

    public /* synthetic */ p(MethodBasedCondition methodBasedCondition, ExtensionContext extensionContext) {
        this.f57132a = methodBasedCondition;
        this.f57133b = extensionContext;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return this.f57132a.lambda$evaluateExecutionCondition$0(this.f57133b, (String) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
