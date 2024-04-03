package org.junit.platform.commons.util;

import j$.util.function.Supplier;
import java.nio.file.Path;

public final /* synthetic */ class a implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Path f28000a;

    public /* synthetic */ a(Path path) {
        this.f28000a = path;
    }

    public final Object get() {
        return ClassFileVisitor.lambda$visitFileFailed$0(this.f28000a);
    }
}
