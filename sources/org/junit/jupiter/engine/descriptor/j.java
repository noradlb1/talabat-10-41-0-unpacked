package org.junit.jupiter.engine.descriptor;

import j$.util.function.Supplier;
import org.junit.jupiter.engine.config.JupiterConfiguration;

public final /* synthetic */ class j implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Class f62447a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ JupiterConfiguration f62448b;

    public /* synthetic */ j(Class cls, JupiterConfiguration jupiterConfiguration) {
        this.f62447a = cls;
        this.f62448b = jupiterConfiguration;
    }

    public final Object get() {
        return DisplayNameUtils.getDisplayNameGenerator(this.f62447a, this.f62448b).generateDisplayNameForNestedClass(this.f62447a);
    }
}
