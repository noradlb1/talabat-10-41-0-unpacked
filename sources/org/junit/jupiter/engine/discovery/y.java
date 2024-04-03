package org.junit.jupiter.engine.discovery;

import j$.util.function.Function;
import org.junit.platform.engine.support.discovery.SelectorResolver;

public final /* synthetic */ class y implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ClassSelectorResolver f62568a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SelectorResolver.Context f62569b;

    public /* synthetic */ y(ClassSelectorResolver classSelectorResolver, SelectorResolver.Context context) {
        this.f62568a = classSelectorResolver;
        this.f62569b = context;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return this.f62568a.lambda$resolve$6(this.f62569b, (Class) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
