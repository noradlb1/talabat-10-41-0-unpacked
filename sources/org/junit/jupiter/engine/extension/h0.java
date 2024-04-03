package org.junit.jupiter.engine.extension;

import j$.util.function.Supplier;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ReflectiveInvocationContext;

public final /* synthetic */ class h0 implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TimeoutExtension f62598a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ReflectiveInvocationContext f62599b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ExtensionContext f62600c;

    public /* synthetic */ h0(TimeoutExtension timeoutExtension, ReflectiveInvocationContext reflectiveInvocationContext, ExtensionContext extensionContext) {
        this.f62598a = timeoutExtension;
        this.f62599b = reflectiveInvocationContext;
        this.f62600c = extensionContext;
    }

    public final Object get() {
        return this.f62598a.lambda$decorate$3(this.f62599b, this.f62600c);
    }
}
