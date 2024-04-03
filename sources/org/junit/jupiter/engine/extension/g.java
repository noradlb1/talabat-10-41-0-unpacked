package org.junit.jupiter.engine.extension;

import j$.util.function.Function;
import org.junit.jupiter.api.extension.ExtensionContext;

public final /* synthetic */ class g implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExtensionContext f62596a;

    public /* synthetic */ g(ExtensionContext extensionContext) {
        this.f62596a = extensionContext;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return TempDirectory.lambda$getScope$5(this.f62596a, (Class) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
