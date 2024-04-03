package org.junit.jupiter.engine.discovery;

import j$.util.function.Supplier;
import org.junit.platform.engine.discovery.NestedClassSelector;

public final /* synthetic */ class s implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ClassSelectorResolver f62541a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NestedClassSelector f62542b;

    public /* synthetic */ s(ClassSelectorResolver classSelectorResolver, NestedClassSelector nestedClassSelector) {
        this.f62541a = classSelectorResolver;
        this.f62542b = nestedClassSelector;
    }

    public final Object get() {
        return this.f62541a.lambda$resolve$3(this.f62542b);
    }
}
