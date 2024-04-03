package org.junit.platform.commons.util;

import j$.util.function.Supplier;
import java.nio.file.Path;

public final /* synthetic */ class g implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Path f28005a;

    public /* synthetic */ g(Path path) {
        this.f28005a = path;
    }

    public final Object get() {
        return String.format("Failed to load java.lang.Class for path [%s] during classpath scanning.", new Object[]{this.f28005a.toAbsolutePath()});
    }
}
