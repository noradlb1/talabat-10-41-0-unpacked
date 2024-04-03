package org.junit.platform.commons.util;

import j$.util.function.Supplier;
import java.nio.file.Path;

public final /* synthetic */ class b implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Path f28001a;

    public /* synthetic */ b(Path path) {
        this.f28001a = path;
    }

    public final Object get() {
        return ClassFileVisitor.lambda$postVisitDirectory$1(this.f28001a);
    }
}
