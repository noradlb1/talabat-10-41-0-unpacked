package org.junit.jupiter.engine.config;

import j$.util.function.Function;

public final /* synthetic */ class c implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InstantiatingConfigurationParameterConverter f62401a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f62402b;

    public /* synthetic */ c(InstantiatingConfigurationParameterConverter instantiatingConfigurationParameterConverter, String str) {
        this.f62401a = instantiatingConfigurationParameterConverter;
        this.f62402b = str;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return this.f62401a.lambda$get$1(this.f62402b, (String) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
