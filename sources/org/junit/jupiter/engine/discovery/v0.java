package org.junit.jupiter.engine.discovery;

import j$.util.function.Supplier;
import java.util.List;
import org.junit.jupiter.engine.discovery.MethodSelectorResolver;

public final /* synthetic */ class v0 implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MethodSelectorResolver.MethodType f62556a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f62557b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Class f62558c;

    public /* synthetic */ v0(MethodSelectorResolver.MethodType methodType, List list, Class cls) {
        this.f62556a = methodType;
        this.f62557b = list;
        this.f62558c = cls;
    }

    public final Object get() {
        return this.f62556a.lambda$resolve$0(this.f62557b, this.f62558c);
    }
}
