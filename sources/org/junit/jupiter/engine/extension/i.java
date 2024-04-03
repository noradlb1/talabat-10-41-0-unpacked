package org.junit.jupiter.engine.extension;

import j$.util.function.Function;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.io.CleanupMode;

public final /* synthetic */ class i implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CleanupMode f62601a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ExtensionContext f62602b;

    public /* synthetic */ i(CleanupMode cleanupMode, ExtensionContext extensionContext) {
        this.f62601a = cleanupMode;
        this.f62602b = extensionContext;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return TempDirectory.g(this.f62601a, this.f62602b);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
