package org.junit.jupiter.engine.extension;

import j$.util.function.Supplier;
import org.junit.jupiter.engine.extension.TempDirectory;

public final /* synthetic */ class l implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TempDirectory.CloseablePath f62608a;

    public /* synthetic */ l(TempDirectory.CloseablePath closeablePath) {
        this.f62608a = closeablePath;
    }

    public final Object get() {
        return this.f62608a.lambda$close$0();
    }
}
