package org.junit.platform.commons.util;

import j$.util.function.BiFunction;
import j$.util.function.Function;
import org.junit.platform.commons.util.CloseablePath;

public final /* synthetic */ class m implements BiFunction {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CloseablePath.ManagedFileSystem f28017a;

    public /* synthetic */ m(CloseablePath.ManagedFileSystem managedFileSystem) {
        this.f28017a = managedFileSystem;
    }

    public /* synthetic */ BiFunction andThen(Function function) {
        return BiFunction.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj, Object obj2) {
        return this.f28017a.release();
    }
}
