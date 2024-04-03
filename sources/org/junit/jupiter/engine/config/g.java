package org.junit.jupiter.engine.config;

import j$.util.function.Supplier;

public final /* synthetic */ class g implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InstantiatingConfigurationParameterConverter f62409a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f62410b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f62411c;

    public /* synthetic */ g(InstantiatingConfigurationParameterConverter instantiatingConfigurationParameterConverter, String str, String str2) {
        this.f62409a = instantiatingConfigurationParameterConverter;
        this.f62410b = str;
        this.f62411c = str2;
    }

    public final Object get() {
        return this.f62409a.lambda$logSuccessMessage$6(this.f62410b, this.f62411c);
    }
}
