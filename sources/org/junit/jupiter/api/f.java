package org.junit.jupiter.api;

import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.api.function.ThrowingSupplier;

public final /* synthetic */ class f implements ThrowingSupplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Executable f57147a;

    public /* synthetic */ f(Executable executable) {
        this.f57147a = executable;
    }

    public final Object get() {
        return this.f57147a.execute();
    }
}
