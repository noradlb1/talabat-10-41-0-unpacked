package org.junit.jupiter.api.condition;

import j$.util.function.Function;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtensionContext;

public final /* synthetic */ class q implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MethodBasedCondition f57134a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ExtensionContext f57135b;

    public /* synthetic */ q(MethodBasedCondition methodBasedCondition, ExtensionContext extensionContext) {
        this.f57134a = methodBasedCondition;
        this.f57135b = extensionContext;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return this.f57134a.lambda$evaluateExecutionCondition$1(this.f57135b, (Method) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
