package org.junit.jupiter.api;

import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.api.function.ThrowingSupplier;

public final /* synthetic */ class k implements ThrowingSupplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Executable f57152a;

    public /* synthetic */ k(Executable executable) {
        this.f57152a = executable;
    }

    public final Object get() {
        return this.f57152a.execute();
    }
}
