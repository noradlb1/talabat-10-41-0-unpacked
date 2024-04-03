package org.junit.jupiter.engine.descriptor;

import j$.util.function.Supplier;
import java.net.URI;

public final /* synthetic */ class a0 implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ URI f62423a;

    public /* synthetic */ a0(URI uri) {
        this.f62423a = uri;
    }

    public final Object get() {
        return MethodSourceSupport.lambda$from$0(this.f62423a);
    }
}
