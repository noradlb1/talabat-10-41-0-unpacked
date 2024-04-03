package org.junit.jupiter.engine.extension;

import j$.util.function.Supplier;

public final /* synthetic */ class v implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f62617a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f62618b;

    public /* synthetic */ v(String str, String str2) {
        this.f62617a = str;
        this.f62618b = str2;
    }

    public final Object get() {
        return String.format("Ignored invalid timeout '%s' set via the '%s' configuration parameter.", new Object[]{this.f62617a, this.f62618b});
    }
}
