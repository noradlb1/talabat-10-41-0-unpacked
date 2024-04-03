package org.junit.jupiter.engine.config;

import j$.util.function.Consumer;

public final /* synthetic */ class e implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ InstantiatingConfigurationParameterConverter f62403b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f62404c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f62405d;

    public /* synthetic */ e(InstantiatingConfigurationParameterConverter instantiatingConfigurationParameterConverter, String str, String str2) {
        this.f62403b = instantiatingConfigurationParameterConverter;
        this.f62404c = str;
        this.f62405d = str2;
    }

    public final void accept(Object obj) {
        this.f62403b.lambda$newInstance$3(this.f62404c, this.f62405d, obj);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }
}
