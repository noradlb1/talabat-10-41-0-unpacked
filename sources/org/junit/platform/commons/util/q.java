package org.junit.platform.commons.util;

import j$.util.function.Function;
import java.nio.file.FileSystem;

public final /* synthetic */ class q implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f28021a;

    public /* synthetic */ q(String str) {
        this.f28021a = str;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return ((FileSystem) obj).getPath(this.f28021a, new String[0]);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
