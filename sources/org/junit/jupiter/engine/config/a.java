package org.junit.jupiter.engine.config;

import j$.util.function.Supplier;

public final /* synthetic */ class a implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InstantiatingConfigurationParameterConverter f62398a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f62399b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f62400c;

    public /* synthetic */ a(InstantiatingConfigurationParameterConverter instantiatingConfigurationParameterConverter, String str, String str2) {
        this.f62398a = instantiatingConfigurationParameterConverter;
        this.f62399b = str;
        this.f62400c = str2;
    }

    public final Object get() {
        return this.f62398a.lambda$logFailureMessage$5(this.f62399b, this.f62400c);
    }
}
