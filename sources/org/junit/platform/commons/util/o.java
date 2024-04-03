package org.junit.platform.commons.util;

import j$.util.function.BiFunction;
import j$.util.function.Function;
import java.net.URI;
import org.junit.platform.commons.util.CloseablePath;

public final /* synthetic */ class o implements BiFunction {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ URI f28018a;

    public /* synthetic */ o(URI uri) {
        this.f28018a = uri;
    }

    public /* synthetic */ BiFunction andThen(Function function) {
        return BiFunction.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj, Object obj2) {
        return CloseablePath.lambda$createForJarFileSystem$3(this.f28018a, (URI) obj, (CloseablePath.ManagedFileSystem) obj2);
    }
}
