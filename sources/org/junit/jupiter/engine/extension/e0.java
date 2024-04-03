package org.junit.jupiter.engine.extension;

import j$.util.function.Function;
import org.junit.jupiter.api.extension.ExtensionContext;

public final /* synthetic */ class e0 implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExtensionContext f62592a;

    public /* synthetic */ e0(ExtensionContext extensionContext) {
        this.f62592a = extensionContext;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return TimeoutExtension.lambda$getGlobalTimeoutConfiguration$2(this.f62592a, (String) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
