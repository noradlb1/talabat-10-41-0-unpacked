package org.junit.platform.commons.util;

import j$.util.function.Supplier;
import java.nio.file.Path;

public final /* synthetic */ class k implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Path f28013a;

    public /* synthetic */ k(Path path) {
        this.f28013a = path;
    }

    public final Object get() {
        return ClasspathScanner.lambda$findClassesForPath$4(this.f28013a);
    }
}
