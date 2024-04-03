package org.junit.platform.commons.util;

import j$.util.function.Supplier;
import java.net.URI;

public final /* synthetic */ class d implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ URI f28002a;

    public /* synthetic */ d(URI uri) {
        this.f28002a = uri;
    }

    public final Object get() {
        return ClasspathScanner.lambda$findClassesForUri$1(this.f28002a);
    }
}
