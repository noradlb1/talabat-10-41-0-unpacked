package org.junit.jupiter.engine.discovery;

import e30.u;
import j$.util.Collection;
import j$.util.function.Supplier;
import j$.util.stream.Collectors;
import java.lang.reflect.Method;
import java.util.Set;

public final /* synthetic */ class p0 implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Set f62531a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Method f62532b;

    public /* synthetic */ p0(Set set, Method method) {
        this.f62531a = set;
        this.f62532b = method;
    }

    public final Object get() {
        return String.format("Possible configuration error: method [%s] resulted in multiple TestDescriptors %s. This is typically the result of annotating a method with multiple competing annotations such as @Test, @RepeatedTest, @ParameterizedTest, @TestFactory, etc.", new Object[]{this.f62532b.toGenericString(), Collection.EL.stream(this.f62531a).map(new u()).map(new m0()).collect(Collectors.toList())});
    }
}
