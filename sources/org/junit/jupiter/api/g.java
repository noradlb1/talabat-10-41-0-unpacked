package org.junit.jupiter.api;

import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.api.function.ThrowingSupplier;

public final /* synthetic */ class g implements ThrowingSupplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Executable f57148a;

    public /* synthetic */ g(Executable executable) {
        this.f57148a = executable;
    }

    public final Object get() {
        return this.f57148a.execute();
    }
}
