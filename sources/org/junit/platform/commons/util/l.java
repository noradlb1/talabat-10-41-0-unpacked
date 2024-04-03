package org.junit.platform.commons.util;

import j$.util.function.Function;
import java.net.URI;

public final /* synthetic */ class l implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ClasspathScanner f28014a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f28015b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ClassFilter f28016c;

    public /* synthetic */ l(ClasspathScanner classpathScanner, String str, ClassFilter classFilter) {
        this.f28014a = classpathScanner;
        this.f28015b = str;
        this.f28016c = classFilter;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return this.f28014a.lambda$findClassesForUris$0(this.f28015b, this.f28016c, (URI) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
