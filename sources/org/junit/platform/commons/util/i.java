package org.junit.platform.commons.util;

import j$.util.function.Supplier;
import java.nio.file.Path;

public final /* synthetic */ class i implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Path f28007a;

    public /* synthetic */ i(Path path) {
        this.f28007a = path;
    }

    public final Object get() {
        return ClasspathScanner.lambda$findClassesForPath$2(this.f28007a);
    }
}
