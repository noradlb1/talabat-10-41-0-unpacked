package org.junit.platform.engine;

import j$.util.function.Supplier;

public final /* synthetic */ class f implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f28049a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ char f28050b;

    public /* synthetic */ f(String str, char c11) {
        this.f28049a = str;
        this.f28050b = c11;
    }

    public final Object get() {
        return String.format("type or value '%s' must not contain '%s'", new Object[]{this.f28049a, Character.valueOf(this.f28050b)});
    }
}
