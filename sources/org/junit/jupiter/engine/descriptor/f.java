package org.junit.jupiter.engine.descriptor;

import j$.util.function.Supplier;
import org.junit.jupiter.engine.config.JupiterConfiguration;

public final /* synthetic */ class f implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Class f62437a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ JupiterConfiguration f62438b;

    public /* synthetic */ f(Class cls, JupiterConfiguration jupiterConfiguration) {
        this.f62437a = cls;
        this.f62438b = jupiterConfiguration;
    }

    public final Object get() {
        return DisplayNameUtils.getDisplayNameGenerator(this.f62437a, this.f62438b).generateDisplayNameForClass(this.f62437a);
    }
}
