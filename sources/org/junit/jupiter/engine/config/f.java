package org.junit.jupiter.engine.config;

import j$.util.function.Consumer;

public final /* synthetic */ class f implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ InstantiatingConfigurationParameterConverter f62406b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f62407c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f62408d;

    public /* synthetic */ f(InstantiatingConfigurationParameterConverter instantiatingConfigurationParameterConverter, String str, String str2) {
        this.f62406b = instantiatingConfigurationParameterConverter;
        this.f62407c = str;
        this.f62408d = str2;
    }

    public final void accept(Object obj) {
        this.f62406b.lambda$newInstance$4(this.f62407c, this.f62408d, (Exception) obj);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }
}
