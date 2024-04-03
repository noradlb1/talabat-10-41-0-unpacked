package org.junit.platform.engine;

import j$.util.function.Function;

public final /* synthetic */ class c implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Object f28023a;

    public /* synthetic */ c(Object obj) {
        this.f28023a = obj;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return ((Filter) obj).apply(this.f28023a);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
