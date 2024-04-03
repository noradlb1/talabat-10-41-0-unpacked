package org.junit.jupiter.engine.descriptor;

import j$.util.function.Supplier;
import java.lang.reflect.Method;
import org.junit.jupiter.api.DisplayNameGenerator;

public final /* synthetic */ class h implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DisplayNameGenerator f62441a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Class f62442b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Method f62443c;

    public /* synthetic */ h(DisplayNameGenerator displayNameGenerator, Class cls, Method method) {
        this.f62441a = displayNameGenerator;
        this.f62442b = cls;
        this.f62443c = method;
    }

    public final Object get() {
        return this.f62441a.generateDisplayNameForMethod(this.f62442b, this.f62443c);
    }
}
