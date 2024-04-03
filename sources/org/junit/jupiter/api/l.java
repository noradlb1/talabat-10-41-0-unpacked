package org.junit.jupiter.api;

import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.api.function.ThrowingSupplier;

public final /* synthetic */ class l implements ThrowingSupplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Executable f57153a;

    public /* synthetic */ l(Executable executable) {
        this.f57153a = executable;
    }

    public final Object get() {
        return this.f57153a.execute();
    }
}
