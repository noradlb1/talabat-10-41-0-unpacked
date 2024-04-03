package org.junit.jupiter.engine.discovery;

import j$.util.function.Function;
import java.lang.reflect.Method;
import java.util.List;

public final /* synthetic */ class u implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ClassSelectorResolver f62549a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f62550b;

    public /* synthetic */ u(ClassSelectorResolver classSelectorResolver, List list) {
        this.f62549a = classSelectorResolver;
        this.f62550b = list;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return this.f62549a.lambda$toResolution$10(this.f62550b, (Method) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
