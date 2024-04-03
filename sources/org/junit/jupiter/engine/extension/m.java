package org.junit.jupiter.engine.extension;

import j$.util.function.Function;
import java.nio.file.Path;
import org.junit.jupiter.engine.extension.TempDirectory;

public final /* synthetic */ class m implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TempDirectory.CloseablePath f62609a;

    public /* synthetic */ m(TempDirectory.CloseablePath closeablePath) {
        this.f62609a = closeablePath;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return this.f62609a.tryToDeleteOnExit((Path) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
